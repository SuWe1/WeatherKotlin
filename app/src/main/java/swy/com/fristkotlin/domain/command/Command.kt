package swy.com.fristkotlin.domain.command

/**
 * Created by Swy on 2017/8/19.
 */
interface Command<T> {
    fun  execute() : T
}