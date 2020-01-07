package ade.dicoding.sub2.ui.tvshow

import ade.dicoding.sub2.data.local.entity.TiviesEntity
import ade.dicoding.sub2.data.model.Movies
import ade.dicoding.sub2.data.model.Tivies
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

class TVViewModelTest {
    private lateinit var viewModel: TVViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repo: TMDBRepository
    private val tivies = FakeDummy().generateTivies()

//    @Mock
//    private lateinit var observer: Observer<Tivies?>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = TVViewModel(repo)
    }

    @Test
    fun getTivies() {
        val resource: Resource<List<TiviesEntity>> = Resource.success(tivies)
        val dummyCourses: MutableLiveData<Resource<List<TiviesEntity>>> = MutableLiveData()
        dummyCourses.value = resource

        Mockito.`when`(repo.tVShow()).thenReturn(dummyCourses)
        val observer = mock(Observer::class.java) as Observer<Resource<List<TiviesEntity>>>
        viewModel.setUsername(NEWEST)
        viewModel.tivies.observeForever(observer)
        verify(observer).onChanged(resource)
    }
}