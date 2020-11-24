package kr.hs.dgsw.juyeop.mymap.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_qr_code.*
import kr.hs.dgsw.juyeop.mymap.base.view.BaseActivity
import kr.hs.dgsw.juyeop.mymap.databinding.ActivityQrCodeBinding
import kr.hs.dgsw.juyeop.mymap.viewmodel.activity.QrCodeViewModel
import kr.hs.dgsw.juyeop.mymap.viewmodelfactory.activity.QrCodeViewModelFactory
import kr.hs.dgsw.juyeop.mymap.widget.extension.getViewModel
import javax.inject.Inject

class QrCodeActivity : BaseActivity<ActivityQrCodeBinding, QrCodeViewModel>(){

    @Inject
    lateinit var viewModelFactory: QrCodeViewModelFactory

    override val viewModel: QrCodeViewModel
        get() = getViewModel(viewModelFactory)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intentIntegrator = IntentIntegrator(this)
        intentIntegrator.setBeepEnabled(true)
        intentIntegrator.initiateScan()
    }

    override fun observerViewModel() {
        with(viewModel) {
            onCancelEvent.observe(this@QrCodeActivity, Observer {
                onBackPressed()
            })
            onNextEvent.observe(this@QrCodeActivity, Observer {
                postSpot()
            })
            onSuccessEvent.observe(this@QrCodeActivity, Observer {
                onBackPressed()
            })
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                onBackPressed()
            } else {
                viewModel.spot_id = result.contents
                viewModel.getSpot()
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
            onBackPressed()
        }
    }
}