open class A2
{
    fun a2()
    {
        println("a2 accessed")
    }
}
open class B2 :A2()
{
    fun b2()
    {
        println("b2 accessed")
    }
}
interface C2
{
    fun c2()
    {
        println("c2 accessed")

    }
}
open class D2 :B2()
{
    fun d2()
    {
        println("d2 accessed")
    }
}

class HybridEx : C2,D2()
{

}
fun main()
{
    var h1 = HybridEx()
    h1.a2()
    h1.b2()
    h1.c2()
    h1.d2()
}