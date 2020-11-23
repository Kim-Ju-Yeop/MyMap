package kr.hs.dgsw.juyeop.mymap.view

import kr.hs.dgsw.juyeop.mymap.base.view.BaseActivity
import kr.hs.dgsw.juyeop.mymap.databinding.ActivityMainBinding
import kr.hs.dgsw.juyeop.mymap.viewmodel.MainViewModel
import kr.hs.dgsw.juyeop.mymap.viewmodelfactory.MainViewModelFactory
import kr.hs.dgsw.juyeop.mymap.widget.extension.getViewModel
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    override val viewModel: MainViewModel
        get() = getViewModel(viewModelFactory)

    override fun observerViewModel() {}
}