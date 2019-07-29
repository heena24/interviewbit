package com.google.prep.questions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Heena Hussain
 *
 */
public class Factors
{
	public static void main(String[] args)
	{
		int n = 9;
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3));

		int j = 0;
		for(int i=1; i<= Math.sqrt(n); i++)
		{
			try
			{
				if(n%i == 0)
				{
					if(arr.size() == 0)
					{
						arr.add(j, i);
						if(i != Math.sqrt(n))
						{
							arr.add(++j, n/i);
						}
					} else
					{
						arr.add(j, i);
						if(i != Math.sqrt(n))
						{
							arr.add(++j, n/i);
						}
					}

				}
			} catch (Exception e)
			{
				System.out.println("i:" + i);
				System.out.println("arr:" + arr);
			}

		}

		System.out.println(arr);
	}
}
