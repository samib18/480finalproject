import java.net.*;
import java.util.*;
import java.io.*;

public class Schedule {
	
	public static void printday(String day, Map<String, Set<String>> list) { 
			for(Map.Entry<String, Set<String>> entry : list.entrySet()){
				for(String s : entry.getValue()){
					String date = s.substring(43, 46);
					if(date.contains(day)){
						System.out.println(s);	
					}
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

    	Map<String, Set<String>> list = new HashMap<String, Set<String>>();
    	
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
    					
    					char[] c = place.toCharArray();
    					Arrays.sort(c);
    					String newPlace = new String(c);
    					
    					if(list.get(newPlace) == null)
    					{
    						Set<String> values = new HashSet<String>();
    						values.add(place);
    						list.put(newPlace, values);
    					}else{
    						Set<String> values = list.get(newPlace);
    						values.add(place);
    					}
    					
    				}else if(quitPosition1 >= 0 && (line.contains("_blank") && line.contains("A")))
    				{
    					String fakeDate = line.substring(quitPosition1);
    					String date = fakeDate.substring(48, 51);
    					String fakeTime = line.substring(quitPosition1);
    					String time = fakeTime.substring(55, 70);
    					String place = line.substring(quitPosition2 + 3 , quitPosition1) +  
    							line.substring(quitPosition1 + 5, quitPosition1 + 38) + date + " " + time;
    					
    					char[] c = place.toCharArray();
    					Arrays.sort(c);
    					String newPlace = new String(c);
    						if(list.get(newPlace) == null)
    						{
        						Set<String> values = new HashSet<String>();
        						values.add(place);
        						list.put(newPlace, values);
        					}else{
        						Set<String> values = list.get(newPlace);
        						values.add(place);
        					}
    				}
    			}
    		}
    	}
    	
    	/*for(Map.Entry<String, Set<String>> entry : list.entrySet()){
			for(String s : entry.getValue()){
				System.out.println(s + " ");
			}
    	}*/
    	
    	
    	System.out.println( " --- Monday --- ");
    	printday("M", list);
    	System.out.println(" --- Tuesday --- ");
    	printday("T", list);
    	System.out.println(" --- Wednesday --- ");
    	printday("W", list);
    	System.out.println(" --- Thursday --- ");
    	printday("TH", list);
    	System.out.println(" --- Friday --- ");
    	printday("F", list);
    }      
}



