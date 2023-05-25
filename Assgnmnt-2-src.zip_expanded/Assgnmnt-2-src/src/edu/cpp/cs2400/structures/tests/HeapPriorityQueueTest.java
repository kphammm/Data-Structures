package edu.cpp.cs2400.structures.tests;
import java.util.Random;
import edu.cpp.cs2400.structures.stacksandqueues.ConcreteHeapPriorityQueue;

public class HeapPriorityQueueTest {
	public static void main(String[] args) {
		testEnqueue();
		testEmpty();
		testOne();
		testFull();
		testRandom();
		System.out.println("\n");
		
	}
	//creates queue with 16 elements
	private static void testEnqueue() {
		ConcreteHeapPriorityQueue<Integer> queue = new ConcreteHeapPriorityQueue<Integer>();
		Random r = new Random();
		
		for(int i = 0; i<16; i++) {
			queue.enqueue(r.nextInt(100));
		}
		System.out.println("testEnqueue()\n"+queue.get());
	}
	
	//Prints an empty queue
	private static void testEmpty() {
		ConcreteHeapPriorityQueue<Integer> queue = new ConcreteHeapPriorityQueue<Integer>();
		System.out.println("\ntestEmpty()\n" + queue.get()+"\nList is Empty: " + queue.isEmpty());
	}
	
	//Prints a queue with One element
	private static void testOne() {
		ConcreteHeapPriorityQueue<Integer> queue = new ConcreteHeapPriorityQueue<Integer>();
		Random r = new Random();
		queue.enqueue(r.nextInt(100));
		System.out.println("\ntestOne()\n" + queue.get()+"\nList is Empty: " + queue.isEmpty()
		+ "\nPolled:[" + queue.poll()+ "]");
	}
	
	private static void testFull() {
		ConcreteHeapPriorityQueue<Integer> queue = new ConcreteHeapPriorityQueue<Integer>();
		Random r = new Random();
		
		System.out.println("\ntestFull()");
		for(int i = 0; i<25; i++) {
			queue.enqueue(r.nextInt(89)+10);
		}
		System.out.println(queue.get()+"\n");
		for(int i = 0; i<r.nextInt(15); i++) {
			queue.dequeue();
		}
		System.out.println(queue.get());
	}
	//Creates a queue w/ #count random (1-15), dequeue #random (1-15) times
	private static void testRandom() {
		ConcreteHeapPriorityQueue<Integer> queue = new ConcreteHeapPriorityQueue<Integer>();
		Random r = new Random();
		int numToAdd = r.nextInt(14)+1;
		int numToRem = r.nextInt(numToAdd) + 1;
		
		System.out.println("\ntestRandom()");
		for(int i=0; i<numToAdd;i++) {
			queue.enqueue(r.nextInt(89)+10);
		}
		System.out.println(queue.get()+"\n");
		for(int i=0; i<numToRem;i++) {
			queue.dequeue();
		}
		System.out.println(queue.get());
	}

}
