import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;


public class Passenger extends FileMethod {


    private RandomAccessFile passengers = new RandomAccessFile("Passengers","rw");
    private RandomAccessFile flights = new RandomAccessFile("Flights" , "rw");
    Scanner input = new Scanner(System.in);

    public Passenger() throws FileNotFoundException {
    }
    //*************************************************************************************************
    public void addCharge(long pointer) throws IOException {
        System.out.println("__________________________________________________________");
        System.out.println("                         ADD CHARGE                       ");
        System.out.println("__________________________________________________________");


        passengers.seek(pointer+120);
        int charge = passengers.readInt();
        System.out.println("your current charge is : " + charge + " toman!" );
        System.out.print("input the charge you want to add:");
        passengers.seek(pointer+120);
        charge = passengers.readInt() + input.nextInt();
        passengers.seek(pointer+120);
        passengers.writeInt(charge);
        System.out.println("your charge updated to : " + charge + " toman!" );
        System.out.println("__________________________________________________________");
        input.nextLine();
    }

//*************************************************************************************************

    public void changePassword(long pointer) throws IOException {
        System.out.println("__________________________________________________________");
        System.out.println("                        CHANGE PASSWORD                   ");
        System.out.println("__________________________________________________________");
        System.out.print("input the new password: ");
        String pass = input.next();
        passengers.seek(pointer+40);
        passengers.writeChars(fixChars(20,pass));

        System.out.println("password updated to \""+pass+"\" succesfully!");
        System.out.println("__________________________________________________________");
        input.nextLine();

    }

//************************************************************************************************

    public void bookingTicket(long pointer) throws IOException {
        System.out.println("__________________________________________________________");
        System.out.println("                       BOOKING TICKET                     ");
        System.out.println("__________________________________________________________");
        System.out.print("input the id you want to buy :");
        String id = input.next();

        String flightid="";
        String origin="";
        String destination="";
        String date="";
        String time="";
        char[]chars ={'a','b','c','d','e'};
        String ticketId = getRandomString(8,chars);
        int price=0;
        int seats;
        long savepointer=0;

        flights.seek(0);
        flights.readLine();
        long flightlastpointer = flights.getFilePointer();
        flights.seek(0);
        while(flights.getFilePointer() < flightlastpointer){

            savepointer = flights.getFilePointer();
            flightid = readChars(20,flights);
            origin = readChars(20,flights);
            destination = readChars(20,flights);
            date = readChars(20,flights);
            time = readChars(20,flights);
            price = flights.readInt();
            seats = flights.readInt();
            if(flightid.equals(id)){
                break;
            }

        }



        passengers.seek(pointer);
        readChars(20,passengers);
        readChars(20,passengers);
        String nameforwrite = readChars(20,passengers);
        long chargepointer = passengers.getFilePointer();
        int chargeof =passengers.readInt();

        for(int i = 0 ; i < 5 ; i++){
            long spoint = passengers.getFilePointer();
            String flightid1 = readChars(20,passengers);
            String origin1 = readChars(20,passengers);
            String destin1 = readChars(20,passengers);
            String date1 = readChars(20,passengers);
            String time1 = readChars(20,passengers);
            String ticketid1= readChars(20,passengers);
            String name1 = readChars(20,passengers);
            int price1 = passengers.readInt();

            if(flightid1.equals(".")){

                passengers.seek(spoint);
                passengers.writeChars(fixChars(20,flightid));
                passengers.writeChars(fixChars(20,origin));
                passengers.writeChars(fixChars(20,destination));
                passengers.writeChars(fixChars(20,date));
                passengers.writeChars(fixChars(20,time));
                passengers.writeChars(fixChars(20,ticketId));
                passengers.writeChars(fixChars(20,nameforwrite));
                passengers.writeInt(price);
                flights.seek(savepointer+204);
                int seats2 = flights.readInt()-1;
                flights.seek(savepointer+204);
                flights.writeInt(seats2);
                passengers.seek(chargepointer);
                passengers.writeInt(chargeof-price);

                break;

            }

        }
        System.out.println("__________________________________________________________");

    }


    public String getRandomString(int length, char[] characterSet) {
        StringBuilder sb = new StringBuilder();

        for (int loop = 0; loop < length; loop++) {
            int index = new Random().nextInt(characterSet.length);
            sb.append(characterSet[index]);
        }

        String nonce = sb.toString();
        return nonce;
    }

    //********************************************************************************************



    public void bookedTicket(long pointer) throws IOException {
        System.out.println("__________________________________________________________");
        System.out.println("                       BOOKED TICKET                      ");
        System.out.println("__________________________________________________________");
        passengers.seek(pointer);
        String userName = readChars(20,passengers);
        String pass = readChars(20,passengers);
        String name = readChars(20,passengers);
        int charge = passengers.readInt();
        for(int i = 0 ; i < 5 ; i++) {
            String flightid1 = readChars(20, passengers);
            String origin1 = readChars(20, passengers);
            String destin1 = readChars(20, passengers);
            String date1 = readChars(20, passengers);
            String time1 = readChars(20, passengers);
            String ticketid1 = readChars(20, passengers);
            String name1 = readChars(20, passengers);
            int price1 = passengers.readInt();


            if(!(flightid1.equals("."))){
                System.out.println( i+1 +" : FLight "+flightid1+" booked!");
            }
        }
        System.out.println("__________________________________________________________");
    }

    //*********************************************************************************************

    public void TicketCancelation(long pointer) throws IOException {
        System.out.println("__________________________________________________________");
        System.out.println("                      TICKET CANCELATION                  ");
        System.out.println("__________________________________________________________");
        passengers.seek(pointer+124);
        System.out.println("input the id of flight you want to cancel");
        String id = input.next();
        for(int i = 0 ; i < 5 ; i++){
            long savepoint = passengers.getFilePointer();
            String flightid1 = readChars(20, passengers);
            String origin1 = readChars(20, passengers);
            String destin1 = readChars(20, passengers);
            String date1 = readChars(20, passengers);
            String time1 = readChars(20, passengers);
            String ticketid1 = readChars(20, passengers);
            String name1 = readChars(20, passengers);
            int price1 = passengers.readInt();

            if(flightid1.equals(id)){
                //removing the ticket
                passengers.seek(savepoint);
                passengers.writeChars(fixChars(20,"."));
                passengers.writeChars(fixChars(20,"."));
                passengers.writeChars(fixChars(20,"."));
                passengers.writeChars(fixChars(20,"."));
                passengers.writeChars(fixChars(20,"."));
                passengers.writeChars(fixChars(20,"."));
                passengers.writeChars(fixChars(20,"."));
                passengers.writeInt(0);

                //adding charge
                passengers.seek(pointer+120);
                int newCharge = price1 + passengers.readInt();
                passengers.seek(pointer+120);
                passengers.writeInt(newCharge);

                //adding 1 to flight seats
                flightSeatAdder(flightid1);


            }
        }
        System.out.println("__________________________________________________________");
    }







    public void flightSeatAdder(String ID) throws IOException {
        flights.seek(0);
        flights.readLine();
        long lastpointer = flights.getFilePointer();
        flights.seek(0);
        while(flights.getFilePointer() < lastpointer ){
            int recordPointer = (int)flights.getFilePointer();
            String id = readChars(20,flights);
            String origin = readChars(20,flights);
            String destination = readChars(20,flights);
            String date = readChars(20,flights);
            String time = readChars(20,flights);
            int price = flights.readInt();
            int seats = flights.readInt();
            if(id.equals(ID)){
                flights.seek(recordPointer+204);
                int newSeats = flights.readInt()+1;
                flights.seek(recordPointer+204);
                flights.writeInt(newSeats);
            }
        }
    }

    //**********************************************************************************************

    public void searchFlightTicket() throws IOException {
        System.out.println("__________________________________________________________");
        System.out.println("                      SEARCH FLIGHTS                      ");
        System.out.println("__________________________________________________________");
        System.out.print("input the word you want to filter the flights by: ");
        String filteringWord = input.next();
        flights.readLine();
        long lastPointerOfFlights = flights.getFilePointer();
        flights.seek(0);
        while(flights.getFilePointer() < lastPointerOfFlights){
            String iD = readChars(20,flights);
            String origin = readChars(20,flights);
            String destination = readChars(20,flights);
            String date = readChars(20,flights);
            String time = readChars(20,flights);
            int price = flights.readInt();
            int seats = flights.readInt();

            if(iD.contains(filteringWord)||
                    origin.contains(filteringWord)||
                    destination.contains(filteringWord)||
                    date.contains(filteringWord)||
                    time.contains(filteringWord)){

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
}
