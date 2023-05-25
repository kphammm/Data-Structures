package edu.cpp.cs2400.structures.tests;
import java.util.Random;
import edu.cpp.cs2400.structures.stacksandqueues.ConcreteFifoQueue;

public class FifoQueueTest {
	
	public static void main(String[] args) {
		System.out.println("testEnqueue()");
		testEnqueue();
		testEmpty();
		testOne();
		testFull();
		testRandom();
		
	}
	//Enqueues 3 elements, then removes the first in 
	private static void testEnqueue() {
		ConcreteFifoQueue<Integer> queue = new ConcreteFifoQueue<Integer>();
		Random r = new Random();
		
		for(int i = 0; i<3; i++) {
			queue.enqueue(r.nextInt(100));
			System.out.println(queue.toString()+"\n");
		}
		System.out.println("Remove First In: ["+queue.dequeue()+"]\n"+queue.toString());
	}
	//Prints an empty queue
	private static void testEmpty() {
		ConcreteFifoQueue<Integer> queue = new ConcreteFifoQueue<Integer>();
		System.out.println("\ntestEmpty()\n" + queue.toString()+"\nList is Empty: " + queue.isEmpty());
	}
	//Prints a queue with One element
	private static void testOne() {
		ConcreteFifoQueue<Integer> queue = new ConcreteFifoQueue<Integer>();
		Random r = new Random();
		queue.enqueue(r.nextInt(100));
		System.out.println("\ntestOne()\n" + queue.toString()+"\nList is Empty: " + queue.isEmpty()
		+ "\nPolled:[" + queue.poll()+ "]");
	}
	//Enqueues 15 elements, then removes #random (1-15) amount of elements
	private static void testFull() {
		ConcreteFifoQueue<Integer> queue = new ConcreteFifoQueue<Integer>();
		Random r = new Random();
		
		System.out.println("\ntestFull()");
		for(int i = 0; i<15; i++) {
			queue.enqueue(r.nextInt(100));
		}
		System.out.println(queue.toString()+"\n");
		for(int i = 0; i<r.nextInt(15); i++) {
			queue.dequeue();
		}
		System.out.println(queue.toString());
	}
	//Creates a queue w/ count #random (1-15), dequeue #random (1-15) times
	private static void testRandom() {
		ConcreteFifoQueue<Integer> queue = new ConcreteFifoQueue<Integer>();
		Random r = new Random();
		int numToAdd = r.nextInt(14) + 1;
		int numToRem = r.nextInt(numToAdd) + 1;
		
		System.out.println("\ntestRandom()");
		for(int i=0; i<numToAdd;i++) {
			queue.enqueue(r.nextInt(100));
		}
		System.out.println(queue.toString()+"\n");
		for(int i=0; i<numToRem;i++) {
			queue.dequeue();
		}
		System.out.println(queue.toString());
	}		
}