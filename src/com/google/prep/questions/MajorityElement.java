package com.google.prep.questions;

import java.util.List;

/**
 * @author Heena Hussain
 *
 */
public class MajorityElement
{
	public int repeatedNumber(final List<Integer> a)
	{
//		Math.sq
		int n = a.size();

		if(n == 0) return -1;

		if(n == 1) return a.get(0);

		int f = Integer.MAX_VALUE;
		int s = Integer.MAX_VALUE;

		int cf = 0;
		int cs = 0;

		for(int i=1; i<n; i++)
		{
			if(f == a.get(i))
			{
				cf++;
			} else if(s == a.get(i))
			{
				cs++;
			} else if(cf == 0)
			{
				f = a.get(i);
				cf++;
			} else if(cs == 0)
			{
				s = a.get(i);
				cs++;
			} else
			{
				cf--;
				cs--;
			}
		}

		cf = 0;
		cs = 0;

		for(int i=0; i<n; i++)
		{
			if(f == a.get(i))
			{
				cf++;
			}

			if(s == a.get(i))
			{
				cs++;
			}
		}

		if(cf > n/3) return f;

		if(cs > n/3) return s;

		return -1;
	}
}
