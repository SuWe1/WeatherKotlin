package swy.com.fristkotlin

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import org.jetbrains.anko.doAsync
import swy.com.fristkotlin.adapter.ForecastListAdapter
import swy.com.fristkotlin.bean.Forecast
import swy.com.fristkotlin.domain.command.RequestForecastCommand
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        message.text="hello kotlin!"
        val forecastList=findViewById<RecyclerView>(R.id.forecast_list) as RecyclerView
        forecastList.layoutManager=LinearLayoutManager(this)

        doAsync {
            val result=RequestForecastCommand("94043").execute()
            forecastList.adapter=ForecastListAdapter(result)
            forecastList.adapter.notifyDataSetChanged()
        }

    }



    fun  Context.toast(message : CharSequence ,duration : Int = Toast.LENGTH_LONG){
        Toast.makeText(this,message,duration).show()
    }

    fun  test(){
        val  f1=Forecast(Date(),27.5f,"Shiny Day")
        //复制一个数据类
        val f2=f1.copy(temperature = 27f)
        //映射对象到变量中
        val (date,temperature,detail)=f1

    }


}
