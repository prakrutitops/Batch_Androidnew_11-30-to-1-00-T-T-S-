class MyFirstClass
{
    fun hasPassed(marks : Int) : Boolean
    {
        return marks > 40
    }
}


fun MyFirstClass.isScholar(marks: Int):Boolean
{
    return marks>90

}

fun main()
{
    var my = MyFirstClass()
    println("Pass Status:"+my.hasPassed(95))
    println("Scholarship status :"+my.isScholar(95))

}
