package kr.hs.dgsw.juyeop.mymap.view.activity

import kr.hs.dgsw.juyeop.mymap.base.view.BaseActivity
import kr.hs.dgsw.juyeop.mymap.databinding.ActivitySplashBinding
import kr.hs.dgsw.juyeop.mymap.viewmodel.activity.SplashViewModel
import kr.hs.dgsw.juyeop.mymap.viewmodelfactory.activity.SplashViewModelFactory
import kr.hs.dgsw.juyeop.mymap.widget.extension.getViewModel
import javax.inject.Inject

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {

    @Inject
    lateinit var viewModelFactory: SplashViewModelFactory

    override val viewModel: SplashViewModel
        get() = getViewModel(viewModelFactory)

    override fun observerViewModel() {}
}