package kr.hs.dgsw.juyeop.mymap.view.activity

import kr.hs.dgsw.juyeop.mymap.base.view.BaseActivity
import kr.hs.dgsw.juyeop.mymap.databinding.ActivitySignInBinding
import kr.hs.dgsw.juyeop.mymap.viewmodel.activity.SignInViewModel
import kr.hs.dgsw.juyeop.mymap.viewmodelfactory.activity.SignInViewModelFactory
import kr.hs.dgsw.juyeop.mymap.widget.extension.getViewModel
import javax.inject.Inject

class SignInActivity : BaseActivity<ActivitySignInBinding, SignInViewModel>() {

    @Inject
    lateinit var viewModelFactory: SignInViewModelFactory

    override val viewModel: SignInViewModel
        get() = getViewModel(viewModelFactory)

    override fun observerViewModel() {}
}