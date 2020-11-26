package kr.hs.dgsw.juyeop.mymap.viewmodelfactory.dialog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.hs.dgsw.juyeop.domain.usecase.PostInfectionUseCase
import javax.inject.Inject

class EmailViewModelFactory @Inject constructor(private val postInfectionUseCase: PostInfectionUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(PostInfectionUseCase::class.java).newInstance(postInfectionUseCase)
    }
}