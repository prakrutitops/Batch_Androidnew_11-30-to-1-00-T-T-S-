import java.io.FileOutputStream

//File Creation and Data writing

fun main()
{
        var s:String= "Welcome To Tops"
        var fout = FileOutputStream("E://krupali.txt")
        fout.write(s.toByteArray())
        println("Success")

}