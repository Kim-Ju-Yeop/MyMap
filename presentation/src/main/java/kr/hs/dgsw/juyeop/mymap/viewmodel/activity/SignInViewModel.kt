package kr.hs.dgsw.juyeop.mymap.viewmodel.activity

import kr.hs.dgsw.juyeop.domain.usecase.PostLoginUseCase
import kr.hs.dgsw.juyeop.mymap.base.viewmodel.BaseViewModel

class SignInViewModel(
    private val postLoginUseCase: PostLoginUseCase
) : BaseViewModel() {

}