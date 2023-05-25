package edu.cpp.cs2400.structures.tests;
import edu.cpp.cs2400.structures.lists.UnboundedArrayList;
import java.util.Random;

public class UnboundedArrayListTest {
	public static void main(String[] args) {
		testEmpty();
		System.out.println("\n");		
		testAddEnsureCapacity();
		System.out.println("\n");
		testRemoveAt();
		System.out.println("\n");
		testRemoveLast();
		System.out.println("\n");
		testRemoveLastFull();
	}
	//prints an emptyList
	private static void testEmpty() {
		UnboundedArrayList<Integer> l = new UnboundedArrayList<Integer>(20);
		System.out.println("testEmpty()\n" + l.toString()+"\nList is Empty: " + l.isEmpty());
	}
	//prints an empty list then
	//creates an list length 20, adds 30 elements to the list so listSize*2
	private static void testAddEnsureCapacity() {
		UnboundedArrayList<Integer> l = new UnboundedArrayList<Integer>(20);
		Random r = new Random();
		System.out.println("testAddEnsureCapacity()\n"+l.toString());
		for (int i = 0; i < 30; ++i) {
			l.add(r.nextInt(100));
		}
		System.out.println(l.toString());
	}
	
	//Array length is originally 15 but is increasing based on the capacity
	//adds random elements with an amount random to list, removes an element at a random index 0-9
		private static void testRemoveAt() {
			UnboundedArrayList<Integer> l = new UnboundedArrayList<Integer>(15);
			Random r = new Random();
			int numToAdd = r.nextInt(40) + 1; 
			int numToRem = r.nextInt(numToAdd) + 1;
			
			for (int i = 0; i <numToAdd; ++i) {
				l.add(r.nextInt(100));
			}
			
			System.out.println("testRemoveAt()\nOriginal List: " + l.toString()+
					"\n\nPosition "+numToRem +" Element Removed: ["+ l.removeAt(numToRem)+"]"+
					"\n\nChanged List: " + l.toString());
		}
		
		//Array length is originally 10 but is increasing based on the capacity
		//adds random elements with an amount random 1-30 to list, removes an element at last index
		private static void testRemoveLast() {
			UnboundedArrayList<Integer> l = new UnboundedArrayList<Integer>(10);
			Random r = new Random();
			int numToAdd = r.nextInt(30) + 1;
			
			for (int i = 0; i < numToAdd; ++i) {
				l.add(r.nextInt(100));
			}
			System.out.println("testRemoveLast()\nOriginal List: " + l.toString()+
					"\n\nLast Element Removed: [" + l.removeLast()+"]\n\n" + l.toString()); 
			
		}
		//Array length is originally 11 but is increasing based on the capacity
		//adds random elements with an amount 40 to list, removeAt(Random) for random # of elements
			private static void testRemoveLastFull() {
				UnboundedArrayList<Integer> l = new UnboundedArrayList<Integer>(11);
				Random r = new Random();
				for (int i = 0; i <40; ++i) {
					l.add(r.nextInt(100));
				}
				System.out.println("testRemoveAtFull()\nOriginal List: " + l.toString());
				for (int i = 0; i <r.nextInt(39)+1; ++i) {
					l.removeAt(r.nextInt(39)+1);
				}
				System.out.println("\nChanged List: " + l.toString());		
			}

}
