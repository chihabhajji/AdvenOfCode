package tn.esprit.helpers;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class PathToFile {
    // DAMN YOU JAVA AND YOUR TWISTED WAYS, YOU WERE THE CHOSEN ONE
    private static final String cd = new File("").getAbsolutePath();
    public static BufferedReader pathToBufferReader(String fileName) throws FileNotFoundException {
        return new BufferedReader(new FileReader(cd + "\\resources\\actual\\" +fileName));
    }
    public static File convertTest(String fileName){
        return new File(cd + "\\resources\\tet\\" +fileName);
    }
    private PathToFile(){}
}
