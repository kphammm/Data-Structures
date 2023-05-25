package edu.cpp.cs2400.structures.stacksandqueues;
import java.util.Arrays;

public class ConcreteFifoQueue<V> implements AbstractFifoQueue<V> {
	
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
	
	public ConcreteFifoQueue() {
		theQueue = new Object[size];
	}

	@Override
	public void enqueue(V elem) {
		// TODO Auto-generated method stub ?? what about the size
		count++;
		theQueue[count-1]= elem;
		if(count>1) {
			last++;
		}
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public V dequeue() {
		// TODO Auto-generated method stub
		V result = null;
		
		if (count > 0) {
			result = (V) theQueue[first];
			theQueue[first] = null;
			first = count == 1 ? first : (first + 1) % theQueue.length;
			--count;
		}
		if(count==0) {
			first=0;
			last=0;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public V poll() {
		// TODO Auto-generated method stub
		V result = null;
		
		if(count>0) {
			result = (V) theQueue[first];
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
		return Arrays.toString(theQueue) +
				"\nfirst: " + first +
				"\nlast: " + last +
				"\ncount: " + count;
	}

}
