package swy.com.fristkotlin.db

import swy.com.fristkotlin.domain.Domain

/**
 * Created by Swy on 2017/8/20.
 */
class DbDataMapper {

    fun convertToDomain(forecast: CityForecast) = with(forecast) {
        val daily = dailyForecast.map { convertDayToDomain(it) }
        Domain.ForecastList(_id,city, country, daily)
    }

    fun convertDayToDomain(dayForecast: DayForecast) = with(dayForecast) {
        Domain.Forecast(_id,date, description, iconUrl,high, low)
    }

    fun convertFromDomain(forecast : Domain.ForecastList)= with(forecast){
            val  daily=dailyForecast.map { convertDayFromDomain(id,it) }
        CityForecast(id,city,country,daily)
    }

    fun convertDayFromDomain(cityId : Long, forecast : Domain.Forecast)=
        with(forecast){
            DayForecast(date,description,high,low,iconUrl,cityId)
        }

}