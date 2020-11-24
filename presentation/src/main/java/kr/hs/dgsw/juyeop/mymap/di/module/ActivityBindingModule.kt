package kr.hs.dgsw.juyeop.mymap.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kr.hs.dgsw.juyeop.mymap.di.scope.PerActivity
import kr.hs.dgsw.juyeop.mymap.view.activity.*

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector
    abstract fun bindingSplashActivity(): SplashActivity

    @PerActivity
    @ContributesAndroidInjector
    abstract fun bindingSignInActivity(): SignInActivity

    @PerActivity
    @ContributesAndroidInjector
    abstract fun bindingMainActivity(): MainActivity

    @PerActivity
    @ContributesAndroidInjector
    abstract fun bindingQrCodeActivity(): QrCodeActivity

    @PerActivity
    @ContributesAndroidInjector
    abstract fun bindingAlertActivity(): AlertActivity
}