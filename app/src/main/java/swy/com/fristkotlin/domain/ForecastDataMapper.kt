package swy.com.fristkotlin.domain

import swy.com.fristkotlin.bean.ForecastResult
import java.text.DateFormat
import java.util.*
import swy.com.fristkotlin.domain.Domain.Forecast as ModelForecast

/**
 * Created by Swy on 2017/8/19.
 */
public class ForecastDataMapper {
    public fun  converFromDataModel( forecast: ForecastResult) : Domain.ForecastList{

        return Domain.ForecastList(forecast.city.name,forecast.city.country,convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list : List<ForecastResult.Forecast>):List<ModelForecast>{
        return  list.map {convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast : ForecastResult.Forecast) : ModelForecast{
        /**
         * forecast.temp.max.toInt() ForecastResult.Temperature的最高温度max转为high(float-->int)
         * forecast.temp.min.toInt() ForecastResult.Temperature的最高温度min转为low(float-->int)
         */
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description,getIconUrl(forecast.weather[0].icon), forecast.temp.max.toInt(), forecast.temp.min.toInt())
    }

    private fun getIconUrl( iconUrl :  String) : String="http://openweathermap.org/img/w/$iconUrl.png"

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }
}