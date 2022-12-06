class student
{
    var name =""
    var rollno=1
    var city=""

    fun detail()
    {
        println("Your Name is $name")
        println("Your rollno is $rollno")
        println("Your City is $city")
    }

}
fun main()
{
    var s1 = student()
    s1.name="Krupali"
    s1.rollno=101
    s1.city="Gondal"
    s1.detail()
    println()
    println("==============================")

    var s2 = student()
    s2.name="Chirag"
    s2.rollno=102
    s2.city="Rajkot"
    s2.detail()
    println()
    println("==============================")


    var s3 = student()
    s3.name="Prakruti"
    s3.rollno=103
    s3.city="Rajkot"
    s3.detail()
    println()
    println("==============================")


}