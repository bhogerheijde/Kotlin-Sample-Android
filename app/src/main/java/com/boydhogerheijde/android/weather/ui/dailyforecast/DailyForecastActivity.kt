package com.boydhogerheijde.android.weather.ui.dailyforecast

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.boydhogerheijde.android.weather.R
import com.boydhogerheijde.android.weather.data.WeatherRepositoryImpl
import com.boydhogerheijde.android.weather.domain.interactor.RequestForecastInteractor
import com.boydhogerheijde.android.weather.extensions.addFragment
import com.boydhogerheijde.android.weather.extensions.findFragment

/**
 * @author Boyd Hogerheijde.
 */
class DailyForecastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        var fragment: DailyForecastFragment? = findFragment(R.id.fragmentContainer)
        if (fragment == null) {
            fragment = DailyForecastFragment.newInstance()
            addFragment(R.id.fragmentContainer, fragment)
        }

        DailyForecastPresenter(fragment, RequestForecastInteractor(WeatherRepositoryImpl()))
    }
}