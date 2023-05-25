package edu.cpp.cs2400.structures.tests;
import java.util.Random;
import edu.cpp.cs2400.structures.stacksandqueues.ConcreteStack;

public class StackTest {
	
	public static void main(String[] args) {
		testPushPopPeek();
		testEmpty();
		testOne();
		testFullPopPush();
		testRandom();
	}
	//Creates a stack count 5, pops out the most recently added element
	private static void testPushPopPeek() {
		ConcreteStack<Integer> stack = new ConcreteStack<Integer>();
		Random r = new Random();
		System.out.println("testPushPopPeek()");
		for(int i=0; i<5;i++) {
			stack.push(r.nextInt(100));
			System.out.println(stack.toString() +"\n");
		}
		Object popped = stack.peek();
		stack.pop();
		System.out.println(stack.toString() +"\nPopped: [" + popped +"]\n");
	}
	//create empty stack
	private static void testEmpty() {
		ConcreteStack<Integer> stack = new ConcreteStack<Integer>();
		Object peeked = stack.peek();
		System.out.println("testEmpty()\n" + stack.toString() +"\nPeeked: [" + peeked +"]\n");
	}
	//create stack with one element
	private static void testOne() {
		ConcreteStack<Integer> stack = new ConcreteStack<Integer>();
		Random r = new Random();
		stack.push(r.nextInt(100));
		Object peeked = stack.peek();
		System.out.println("testOne()\n" + stack.toString() +"\nPeeked: [" + peeked +"]\n");
	}
	//creates a full stack, pops the full stack, then adds an element
	private static void testFullPopPush() {
		ConcreteStack<Integer> stack = new ConcreteStack<Integer>();
		Random r = new Random();
		System.out.println("testFull()");
		for(int i=0; i<16;i++) {
			stack.push(r.nextInt(100));
		}
		System.out.println(stack.toString()+"\n");
		for(int i=0; i<16;i++) {
			stack.pop();
		}
		System.out.println(stack.toString()+"\n");
		stack.push(r.nextInt(100));
		System.out.println(stack.toString());
	}
	//Creates a stack #random (1-15) count, pops #random (1-15) times
		private static void testRandom() {
			ConcreteStack<Integer> stack = new ConcreteStack<Integer>();
			Random r = new Random();
			int numToAdd = r.nextInt(14) + 1;
			int numToRem = r.nextInt(numToAdd) + 1;
			
			System.out.println("\ntestRandom()");
			for(int i=0; i<numToAdd;i++) {
				stack.push(r.nextInt(100));
			}
			System.out.println(stack.toString()+"\n");
			for(int i=0; i<numToRem;i++) {
				stack.pop();
			}
			stack.pop();
			System.out.println(stack.toString());
		}
}