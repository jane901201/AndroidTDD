import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito.*

class UmbrellaTest {

    @Test
    fun totalPrice_sunnyDay_NotUseMockito(){
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
    fun totoalPrice_sunnyDay_UstMockito() {
        val umbrella = Umbrella()
        val weather = mock(IWeather::class.java)
        `when`(weather.isSunny()).thenReturn(true)
        val actual = umbrella.totalPrice(weather, 3, 100)
        val expected = 270
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun totalPrice_rainingDay(){
        val umbrella = Umbrella()
        //建一個假的Weather
        val weather = StubWeather()
        //設定這個假的Weather永遠回傳目前天氣為晴天
        weather.fakeIsSunny = true

        //晴天的測試
        val actual = umbrella.totalPrice(weather, 3,100)
        val expected = 300
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun testInsertOrder() {
        val order = Order()
        val mockEmailUtil = MockEmailUtil()
        val userEmail = "test123@gmail.com"
        order.insertOrder(userEmail, 1, 200, mockEmailUtil)
        Assert.assertEquals(userEmail, mockEmailUtil.receiveEmail)
    }

    @Test
    fun insertOrderWithMockito() {
        val order = Order()
        val mockEmailUtil = mock(IEmailUtil::class.java)
        val userEmail = "somebody@gmail.com"
        order.insertOrder(userEmail, 1, 200, mockEmailUtil)
        verify(mockEmailUtil).sendCustomer(userEmail)
    }

}