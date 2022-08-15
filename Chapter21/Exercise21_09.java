package exercise08_37;

import java.util.*;

public class Exercise08_37 {
  public static void main(String[] args) {
    String[][] stateCapital = {
      {"Alabama", "Montgomery"},
      {"Alaska", "Juneau"},
      {"Arizona", "Phoenix"},
      {"Arkansas", "Little Rock"},
      {"California", "Sacramento"},
      {"Colorado", "Denver"},
      {"Connecticut", "Hartford"},
      {"Delaware", "Dover"},
      {"Florida", "Tallahassee"},
      {"Georgia", "Atlanta"},
      {"Hawaii", "Honolulu"},
      {"Idaho", "Boise"},
      {"Illinois", "Springfield"},
      {"Indiana", "Indianapolis"},
      {"Iowa", "Des Moines"},
      {"Kansas", "Topeka"},
      {"Kentucky", "Frankfort"},
      {"Louisiana", "Baton Rouge"},
      {"Maine", "Augusta"},
      {"Maryland", "Annapolis"},
      {"Massachusettes", "Boston"},
      {"Michigan", "Lansing"},
      {"Minnesota", "Saint Paul"},
      {"Mississippi", "Jackson"},
      {"Missouri", "Jefferson City"},
      {"Montana", "Helena"},
      {"Nebraska", "Lincoln"},
      {"Nevada", "Carson City"},
      {"New Hampshire", "Concord"},
      {"New Jersey", "Trenton"},
      {"New York", "Albany"},
      {"New Mexico", "Santa Fe"},
      {"North Carolina", "Raleigh"},
      {"North Dakota", "Bismarck"},
      {"Ohio", "Columbus"},
      {"Oklahoma", "Oklahoma City"},
      {"Oregon", "Salem"},
      {"Pennsylvania", "Harrisburg"},
      {"Rhode Island", "Providence"},
      {"South Carolina", "Columbia"},
      {"South Dakota", "Pierre"},
      {"Tennessee", "Nashville"},
      {"Texas", "Austin"},
      {"Utah", "Salt Lake City"},
      {"Vermont", "Montpelier"},
      {"Virginia", "Richmond"},
      {"Washington", "Olympia"},
      {"West Virginia", "Charleston"},
      {"Wisconsin", "Madison"},
      {"Wyoming", "Cheyenne"}
    };
    
    // create hashmap and loop to put everything in it
    Map<String, String> map = new HashMap<>();
    for (int i = 0; i < stateCapital.length; i++) 
    	map.put(stateCapital[i][0], stateCapital[i][1]);

    Scanner input = new Scanner(System.in);
    
    int correctCount = 0;
    
    for (String key: map.keySet()) {
    	System.out.print("What is the capital of " + key + "? ");
    	String capital = input.nextLine().trim().toLowerCase(); 
    	
    	if (capital.equals(map.get(key).toLowerCase())) {
    		System.out.println("Your answer is correct"); 
    		correctCount++; 
    	}
    	else 
    		System.out.println("The correct answer should be " + map.get(key)); 
    }
    System.out.println("The correct count is " + correctCount);
  }
}

