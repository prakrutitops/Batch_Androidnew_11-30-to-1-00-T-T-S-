fun main()
{

    var data1= mutableMapOf<Int,String>(1 to "a",2 to "b",3 to "c")

    data1.put(4,"d")

    for(i in data1)
    {
        println("Key: ${i.key}")
        println("Value :${i.value}")
    }

}