package com.boydhogerheijde.android.weather.ui.dailyforecast

import com.boydhogerheijde.android.weather.ui.BasePresenter
import com.boydhogerheijde.android.weather.ui.BaseView
import com.boydhogerheijde.android.weather.domain.model.ForecastList

/**
 * @author Boyd Hogerheijde.
 */
interface DailyForecastContract {

    interface View : BaseView<Presenter> {

        fun setLoading(isLoading: Boolean)

        fun showDailyForecast(forecastList: ForecastList?)

        fun showNoConnection()

        fun showDataUnavailable()
    }

    interface Presenter : BasePresenter
}