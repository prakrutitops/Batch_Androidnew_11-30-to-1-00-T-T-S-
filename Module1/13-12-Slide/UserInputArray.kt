import java.lang.Integer.parseInt

fun main()
{

        var a = IntArray(5) //arrau declare


        //UserInput for Array
        for(i in 0..4)
        {
            println("Enter Marks : $i")
            val data = readLine()
            a[i]=parseInt(data)

        }

        //print array detail
        for(i in 0..4)
        {
           // println(a[i])
            a[i]+=a[i]
            println(a[i])
        }




}