package exercise22_3;

/* Alex Manley 
 * Aug 18, 2022
 * 
 * Estimate Big O time is O(n)
 */

import java.util.Scanner; 

public class Exercise22_03 {

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in); 
	
		// Prompt user 
		System.out.println("Enter a string s1: ");
		String s1 = input.nextLine();
		System.out.println("Enter a string s2: ");
		String s2 = input.nextLine();
		
		// find match
		int index = -1; 
		for (int i = 0; i < s1.length(); i++) {
			if (s1.substring(i).length() >= s2.length() && s1.substring(i, i + s2.length()).equals(s2))
				index = i; 
		}
		if(index == -1)
			System.out.println("No Match");
		else
			System.out.println("Matched at index " + index); 
	}
}
