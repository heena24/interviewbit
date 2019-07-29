package com.google.prep.datastructure;

/**
 * @author Heena Hussain
 *
 */
public class DynamicArray<T>
{
	private T[] array;
	private int initial_size = 10;
	private int factor = 2;
	private int size;

	public DynamicArray()
	{
		array =(T[])new Object[initial_size];
	}

	public T get(int i)
	{
		return array[i];
	}

	public void set(int i, T value)
	{
		if((1.0) * size/initial_size == 0.5)
		{
			T[] temp = array;
			initial_size = factor * initial_size;
			array = (T[])new Object[initial_size];
			for (int j=0; j< temp.length; j++)
			{
				array[j] = temp[j];
			}
		}
		array[i] = value;
		size++;
	}

	public static void main(String[] args)
	{
//		DynamicArray<Integer> arr = new DynamicArray<>();
//		arr.set(0, 11);
//		arr.set(1, 21);
//		arr.set(2, 31);
//		arr.set(3, 41);
//		arr.set(4, 51);
//		arr.set(5, 61);
//		arr.set(6, 61);
//		arr.set(7, 61);
//		arr.set(8, 61);
//		arr.set(9, 61);
//		arr.set(10, 61);
//		arr.set(11, 61);
//		System.out.println(arr.size);
//		StringBuilder s = new StringBuilder();

		String s1 = "erbottlewat";
		String s2 = "bottle";
		boolean found = true;
		int len1 = s1.length();
		int len2 = s2.length();

		System.out.println("s1: " + s1.length()); //11
		System.out.println("s2: " + s2.length()); //6

		for (int i=0; i<=len1 - len2; i++)
		{
			int count = 0;
			int j;
			for(j=0; j< len2; j++)
			{
				if (s1.charAt(i+j) != s2.charAt(j)) break;
			}

//			if (j == len2)
//				System.out.println("found"); //return


			if(j == len2)
			{
				found = true;
				break;
			} else
			{
				found = false;
			}
		}

		if(found) System.out.println("Found"); else System.out.println("Not found");
	}
}
