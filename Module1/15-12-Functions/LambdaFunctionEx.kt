
class MyFirstClass2
{
    fun addTwoNum(a: Int , b : Int, action: (Int) ->Unit)
    {
        val sum = a+b
        action(sum)
    }
}
fun main()
{
    val my = MyFirstClass2()
    val myLambda : (Int) -> Unit={s : Int -> println(s)} //lmabda expression
    my.addTwoNum(2,3,myLambda)
}