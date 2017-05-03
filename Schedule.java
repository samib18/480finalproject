import java.net.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;


public class Schedule {
	public static void printday(String day, List<String> allClasses){ 
		DateFormat primaryFormat = new SimpleDateFormat("hh:mma");
		Set<String> uniqueClasses = new HashSet<String>(allClasses);
		List<String> listClasses = new ArrayList<String>(uniqueClasses);
		
		Comparator<String> cmp = new Comparator<String>() {
			  public int compare(String time1, String time2) {
			   try {
			        return primaryFormat.parse(time1.substring(47, 55)).compareTo(primaryFormat.parse(time2.substring(47, 55)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					return 0;
					}
			   }};
			   
	   Collections.sort(listClasses, cmp);
	   for(String s : listClasses){
			String date = s.substring(43, 46);
			String tues = s.substring(44, 45);
			
			if((day.contains("T") && date.contains(day)) && !tues.contains("H")){
				System.out.println(s);
			}else if((day.contains("TH") && date.contains(day)) && tues.contains("H")){
				System.out.println(s);
			}else if((day.contains("M") && date.contains(day))){
				System.out.println(s);
			}else if((day.contains("W") && date.contains(day))){
				System.out.println(s);
			}else if((day.contains("F") && date.contains(day))){
				System.out.println(s);
			}
	    }
	}
		   
    public static void main(String[] args) throws Exception {
    	
		Scanner input = new Scanner(System.in);
    	
		String currentYear;
    	String currentSemester;
    	String classDescriptors;
    	String[] classes;
    	
    	System.out.println("Enter in the Class Descriptors you want to Take: ");
    	classDescriptors = input.nextLine();
    	classes = classDescriptors.split(" ");
    	System.out.println("Enter in Current Year (Ex: 2017 = 17): ");
    	currentYear = input.next();
    	System.out.println("Enter in FA for Fall Semester or SP for Spring Semester: ");
    	currentSemester = input.next();
    	
    	URL scheduleReader = new URL("https://admin.washcoll.edu/schedules/" + currentYear + currentSemester + "schedules.html");
    	BufferedReader in = new BufferedReader( new InputStreamReader(scheduleReader.openStream()));
    
    	String line = "";
    	int classesSize = classes.length;
    	
    	List<String> allClasses = new ArrayList<String>();
    	
    	while((line = in.readLine()) != null)
    	{
    		String piece = "k\">";
    		int quitPosition = line.indexOf("</A>/");
    		int quitPosition1 = line.indexOf("</A>");
    		int quitPosition2 = line.indexOf(piece);
    		
    		for (int i = 0; i < classesSize; i++){
    			if(line.contains(classes[i])){
    				if(quitPosition >= 0 && (line.contains("_blank") && line.contains("A")))
    				{
    					String fakeDate = line.substring(quitPosition);
    					String date = fakeDate.substring(48, 51);
    					String fakeTime = line.substring(quitPosition);
    					String time = fakeTime.substring(55, 70);
    					String place = line.substring(quitPosition2 + 3 , quitPosition) +  
    							line.substring(quitPosition + 5, quitPosition + 38) + date + " " + time;
    					
    					if(!allClasses.equals(place)){
    						allClasses.add(place);
    					}
    				}else if(quitPosition1 >= 0 && (line.contains("_blank") && line.contains("A")))
    				{
    					String fakeDate = line.substring(quitPosition1);
    					String date = fakeDate.substring(48, 51);
    					String fakeTime = line.substring(quitPosition1);
    					String time = fakeTime.substring(55, 70);
    					String place = line.substring(quitPosition2 + 3 , quitPosition1) +  
    							line.substring(quitPosition1 + 5, quitPosition1 + 38) + date + " " + time;
    					
    					if(!allClasses.equals(place)){
    						allClasses.add(place);
    					}
    				}
    			}
    		}
    	}
    	
    	System.out.println( " --- Monday --- ");
    	printday("M", allClasses);
    	System.out.println(" --- Tuesday --- ");
    	printday("T", allClasses);
    	System.out.println(" --- Wednesday --- ");
    	printday("W", allClasses);
    	System.out.println(" --- Thursday --- ");
    	printday("TH", allClasses);
    	System.out.println(" --- Friday --- ");
    	printday("F", allClasses);
    }  
    
}







