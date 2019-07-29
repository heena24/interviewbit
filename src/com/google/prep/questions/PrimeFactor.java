package com.google.prep.questions;

import java.util.ArrayList;

/**
 * @author Heena Hussain
 *
 */
public class PrimeFactor
{
	public static void main(String[] args)
	{
		PrimeFactor p = new PrimeFactor();
		System.out.println(p.primeFactorsUsingPrimeCheck(36));
	}

	private ArrayList<Integer> findFactors(int n)
	{
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 1; i<= Math.sqrt(n); i++)
		{
			if(n%i == 0)
			{
				arr.add(i);
				if(i != Math.sqrt(n))
				{
					arr.add(n/i);
				}
			}
		}

		return arr;
	}

	private ArrayList<Integer> primeFactorsUsingPrimeCheck(int n)
	{
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 1; i<= Math.sqrt(n); i++)
		{
			if(n%i == 0)
			{
				if(isPrime(i)) arr.add(i);

				if(i != Math.sqrt(n))
				{
					if(isPrime(n/i)) arr.add(n/i);
				}
			}
		}

		return arr;
	}

	private boolean isPrime(int n)
	{
		if(n == 2) return true;
		if(n == 1) return false;

		for(int i = 2; i<= Math.sqrt(n); i++)
		{
			if(n % i == 0)
			{
				return false;
			}
		}

		return true;
	}

	private ArrayList<Integer> primeFactors(int n)
	{
		ArrayList<Integer> arr = new ArrayList<>();
		while (n%2==0)
		{
			arr.add(2);
			n /= 2;
		}

		for (int i = 3; i <= Math.sqrt(n); i+= 2)
		{
			// While i divides n, print i and divide n
			while (n%i == 0)
			{
				arr.add(i);
				n /= i;
			}
		}

		return arr;
	}

}
