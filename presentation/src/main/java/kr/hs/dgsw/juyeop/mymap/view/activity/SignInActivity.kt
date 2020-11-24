package kr.hs.dgsw.juyeop.mymap.view.activity

import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_sign_in.*
import kr.hs.dgsw.juyeop.mymap.base.view.BaseActivity
import kr.hs.dgsw.juyeop.mymap.databinding.ActivitySignInBinding
import kr.hs.dgsw.juyeop.mymap.viewmodel.activity.SignInViewModel
import kr.hs.dgsw.juyeop.mymap.viewmodelfactory.activity.SignInViewModelFactory
import kr.hs.dgsw.juyeop.mymap.widget.extension.getViewModel
import kr.hs.dgsw.juyeop.mymap.widget.extension.shortSnackbar
import kr.hs.dgsw.juyeop.mymap.widget.extension.startActivityWithFinish
import javax.inject.Inject

class SignInActivity : BaseActivity<ActivitySignInBinding, SignInViewModel>() {

    @Inject
    lateinit var viewModelFactory: SignInViewModelFactory

    override val viewModel: SignInViewModel
        get() = getViewModel(viewModelFactory)

    override fun observerViewModel() {
        with(viewModel) {
            onSignInEvent.observe(this@SignInActivity, Observer {
                postLogin()
            })
            onSignUpEvent.observe(this@SignInActivity, Observer {
                shortSnackbar(layout, "준비중인 기능입니다.")
            })
            onSuccessEvent.observe(this@SignInActivity, Observer {
                startActivityWithFinish(applicationContext, MainActivity::class.java)
            })
            onFailureEvent.observe(this@SignInActivity, Observer {
                shortSnackbar(layout, "아이디 또는 비밀번호가 틀렸습니다.")
            })
        }
    }
}