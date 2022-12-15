data class MyFirstExample(var name : String, var id : Int)
{

}
fun main()
{
    var m1 = MyFirstExample("A",101)
    var m2 = MyFirstExample("B",102)

  /*  println(m1)
    println(m2)*/

    if(m1==m2)
    {
        println("Equal")
    }
    else
    {
        println("Not Equal")
    }

    var m3 = m1.copy()
    println(m3)

}