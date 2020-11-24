package kr.hs.dgsw.juyeop.mymap.viewmodelfactory.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.hs.dgsw.juyeop.domain.usecase.GetMySpotUseCase
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(
    private val getMySpotUseCase: GetMySpotUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            GetMySpotUseCase::class.java
        ).newInstance(getMySpotUseCase)
    }
}