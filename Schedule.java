import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

public class Schedule {
    public static void main(String[] args) throws Exception {

        URL scheduleReader = new URL("https://admin.washcoll.edu/schedules/17SPschedules.txt");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(scheduleReader.openStream()));
       
        Document doc = Jsoup.connect("https://admin.washcoll.edu/schedules/17SPschedules.txt").get();
        //doc.outputSettings().prettyPrint(false);
        
        Element link = doc.body().wrap("A");
        String text = doc.text();
        
        String inputLine = doc.body().text();
        String linkHref = link.attr("HREF");
        String linkText = link.text();
        
        String linkOuterH = link.outerHtml();
        String linkInnerH = link.html();
        
        List<String> list = new ArrayList<>();
        
        	for(Element element : doc.select("A"))
        	{
        		list.add(element.nextSibling().toString());
        	}
        	
        	System.out.println(text + list);
        in.close();
        //hello
    }
}
