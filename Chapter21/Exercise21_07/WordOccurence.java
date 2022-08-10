package programming217;

public class WordOccurence implements Comparable<WordOccurence>{
	String word = null; 
	int count = 0;
	
	WordOccurence(String word1, int count1) {
		this.word = word1; 
		this.count = count1; 
	}
	
	@Override
	public int compareTo(WordOccurence arg0) { 
		
		if(this.count > arg0.count)
			return 1; 
		if(this.count == arg0.count)
			return 0;
		else; 
			return -1; 
	}
	
	@Override
	public String toString() {
		return word + " " + count;
	}

}
