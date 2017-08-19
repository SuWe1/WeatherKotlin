package swy.com.fristkotlin.extensions

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by Swy on 2017/8/20.
 */

class NotNullSingleValueVar<T>() : ReadWriteProperty<Any?,T>{
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("${property.name} not initialized")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value =if(this.value==null) value else throw IllegalStateException("${property.name} already initialized")

    }

    private var value : T ?=null

}