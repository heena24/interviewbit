package com.google.prep.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Heena Hussain
 *
 */
public class TripletWithSum
{
	public static void main(String[] args)
	{
		TripletWithSum s = new TripletWithSum();
		String[] arr = new String[]{"0.297657", "0.420048", "0.053365", "0.437979", "0.375614", "0.264731", "0.060393", "0.197118", "0.203301", "0.128168"};
		//"0.297657", "0.420048", "0.053365", "0.437979", "0.375614", "0.264731", "0.060393", "0.197118", "0.203301", "0.128168"

		System.out.println(s.solve(new ArrayList<>(Arrays.asList(arr))));
	}

	public int solve(ArrayList<String> A)
	{
		if (A.size() >=0 && A.size() <=2)
		{
			return 0;
		}
		ArrayList<Double> ad = new ArrayList<>();

		for(String str : A)
		{
			ad.add(Double.parseDouble(str));
		}

		Collections.sort(ad);

		System.out.println("Sorted: " + Arrays.toString(ad.toArray()));

		for(int i=0; i<ad.size()/2; i++)
		{
			Double sum = ad.get(i) + ad.get(i+1) + ad.get(i+2);
			System.out.println("i:" + ad.get(i));
			System.out.println("i+1:" + ad.get(i+1));
			System.out.println("i+2:" + ad.get(i+2));
			System.out.println("sum: " + sum.doubleValue());
			if(sum > 1 && sum < 2)
			{
				return 1;
			}
		}

		return 0;
	}
}
