package edu.cpp.cs2400.structures.tests;
import java.util.Random;
import edu.cpp.cs2400.structures.stacksandqueues.ArrayHeap;

public class HeapTest {
	public static void main(String[] args) {
		testAddRemOne();
		testEmptyAndOne();
		testEnsureCapacity();
		testGetSortedContents();
		testAddRem();
		System.out.println("\n");
		
	}
	//adds 25 elements to theHeap, Sifts up, then Removes an element, sifts down
	private static void testAddRemOne() {
		ArrayHeap<Integer> theHeap = new ArrayHeap<Integer>();
		Random r = new Random();
		
		for(int i = 0; i<25; i++) {
			theHeap.add(r.nextInt(100));
		}
		System.out.println("\ntestAdd()\n"+ theHeap.toString());
		theHeap.remove();	
		System.out.println("\n"+theHeap.toString());
	}
	
	//creates an empty heap and heap with one element
	private static void testEmptyAndOne() {
		ArrayHeap<Integer> theHeap = new ArrayHeap<Integer>();
		System.out.println("\ntestEmptyAndOne()\n"+theHeap.toString());
		theHeap.add(1);
		System.out.println("\n"+theHeap.toString());
	}
	
	//tests ensureCapacity by creating a heap length #random(101-400)
	private static void testEnsureCapacity() {
		ArrayHeap<Integer> theHeap = new ArrayHeap<Integer>();
		Random r = new Random();
		
		for(int i = 0; i<r.nextInt(299)+101; i++) {
			theHeap.add(r.nextInt(100));
		}
		System.out.println("\ntestEnsureCapacity()\n"+ theHeap.toString());	
		System.out.println("\n"+theHeap.toString());
	}
	
	//tests getSortedContents and prints theHeap
	private static void testGetSortedContents() {
		ArrayHeap<Integer> theHeap = new ArrayHeap<Integer>();
		Random r = new Random();
		
		for(int i = 0; i<25; i++) {
			theHeap.add(r.nextInt(100));
		}
		theHeap.getSortedContents();
		System.out.println("\ntestGetSortedContents()\n"+ theHeap.toString());
	}
	
	//adds 16 elements to the heap, sifts up, them removes #random(1-6) elements, sifts down
	private static void testAddRem() {
		ArrayHeap<Integer> theHeap = new ArrayHeap<Integer>();
		Random r = new Random();
		
		for(int i = 0; i<16; i++) {
			theHeap.add(r.nextInt(100));
		}
		System.out.println("\ntestAddRem()\n"+ theHeap.toString());
		for(int i = 0; i<r.nextInt(5)+1; i++) {
			theHeap.remove();
		}
		System.out.println("\n"+theHeap.toString());
	}
	

}
