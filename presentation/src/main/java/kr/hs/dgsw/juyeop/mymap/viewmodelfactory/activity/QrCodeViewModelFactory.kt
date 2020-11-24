package kr.hs.dgsw.juyeop.mymap.viewmodelfactory.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.hs.dgsw.juyeop.domain.usecase.GetSpotUseCase
import kr.hs.dgsw.juyeop.domain.usecase.PostSpotUseCase
import javax.inject.Inject

class QrCodeViewModelFactory @Inject constructor(
    private val getSpotUseCase: GetSpotUseCase,
    private val postSpotUseCase: PostSpotUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            GetSpotUseCase::class.java,
            PostSpotUseCase::class.java
        ).newInstance(getSpotUseCase, postSpotUseCase)
    }
}