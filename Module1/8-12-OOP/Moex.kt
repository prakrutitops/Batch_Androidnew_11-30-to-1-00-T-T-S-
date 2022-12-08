class Moex
{
    fun add(a:Int,b:Int) :Int
    {
        return  a+b
    }

    fun add(a:Int,b:Int,c:Int) :Int
    {
        return  a*b*c
    }
}
fun main()
{
    var m1 =Moex()
    println(m1.add(5,6,7))
}