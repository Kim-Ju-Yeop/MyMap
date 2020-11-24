package kr.hs.dgsw.juyeop.mymap.view.activity

import kr.hs.dgsw.juyeop.mymap.base.view.BaseActivity
import kr.hs.dgsw.juyeop.mymap.databinding.ActivityAlertBinding
import kr.hs.dgsw.juyeop.mymap.viewmodel.activity.AlertViewModel
import kr.hs.dgsw.juyeop.mymap.viewmodelfactory.activity.AlertViewModelFactory
import kr.hs.dgsw.juyeop.mymap.widget.extension.getViewModel
import javax.inject.Inject

class AlertActivity : BaseActivity<ActivityAlertBinding, AlertViewModel>() {

    @Inject
    lateinit var viewModelFactory: AlertViewModelFactory

    override val viewModel: AlertViewModel
        get() = getViewModel(viewModelFactory)

    override fun observerViewModel() {}
}