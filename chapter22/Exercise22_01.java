package exercise22_1;

/* Alex Manley 
 * 05/17/2022
 * 
 * analyze time 
 */
import java.util.Scanner; 
import java.util.ArrayList; 

public class Exercise22_01 {

	public static void main(String[] args) {
		// create Scanner 
		Scanner input = new Scanner(System.in);
		
		//get string from user
		System.out.println("Enter a string: ");
		String user = input.next(); 
		 
		// loop to find the maximum consecutive increasingly ordered substring
		String maximum = null; 
		for (int i = 0; i < user.length(); i++) {
			int count = 0;
			while(Character.compare(user.charAt(i), user.charAt(i + 1)) < 0) {
				count++; 
				i++; 
			}
			if(maximum == null ||count > maximum.length())
				maximum = user.substring(i - count, i);
		}
		System.out.println("Maximum consecutive substring is " + maximum);

	}

}
