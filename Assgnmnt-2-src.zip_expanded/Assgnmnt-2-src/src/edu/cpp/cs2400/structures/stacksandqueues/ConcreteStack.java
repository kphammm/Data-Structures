package edu.cpp.cs2400.structures.stacksandqueues;

import java.util.Arrays;

public class ConcreteStack<V> implements AbstractStack<V> {

	/**
	 * This is the internal representation of the stack.
	 */
	private Object[] theStack;
	
	/**
	 * The number of elements in the stack.
	 * @initially {@code 0}.
	 */
	protected int count = 0;
	
	/**
	 * Keeps track of the beginning of the stack.
	 */
	protected int first = 0;
	
	
	/**
	 * Keeps track of the end of the stack.
	 */
	protected int last = 0;
	
	/* We set the internal array to have an initial size of 100.
	 */
	private int size = 15;
	
	public ConcreteStack() {
		theStack = new Object[size];
	}
	
	@Override
	public void push(V elem) {
		// TODO Auto-generated method stub SIZE???
		if(count < theStack.length) {
			last = count == 0 ? last : (last + 1) % theStack.length;
			theStack[last] = elem;
			++count;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public V pop() {
		// TODO Auto-generated method stub
		V result = null;
		
		if (count > 0) {
			result = (V) theStack[last];
			theStack[last] = null;
			last = count == 0 ? last : (last - 1) % theStack.length;
			--count;
		}
		if(count==0) {
			first = 0;
			last = 0;
		}
		
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public V peek() {
		// TODO Auto-generated method stub
		V result = null;
		
		if(count>0) {
			result = (V) theStack[last];
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(count==0) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(theStack) +
				"\nfirst: " + first +
				"\nlast: " + last +
				"\ncount: " + count;
	}

}
