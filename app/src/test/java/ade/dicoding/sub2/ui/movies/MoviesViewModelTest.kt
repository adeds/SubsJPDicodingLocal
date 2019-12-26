package ade.dicoding.sub2.ui.movies

import ade.dicoding.sub2.data.model.Movies
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


class MoviesViewModelTest {
    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repo: TMDBRepository
    private val movies = FakeDummy().generateMovies()

    @Mock
    private lateinit var observer: Observer<Movies?>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = MoviesViewModel(repo)
    }

    @Test
    fun getMovie() {
        val mockMovies: MutableLiveData<Movies?> = MutableLiveData()
        mockMovies.value = movies
        Mockito.`when`(repo.movies()).thenReturn(mockMovies)

        viewModel.movies().observeForever(observer)
        verify(observer).onChanged(movies)
    }
}