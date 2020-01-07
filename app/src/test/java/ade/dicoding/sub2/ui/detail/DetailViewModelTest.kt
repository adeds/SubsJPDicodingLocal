package ade.dicoding.sub2.ui.detail

import ade.dicoding.sub2.data.local.entity.MovieDetailEntity
import ade.dicoding.sub2.data.repository.TMDBRepository
import ade.dicoding.sub2.util.FakeDummy
import ade.dicoding.sub2.vo.Resource
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repo: TMDBRepository
    private val movies = FakeDummy().generateMovies()
    private val movie = FakeDummy().generateMovieDetail()
    private val movieID = movies[0].id!!

//    @Mock
//    private lateinit var observer: Observer<Resource<MovieDetailEntity>?>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = DetailViewModel(repo)
        viewModel.setId(movieID)
    }

    @Test
    fun getDetail() {
        val resource: Resource<MovieDetailEntity> = Resource.success(movie)
        val mockMovie: MutableLiveData<Resource<MovieDetailEntity>> = MutableLiveData()
        mockMovie.value = resource
        `when`(repo.movieDetail(movieID)).thenReturn(mockMovie)

        val observer = mock(Observer::class.java) as Observer<Resource<MovieDetailEntity>>
//        val observer = mock<Observer<Resource<MovieDetailEntity>>>()
        viewModel.movie.observeForever(observer)
        verify(observer).onChanged(resource)
    }
}