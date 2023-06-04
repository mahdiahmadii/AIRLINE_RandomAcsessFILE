import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
public class RunTheProgram extends ColorFullTextsAndBackground {
    Scanner input = new Scanner(System.in);
    private RandomAccessFile passengers = new RandomAccessFile("Passengers","rw");
    private RandomAccessFile flights = new RandomAccessFile("Flights","rw");
    //*****************************************************************************************************************************constructor
    public RunTheProgram() throws FileNotFoundException {
    }
    //*****************************************************************************************************************************
    public void runTheProgram() throws IOException {
        SignUp signup = new SignUp(passengers);
        SignIn signin = new SignIn();
        Admin admin = new Admin();
        Passenger passengerss = new Passenger();
        int c = 0;
        while (c==0) {//start of code
            mainMenu();
            String command = input.next();

            //SIGNIN
            while (command.equals("1")) {

                signInShow();
                System.out.print("Username: ");
                String username = input.next();
                System.out.print("password: ");
                String password = input.next();

                //ADMIN
                while(username.equals("admin")&&password.equals("admin") && c==0){
                    adminOptionShow();
                    String adminCommand = input.next();
                    if(adminCommand.equals("1"))
                    {
                        admin.addFlight();
                    }
                    if(adminCommand.equals("2")){
                        admin.updateFlights();
                    }
                    if(adminCommand.equals("3")){
                        admin.removeFlight();
                    }
                    if(adminCommand.equals("4")){
                        admin.flightSchedule();
                    }

                    if(adminCommand.equals("0")){
                        c=1;
                        break;
                    }
                    else{
                        System.out.println("wrong command!");
                    }
                }



                //PASSENGER MENU
                long a = signin.signIn(username,password);
                if(a == 2 && !(username.equals("admin"))){
                    System.out.println("User not found!");
                }


                //PASSENGER MENU
                while(a!=2 && !(username.equals("admin")) && c==0){
                    passengerMenu();
                    String passengerCommmand = input.next();

                    if(passengerCommmand.equals("1")){
                        passengerss.changePassword(a);
                    }

                    if (passengerCommmand.equals("2")){
                        passengerss.searchFlightTicket();
                    }
                    if (passengerCommmand.equals("3")){
                        passengerss.bookingTicket(a);
                    }
                    if (passengerCommmand.equals("4")){
                        passengerss.TicketCancelation(a);
                    }
                    if (passengerCommmand.equals("5")){
                        passengerss.bookedTicket(a);

                    }
                    if (passengerCommmand.equals("6")){
                        passengerss.addCharge(a);
                    }
                    if (passengerCommmand.equals("0")){
                        c=1;
                        break;
                    }
                }
            }

            //SIGNUP
            while (command.equals("2")) {
                signUpShow();
                signup.addPassenger();
                System.out.print("press 0 to add another passenger or 1 to return to main menu >>");
                String commandSignUp = input.next();
                if(commandSignUp.equals("0"))
                {
                    continue;
                } else if (command.equals(1)) {
                    break;
                }
                else{
                    System.out.println("wrong command");
                    break;
                }
            }

            //EXIT
            if(command.equals("0")){
                break;
            }
        }
    }
    //************************************************************************************************************************
    public void signUpShow(){
        System.out.println("       SIGNUP");
    }

    //************************************************************************************************************************
    public void signInShow(){
        System.out.println("       SIGNIN");
    }
    //************************************************************************************************************************
    public void adminOptionShow(){
        System.out.println("__________________________________________________________");
        System.out.println(BLUE+"                            ADMIN                         "+RESET);
        System.out.println("__________________________________________________________");
        System.out.println(RED+"                       <1>Add Flight                      "+RESET);
        System.out.println(GREEN+"                      <2>Update Flight                    "+RESET);
        System.out.println(CYAN+"                      <3>Remove Flight                    "+RESET);
        System.out.println(YELLOW+"                     <4>Flight Schedule                   "+RESET);
        System.out.println(PURPLE+"                          <0>Return                       ");
        System.out.println("__________________________________________________________");
        System.out.print(">>>");
    }

    //*************************************************************************************************************************
    public void passengerMenu(){
        System.out.println("__________________________________________________________");
        System.out.println(RED_BOLD+"                         PASSENGER                        "+RESET);
        System.out.println("__________________________________________________________");
        System.out.println(GREEN+"                     1-Change Password                    ");
        System.out.println(BLUE+"                   2-Search Flight Ticket                 ");
        System.out.println(BROWN+"                     3-Booking Ticket                     ");
        System.out.println(YELLOW+"                    4-Ticket Cancelation                  ");
        System.out.println(PURPLE+"                      5-Booked Ticket                     ");
        System.out.println(CYAN+"                        6-Add Charge                      ");
        System.out.println("                         0-Sign Out                       ");
        System.out.println("__________________________________________________________");
        System.out.print(">>>");
    }
    //************************************************************************************************************************
    public void mainMenu(){
        System.out.println("__________________________________________________________");
        System.out.println("                          MAIN MENU                       ");
        System.out.println("__________________________________________________________");
        System.out.println("                        <1> SIGN UP                       ");
        System.out.println("                        <2> signup                        ");
        System.out.println("                        <0> EXIT                          ");
        System.out.println("__________________________________________________________");
        System.out.print(">>>");
    }
    //************************************************************************************************************************
}
