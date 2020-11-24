package kr.hs.dgsw.juyeop.mymap.di.module

import dagger.Module
import dagger.Provides
import kr.hs.dgsw.juyeop.data.repository.*
import kr.hs.dgsw.juyeop.domain.repository.*
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository {
        return authRepositoryImpl
    }

    @Singleton
    @Provides
    fun provideSpotRepository(spotRepositoryImpl: SpotRepositoryImpl): SpotRepository {
        return spotRepositoryImpl
    }

    @Singleton
    @Provides
    fun provideMemberRepository(memberRepositoryImpl: MemberRepositoryImpl): MemberRepository {
        return memberRepositoryImpl
    }

    @Singleton
    @Provides
    fun provideAlertRepository(alertRepositoryImpl: AlertRepositoryImpl): AlertRepository {
        return alertRepositoryImpl
    }

    @Singleton
    @Provides
    fun providerStatusRepository(statusRepositoryImpl: StatusRepositoryImpl): StatusRepository {
        return statusRepositoryImpl
    }
}