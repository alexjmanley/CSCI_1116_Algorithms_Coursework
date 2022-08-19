package exercise23_3;
import java.lang.reflect.Array;
/*

Author: Alex Manley
Date: Aug 19, 2022

Description: 
*/
import java.util.Comparator;

public class Exercise23_03 {
  public static void main(String[] args) {
    Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    quickSort(list);
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }

    System.out.println();
    System.out.println(); 
    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
                     new Circle(5), new Circle(6), new Circle(1), new Circle(2),
                     new Circle(3), new Circle(14), new Circle(12)};
    quickSort(list1, new GeometricObjectComparator());
    for (int i = 0; i < list1.length; i++) {
      System.out.println(list1[i] + " ");
    }
  }
  
  //create 1st method
public static<E extends Comparable<E>> void quickSort(E[] list) {
	  quickSort(list, 0, list.length -1);
  }

  private static<E extends Comparable<E>> void quickSort(E[] array, int lowIndex, int highIndex) {
	if(lowIndex >= highIndex) {
		return; 
	}
	  
	E pivot = array[highIndex];
	int leftPointer = lowIndex; 
	int rightPointer = highIndex; 
	
	while (leftPointer < rightPointer) {
		while (array[leftPointer].compareTo(pivot) <= 0 && leftPointer < rightPointer) {
			leftPointer++;
		}
		while (array[rightPointer].compareTo(pivot) >= 0 && leftPointer < rightPointer) {
			rightPointer--;
		}
		
		swap(array, leftPointer, rightPointer); 
	}
	
	swap(array, leftPointer, highIndex); 
	
	quickSort(array, lowIndex, leftPointer - 1);
	quickSort(array, leftPointer + 1, highIndex);
  }
  
  // swap method 
  private static<E> void swap(E[] array, int index1, int index2) {
	  E temp = array[index1];
	  array[index1] = array[index2];
	  array[index2] = temp; 
  }
  
  // create second method 
  public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
	  quickSort(list, comparator, 0, list.length -1);
  }
  public static <E> void quickSort(E[] array, Comparator<? super E> comparator, int lowIndex, int highIndex) {
	  if(lowIndex >= highIndex) {
			return; 
		}
		  
		E pivot = array[highIndex];
		int leftPointer = lowIndex; 
		int rightPointer = highIndex; 
		
		while (leftPointer < rightPointer) {
			while (comparator.compare(array[leftPointer], pivot) <= 0 && leftPointer < rightPointer) {
				leftPointer++;
			}
			while (comparator.compare(array[rightPointer], pivot) >= 0 && leftPointer < rightPointer) {
				rightPointer--;
			}
			
			swap(array, leftPointer, rightPointer); 
		}
		
		swap(array, leftPointer, highIndex); 
		
		quickSort(array, comparator, lowIndex, leftPointer - 1);
		quickSort(array, comparator, leftPointer + 1, highIndex);
  }
}
 
