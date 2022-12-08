class Counter
{
    companion object
    {
        var count=0


    }
    constructor(id:Int,name:String)
    {
        count++
        println(count)
    }


}
fun main()
{
    var c1 = Counter(101,"A")
    var c2 = Counter(102,"B")
    var c3 = Counter(103,"C")

}