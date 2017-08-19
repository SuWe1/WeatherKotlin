package swy.com.fristkotlin.domain

/**
 * Created by Swy on 2017/8/19.
 * //天气预报转换结果
 */
class Domain {
    data  class ForecastList(val city : String,val country : String, val dailyForecast : List<Forecast>){
        operator fun  get(position : Int) : Forecast =dailyForecast[position]
        fun size() : Int = dailyForecast.size
    }

    /**
     * data 日期
     * description 气温描述
     * main
     * high 最高温度
     * low 最低温度
     */
    data class Forecast(val date: String, val description: String, val iconUrl : String ,val high: Int, val low: Int)
}