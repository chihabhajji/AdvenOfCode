package tn.esprit.helpers;
import java.io.File;
public class PathToFile {
    // DAMN YOU JAVA AND YOUR TWISTED WAYS, YOU WERE THE CHOSEN ONE
    private static final String cd = new File("").getAbsolutePath();
    public static File convertActual(String fileName){
        return new File(cd + "\\resources\\actual\\" +fileName);
    }
    public static File convertTest(String fileName){
        return new File(cd + "\\resources\\tet\\" +fileName);
    }
    private PathToFile(){}
}
