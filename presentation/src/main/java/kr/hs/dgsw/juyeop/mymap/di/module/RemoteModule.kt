package kr.hs.dgsw.juyeop.mymap.di.module

import dagger.Module
import dagger.Provides
import kr.hs.dgsw.juyeop.data.network.remote.*
import kr.hs.dgsw.juyeop.data.network.service.*
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

    @Singleton
    @Provides
    fun postStatusRemote(retrofit: Retrofit): StatusRemote {
        return StatusRemote(retrofit.create(StatusService::class.java))
    }
}