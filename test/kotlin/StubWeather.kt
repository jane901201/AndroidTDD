class StubWeather :IWeather{
    //建立屬性，讓外部可設定假的天氣要回傳晴天或雨天
    var fakeIsSunny = true

    override fun isSunny(): Boolean {
        //回傳設定的假天氣
        return fakeIsSunny
    }
}