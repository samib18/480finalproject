import java.net.*;
import org.jsoup.*;
import org.jsoup.nodes.Document;

import java.io.*;

public class Schedule {
    public static void main(String[] args) throws Exception {

        URL scheduleReader = new URL("https://admin.washcoll.edu/schedules/17SPschedules.html");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(scheduleReader.openStream()));
        
        Document doc = Jsoup.connect("https://admin.washcoll.edu/schedules/17SPschedules.html").get();
        System.out.println(doc);
        

        String inputLine;
        while ((inputLine = in.readLine()) != null){
        	//inputLine = inputLine.replaceAll("</A", "");
        	
        	System.out.println(doc);
            //String parts[] = inputLine.split("\\>+");
            //String[] sArray = parts[2].split("\\s{2,}");
       //     System.out.println(" ");
         //   System.out.println(parts[1]);
           // int l = sArray.length;
            //for (int i = 1; i < l; i++){
            	//System.out.println(sArray[i]);
      //      }
        }
    	//*
        in.close();
        
    }
}
