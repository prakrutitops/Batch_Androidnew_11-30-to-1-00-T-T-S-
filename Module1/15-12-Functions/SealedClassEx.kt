sealed class A12
{
    class B :A12()
    object C :A12()
}
fun main()
{
    val x : A12 =A12.C
    val output = when(x)
    {
        is A12.B->"B class"
        is A12.C->"object"
    }
    println(output)

}
