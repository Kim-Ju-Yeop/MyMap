package kr.hs.dgsw.juyeop.mymap.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import kr.hs.dgsw.juyeop.mymap.di.module.*
import kr.hs.dgsw.juyeop.mymap.widget.MyMapApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ActivityBindingModule::class,
        AppModule::class,
        FragmentBindingModule::class,
        NetworkModule::class,
        RemoteModule::class,
        RepositoryModule::class,
        ServiceBindingModule::class,
        AndroidInjectionModule::class
    ]
)
interface AppComponent : AndroidInjector<MyMapApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}