import java.io.FileInputStream
import java.io.ObjectInputStream

class DeserialoizeEx
{

    fun mydata2()
    {
        var in1=ObjectInputStream(FileInputStream("E://Chirag.txt"))
        var s:Tops12= in1.readObject() as Tops12
        println("${s.id} and ${s.name}")

    }

}
fun main()
{
    var s1 = DeserialoizeEx()
    s1.mydata2()
}