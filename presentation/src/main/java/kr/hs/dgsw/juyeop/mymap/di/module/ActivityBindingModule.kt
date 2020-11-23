package kr.hs.dgsw.juyeop.mymap.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kr.hs.dgsw.juyeop.mymap.di.scope.PerActivity
import kr.hs.dgsw.juyeop.mymap.view.MainActivity

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector
    abstract fun bindingMainActivity(): MainActivity
}