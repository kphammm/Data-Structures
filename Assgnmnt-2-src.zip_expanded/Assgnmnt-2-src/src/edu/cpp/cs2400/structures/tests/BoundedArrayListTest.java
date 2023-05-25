/**
 * 
 */
package edu.cpp.cs2400.structures.tests;
import java.util.Arrays;
import java.util.Random;

import edu.cpp.cs2400.structures.lists.BoundedArrayList;

/**
 * @author Edwin Rodr&iacute;guez
 *
 */
public class BoundedArrayListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testAdd();
		System.out.println("\n");
		testAddRem();
		System.out.println("\n");
		testRemoveAt();
		System.out.println("\n");
		testRemoveLast();
		System.out.println("\n");
		testRemoveAtFull();
	}
	//prints an empty list, adds one element to the list, then prints it again
	private static void testAdd() {
		BoundedArrayList<Integer> l = new BoundedArrayList<Integer>(10);
		Random r = new Random();
		
		System.out.println("testAdd() \n" + l.toString() + "\nThe Array is empty: " + l.isEmpty());
		l.add(r.nextInt(100));
		System.out.println("\n"+ l.toString() + "\nThe Array is empty: " + l.isEmpty());
	}
	
	//Template Test Case
	private static void testAddRem() {
		BoundedArrayList<Integer> l = new BoundedArrayList<Integer>(10);
		Random r = new Random();
		
		
		int numToAdd = r.nextInt(10) + 1;
		
		for (int i = 0; i < numToAdd; ++i) {
			l.add(r.nextInt(100));
		}
		String orig = "testAddRem()\nOriginal List: " + l.toString();
			
		int numToRem = r.nextInt(numToAdd) + 1;
		Integer[] elemRem = new Integer[numToRem];

		for (int i = 0; i < numToRem; ++i) {
			elemRem[i] = l.remove();
		}
		
		String output = orig + "\n" + l.toString() +
				"\nElements Removed: " + Arrays.toString(elemRem);
		System.out.println(output);
	}
	
	//adds random elements with an amount random to list, removes an element at a random index 0-9
	private static void testRemoveAt() {
		BoundedArrayList<Integer> l = new BoundedArrayList<Integer>(10);
		Random r = new Random();
		int numToAdd = r.nextInt(10) + 1; 
		int numToRem = r.nextInt(numToAdd) + 1;
		
		for (int i = 0; i <numToAdd; ++i) {
			l.add(r.nextInt(100));
		}
		
		System.out.println("testRemoveAt()\nOriginal List: " + l.toString()+
				"\n\nPosition "+numToRem +" Element Removed: ["+ l.removeAt(numToRem)+"]"+
				"\n\nChanged List: " + l.toString());
	}
	//adds random elements with an amount random to list, removes an element at last index
	private static void testRemoveLast() {
		BoundedArrayList<Integer> l = new BoundedArrayList<Integer>(10);
		Random r = new Random();
		
		
		int numToAdd = r.nextInt(10) + 1;
		
		for (int i = 0; i < numToAdd; ++i) {
			l.add(r.nextInt(100));
		}
		System.out.println("testRemoveLast()\nOriginal List: " + l.toString()+
				"\n\nLast Element Removed: [" + l.removeLast()+"]\n\n" + l.toString()); 
		
	}
	//adds random elements with an amount 10 to list, removes an element at a random index 0-9
		private static void testRemoveAtFull() {
			BoundedArrayList<Integer> l = new BoundedArrayList<Integer>(10);
			Random r = new Random();
			int numToRem = r.nextInt(10) + 1;
			
			for (int i = 0; i <10; ++i) {
				l.add(r.nextInt(100));
			}
			
			System.out.println("testRemoveAtFull()\nOriginal List: " + l.toString()+
					"\n\nPosition "+numToRem +" Element Removed: ["+ l.removeAt(numToRem)+"]"+
					"\n\nChanged List: " + l.toString());
		}

}
