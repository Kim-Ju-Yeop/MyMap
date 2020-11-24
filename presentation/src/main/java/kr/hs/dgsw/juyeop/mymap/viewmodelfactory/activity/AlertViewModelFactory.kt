package kr.hs.dgsw.juyeop.mymap.viewmodelfactory.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.hs.dgsw.juyeop.domain.usecase.GetAlertUseCase
import javax.inject.Inject

class AlertViewModelFactory @Inject constructor(private val getAlertUseCase: GetAlertUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(GetAlertUseCase::class.java).newInstance(getAlertUseCase)
    }
}