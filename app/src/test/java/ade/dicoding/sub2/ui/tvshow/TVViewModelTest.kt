package ade.dicoding.sub2.ui.tvshow

import ade.dicoding.sub2.data.model.Movies
import ade.dicoding.sub2.data.model.Tivies
import ade.dicoding.sub2.data.repository.TMDBRepository
import ade.dicoding.sub2.util.FakeDummy
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class TVViewModelTest {
    private lateinit var viewModel: TVViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repo: TMDBRepository
    private val tivies = FakeDummy().generateTivies()

    @Mock
    private lateinit var observer: Observer<Tivies?>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = TVViewModel(repo)
    }

    @Test
    fun getTivies() {
        val mockTivies: MutableLiveData<Tivies?> = MutableLiveData()
        mockTivies.value = tivies
        Mockito.`when`(repo.tVShow()).thenReturn(mockTivies)

        viewModel.tivies().observeForever(observer)
        verify(observer).onChanged(tivies)
    }
}