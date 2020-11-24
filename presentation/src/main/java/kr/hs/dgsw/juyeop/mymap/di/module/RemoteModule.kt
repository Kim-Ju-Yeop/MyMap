package kr.hs.dgsw.juyeop.mymap.di.module

import dagger.Module
import dagger.Provides
import kr.hs.dgsw.juyeop.data.network.remote.AlertRemote
import kr.hs.dgsw.juyeop.data.network.remote.AuthRemote
import kr.hs.dgsw.juyeop.data.network.remote.MemberRemote
import kr.hs.dgsw.juyeop.data.network.remote.SpotRemote
import kr.hs.dgsw.juyeop.data.network.service.AlertService
import kr.hs.dgsw.juyeop.data.network.service.AuthService
import kr.hs.dgsw.juyeop.data.network.service.MemberService
import kr.hs.dgsw.juyeop.data.network.service.SpotService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RemoteModule {

    @Singleton
    @Provides
    fun provideAuthRemote(): AuthRemote = AuthRemote()

    @Singleton
    @Provides
    fun provideSpotRemote(retrofit: Retrofit): SpotRemote {
        return SpotRemote(retrofit.create(SpotService::class.java))
    }

    @Singleton
    @Provides
    fun postMemberRemote(retrofit: Retrofit): MemberRemote {
        return MemberRemote(retrofit.create(MemberService::class.java))
    }

    @Singleton
    @Provides
    fun postAlertRemote(retrofit: Retrofit): AlertRemote {
        return AlertRemote(retrofit.create(AlertService::class.java))
    }
}