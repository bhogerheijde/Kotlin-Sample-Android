package com.boydhogerheijde.android.weather.data

import com.boydhogerheijde.android.weather.domain.model.ForecastList
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Boyd Hogerheijde.
 */
class WeatherRepositoryImpl(private val api: WeatherApi = Retrofit.Builder()
        .baseUrl("http://api.openweathermap.org/data/2.5/forecast/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(WeatherApi::class.java)) : WeatherRepository {

    override fun getDailyForecast(cityId: String): Observable<ForecastList> {
        return api.getDailyForecast(cityId).map { WeatherDataMapper().convertToDomain(it) }
    }
}