fun main() {
    val weather = Weather()
    val umbrella = Umbrella()
    val totalPrice = umbrella.totalPrice(weather, 1, 600)
}
class Umbrella {
    fun totalPrice(weather: IWeather, quantity: Int, price: Int): Int {
        val isSunny = Weather().isSunny()
        var price = quantity * price

        if(isSunny) {
            price = (price * 0.9).toInt()
        }

        return price
    }
}