package exercise24_5;

import java.util.LinkedList;

public class GenericQueue <E> extends LinkedList{
	
	public void enqueue(E e) {
		this.addLast(e); 
	}
	
	public E dequeue() {
		return (E) this.removeFirst(); 
	}
	
	public int getSize() {
		return this.size(); 
	}
	
	
	public String print() {
		return "Queue: " + this.toString(); 
	}
}
