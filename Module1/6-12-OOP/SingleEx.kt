open class A
{
    fun a1()
    {
        println("A accessed")
    }
}
class B :A()
{
    fun b1()
    {
        println("B accessed")
    }
}
fun main()
{
    var b = B()
    b.b1()
    b.a1()
}