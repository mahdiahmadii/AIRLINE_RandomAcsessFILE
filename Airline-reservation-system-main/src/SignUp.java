import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class SignUp extends FileMethod {
    private RandomAccessFile passengers = new RandomAccessFile("Passengers" , "rw");

    Scanner input = new Scanner(System.in);
    //************************************************************************************************
    public SignUp(RandomAccessFile passengers) throws FileNotFoundException {
        this.passengers = passengers;
    }
    //**********************************************************************************************

    public void addPassenger() throws IOException {
        System.out.println("__________________________________________________________");
        System.out.println("                        SIGNUP                            ");
        System.out.println("__________________________________________________________");

        System.out.print("input the name of passanger: ");
        String name = input.next();
        System.out.print("input the username of passanger :");
        String username = input.next();
        System.out.print("input the password of passenger :");
        String passWord = input.next();
        int charge = 0;

        passengers.readLine();
        passengers.writeChars(fixChars(20, username));
        passengers.writeChars(fixChars(20, passWord));
        passengers.writeChars(fixChars(20, name));
        passengers.writeInt(charge);
        for(int i = 0 ; i < 5 ; i++){
            passengers.writeChars(fixChars(20,"."));
            passengers.writeChars(fixChars(20,"."));
            passengers.writeChars(fixChars(20,"."));
            passengers.writeChars(fixChars(20,"."));
            passengers.writeChars(fixChars(20,"."));
            passengers.writeChars(fixChars(20,"."));
            passengers.writeChars(fixChars(20,"."));
            passengers.writeInt(0);
        }
        System.out.println("__________________________________________________________");
        System.out.println("Done");

    }
}
