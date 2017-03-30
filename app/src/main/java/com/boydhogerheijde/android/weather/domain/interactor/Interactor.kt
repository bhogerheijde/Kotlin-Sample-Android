package com.boydhogerheijde.android.weather.domain.interactor

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver

/**
 * @author Boyd Hogerheijde.
 */
interface Interactor<T> {

    val disposable get() = CompositeDisposable()

    fun execute(observer: DisposableObserver<T>)

    fun dispose() {
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }
}