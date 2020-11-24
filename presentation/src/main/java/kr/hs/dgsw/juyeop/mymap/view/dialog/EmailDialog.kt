package kr.hs.dgsw.juyeop.mymap.view.dialog

import androidx.lifecycle.Observer
import kr.hs.dgsw.juyeop.mymap.base.view.BaseDialog
import kr.hs.dgsw.juyeop.mymap.databinding.DialogEmailBinding
import kr.hs.dgsw.juyeop.mymap.viewmodel.dialog.EmailViewModel
import kr.hs.dgsw.juyeop.mymap.viewmodelfactory.dialog.EmailViewModelFactory
import kr.hs.dgsw.juyeop.mymap.widget.extension.getViewModel
import javax.inject.Inject

class EmailDialog : BaseDialog<DialogEmailBinding, EmailViewModel>() {

    @Inject
    lateinit var viewModelFactory: EmailViewModelFactory

    override val viewModel: EmailViewModel
        get() = getViewModel(viewModelFactory)

    override fun observerViewModel() {
        with(viewModel) {
            onDismissEvent.observe(this@EmailDialog, Observer {
                dismiss()
            })
        }
    }
}