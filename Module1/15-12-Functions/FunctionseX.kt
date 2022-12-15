//1.with para with return

fun add(a:Int,b:Int) : Int
{
    return a+b
}

//2)With Return Without Para

fun add2() :Int
{
    var a=5
    var b=6

    return  a+b
}

//3)With Para Without Return

fun add3(a:Int,b:Int)
{
    var c=a+b
    println(c)
}
//4)Without Para Without Return
fun add4()
{
    var a=5
    var b=3

    var c=a+b

    println(c)
}

fun main()
{
    println(add(5,7))
    println(add2())
    add3(7,5)
    add4()
}