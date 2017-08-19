package swy.com.fristkotlin.data

import swy.com.fristkotlin.domain.Domain

/**
 * Created by Swy on 2017/8/20.
 */

interface ForecastDataSource {

    fun requestForecastByZipCode(zipCode: Long, date: Long): Domain.ForecastList?

    fun requestDayForecast(id: Long): Domain.Forecast?

}