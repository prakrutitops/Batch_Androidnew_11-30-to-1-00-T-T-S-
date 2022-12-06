import com.sun.org.apache.xpath.internal.operations.Mult

interface Print
{
    fun print()
    {
        println("printing")
    }
}
 interface Show
{
    fun show()
    {
        println("showing")
    }
}
class MultipleEx :Print,Show
{

}
fun main()
{
    var m1 = MultipleEx()
    m1.print()
    m1.show()
}