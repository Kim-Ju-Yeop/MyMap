package kr.hs.dgsw.juyeop.mymap.view.fragment

import android.os.Bundle
import androidx.lifecycle.Observer
import kr.hs.dgsw.juyeop.mymap.base.view.BaseFragment
import kr.hs.dgsw.juyeop.mymap.databinding.FragmentHomeBinding
import kr.hs.dgsw.juyeop.mymap.view.activity.QrCodeActivity
import kr.hs.dgsw.juyeop.mymap.viewmodel.fragment.HomeViewModel
import kr.hs.dgsw.juyeop.mymap.viewmodelfactory.fragment.HomeViewModelFactory
import kr.hs.dgsw.juyeop.mymap.widget.extension.getViewModel
import kr.hs.dgsw.juyeop.mymap.widget.extension.startActivity
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    @Inject
    lateinit var viewModelFactory: HomeViewModelFactory

    override val viewModel: HomeViewModel
        get() = getViewModel(viewModelFactory)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun observerViewModel() {
        with(viewModel) {
            onQrCodeEvent.observe(this@HomeFragment, Observer {
                startActivity(requireContext().applicationContext, QrCodeActivity::class.java)
            })
        }
    }
}