import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class SignIn extends FileMethod {
    Scanner input = new Scanner(System.in);

    private RandomAccessFile passegers = new RandomAccessFile("Passengers","rw");
    //*********************************************************************************************
    public SignIn() throws FileNotFoundException {
    }
    //**********************************************************************************************
    public long signIn(String username , String password) throws IOException {


        passegers.seek(0);
        passegers.readLine();

        long lastPoint = passegers.getFilePointer();
        passegers.seek(0);
        while(lastPoint > passegers.getFilePointer()){
            long savepoint = passegers.getFilePointer();
            String userName = readChars(20,passegers);
            String pass = readChars(20,passegers);
            String name = readChars(20,passegers);
            int charge = passegers.readInt();

            String flightid1 = readChars(20,passegers);
            String origin1 = readChars(20,passegers);
            String destin1 = readChars(20,passegers);
            String date1 = readChars(20,passegers);
            String time1 = readChars(20,passegers);
            String ticketid1= readChars(20,passegers);
            String name1 = readChars(20,passegers);
            int price1 = passegers.readInt();

            String flightid22 = readChars(20,passegers);
            String origin2 = readChars(20,passegers);
            String destin2 = readChars(20,passegers);
            String date2 = readChars(20,passegers);
            String time2 = readChars(20,passegers);
            String ticketid2 = readChars(20,passegers);
            String name2 = readChars(20,passegers);
            int price2 = passegers.readInt();

            String flightid3 = readChars(20,passegers);
            String origin3 = readChars(20,passegers);
            String destin3 = readChars(20,passegers);
            String date3 = readChars(20,passegers);
            String time3 = readChars(20,passegers);
            String ticketid3 = readChars(20,passegers);
            String name3 = readChars(20,passegers);
            int price3 = passegers.readInt();

            String flightid4 = readChars(20,passegers);
            String origin4 = readChars(20,passegers);
            String destin4 = readChars(20,passegers);
            String date4 = readChars(20,passegers);
            String time4 = readChars(20,passegers);
            String ticketid4 = readChars(20,passegers);
            String name4 = readChars(20,passegers);
            int price4 = passegers.readInt();

            String flightid5 = readChars(20,passegers);
            String origin5 = readChars(20,passegers);
            String destin5 = readChars(20,passegers);
            String date5 = readChars(20,passegers);
            String time5 = readChars(20,passegers);
            String ticketid5 = readChars(20,passegers);
            String name5 = readChars(20,passegers);
            int price5 = passegers.readInt();

            if(userName.equals(username) && password.equals(pass)){
                System.out.println("Ok");
                return savepoint;
            }
        }
        return 2;
    }
}
