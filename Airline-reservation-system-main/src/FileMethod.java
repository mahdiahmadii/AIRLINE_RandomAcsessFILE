import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class FileMethod{



    public String readChars(int n , RandomAccessFile rfile) throws IOException {
        String str = "";
        for(int i = 0 ; i < n ; i++){
            str = str + rfile.readChar();
        }
        return str.trim();
    }





    public String fixChars(int n , String str){
        for(int i = str.length() ; i < n ; i++){
            str = str + " ";
        }
        return str.substring(0,n);
    }



}
