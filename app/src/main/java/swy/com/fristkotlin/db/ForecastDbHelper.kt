package swy.com.fristkotlin.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*
import swy.com.fristkotlin.app.App

/**
 * Created by Swy on 2017/8/20.
 */
class ForecastDbHelper( ctx : Context = App.instance) : ManagedSQLiteOpenHelper(ctx, ForecastDbHelper.DB_NAME,null,ForecastDbHelper.DB_VERSION) {

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.dropTable(CityForecastTable.NAME,true)
        db.dropTable(DayForecastTable.NAME,true)
        onCreate(db)
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(CityForecastTable.NAME, true,
                CityForecastTable.ID to INTEGER + PRIMARY_KEY,
                CityForecastTable.CITY to TEXT,
                CityForecastTable.COUNTRY to TEXT)

        db.createTable(DayForecastTable.NAME, true,
                DayForecastTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                DayForecastTable.DATE to INTEGER,
                DayForecastTable.DESCRIPTION to TEXT,
                DayForecastTable.HIGH to INTEGER,
                DayForecastTable.LOW to INTEGER,
                DayForecastTable.ICON_URL to TEXT,
                DayForecastTable.CITY_ID to INTEGER)
    }

    /**
    使用了 lazy 委托，它表示直到它真的被调用才会被创建。
    用这种方法，如果数据库从来没有被使用，我们没有必要去创建这个对象。一
    般 lazy 委托的代码块可以阻止在多个不同的线程中创建多个对象。这个只会发生
    在两个线程在同事时间访问这个 instance 对象，它很难发生但是发生具体还有看
    app的实现。无人如何， lazy 委托是线程安全的。
     */
    companion object {
        val DB_NAME = "forecast.db"
        val DB_VERSION = 1
        val instance by lazy { ForecastDbHelper() }
    }
}