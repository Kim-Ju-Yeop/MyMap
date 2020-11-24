package kr.hs.dgsw.juyeop.domain.base

abstract class ParamUseCase<in Params, out T> {
    abstract fun buildUseCaseObservable(params: Params): T
}