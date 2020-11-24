package kr.hs.dgsw.juyeop.mymap.viewmodelfactory.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.hs.dgsw.juyeop.domain.usecase.PostLoginUseCase
import javax.inject.Inject

class SignInViewModelFactory @Inject constructor(
    private val postLoginUseCase: PostLoginUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            PostLoginUseCase::class.java
        ).newInstance(postLoginUseCase)
    }
}