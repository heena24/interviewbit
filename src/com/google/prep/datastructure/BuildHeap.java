package com.google.prep.datastructure;

/**
 * @author Heena Hussain
 *
 */
public class BuildHeap
{
	int[] minHeap;
	int minHeapSize;
	int[] maxHeap;
	int maxHeapSize;

	public BuildHeap()
	{
		minHeap = new int[10];
		maxHeap = new int[10];
		minHeapSize = 0;
		maxHeapSize = 0;
	}

	public void buildMinHeap(Integer[] inputArray)
	{
		for (int v : inputArray)
		{
			insertIntoMinHeap(v);
		}
	}

	private void insertIntoMinHeap(Integer value)
	{
		int index = minHeapSize;
		minHeap[index] = value;
		minHeapify(index);
		minHeapSize++;
	}

	private void minHeapify(int index)
	{
		int parentIndex = parentIndex(index);
		while (parentIndex >= 0 && minHeap[parentIndex] > minHeap[index])
		{
			int temp = minHeap[parentIndex];
			minHeap[parentIndex] = minHeap[index];
			minHeap[index]= temp;
			index = parentIndex;
			parentIndex = parentIndex(index);
		}
	}

	public void printMinHeap()
	{
		for (int i= 0; i < minHeapSize; i++)
		{
			System.out.println("index:" + i + "value:" + minHeap[i]);
		}
	}

	private int parentIndex(int index)
	{
		return (index % 2 == 0) ? index/2 -1 : index/2;
	}

	public void buildMaxHeap(Integer[] inputArray)
	{

	}

	public static void main(String[] args)
	{
		BuildHeap heap = new BuildHeap();
		Integer[] arr1 = {3,2,1,7 ,8, 4,  10,  16,  12};
		heap.buildMinHeap(arr1);
		heap.printMinHeap();
	}
}
