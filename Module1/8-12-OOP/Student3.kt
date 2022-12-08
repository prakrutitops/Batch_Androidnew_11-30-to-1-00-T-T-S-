class Student3(var id:Int,var name:String)
{
    companion object
    {
        var college:String="VVP"
    }
    fun display()
    {

        println()
        println("====================")
        println("Your id is $id")
        println("Your name is $name")
        println("Your college is $college")



    }


}
fun main()
{
    var s3 = Student3(101,"Chirag")
    var s4 = Student3(102,"Krupali")

    s3.display()
    s4.display()
}