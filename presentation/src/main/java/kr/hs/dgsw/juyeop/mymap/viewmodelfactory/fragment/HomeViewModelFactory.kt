package kr.hs.dgsw.juyeop.mymap.viewmodelfactory.fragment

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.hs.dgsw.juyeop.domain.usecase.GetMySpotUseCase
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(
    private val context: Context,
    private val getMySpotUseCase: GetMySpotUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            Context::class.java,
            GetMySpotUseCase::class.java
        ).newInstance(context, getMySpotUseCase)
    }
}