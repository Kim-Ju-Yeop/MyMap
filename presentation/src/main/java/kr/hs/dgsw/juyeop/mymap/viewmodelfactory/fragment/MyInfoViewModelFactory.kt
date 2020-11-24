package kr.hs.dgsw.juyeop.mymap.viewmodelfactory.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.hs.dgsw.juyeop.domain.usecase.GetInformationUseCase
import javax.inject.Inject

class MyInfoViewModelFactory @Inject constructor(
    private val getInformationUseCase: GetInformationUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(GetInformationUseCase::class.java).newInstance(getInformationUseCase)
    }
}