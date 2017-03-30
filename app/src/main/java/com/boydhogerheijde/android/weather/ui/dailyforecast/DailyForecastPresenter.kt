package com.boydhogerheijde.android.weather.ui.dailyforecast

import com.boydhogerheijde.android.weather.domain.interactor.Interactor
import com.boydhogerheijde.android.weather.domain.model.ForecastList
import io.reactivex.observers.DisposableObserver

/**
 * @author Boyd Hogerheijde.
 */
class DailyForecastPresenter(private val dailyForecastView: DailyForecastContract.View,
                             private val dailyForecastInteractor: Interactor<ForecastList>) : DailyForecastContract.Presenter {

    init {
        dailyForecastView.setPresenter(this)
    }

    override fun start() {
        loadForecast()
    }

    private fun loadForecast() {
        dailyForecastView.setLoading(true)
        dailyForecastInteractor.execute(ForecastObserver())
    }

    private inner class ForecastObserver : DisposableObserver<ForecastList>() {

        override fun onNext(t: ForecastList?) {
            dailyForecastView.showDailyForecast(t)
        }

        override fun onComplete() {
            dailyForecastView.setLoading(false)
        }

        override fun onError(e: Throwable?) {
            dailyForecastView.showDataUnavailable()
        }
    }
}