fun main()
{

        var a = mutableListOf(1,2,3,4,5,6)
        var b = mutableListOf(6,7,8,9,10)

       /* a.add(6)
        a.addAll(b)
        a.removeAt(3)
        a.removeAll(b)*/

        a.retainAll(b)

        for(i in a)
        {
            println(i)
        }

}