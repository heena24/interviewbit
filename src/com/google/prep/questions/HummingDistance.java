package com.google.prep.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heena Hussain
 *
 *  & with 1 => % by 2
 *  >> with 1 => / by 2
 */
public class HummingDistance
{
	public static void main(String[] args)
	{

		int i =2;
		int j=6;
			System.out.println(i & (1 << 0));
			System.out.println(j & (1 << 0));
			System.out.println(7 & (1 << 0));
//		HummingDistance h = new HummingDistance();
//		Integer[] a = new Integer[]{2,4,6};
//		int sum = h.hammingDistance(new ArrayList<Integer>(Arrays.asList(a)));
//		System.out.println("sum: " +sum);
	}

	public int hammingDistance(final List<Integer> A)
	{
		int len = A.size();
		int sum = 0;
		for(int i=0; i<= len-1; i++)
		{
			for(int j=i+1; j<len; j++)
			{
				if(i!=j) sum+= countUsingXor(A.get(i), A.get(j));
			}
		}

		return sum * 2;
	}


	private int countUsingXor(int a, int b)
	{
		int c = a ^ b;
		int setbits = 0;

		while(c > 0)
		{
			setbits += c & 1;
			c >>= 1;
		}

		return setbits;
	}

	private int countDistance(int a, int b)
	{
		String arrA = findBinary(a);
		String arrB = findBinary(b);

		String[] arr = zeroPadding(new String[]{arrA, arrB});

		char[] charA = arr[0].toCharArray();
		char[] charB = arr[1].toCharArray();

		int c = 0;
		for(int i=0; i< charA.length; i++)
		{
			if(charA[i] != charB[i])
			{
				c++;
			}
		}

		return c;
	}

	private String[] zeroPadding(String[] arr)
	{
		String arrA = arr[0];
		String arrB = arr[1];

		int la = arrA.length();
		int lb = arrB.length();

		if(la > lb)
		{
			for(int i=0; i< la - lb; i++)
			{
				arrB+= 0;
			}

		} else if(lb > la){
			for(int i=0; i< lb - la; i++)
			{
				arrA+= 0;
			}
		}

		return new String[]{arrA, arrB};
	}

	private String findBinary(int num)
	{
		String arr = "";
		while(num != 0)
		{
			arr+= num%2;
			num/=2;
		}
		return arr;
	}

}


