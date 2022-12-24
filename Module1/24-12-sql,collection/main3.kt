//immutable list
fun main(args: Array<String>)
{

    var course = setOf("Android","Java","Testing","Flutter","Android")
    var fees = setOf(100,200,300,400)


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