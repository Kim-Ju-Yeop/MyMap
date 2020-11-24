package kr.hs.dgsw.juyeop.mymap.di.module

import dagger.Module
import dagger.Provides
import kr.hs.dgsw.juyeop.data.repository.AuthRepositoryImpl
import kr.hs.dgsw.juyeop.data.repository.MemberRepositoryImpl
import kr.hs.dgsw.juyeop.data.repository.SpotRepositoryImpl
import kr.hs.dgsw.juyeop.domain.repository.AuthRepository
import kr.hs.dgsw.juyeop.domain.repository.MemberRepository
import kr.hs.dgsw.juyeop.domain.repository.SpotRepository
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
}