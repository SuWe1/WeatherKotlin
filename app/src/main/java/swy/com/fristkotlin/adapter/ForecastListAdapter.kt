package swy.com.fristkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.find
import swy.com.fristkotlin.R
import swy.com.fristkotlin.domain.Domain
import swy.com.fristkotlin.extensions.ctx

/**
 * Created by Swy on 2017/8/19.
 */
class ForecastListAdapter(val  weekForecast : Domain.ForecastList,val listener : (Domain.Forecast) -> Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        val view =LayoutInflater.from(parent!!.ctx).inflate(R.layout.item_forecast,parent,false)
            return ViewHolder(view,listener)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int=weekForecast.size()


    class ViewHolder(val view : View,val clickListener: (Domain.Forecast) -> Unit) : RecyclerView.ViewHolder(view){

        private val iconView : ImageView
        private val dateView : TextView
        private val descriptionView : TextView
        private val maxTempetatureView : TextView
        private val minTempetatureView : TextView

        //初始化
        init{
            iconView=view.find(R.id.icon)
            dateView=view.findViewById(R.id.date)
            descriptionView=view.find(R.id.description)
            maxTempetatureView=view.find(R.id.maxTemperature)
            minTempetatureView=view.find(R.id.minTemperature)
        }


        /**
         * data 日期
         * description 气温描述
         * high 最高温度
         * low 最低温度
         * main 天气
         */
        fun  bindForecast(forecast :Domain.Forecast){
            with(forecast){
                Glide.with(view.context).load(iconUrl).into(iconView)
                dateView.text=description
                descriptionView.text=description
                maxTempetatureView.text= "${    high.toString() }"
                minTempetatureView.text= "${    low.toString() }"
                itemView.setOnClickListener { clickListener(this) }
            }
        }


    }


}