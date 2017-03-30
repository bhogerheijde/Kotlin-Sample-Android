package com.boydhogerheijde.android.weather.domain.interactor

import com.boydhogerheijde.android.weather.data.WeatherRepository
import com.boydhogerheijde.android.weather.domain.model.ForecastList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * @author Boyd Hogerheijde.
 */
class RequestForecastInteractor(private val repository: WeatherRepository,
                                private val cityId: String = "94043") : Interactor<ForecastList> {

    override fun execute(observer: DisposableObserver<ForecastList>) {
        disposable.add(repository.getDailyForecast(cityId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer))
    }
}