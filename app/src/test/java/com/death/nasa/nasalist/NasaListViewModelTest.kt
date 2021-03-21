package com.death.nasa.nasalist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.death.nasa.TestSchedulerProvider
import com.death.nasa.data.model.NasaImage
import com.death.nasa.data.repository.NasaImageRepository
import com.death.nasa.ui.home.list.NasaListContract
import com.death.nasa.ui.home.list.NasaListViewModel
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule


class NasaListViewModelTest {

    lateinit var nasaListViewModel: NasaListViewModel

    private val testScheduler =  TestScheduler()
    private val testSchedulerProvider = TestSchedulerProvider(testScheduler)

    private val nasaImageRepository:NasaImageRepository = mockk()

    @Rule @JvmField var rule: TestRule = InstantTaskExecutorRule()

    val nasaImage = NasaImage("Sample", "Sample", "Sample", "hdurl", "sample", "service", "title", "url")

    @Before
    @Throws(Exception::class)
    fun setUp() {
        nasaListViewModel = NasaListViewModel(testSchedulerProvider, nasaImageRepository)
    }

    @Test
    fun `when initialized emits states with loading`(){
        val viewModel = nasaListViewModel

        viewModel.viewStates().observeForever{}

        assert(viewModel.viewStates().value!!.loadStatus == NasaListContract.LoadStatus.Loading)
    }

    @Test
    fun `when view is created emits states with nasa images`(){

        every { nasaImageRepository.getNasaPhotos() }.returns(Single.just(listOf(nasaImage)))

        val viewModel = nasaListViewModel
        viewModel.viewStates().observeForever{}
        viewModel.onViewCreated()
        testScheduler.triggerActions()
        assert(viewModel.viewStates().value!!.loadStatus == NasaListContract.LoadStatus.Loaded && viewModel.viewStates().value!!.nasaImages==listOf(nasaImage))
    }

    @Test
    fun `on error in fetching images emits state with error`(){
        every { nasaImageRepository.getNasaPhotos() }.returns(Single.error(Exception()))
        val viewModel = nasaListViewModel
        viewModel.viewStates().observeForever{}
        viewModel.onViewCreated()
        testScheduler.triggerActions()
        assert(viewModel.viewStates().value!!.loadStatus == NasaListContract.LoadStatus.Error && viewModel.viewStates().value!!.nasaImages.isEmpty())
    }


}