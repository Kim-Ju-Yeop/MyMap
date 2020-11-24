package kr.hs.dgsw.juyeop.mymap.viewmodelfactory.activity

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.hs.dgsw.juyeop.domain.usecase.PostLoginUseCase
import javax.inject.Inject

class SignInViewModelFactory @Inject constructor(
    private val context: Context,
    private val postLoginUseCase: PostLoginUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            Context::class.java,
            PostLoginUseCase::class.java
        ).newInstance(context, postLoginUseCase)
    }
}