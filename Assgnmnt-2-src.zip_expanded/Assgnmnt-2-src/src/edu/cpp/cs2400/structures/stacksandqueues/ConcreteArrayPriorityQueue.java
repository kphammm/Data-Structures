package edu.cpp.cs2400.structures.stacksandqueues;

import java.util.Arrays;

public class ConcreteArrayPriorityQueue<V extends Comparable<V>> implements AbstractPriorityQueue<V>{

	/**
	 * This is the internal representation of the queue.
	 */
	protected Object[] theQueue;
	
	/**
	 * The number of elements in the queue.
	 * @initially {@code 0}.
	 */
	protected int count = 0;
	
	/**
	 * Keeps track of the beginning of the queue.
	 */
	protected int first = 0;
	
	/**
	 * Keeps track of the end of the queue.
	 */
	protected int last = 0;
	/**
	 * We set the internal array to have an initial size of 50.
	 */
	private int size = 15;
	
	public ConcreteArrayPriorityQueue() {
		theQueue = new Object[size];
	}
	
	@Override
	public void enqueue(V elem) {
		// TODO Auto-generated method stub
		
		if(count>0) {
			last++;
			count++;
			theQueue[count-1]=elem;
			sort();
		}
		
		if(count==0) {
			theQueue[0]=elem;
			count++;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void sort() {
		for(int i = 0; i<count; i++) {
			for(int j = i+1; j<count; j++) {
				
				if((theQueue[i].toString()).compareTo(theQueue[j].toString())>0) {
					V temp = (V) theQueue[i];
					theQueue[i] = theQueue[j];
					theQueue[j] = temp;
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public V dequeue() {
		// TODO Auto-generated method stub
		if(count>0) {
			V high = (V)theQueue[count-1];
			theQueue[count-1] = null;
			last--;
			count--;
			sort();
			if(count==0) {
				first=0;
				last=0;
			}
			return high;
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public V poll() {
		// TODO Auto-generated method stub
		V result = null;
		if(count>0) {
			result = (V) theQueue[count-1];
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
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
	
	public String get() {
		return Arrays.toString(theQueue) +
				"\nfirst: " + first +
				"\nlast: " + last +
				"\ncount: " + count;
	}

}
