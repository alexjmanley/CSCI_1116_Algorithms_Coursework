package exercise24_5;

public class Exercise24_05 {

	public static void main(String[] args) {
		GenericQueue list = new GenericQueue(); 
		
		list.add(0);
		list.add(1); 
		list.add(2); 
		list.add(3); 
		
		list.enqueue(4);
		System.out.println(list.print());

		
		list.dequeue();
		System.out.println(list.print());

	}

}
