import java.io.IOException;
public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        TextArt.animationplne();
        TextArt.welcome();
        TextArt.showAirlineReservationSystem();
        RunTheProgram runTheProgram = new RunTheProgram();
        runTheProgram.runTheProgram();

    }
}