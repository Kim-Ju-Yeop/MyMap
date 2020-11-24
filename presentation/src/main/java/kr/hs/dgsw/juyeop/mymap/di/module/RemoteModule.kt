package kr.hs.dgsw.juyeop.mymap.di.module

import dagger.Module
import dagger.Provides
import kr.hs.dgsw.juyeop.data.network.remote.AuthRemote
import kr.hs.dgsw.juyeop.data.network.service.AuthService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RemoteModule {

    @Singleton
    @Provides
    fun provideAuthRemote(retrofit: Retrofit): AuthRemote {
        return AuthRemote(retrofit.create(AuthService::class.java))
    }
}