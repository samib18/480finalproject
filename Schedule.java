import java.net.*;
import java.io.*;

public class Schedule {
    public static void main(String[] args) throws Exception {

        URL scheduleReader = new URL("https://admin.washcoll.edu/schedules/17SPschedules.txt");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(scheduleReader.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
        
        //hthiqrgudihbs
    }
}
