package com.boydhogerheijde.android.weather.domain.model

/**
 * @author Boyd Hogerheijde.
 */
data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>) {

    operator fun get(position: Int): Forecast = dailyForecast[position]

    fun size() = dailyForecast.size
}

data class Forecast(val date: Long, val description: String,
                    val high: Float, val low: Float, val iconUrl: String)