package kr.hs.dgsw.juyeop.mymap.widget

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kr.hs.dgsw.juyeop.mymap.di.injector.ApplicationInjector
import javax.inject.Inject

class MyMapApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()
        ApplicationInjector().init(this)
    }
}