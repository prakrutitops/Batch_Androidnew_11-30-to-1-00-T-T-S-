fun main()
{
    println("Enter Any Number")
    var num = readLine()!!.toInt()

    var flag = false

    for (i in 2..num / 2)
    {
        // condition for nonprime number
        if (num % i == 0)
        {
            flag = true
            break
        }
    }

    if (!flag)
        println("$num is a prime number.")
    else
        println("$num is not a prime number.")
}