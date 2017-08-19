package swy.com.fristkotlin.app

import android.app.Application
import swy.com.fristkotlin.extensions.NotNullSingleValueVar
import kotlin.properties.Delegates

/**
 * Created by Swy on 2017/8/20.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance=this
    }

    companion object {
        var instance : App by NotNullSingleValueVar()
    }
}