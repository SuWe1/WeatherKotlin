package swy.com.fristkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import swy.com.fristkotlin.domain.Domain

/**
 * Created by Swy on 2017/8/19.
 */
class ForecastListAdapter(val  weekForecast : Domain.ForecastList) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
            return ViewHolder(TextView(parent!!.context))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
            with(weekForecast.dailyForecast[position]){
                /**
                 * data 日期
                 * description 气温描述
                 * high 最高温度
                 * low 最低温度
                 * main
                 */
                holder!!.textview.text="$date - $description - $high/$low - $main"
            }

    }

    override fun getItemCount(): Int=weekForecast.dailyForecast.size


    class ViewHolder(val textview : TextView) : RecyclerView.ViewHolder(textview)
}