package com.example.marsphotos.marsphotos

import com.example.marsphotos.marsphotos.rules.TestDispatcherRule
import com.example.marsphotos.ui.screens.MarsUiState
import com.example.marsphotos.ui.screens.MarsViewModel
import kotlinx.coroutines.test.runTest
import com.example.marsphotos.marsphotos.fake.FakeDataSource
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import com.example.marsphotos.marsphotos.fake.FakeNetworkMarsPhotosRepository
class MarsViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun marsViewModel_getMarsPhotos_verifyMarsUiStateSuccess() =
        runTest {
            val marsViewModel = MarsViewModel(
                marsPhotosRepository = FakeNetworkMarsPhotosRepository()
            )
            assertEquals(
                MarsUiState.Success(FakeDataSource.photosList),
                marsViewModel.marsUiState
            )
        }
}