package com.boydhogerheijde.android.weather.data

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Boyd Hogerheijde.
 */
interface WeatherApi {

    companion object {
        private val APP_ID = "e9ddb4a002fcf513998dfac04adc3c3d"
    }

    @GET("daily")
    fun getDailyForecast(@Query("q") cityId: String,
                         @Query("mode") mode: String = "json",
                         @Query("units") units: String = "metric",
                         @Query("cnt") numOfDays: Int = 7,
                         @Query("APPID") appId: String = APP_ID): Observable<ForecastResult>
}