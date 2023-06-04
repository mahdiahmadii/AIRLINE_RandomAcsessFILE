import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Admin extends FileMethod {

    /**
     * features
     */
    private String name = "admin";
    private String password = "admin";

    RandomAccessFile flights = new RandomAccessFile("Flights","rw");
//************************************************************************************************
    public Admin() throws FileNotFoundException {
    }
//************************************************************************************************

    /**
     *Getter & Setter
     */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
//**********************************************************************************************
    Scanner input = new Scanner(System.in);
    /**
     * methods
     */
    public void addFlight() throws IOException {
        System.out.println("__________________________________________________________");
        System.out.println("                         ADD FLIGHT                       ");
        System.out.println("__________________________________________________________");
        System.out.print("input the flight id:");
        String id = input.next();
        System.out.print("input the origin:");
        String origin = input.next();
        System.out.print("input the destination:");
        String destination = input.next();
        System.out.print("input the date:");
        String date = input.next();
        System.out.print("input the time:");
        String time = input.next();
        System.out.print("input the price :");
        int price = input.nextInt();
        System.out.print("input the seats :");
        int seats = input.nextInt();

        flights.readLine();

        flights.writeChars(fixChars(20 , id));
        flights.writeChars(fixChars(20 , origin));
        flights.writeChars(fixChars(20 , destination));
        flights.writeChars(fixChars(20 , date));
        flights.writeChars(fixChars(20 , time));
        flights.writeInt(price);
        flights.writeInt(seats);


        //number of flights in file
//        long savePointer = flights.getFilePointer();
//        flights.seek(0);
//        int n = flights.readInt();
//        flights.writeInt(n+1);
//        flights.seek(savePointer);

        System.out.println("__________________________________________________________");
        System.out.println("Done!");

    }

//************************************************************************************

    public void removeFlight() throws IOException {
        System.out.println("__________________________________________________________");
        System.out.println("                       REMOVE FLIGHT                      ");
        System.out.println("__________________________________________________________");
        //last pointer
        flights.seek(0);
        flights.readLine();
        long lastPointer = flights.getFilePointer();
        flights.seek(0);
        //print inputs info
        String ID = showRemoveFlight();
        //read number f flights
        //int n = flights.readInt();
        //search to find
        while(flights.getFilePointer()<lastPointer){
            int recordPointer = (int)flights.getFilePointer();
            String id = readChars(20,flights);
            String origin = readChars(20,flights);
            String destination = readChars(20,flights);
            String date = readChars(20,flights);
            String time = readChars(20,flights);
            int price = flights.readInt();
            int seats = flights.readInt();
            //replace by null
            if(id.equals(ID)){
                flights.seek(recordPointer);
                flights.writeChars(fixChars(20 , ""));
                flights.writeChars(fixChars(20 , ""));
                flights.writeChars(fixChars(20 , ""));
                flights.writeChars(fixChars(20 , ""));
                flights.writeChars(fixChars(20 , ""));
                flights.writeInt(0);
                flights.writeInt(0);
            }
        }
        System.out.println("__________________________________________________________");
    }
    public String showRemoveFlight(){
        System.out.print("Input the Id of flight you want to remove: ");
        String id = input.next();
        return id;
    }
    //********************************************************************************************************

    public void flightSchedule() throws IOException {
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n","ID","Origin","Destination","Date","Time","price","seats");
        flights.seek(0);
        flights.readLine();
        long lastpointer = flights.getFilePointer();
        flights.seek(0);
        //int n =flights.readInt();
        while(flights.getFilePointer()<lastpointer){

            String iD = readChars(20,flights);
            String origin = readChars(20,flights);
            String destination = readChars(20,flights);
            String date = readChars(20,flights);
            String time = readChars(20,flights);
            int price = flights.readInt();
            int seats = flights.readInt();

            if(!(iD.equals(""))) {
                System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20d | %-20d |",
                        iD,
                        origin,
                        destination,
                        date,
                        time,
                        price,
                        seats);
                System.out.println(".");

            }

        }
        System.out.println("__________________________________________________________");

    }
//****************************************************************************************************


    public void updateFlights() throws IOException {

        System.out.println("__________________________________________________________");
        System.out.println("                     UPDATE FLIGHTS                       ");
        System.out.println("__________________________________________________________");
        long startPointer = updateFlightsMenu();
        flights.seek(startPointer);

        System.out.print("input the new flight id:");
        String id = input.next();
        System.out.print("input the new origin:");
        String origin = input.next();
        System.out.print("input the new destination:");
        String destination = input.next();
        System.out.print("input the new date:");
        String date = input.next();
        System.out.print("input the new time:");
        String time = input.next();
        System.out.print("input the new price :");
        int price = input.nextInt();
        System.out.print("input the new seats :");
        int seats = input.nextInt();


        flights.writeChars(fixChars(20 , id));
        flights.writeChars(fixChars(20 , origin));
        flights.writeChars(fixChars(20 , destination));
        flights.writeChars(fixChars(20 , date));
        flights.writeChars(fixChars(20 , time));
        flights.writeInt(price);
        flights.writeInt(seats);
        System.out.println("__________________________________________________________");
    }






    public long updateFlightsMenu() throws IOException {
        System.out.println("input the id of flight you want to change: ");
        String id = input.next();
        flights.seek(0);
        flights.readLine();
        long lastPointer = flights.getFilePointer();
        flights.seek(0);
        long truePointer = 2;

        while(flights.getFilePointer()<lastPointer) {
            int recordPointer = (int) flights.getFilePointer();
            String Id = readChars(20, flights);
            String origin = readChars(20, flights);
            String destination = readChars(20, flights);
            String date = readChars(20, flights);
            String time = readChars(20, flights);
            int price = flights.readInt();
            int seats = flights.readInt();

            if (id.equals(Id)){
                truePointer = recordPointer;
                break;
            }
        }
        return truePointer;
    }



}
