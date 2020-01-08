package ade.dicoding.sub2.data.repository

import ade.dicoding.sub2.data.local.LocalRepository
import ade.dicoding.sub2.data.local.entity.MovieDetailEntity
import ade.dicoding.sub2.data.local.entity.MoviesEntity
import ade.dicoding.sub2.data.local.entity.TiviesEntity
import ade.dicoding.sub2.data.remote.RemoteRepository
import ade.dicoding.sub2.helper.SortUtils.NEWEST
import ade.dicoding.sub2.util.FakeDummy
import ade.dicoding.sub2.util.InstantAppExecutors
import ade.dicoding.sub2.util.LiveDataTestUtil
import ade.dicoding.sub2.util.PagedListUtil
import ade.dicoding.sub2.vo.Resource
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.eq
import junit.framework.Assert.assertEquals
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

    @Mock
    private lateinit var local: LocalRepository

    @Mock
    private lateinit var executor: InstantAppExecutors

    @Mock
    private lateinit var dataSourceFactory: DataSource.Factory<Int,MovieDetailEntity>

    private lateinit var repository: FakeTMDBRepository

    private val movies = FakeDummy().generateMovies()
    private val movieId = movies[0].id!!
    private val tivies = FakeDummy().generateTivies()
    private val tvId = tivies.get(0).id
    private val detail = FakeDummy().generateMovieDetail()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repository = FakeTMDBRepository(local, remote, executor)
    }

    @After
    fun tearDown() {

    }

    @Test
    fun movies() {
        val dummyCourses: MutableLiveData<List<MoviesEntity>> =
            MutableLiveData()
        dummyCourses.value = movies

        Mockito.`when`(local.getAllMovie(page)).thenReturn(dummyCourses)

        val result: Resource<List<MoviesEntity>>? =
            repository.movies(data)?.let { LiveDataTestUtil.getValue(it) }


        Mockito.verify(local, Mockito.times(1)).getAllMovie(page)

        Assert.assertNotNull(result)
        Assert.assertEquals(movies.size.toLong(), result?.data?.size?.toLong())
    }

    @Test
    fun tivies() {
        val dummyCourses: MutableLiveData<List<TiviesEntity>> =
            MutableLiveData()
        dummyCourses.value = tivies

        Mockito.`when`(local.getAllTivi()).thenReturn(dummyCourses)

        val response: Resource<List<TiviesEntity>>? =
            repository.tVShow()?.let { LiveDataTestUtil.getValue(it) }

        Mockito.verify(local, Mockito.times(1)).getAllTivi()

        Assert.assertNotNull(response)
        Assert.assertEquals(tivies.size.toLong(), response?.data?.size?.toLong())
    }


    @Test
    fun detail() {
        val dummyCourses: MutableLiveData<MovieDetailEntity> =
            MutableLiveData()
        dummyCourses.value = FakeDummy().generateMovieDetail()
        Mockito.`when`(local.getMovieDetail(movieId)).thenReturn(dummyCourses)

        val result: Resource<MovieDetailEntity> = LiveDataTestUtil.getValue(repository.movieDetail(movieId))

        Mockito.verify(local, Mockito.times(1)).getMovieDetail(movieId)

        Assert.assertNotNull(result)
        Assert.assertEquals(detail.title, result.data?.title)
    }

    @Test
    fun getFavMovie(){
        val dummyCourses: MutableList<MovieDetailEntity> =
            mutableListOf()
        dummyCourses.addAll(FakeDummy().generateMovieFavorite())

        Mockito.`when`(local.getAllMovieDetail(eq(NEWEST))).thenReturn(any())
        repository.favMovies(NEWEST)
        val result: Resource<PagedList<MovieDetailEntity>> =
            Resource.success(PagedListUtil.mockPagedList(dummyCourses))

        Mockito.verify(local).getAllMovieDetail(eq(NEWEST))
        Assert.assertNotNull(result.data)
        assertEquals(dummyCourses.size, result.data?.size)
    }

}