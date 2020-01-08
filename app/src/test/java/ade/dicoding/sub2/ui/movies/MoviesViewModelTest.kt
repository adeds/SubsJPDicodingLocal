package ade.dicoding.sub2.ui.movies

import ade.dicoding.sub2.data.local.entity.MoviesEntity
import ade.dicoding.sub2.data.repository.TMDBRepository
import ade.dicoding.sub2.helper.SortUtils.NEWEST
import ade.dicoding.sub2.util.FakeDummy
import ade.dicoding.sub2.vo.Resource
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


class MoviesViewModelTest {
    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repo: TMDBRepository
    private val movies = FakeDummy().generateMovies()

//    @Mock
//    private lateinit var observer: Observer<Resource<List<MoviesEntity>>?>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = MoviesViewModel(repo)
    }

    @Test
    fun getMovie() {
        val resource: Resource<List<MoviesEntity>> = Resource.success(movies)
        val dummyCourses: MutableLiveData<Resource<List<MoviesEntity>>> = MutableLiveData()
        dummyCourses.value = resource

        Mockito.`when`(repo.movies(data)).thenReturn(dummyCourses)
        val observer = mock(Observer::class.java) as Observer<Resource<List<MoviesEntity>>>
        viewModel.setUsername(NEWEST)
        viewModel.movies.observeForever(observer)
        verify(observer).onChanged(resource)
    }
}