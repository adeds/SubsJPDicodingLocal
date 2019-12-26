package ade.dicoding.sub2.ui.detail

import ade.dicoding.sub2.data.model.MovieDetail
import ade.dicoding.sub2.data.repository.RemoteRepository
import ade.dicoding.sub2.data.repository.TMDBRepository
import ade.dicoding.sub2.util.FakeDummy
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repo: TMDBRepository
    private val movies = FakeDummy().generateMovies()
    private val movie = FakeDummy().generateMovieDetail()
    private val movieID = movies.results!![0]!!.id!!

    @Mock
    private lateinit var observer: Observer<MovieDetail?>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = DetailViewModel(repo)
    }

    @Test
    fun getDetail() {
        val mockMovie: MutableLiveData<MovieDetail?>? = MutableLiveData()
        mockMovie?.value = movie
        Mockito.`when`(repo.movieDetail(movieID)).thenReturn(mockMovie)

        viewModel.movie(movieID).observeForever(observer)
        verify(observer).onChanged(movie)
    }
}