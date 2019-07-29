package com.google.prep.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Heena Hussain
 *
 */
public class NobleInteger
{
	public static void main(String[] args)
	{
		NobleInteger n = new NobleInteger();
		Integer[] arr = new Integer[]{4, 7, 5, 3, 5, -4, 2, -1, -9, -8, -3, 0, 9, -7, -4, -10, -4, 2, 6, 1, -2, -3, -1, -8, 0, -8, -7, -3, 5, -1, -8, -8, 8, -1, -3, 3, 6, 1, -8, -1, 3, -9, 9, -6, 7, 8, -6, 5, 0, 3, -4, 1, -10, 6, 3, -8, 0, 6, -9, -5, -5, -6, -3, 6, -5, -4, -1, 3, 7, -6, 5, -8, -5, 4, -3, 4, -6, -7, 0, -3, -2, 6, 8, -2, -6, -7, 1, 4, 9, 2, -10, 6, -2, 9, 2, -4, -4, 4, 9, 5, 0, 4, 8, -3, -9, 7, -8, 7, 2, 2, 6, -9, -10, -4, -9, -5, -1, -6, 9, -10, -1, 1, 7, 7, 1, -9, 5, -1, -3, -3, 6, 7, 3, -4, -5, -4, -7, 9, -6, -2, 1, 2, -1, -7, 9, 0, -2, -2, 5, -10, -1, 6, -7, 8, -5, -4, 1, -9, 5, 9, -2, -6, -2, -9, 0, 3, -10, 4, -6, -6, 4, -3, 6, -7, 1, -3, -5, 9, 6, 2, 1, 7, -2, 5 };
		System.out.println("Before Sorting: " + Arrays.toString(arr));
		System.out.println(n.solve(new ArrayList<>(Arrays.asList(arr))));
	}

	public int solve(ArrayList<Integer> A)
	{
		if (A.size() >= 0 && A.size() <=1) return -1;
		Collections.sort(A);

		System.out.println("After Sorting: " + Arrays.toString(A.toArray()));

		for(int i=0; i<A.size()-1; i++)
		{
			if(A.get(i) >= 0 && (A.get(i) != A.get(i+1))&& A.get(i) == A.size() - i-1)
			{
				System.out.println("v: " + A.get(i) + "-" + i);
				System.out.println("size: " + A.size());
				return 1;
			}
		}
		return -1;
	}
}
