class Tops2
{
    constructor(id:Int,name:String)
    {
            println("Your id is $id")
            println("Your Name is $name")
    }
    constructor(id:Int,name:String,number:String)
    {
        println("Your id is $id")
        println("Your Name is $name")
        println("Your Number is $number")
    }
    constructor(id:Int,name:String,number: String,city:String)
    {
        println("Your id is $id")
        println("Your Name is $name")
        println("Your Number is $number")
        println("Your City is $city")
    }
}

fun main()
{
    var t1 = Tops2(101,"a","2121213","rjsrhew")

    println("===================")

    var t2 = Tops2(101,"a",)

}
