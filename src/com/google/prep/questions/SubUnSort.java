package com.google.prep.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Heena Hussain
 *
 */
public class SubUnSort
{

	public ArrayList<Integer> subUnsort(ArrayList<Integer> A)
	{
		ArrayList<Integer> b = new ArrayList<Integer>();

		List<Integer> a = new ArrayList<>();
		a.add(1,2);
		a.set(1,2);
		a.subList(1,1);


		b.get(1);
		int n = A.size();
		int s = -1;
		int e = -1;
		if(isSorted(A, A.size()))
		{
			b.add(-1);
			return b;
		}



		for(int i=0; i< n-1; i++)
		{
			if(A.get(i) > A.get(i+1))
			{
				s = i;
				break;
			}
		}

		for(int j=n-1; j>0; j--)
		{
			if(A.get(j) < A.get(j-1))
			{
				e = j;
				break;
			}
		}

		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		// check if two index are correct
		if(s != -1 && e != -1)
		{
			for(int k=s; k<=e; k++)
			{
				temp.add(A.get(k));
			}

			Collections.sort(temp);

			int l =0;
			for(int k=0; k < n; k++)
			{
				if(k<s || k >= e+1)
				{
					sorted.add(A.get(k));
				} else
				{
					sorted.add(temp.get(l));
					l++;
				}
			}

			boolean issorted = isSorted(sorted, n);

			int max = temp.get(temp.size()-1);
			int min = temp.get(0);

			if(!issorted)
			{
				for(int k=0; k<s; k++)
				{
					if(A.get(k) > min)
					{
						s = k;
						break;
					}
				}

				for(int k=e+1; k<n; k++)
				{
					if(A.get(k) < max)
					{
						e = k;
						break;
					}
				}
			}
		}

		if(s != -1 && e != -1)
		{
			b.add(s);
			b.add(e);
		} else
		{
			b.add(-1);
		}

		return b;
	}

	private boolean isSorted( ArrayList<Integer> sorted, int n)
	{
		for(int k=0; k<n-1; k++)
		{
			if(sorted.get(k) > sorted.get(k+1))
			{
				return false;
			}
		}

		return true;
	}
}
