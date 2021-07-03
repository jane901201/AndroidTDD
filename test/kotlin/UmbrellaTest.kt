import org.junit.Assert
import org.junit.Test

class UmbrellaTest {

    @Test
    fun totalPrice_sunnyDay(){
        val umbrella = Umbrella()
        //建一個假的Weather
        val weather = StubWeather()
        //設定這個假的Weather永遠回傳目前天氣為晴天
        weather.fakeIsSunny = true

        //晴天的測試
        val actual = umbrella.totalPrice(weather, 3,100)
        val expected = 270
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun totalPrice_rainingDay(){
        val umbrella = Umbrella()
        //建一個假的Weather
        val weather = StubWeather()
        //設定這個假的Weather永遠回傳目前天氣為晴天
        weather.fakeIsSunny = false

        //晴天的測試
        val actual = umbrella.totalPrice(weather, 3,100)
        val expected = 300
        Assert.assertEquals(expected, actual)
    }
}