package swy.com.fristkotlin.interfaces

import swy.com.fristkotlin.domain.Domain

/**
 * Created by Swy on 2017/8/19.
 */
interface OnItemClickListener {
    //被调用时 invoke  方面可以被省略  --> clickListener(forecast)
    operator fun invoke(forecast: Domain.Forecast)
}