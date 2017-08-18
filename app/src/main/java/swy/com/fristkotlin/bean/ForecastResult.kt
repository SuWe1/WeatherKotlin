package swy.com.fristkotlin.bean

/**
 * Created by Swy on 2017/8/19.
 */
data class ForecastResult(val city :City,val list : List<Forecast>) {
    /**
     * {
    "city": {
    "id": 5375480,
    "name": "Mountain View",
    "coord": {
        "lon": -122.0839,
         "lat": 37.3861
    },
    "country": "US",
    "population": 0
    },
    "cod": "200",
    "message": 0.8119479,
    "cnt": 7,
    "list": [{
       "dt": 1503086400,
       "temp": {
         "day": 26.22,
         "min": 12.79,
         "max": 26.36,
         "night": 12.79,
         "eve": 21.24,
         "morn": 22.46
       },
       "pressure": 990.5,
       "humidity": 66,
       "weather": [{
          "id": 800,
          "main": "Clear",
          "description": "sky is clear",
          "icon": "01d"
        }],
       "speed": 1.42,
       "deg": 255,
       "clouds": 0
    }]
    }
     */
    data class City(val id :Long ,val name :String ,val coord : Coordinataes , val country : String, val  population : Int)

    data class Coordinataes(val lon : Float, val lat : Float)

    data class Forecast(val dt : Long ,val temp : Temperature, val pressure : Float , val humidity : Int ,val weather : List<Weather>
                        ,val speed : Float,val deg : Int ,val clouds : Int
    )

    data class Temperature(val day: Float, val min: Float, val max: Float, val night: Float, val eve: Float, val morn: Float)

    data class Weather(val id: Long, val main: String, val description: String, val icon: String)
}