package com.boydhogerheijde.android.weather.ui.dailyforecast

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.*
import com.boydhogerheijde.android.weather.R
import com.boydhogerheijde.android.weather.domain.model.ForecastList
import com.boydhogerheijde.android.weather.extensions.inflateLayout
import com.boydhogerheijde.android.weather.extensions.showSnackbar
import com.boydhogerheijde.android.weather.extensions.supportsLollipop
import kotlinx.android.synthetic.main.fragment_daily_forecast.*

/**
 * @author Boyd Hogerheijde.
 */
class DailyForecastFragment : Fragment(), DailyForecastContract.View {

    lateinit private var presenter: DailyForecastContract.Presenter

    companion object {
        fun newInstance() = DailyForecastFragment()
    }

    override fun setPresenter(presenter: DailyForecastContract.Presenter) {
        this.presenter = presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = container?.inflateLayout(R.layout.fragment_daily_forecast)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        swipeRefreshLayout.apply {
            setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent)
            setOnRefreshListener { presenter.start() }
        }

        supportsLollipop {
            // Some code which works from Lollipop and up...
        }

        dailyForecastRecycler.apply { layoutManager = LinearLayoutManager(context); setHasFixedSize(true) }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_daily_forecast, menu)
    }

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun setLoading(isLoading: Boolean) {
        swipeRefreshLayout.post { swipeRefreshLayout.isRefreshing = isLoading }
    }

    override fun showDailyForecast(forecastList: ForecastList?) {
        Log.d(javaClass.simpleName, forecastList?.toString())
        dailyForecastRecycler.adapter = DailyForecastAdapter(listOf("Sunny", "Windy", "Cloudy", "Foggy", "Stormy", "Rainy", "Snowy"))
        showSnackbar("Forecast loaded!")
    }

    override fun showNoConnection() {}

    override fun showDataUnavailable() {}
}
