package kr.hs.dgsw.juyeop.mymap.di.module

import dagger.Module
import dagger.Provides
import kr.hs.dgsw.juyeop.data.repository.AuthRepositoryImpl
import kr.hs.dgsw.juyeop.domain.repository.AuthRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository {
        return authRepositoryImpl
    }
}