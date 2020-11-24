package kr.hs.dgsw.juyeop.domain.base

abstract class BaseUseCase<out T> {
    abstract fun buildUseCaseObservable(): T
}