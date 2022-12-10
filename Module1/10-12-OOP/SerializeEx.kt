import java.io.FileOutputStream
import java.io.ObjectOutputStream

class SerializeEx
{

    fun mydata()
    {
        var t12 = Tops12(101,"abcd")
        var fout =FileOutputStream("E://Chirag.txt")
        var out12:ObjectOutputStream = ObjectOutputStream(fout)
        out12.writeObject(t12)
    }



}
fun main()
{
    var s1 = SerializeEx()
    s1.mydata()
}