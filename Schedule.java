import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

import java.io.*;

public class Schedule {
    public static void main(String[] args) throws Exception {

        URL scheduleReader = new URL("https://admin.washcoll.edu/schedules/17SPschedules.html");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(scheduleReader.openStream()));
       
        Document doc = Jsoup.connect("https://admin.washcoll.edu/schedules/17SPschedules.txt").get();
        
        Elements link = doc.body().select("*");
        
        	for(Element element : link)
        	{
        			System.out.println(element.ownText());
        	}
        	
        in.close();
    }
}
