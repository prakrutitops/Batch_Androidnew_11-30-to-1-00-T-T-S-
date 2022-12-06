class Tops(var num:String,var city:String,var owner:String)//Primary Constructor
{
    fun display()
    {
        println("Your Number is $num")
        println("Your City is $city")
        println("Your Owner is $owner")
    }
}
fun main()
{
    var t1 = Tops("9724004242","Rajkot","Xyz")
    var t2 = Tops("9724004243","Baroda","Abc")
    var t3 = Tops("9724004244","Ahmedabad","Pqr")

    t1.display()
    t2.display()
    t3.display()
}