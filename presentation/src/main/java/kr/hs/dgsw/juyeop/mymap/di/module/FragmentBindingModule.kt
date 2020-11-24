package kr.hs.dgsw.juyeop.mymap.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kr.hs.dgsw.juyeop.mymap.di.scope.PerFragment
import kr.hs.dgsw.juyeop.mymap.view.fragment.HomeFragment
import kr.hs.dgsw.juyeop.mymap.view.fragment.MyInfoFragment
import kr.hs.dgsw.juyeop.mymap.view.fragment.GpsFragment

@Module
abstract class FragmentBindingModule {

    @PerFragment
    @ContributesAndroidInjector
    abstract fun bindingHomeFragment(): HomeFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun bindingQrCodeFragment(): GpsFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun bindingMyInfoFragment(): MyInfoFragment
}