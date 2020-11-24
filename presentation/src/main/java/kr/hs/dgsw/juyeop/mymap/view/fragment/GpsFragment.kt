package kr.hs.dgsw.juyeop.mymap.view.fragment

import android.os.Bundle
import kr.hs.dgsw.juyeop.mymap.base.view.BaseFragment
import kr.hs.dgsw.juyeop.mymap.databinding.FragmentGpsBinding
import kr.hs.dgsw.juyeop.mymap.viewmodel.fragment.GpsViewModel
import kr.hs.dgsw.juyeop.mymap.viewmodelfactory.fragment.GpsViewModelFactory
import kr.hs.dgsw.juyeop.mymap.widget.extension.getViewModel
import javax.inject.Inject

class GpsFragment : BaseFragment<FragmentGpsBinding, GpsViewModel>() {

    @Inject
    lateinit var viewModelFactory: GpsViewModelFactory

    override val viewModel: GpsViewModel
        get() = getViewModel(viewModelFactory)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun observerViewModel() {}
}