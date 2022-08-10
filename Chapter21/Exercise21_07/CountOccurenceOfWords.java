package programming217;

import java.util.*;

public class CountOccurenceOfWords {
	public static void main(String[] args) {
		// Set text in a string
		String text = "Good morning. Have a good class. " +
			"Have a good visit. Have fun!";

		// Create a TreeMap to hold words as key and count as value
		HashMap<String, Integer> map = new HashMap<>();

		String[] words = text.split("[\\s+\\p{P}]");
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();
			
			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				}
				else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}
		//array of WordOccurence 
		ArrayList<WordOccurence> list = new ArrayList<>();
		for (String key: map.keySet()) {
			list.add(new WordOccurence(key, map.get(key)));
		}
		Collections.sort(list);
		// Display key and value for each entry
		for (WordOccurence item: list) {
			System.out.println(item); 
		}
	}
}
