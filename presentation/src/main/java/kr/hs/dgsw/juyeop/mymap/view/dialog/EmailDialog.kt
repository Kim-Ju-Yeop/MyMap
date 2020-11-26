package kr.hs.dgsw.juyeop.mymap.view.dialog

import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.dialog_email.*
import kr.hs.dgsw.juyeop.mymap.base.view.BaseDialog
import kr.hs.dgsw.juyeop.mymap.databinding.DialogEmailBinding
import kr.hs.dgsw.juyeop.mymap.viewmodel.dialog.EmailViewModel
import kr.hs.dgsw.juyeop.mymap.viewmodelfactory.dialog.EmailViewModelFactory
import kr.hs.dgsw.juyeop.mymap.widget.SingleLiveEvent
import kr.hs.dgsw.juyeop.mymap.widget.extension.getViewModel
import kr.hs.dgsw.juyeop.mymap.widget.extension.shortSnackbar
import javax.inject.Inject

class EmailDialog : BaseDialog<DialogEmailBinding, EmailViewModel>() {

    val onComEvent = SingleLiveEvent<Unit>()
    val onFailEvent = SingleLiveEvent<Unit>()

    @Inject
    lateinit var viewModelFactory: EmailViewModelFactory

    override val viewModel: EmailViewModel
        get() = getViewModel(viewModelFactory)

    override fun observerViewModel() {
        with(viewModel) {
            onDismissEvent.observe(this@EmailDialog, Observer {
                dismiss()
            })
            onCompleteEvent.observe(this@EmailDialog, Observer {
                onComEvent.call()
                dismiss()
            })
            onFailureEvent.observe(this@EmailDialog, Observer {
                onFailEvent.call()
                dismiss()
            })
        }
    }
}