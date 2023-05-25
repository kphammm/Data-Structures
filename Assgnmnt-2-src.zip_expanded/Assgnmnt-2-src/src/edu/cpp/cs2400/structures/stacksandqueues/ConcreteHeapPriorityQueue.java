package edu.cpp.cs2400.structures.stacksandqueues;

import java.util.Arrays;

public class ConcreteHeapPriorityQueue<V extends Comparable<V>> implements AbstractPriorityQueue<V>{

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
	private int size = 25;
	
	public ConcreteHeapPriorityQueue() {
		theQueue = new Object[size];
	}
	
	@Override
	public void enqueue(V elem) {
		// TODO Auto-generated method stub
		if(count>=1) {
			last++;
			count++;
			theQueue[count-1]=elem;
			siftUp(last);
		}
		
		if(count==0) {
			theQueue[0]=elem;
			count++;
		}
		
	}
	private void siftUp(int index) {
		assert (index >= 0 && index <= (last));
		
		// TODO: Implement me!
		if(count>0) {
			boolean swapped;
			
			
			do{
				int comparedIndex = (index-1)/2;
				swapped = false;
				if(compareValues(index, comparedIndex)) {
					swapValues(index, comparedIndex);
					index = comparedIndex;
					swapped=true;
					
				}
				
			} while(swapped);
		}
		

	}
	@SuppressWarnings("unchecked")
	private boolean compareValues(int index1, int index2) {
		
			return ((V) theQueue[index1]).compareTo((V) theQueue[index2]) > 0;
		
	}
	
	private void swapValues(int index1, int index2) {
		Object value = theQueue[index1];
		theQueue[index1] = theQueue[index2];
		theQueue[index2] = value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public V dequeue() {
		// TODO Auto-generated method stub
		V result = null;
		if(count>0) {
			result = (V) theQueue[0];
			
			count--;
			swapValues(0,last);
			theQueue[count] = null;
			last--;
			siftDown(0);
		}
		if(count==0) {
			first=0;
			last=0;
		}
		return result;
	}
	private void siftDown(int index) {
		assert (index >= 0 && index <= (last));

		if (index <= ((last - 1) / 2)) {
			int ch1Index;
			int ch2Index;
			int swapIndex = 0;
			boolean swapped;

			do {
				swapped = false;
				ch1Index = 2 * index + 1;

				if (ch1Index <= last) {
					ch2Index = ch1Index + 1;

					swapIndex = ch2Index <= last
							&& compareValues(ch2Index, ch1Index) ? ch2Index
							: ch1Index;
				}

				if (compareValues(swapIndex, index)) {
					swapValues(swapIndex, index);
					index = swapIndex;
					swapped = true;
				}
			} while (swapped);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public V poll() {
		V result = null;
		if(count>0) {
			result = (V) theQueue[0];
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
