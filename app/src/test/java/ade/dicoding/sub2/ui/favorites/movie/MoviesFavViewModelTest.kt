package ade.dicoding.sub2.ui.favorites.movie

import ade.dicoding.sub2.data.local.entity.MovieDetailEntity
import ade.dicoding.sub2.data.repository.TMDBRepository
import ade.dicoding.sub2.helper.SortUtils.NEWEST
import ade.dicoding.sub2.util.FakeDummy
import ade.dicoding.sub2.util.PagedListUtil
import ade.dicoding.sub2.vo.Resource
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class MoviesFavViewModelTest{
    private lateinit var viewModel: MoviesFavViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repo: TMDBRepository
    private val movies = FakeDummy().generateMovieFavorite()

//    @Mock
//    private lateinit var observer: Observer<Resource<List<MoviesEntity>>?>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = MoviesFavViewModel(repo)
    }

    @Test
    fun getMovieFav() {
        val resource: Resource<PagedList<MovieDetailEntity>> = Resource.success(PagedListUtil.mockPagedList(movies))
        val dummyCourses: MutableLiveData<Resource<PagedList<MovieDetailEntity>>> = MutableLiveData()
        dummyCourses.value = resource

        Mockito.`when`(repo.favMovies(NEWEST)).thenReturn(dummyCourses)
        val observer = mock(Observer::class.java) as Observer<Resource<PagedList<MovieDetailEntity>>>
        viewModel.setSorter(NEWEST)
        viewModel.movies.observeForever(observer)
        verify(observer).onChanged(resource)
    }
}