package swy.com.fristkotlin.domain.command

import swy.com.fristkotlin.domain.Domain
import swy.com.fristkotlin.domain.ForecastDataMapper
import swy.com.fristkotlin.request.ForecastRequest

/**
 * Created by Swy on 2017/8/19.
 */
class RequestForecastCommand(val  zipCode : String) : Command<Domain.ForecastList> {
    override fun execute(): Domain.ForecastList {
        val forecastRequest=ForecastRequest(zipCode)
        return  ForecastDataMapper().converFromDataModel(forecastRequest.execute())
    }
}