package kr.hs.dgsw.juyeop.mymap.view.fragment

import kr.hs.dgsw.juyeop.mymap.base.view.BaseFragment
import kr.hs.dgsw.juyeop.mymap.databinding.FragmentHomeBinding
import kr.hs.dgsw.juyeop.mymap.viewmodel.fragment.HomeViewModel
import kr.hs.dgsw.juyeop.mymap.viewmodelfactory.fragment.HomeViewModelFactory
import kr.hs.dgsw.juyeop.mymap.widget.extension.getViewModel
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    @Inject
    lateinit var viewModelFactory: HomeViewModelFactory

    override val viewModel: HomeViewModel
        get() = getViewModel(viewModelFactory)

    override fun observerViewModel() {}
}