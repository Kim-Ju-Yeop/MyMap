package kr.hs.dgsw.juyeop.mymap.view.fragment

import kr.hs.dgsw.juyeop.mymap.base.view.BaseFragment
import kr.hs.dgsw.juyeop.mymap.databinding.FragmentQrCodeBinding
import kr.hs.dgsw.juyeop.mymap.viewmodel.fragment.QrCodeViewModel
import kr.hs.dgsw.juyeop.mymap.viewmodelfactory.fragment.QrCodeViewModelFactory
import kr.hs.dgsw.juyeop.mymap.widget.extension.getViewModel
import javax.inject.Inject

class QrCodeFragment : BaseFragment<FragmentQrCodeBinding, QrCodeViewModel>() {

    @Inject
    lateinit var viewModelFactory: QrCodeViewModelFactory

    override val viewModel: QrCodeViewModel
        get() = getViewModel(viewModelFactory)

    override fun observerViewModel() {}
}