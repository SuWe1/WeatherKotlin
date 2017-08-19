package swy.com.fristkotlin.extensions

/**
 * Created by Swy on 2017/8/20.
 */

fun <K, V : Any> Map<K, V?>.toVarargArray(): Array<out Pair<K, V>> =
        map({ Pair(it.key, it.value!!) }).toTypedArray()