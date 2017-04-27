import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Schedule {
    public static void main(String[] args) throws Exception {

    	Scanner input = new Scanner(System.in);
    	
    	String currentYear;
    	String currentSemester;
    	String classDescriptors;
    	
    	System.out.println("Enter in the Class Descriptors you want to Take: ");
    	classDescriptors = input.next();
    	System.out.println("Enter in Current Year (Ex: 2017 = 17): ");
    	currentYear = input.next();
    	System.out.println("Enter in FA for Fall Semester or SP for Spring Semester: ");
    	currentSemester = input.next();
    	
        URL scheduleReader = new URL("https://admin.washcoll.edu/schedules/" + currentYear + currentSemester + "schedules.txt");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(scheduleReader.openStream()));
    
        for (String line = in.readLine(); line != null; line = in.readLine())
        {	
        	int quitPosition = line.indexOf("%%CQQ1");
        	int quitPosition2 = line.indexOf("%%CQQ2");
        	int quitPosition3 = line.indexOf("%%CQQ4");
        	int quitPosition4 = line.indexOf("QQ0");
        	int quitPosition5 = line.indexOf("QQ1");
        	int quitPosition6 = line.indexOf("QQ2");
        	int quitPosition7 = line.indexOf("QQ4");
        	
        	Boolean grw = line.contains("GRW");
        	
        	if (line.contains(classDescriptors)){
        		if (quitPosition >= 0 ){
            		System.out.println(line.substring(89, 99) + line.substring(104, quitPosition));
            	}else if(quitPosition2 >= 0){
            		System.out.println(line.substring(89, 99) + line.substring(104, quitPosition2));
            	}else if(quitPosition3 >= 0){
            		if(grw == true){
            			System.out.println(line.substring(121, 131) + line.substring(136, quitPosition3));
            		}else{
            			System.out.println(line.substring(89, 99) + line.substring(104, quitPosition3));
            		}
            	}else if(quitPosition4 >= 0){
            		System.out.println(line.substring(89, 99) + line.substring(104, quitPosition4));
            	}else if(quitPosition5 >= 0){
            		System.out.println(line.substring(89, 99) + line.substring(104, quitPosition5));
            	}else if(quitPosition6 >= 0){
            		System.out.println(line.substring(89, 99) + line.substring(104, quitPosition6));
            	}else if(quitPosition7 >= 0){
            		if(grw == true){
            			System.out.println(line.substring(121, 131) + line.substring(136, quitPosition7));
            		}else{
            			System.out.println(line.substring(89, 99) + line.substring(104, quitPosition7));
            		}
            	}else{
            		System.out.println(line);
            	}
        	}
        }      
    }
}

