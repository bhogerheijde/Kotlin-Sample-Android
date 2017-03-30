package com.boydhogerheijde.android.weather.ui.dailyforecast

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * @author Boyd Hogerheijde.
 */
class DailyForecastAdapter(var forecast: List<String>) : RecyclerView.Adapter<DailyForecastAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder
            = ViewHolder(TextView(parent!!.context))

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.apply { textView.text = forecast[position] }
    }

    override fun getItemCount(): Int = forecast.size

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}