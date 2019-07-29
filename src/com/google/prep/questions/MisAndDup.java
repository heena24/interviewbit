package com.google.prep.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Heena Hussain
 *
 */
public class MisAndDup
{
	public static ArrayList<Integer> repeatedAndMissNumber(final List<Integer> A)
	{
		Map<Integer, Boolean> numberPresenceMap = new HashMap<>();
		ArrayList<Integer> result = new ArrayList<>();
		for(Integer i : A)
		{
			if(numberPresenceMap.containsKey(i)) result.add(i);
			numberPresenceMap.put(i, new Boolean(true));
		}

		for (int i=1; i<= A.size(); i++)
		{
			if(!numberPresenceMap.containsKey(i))
			{
				result.add(i);
				break;
			}
		}

		return result;

	}

	public static void printTwoElements(int arr[], int size)
	{
		int i;
		System.out.print("The repeating element is ");

		for (i = 0; i < size; i++) {
			int abs_val = Math.abs(arr[i]);
			if (arr[abs_val - 1] > 0)
				arr[abs_val - 1] = -arr[abs_val - 1];
			else
				System.out.println(abs_val);
		}

		System.out.print("And the missing element is ");
		for (i = 0; i < size; i++) {
			if (arr[i] > 0)
				System.out.println(i + 1);
		}
	}
}
