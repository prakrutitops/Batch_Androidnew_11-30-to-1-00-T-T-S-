open class A1
{
    fun a1()
    {
        println("A accessed")
    }
}
open class B1 :A1()
{
    fun b1()
    {
        println("B accessed")
    }
}
class C1 :B1()
{
    fun c1()
    {
        println("C accessed")
    }
}
fun main()
{
    var c = C1()
    c.b1()
    c.a1()
    c.c1()

}