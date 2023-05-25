package edu.cpp.cs2400.structures.tests;
import java.util.Random;
import edu.cpp.cs2400.structures.stacksandqueues.ConcreteArrayPriorityQueue;

public class ArrayPriorityQueueTest {

	public static void main(String[] args) {
		System.out.println("testEnqueue()");
		testEnqueue();
		testEmpty();
		testOne();
		testFull();
		testRandom();
		
	}
	
	private static void testEnqueue() {
		ConcreteArrayPriorityQueue<Integer> queue = new ConcreteArrayPriorityQueue<Integer>();
		Random r = new Random();
		for(int i = 0; i<6; i++) {
			queue.enqueue(r.nextInt(89)+10);
		}
		System.out.println(queue.get() + "\n\nElement Dequeued: [" + queue.dequeue() +"]\n\n" 
				+ queue.get() + "\nElement Polled: [" + queue.poll()+"]");
	}
	
	//Prints an empty queue
	private static void testEmpty() {
		ConcreteArrayPriorityQueue<Integer> queue = new ConcreteArrayPriorityQueue<Integer>();
		System.out.println("\ntestEmpty()\n" + queue.get()+"\nList is Empty: " + queue.isEmpty());
	}
	
	//Prints a queue with One element
	private static void testOne() {
		ConcreteArrayPriorityQueue<Integer> queue = new ConcreteArrayPriorityQueue<Integer>();
		Random r = new Random();
		queue.enqueue(r.nextInt(100));
		System.out.println("\ntestOne()\n" + queue.get()+"\nList is Empty: " + queue.isEmpty()
		+ "\nPolled:[" + queue.poll()+ "]");
	}
	
	private static void testFull() {
		ConcreteArrayPriorityQueue<Integer> queue = new ConcreteArrayPriorityQueue<Integer>();
		Random r = new Random();
		
		System.out.println("\ntestFull()");
		for(int i = 0; i<15; i++) {
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
		ConcreteArrayPriorityQueue<Integer> queue = new ConcreteArrayPriorityQueue<Integer>();
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
