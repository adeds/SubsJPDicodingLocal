package ade.dicoding.sub2.ui.favorites.tivshow

import ade.dicoding.sub2.data.local.entity.TVDetailEntity
import ade.dicoding.sub2.data.repository.TMDBRepository
import ade.dicoding.sub2.helper.SortUtils
import ade.dicoding.sub2.util.FakeDummy
import ade.dicoding.sub2.util.PagedListUtil
import ade.dicoding.sub2.vo.Resource
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class TVFavViewModelTest{
    private lateinit var viewModel: TVFavViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repo: TMDBRepository
    private val tvies = FakeDummy().generateTVFavorite()

//    @Mock
//    private lateinit var observer: Observer<Resource<List<MoviesEntity>>?>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = TVFavViewModel(repo)
    }

    @Test
    fun getTVFav() {
        val resource: Resource<PagedList<TVDetailEntity>> = Resource.success(PagedListUtil.mockPagedList(tvies))
        val dummyCourses: MutableLiveData<Resource<PagedList<TVDetailEntity>>> = MutableLiveData()
        dummyCourses.value = resource

        Mockito.`when`(repo.favTivies(SortUtils.NEWEST)).thenReturn(dummyCourses)
        val observer = Mockito.mock(Observer::class.java) as Observer<Resource<PagedList<TVDetailEntity>>>
        viewModel.setSorter(SortUtils.NEWEST)
        viewModel.tivies.observeForever(observer)
        Mockito.verify(observer).onChanged(resource)
    }
}