package ade.dicoding.sub2.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import ade.dicoding.sub2.data.remote.ApiResponse;
import ade.dicoding.sub2.util.AppExecutors;
import ade.dicoding.sub2.vo.Resource;


public abstract class NetworkBoundResource<ResultType, RequestType> {

    private MediatorLiveData<Resource<ResultType>> result = new MediatorLiveData<>();

    private AppExecutors mExecutors;

    public NetworkBoundResource(AppExecutors appExecutors) {

        this.mExecutors = appExecutors;
        result.setValue(Resource.loading(null));

        LiveData<ResultType> dbSource = loadFromDB();

        result.addSource(dbSource, data -> {
            result.removeSource(dbSource);
            if (shouldFetch(data)) {
                fetchFromNetwork(dbSource);
            } else {
                result.addSource(dbSource, newData -> result.setValue(Resource.success(newData)));
            }
        });
    }

    private void fetchFromNetwork(LiveData<ResultType> dbSource) {

        LiveData<ApiResponse<RequestType>> apiResponse = createCall();

        result.addSource(dbSource, newData ->
                result.setValue(Resource.loading(newData))
        );
        result.addSource(apiResponse, response -> {

            result.removeSource(apiResponse);
            result.removeSource(dbSource);

            if (response.isSuccessful()) {
                mExecutors.diskIO().execute(() -> {
                    saveCallResult(response.getBody());

                    mExecutors.mainThread().execute(() ->
                            result.addSource(loadFromDB(),
                                    newData -> result.setValue(Resource.success(newData))));

                });
            } else if (response.isFailure()) {
                onFetchFailed(response.getMessage());
                result.addSource(dbSource, newData ->
                        result.setValue(Resource.error(response.getMessage(), newData)));
            } else {
                mExecutors.mainThread().execute(() ->
                        result.addSource(loadFromDB(),
                                newData -> result.setValue(Resource.success(newData))));
            }
//            }
        });
    }

    protected void onFetchFailed(String message) {
    }

    protected abstract LiveData<ResultType> loadFromDB();

    protected abstract Boolean shouldFetch(ResultType data);

    protected abstract LiveData<ApiResponse<RequestType>> createCall();

    protected abstract void saveCallResult(RequestType data);

    public LiveData<Resource<ResultType>> asLiveData() {
        return result;
    }
}