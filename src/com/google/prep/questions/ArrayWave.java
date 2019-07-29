package com.google.prep.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Heena Hussain
 *
 */
public class ArrayWave
{
	public static void main(String[] args)
	{
		Integer[] arr = new Integer[] {4,1,3,2,5};
		ArrayList<Integer> A = new ArrayList(Arrays.asList(arr));
		Collections.sort(A);
		for (int i=1; i< A.size(); i=i+2)
		{
			Integer temp = A.get(i);
			A.set(i, A.get(i-1));
			A.set(i-1, temp);
		}
		System.out.println(A);
	}
}
