package com.boydhogerheijde.android.weather.data

import com.boydhogerheijde.android.weather.domain.model.ForecastList
import io.reactivex.Observable

/**
 * @author Boyd Hogerheijde.
 */
interface WeatherRepository {

    fun getDailyForecast(cityId: String): Observable<ForecastList>
}