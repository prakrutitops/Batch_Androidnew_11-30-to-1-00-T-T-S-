fun main()
{

    var course = mutableListOf("Android","Java","Testing","Flutter")
    var fees = mutableListOf(100,200,300,400)

    course.add("Selenium")

    //println(list)
    for(i in course)
    {
        println("course : $i")
    }
    for(i in fees)
    {
        println("Fees: $i")
    }


}