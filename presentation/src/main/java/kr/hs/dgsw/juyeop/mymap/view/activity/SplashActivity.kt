package kr.hs.dgsw.juyeop.mymap.view.activity

import android.os.Handler
import androidx.lifecycle.Observer
import kr.hs.dgsw.juyeop.mymap.base.view.BaseActivity
import kr.hs.dgsw.juyeop.mymap.databinding.ActivitySplashBinding
import kr.hs.dgsw.juyeop.mymap.viewmodel.activity.SplashViewModel
import kr.hs.dgsw.juyeop.mymap.viewmodelfactory.activity.SplashViewModelFactory
import kr.hs.dgsw.juyeop.mymap.widget.extension.getViewModel
import kr.hs.dgsw.juyeop.mymap.widget.extension.startActivityWithFinish
import javax.inject.Inject

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {

    @Inject
    lateinit var viewModelFactory: SplashViewModelFactory

    override val viewModel: SplashViewModel
        get() = getViewModel(viewModelFactory)

    override fun observerViewModel() {
        val handler = Handler()
        var runnable: Runnable

        with(viewModel) {
            onNullEvent.observe(this@SplashActivity, Observer {
                runnable = Runnable { startActivityWithFinish(applicationContext, SignInActivity::class.java) }
                handler.postDelayed(runnable, 2000)
            })
            onNotNullEvent.observe(this@SplashActivity, Observer {
                runnable = Runnable { startActivityWithFinish(applicationContext, MainActivity::class.java) }
                handler.postDelayed(runnable, 2000)
            })
        }
    }
}