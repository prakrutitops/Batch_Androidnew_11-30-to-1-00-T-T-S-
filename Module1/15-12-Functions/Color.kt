enum class Color
{
    Red,Green,Blue,Black,White,Orange,Yellow
}
fun main()
{
    var c1 : Color
    c1 = Color.Black


    when(c1)
    {
        Color.Red -> println("color is Red")
        Color.Green -> println("color is Green")
        Color.Orange-> println("color is Orange")
        Color.Yellow-> println("color is Yellow")
        Color.Blue -> println("color is blue")
        Color.Black -> println("color is black")
        Color.White -> println("color is white")
    }
}