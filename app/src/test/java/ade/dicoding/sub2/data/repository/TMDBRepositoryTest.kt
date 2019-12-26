package ade.dicoding.sub2.data.repository

import ade.dicoding.sub2.data.model.MovieDetail
import ade.dicoding.sub2.data.model.Movies
import ade.dicoding.sub2.data.model.Tivies
import ade.dicoding.sub2.util.FakeDummy
import ade.dicoding.sub2.util.LiveDataTestUtil
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TMDBRepositoryTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var remote: RemoteRepository
    private lateinit var repository: FakeTMDBRepository

    private val movies = FakeDummy().generateMovies()
    private val movieId = movies.results!![0]!!.id!!
    private val tivies = FakeDummy().generateTivies()
    private val tvId = tivies.results?.get(0)?.id
    private val detail = FakeDummy().generateMovieDetail()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repository = FakeTMDBRepository(remote)
    }

    @After
    fun tearDown() {

    }

    @Test
    fun movies() {
        doAnswer {
            //            (it.arguments[0] as RemoteRepository.LoadMoviesCallback).onAllMoviesReceived(movies)
            val callback = it.arguments[0] as RemoteRepository.LoadMoviesCallback
            callback.onAllMoviesReceived(movies)
            null
        }.`when`(remote).getMovies(any())

        val response: Movies? = LiveDataTestUtil.getValue(repository.movies())

        Mockito.verify(remote, Mockito.times(1)).getMovies(any())

        Assert.assertNotNull(response)
        Assert.assertEquals(movies.results?.size?.toLong(), response?.results?.size?.toLong())
    }

    @Test
    fun tivies() {
        doAnswer {
            val callback = it.arguments[0] as RemoteRepository.LoadTVCallback
            callback.onTVReceived(tivies)
            null
        }.`when`(remote).getTv(any())

        val response: Tivies? = LiveDataTestUtil.getValue(repository.tVShow())

        Mockito.verify(remote, Mockito.times(1)).getTv(any())

        Assert.assertNotNull(response)
        Assert.assertEquals(tivies.results?.size?.toLong(), response?.results?.size?.toLong())
    }


    @Test
    fun detail() {
        doAnswer {
            val callback = it.arguments[1] as RemoteRepository.LoadMovieDetailCallback
            callback.onMovieReceived(detail)
            null
        }.`when`(remote).getMovieDetail(eq(movieId), any())

        val result: MovieDetail = LiveDataTestUtil.getValue(repository.movieDetail(movieId))!!

        Mockito.verify(remote, Mockito.times(1)).getMovieDetail(eq(movieId), any())
//
        Assert.assertNotNull(result)
        Assert.assertEquals(detail.originalTitle, result.originalTitle)
    }

}