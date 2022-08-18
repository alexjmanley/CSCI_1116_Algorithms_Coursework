package exercise22_1;

/* Alex Manley 
 * Aug 18, 2022
 * 
 * My estimate big O time is O(n) 
 */

import java.util.Scanner;
import java.util.ArrayList; 

public class Exercise22_01 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
		
		//prompt user
		System.out.println("Enter a string: ");
		String user = input.next(); 
		
		// make loop and array to find max substring
		ArrayList<Character> max = new ArrayList<>();
		ArrayList<Character> newList = new ArrayList<>(); 
		
		for (int i = 0; i < user.length(); i++) {
			if(newList.size() > 1 && newList.get(newList.size() - 1) > user.charAt(i))
				newList.clear();
			newList.add(user.charAt(i));	
			if(newList.size() > max.size()) {
				max.clear();
				max.addAll(newList);
			}
		}
		
		//print
		for (Character e: max)
			System.out.print(e);

	}

}
