class T1 : Thread()
{
    override fun run()
    {
        for(i in 1..10)
        {
            println("Thread A: $i")
        }
    }
}
class T2 : Thread()
{
    override fun run() {
        for(i in 1..10)
        {
            println("Thread B: $i")
        }
    }
}
fun main()
{
    var t1 = T1()
    var t2 = T2()

    t1.start()
    t2.start()
}