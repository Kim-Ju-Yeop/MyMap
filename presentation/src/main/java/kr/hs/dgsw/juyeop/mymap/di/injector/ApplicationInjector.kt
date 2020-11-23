package kr.hs.dgsw.juyeop.mymap.di.injector

import kr.hs.dgsw.juyeop.mymap.di.component.DaggerAppComponent
import kr.hs.dgsw.juyeop.mymap.widget.MyMapApplication

class ApplicationInjector {

    fun init(interviewApplication: MyMapApplication) {
        DaggerAppComponent
            .builder()
            .application(interviewApplication)
            .build()
            .inject(interviewApplication)
    }
}