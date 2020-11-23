package kr.hs.dgsw.juyeop.mymap.view.activity

import kr.hs.dgsw.juyeop.mymap.base.view.BaseActivity
import kr.hs.dgsw.juyeop.mymap.databinding.ActivityMainBinding
import kr.hs.dgsw.juyeop.mymap.viewmodel.activity.MainViewModel
import kr.hs.dgsw.juyeop.mymap.viewmodelfactory.activity.MainViewModelFactory
import kr.hs.dgsw.juyeop.mymap.widget.extension.getViewModel
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    override val viewModel: MainViewModel
        get() = getViewModel(viewModelFactory)

    override fun observerViewModel() {}
}