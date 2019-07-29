package com.google.prep.questions;

import java.util.ArrayList;

/**
 * @author Heena Hussain
 *
 */
public class PascalTriangle
{
	public static void main(String[] args)
	{
		PascalTriangle p = new PascalTriangle();
		p.printKth(5);
	}

	public void print(int k) //without using space
	{
		for(int l=1; l<=k; l++)
		{
			int C=1;
			for(int i=1; i<=l; i++)
			{
				System.out.print(C+" ");
				C = C*(l-i)/i;
			}
			System.out.println();
		}
	}

	public void printKth(int k)
	{
		int C=1;
		for(int i=1; i<=k; i++)
		{
			System.out.print(C+" ");
			C = C*(k-i)/i;
		}
		System.out.println();

	}

	public ArrayList<Integer> generateKth(int k)
	{
		ArrayList<Integer> previous = new ArrayList<Integer>();

		for(int i=0; i<k; i++)
		{
			ArrayList<Integer> current = new ArrayList<Integer>();

			for (int j = 0; j <= i; j++)
			{
				if (i == j || j == 0)
				{
					current.add(1);
				} else
				{
					int sum = previous.get(j-1) + previous.get(j);
					current.add(sum);
				}
			}

			previous = current;

		}

		return previous;
	}

	public ArrayList<ArrayList<Integer>> generate(int k)
	{
		ArrayList<ArrayList<Integer>> pascal = new ArrayList<ArrayList<Integer>>();

		for(int i=0; i<k; i++)
		{
			ArrayList<Integer> rowi = new ArrayList<Integer>();
			pascal.add(rowi);
			for (int j = 0; j <= i; j++)
			{
				if (i == j || j == 0)
				{
					rowi.add(j, 1);
				} else
				{
					int sum = pascal.get(i-1).get(j-1) + pascal.get(i-1).get(j);
					rowi.add(j, sum);
				}

			}
		}

		return pascal;

	}
}
