package com.boydhogerheijde.android.weather.data

import com.boydhogerheijde.android.weather.domain.model.ForecastList
import com.boydhogerheijde.android.weather.domain.model.Forecast as ModelForecast

/**
 * @author Boyd Hogerheijde.
 */
class WeatherDataMapper {

    fun convertToDomain(forecastResult: ForecastResult): ForecastList
            = ForecastList(forecastResult.city.name,
            forecastResult.city.country,
            convertForecastListToDomain(forecastResult.list))

    private fun convertForecastListToDomain(forecastList: List<Forecast>): List<ModelForecast>
            = forecastList.map { convertForecastItemToDomain(it) }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast
            = ModelForecast(forecast.dt,
            forecast.weather[0].description,
            forecast.temp.max,
            forecast.temp.min,
            generateIconUrl(forecast.weather[0].icon))

    private fun generateIconUrl(iconCode: String): String
            = "http://openweathermap.org/img/w/$iconCode.png"
}