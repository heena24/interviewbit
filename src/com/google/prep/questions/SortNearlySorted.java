package com.google.prep.questions;

import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Heena Hussain
 *
 * O(NK)
 * O(NlogK)
 */
public class SortNearlySorted
{
	public static void main(String[] args)
	{
		SortNearlySorted s = new SortNearlySorted();
		Integer[] arr = new Integer[] {2, 6, 3, 12, 56, 8};
//		ArrayList<Integer> arrayList = s.sortUsingInsertionSort(new ArrayList<Integer>(Arrays.asList(arr)), 3);
//		System.out.println(arrayList);
		ArrayList<Integer> arrayList = s.sortUsingHeapSort(new ArrayList<Integer>(Arrays.asList(arr)), 3);
		System.out.println(arrayList);
	}
	private ArrayList<Integer> sortUsingInsertionSort(ArrayList<Integer> arrayList, int k)
	{
		int n = arrayList.size();
		for(int i=0; i<n-1; i++)
		{
			for(int j=i+1; j<n; j++)
			{
				if(arrayList.get(i) > arrayList.get(j))
				{
					int temp = arrayList.get(i);
					arrayList.set(i, arrayList.get(j));
					arrayList.set(j, temp);
				}
			}
		}
		return arrayList;
	}

	private ArrayList<Integer> sortUsingHeapSort(ArrayList<Integer> arrayList, int k)
	{
		int n = arrayList.size();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new QueueComparator());
		for (int i = 0; i<=k; i++)
		{
			pq.add(arrayList.get(i));
		}
		int index = 0;
		for( int j = k+1; j < n; j++)
		{
			arrayList.set(index++, pq.peek());
			pq.remove();
			pq.add(arrayList.get(j));
		}

		while(!pq.isEmpty())
		{
			arrayList.set(index++, pq.peek());
			pq.remove();
		}

		return arrayList;

	}

	//To print in increasing order
	class QueueComparator implements Comparator<Integer>
	{
		public int compare(Integer a, Integer b)
		{
			if(a==b) return 0;
			else if(a>b) return -1;
			else return 1;
		}
	}
}


