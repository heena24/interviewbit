package com.google.prep.questions;

import java.util.ArrayList;

/**
 * @author Heena Hussain
 *
 */
public class DnI {

	/**
	 * Removed max and min calculation so the requirement of swapping.
	 * @param A
	 * @param B
	 * @return
	 */
	public ArrayList<Integer> findPermOptimal(final String A, int B)
	{
		int smallest = 1;
		int largest = B;
		ArrayList<Integer> op = new ArrayList<Integer>();
		for(int i=0;i<A.length();i++)
		{
			if(A.charAt(i)=='D')
			{
				op.add(largest);
				largest = largest -1;
			}
			else
			{
				op.add(smallest);
				smallest = smallest+1;
			}
		}

		op.add(smallest);
		return op;
	}
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public ArrayList<Integer> findPerm(final String A, int B)
	{
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=1; i<=B; i++)
		{
			arr.add(i-1, i);
		}

		char[] charArr = A.toCharArray();

		for(int i=0; i<A.length(); i++)
		{
			int swap = -1;
			if(charArr[i] == 'I')
			{
				swap = min(arr, i);
			} else
			{
				swap = max(arr, i);
			}

			int temp = arr.get(i);
			arr.set(i, arr.get(swap));
			arr.set(swap, temp);
		}

		return arr;
	}

	private int min(ArrayList<Integer> arr, int i)
	{
		int minIdx = i;
		for(int j = i+1; j < arr.size(); j++)
		{
			if (arr.get(minIdx) > arr.get(j))
			{
				minIdx = j;
			}
		}

		return minIdx;
	}

	private int max(ArrayList<Integer> arr, int i)
	{
		int maxIdx = i;
		for(int j = i+1; j < arr.size(); j++)
		{
			if (arr.get(maxIdx) < arr.get(j))
			{
				maxIdx = j;
			}
		}

		return maxIdx;
	}
}

