package kr.hs.dgsw.juyeop.mymap.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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

    override fun observerViewModel() {}
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                onBackPressed()
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
            } else {
                storeNameTextView.text = result.contents
                storeAddressTextView.text = result.contents
                Toast.makeText(this, "Scanned : " + result.contents, Toast.LENGTH_LONG).show()
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
            onBackPressed()
        }
    }
}