package com.google.prep.questions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

/**
 * @author Heena Hussain
 *
 */
public class LargestNumber
{
	public static void main(String[] args)
	{
		ArrayList<Integer> arr = new ArrayList<>();
		arr.size();
		Stack<Integer> s = new Stack<>();
		boolean em = s.isEmpty();
		s.pop();
		s.push(1);
		s.size();

		int i = s.peek();
		LinkedList<Integer> ll = new LinkedList<>();
		ll.isEmpty();
		ll.size();
		ll.addFirst(2);
		ll.addLast(1);


		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		int j = queue.remove(); //npe
		int k = queue.peek();
		queue.poll(); // if empty return null
		queue.isEmpty();
		queue.size();

		String str = "";
		str.substring(1,2);
		str.substring(2);
		str.toCharArray();
		str.concat("");
		str.isEmpty();
		str.charAt(1);
		str.length();
		str.compareTo("");

//		Collections.max

		//		List<Integer> arr = new ArrayList<>();
//		arr.add(3);
//		arr.add(30);
//		arr.add(34);
//		arr.add(5);
//		arr.add(9);
//
//		LargestNumber l = new LargestNumber();
////		System.out.println(l.largestNumber(arr));
//		System.out.println(l.largestNumberObject(arr));
//		long out = Long.parseLong("52");
//		System.out.println(out);
		int l = 1;
		System.out.println(new int[]{1,2,3,l});

		StringBuilder b = new StringBuilder();
		b.replace(1,2, "str");
		b.reverse();
		b.append("");
		String st = "";

		HashMap<Character, Integer> map = new HashMap<>();
		map.size();
	}
	public String largestNumber(final List<Integer> A)
	{
		if(isAllZero(A))
		{
			return "0";
		}
		Vector<String> vector = new Vector<>();
		for(Integer n : A)
		{
			vector.add(String.valueOf(n));
		}
		return printLargest(vector);
	}

	private boolean isAllZero(List<Integer> A)
	{
		boolean isZero = true;
		for (Integer i : A)
		{
			if(i > 0) return false;
		}

		return isZero;
	}

	private String printLargest(Vector<String> arr)
	{
		Collections.sort(arr, new Comparator<String>(){
			public int compare(String x, String y)
			{
				String xy = x + y;
				String yx = y + x;

				return xy.compareTo(yx) > 0 ? -1 : 1;
			}
		});


		String str = "";
		Iterator it = arr.iterator();
		while(it.hasNext())
		{
			str+= it.next();
		}

		return str;
	}

	public String largestNumberObject(List<Integer> arr)
	{
		int n = Collections.max(arr).toString().length();

		ArrayList<ExtendedInteger> ex = new ArrayList<ExtendedInteger>();
		for(Integer i : arr)
		{
			ex.add(new ExtendedInteger(i, n));
		}

		Collections.sort(ex, (p1, p2) -> (int)(p2.mValue - p1.mValue));
//		Collections.sort(ex, new Comparator<ExtendedInteger>()
//		{
//			@Override public int compare(ExtendedInteger o1, ExtendedInteger o2)
//			{
//				return (int)(o2.mValue - o1.mValue);
//			}
//		});

		String str = "";
		StringBuilder sb = new StringBuilder(str);
		for(ExtendedInteger e : ex)
		{
			sb.append(Integer.toString(e.oValue));
		}

		return sb.toString();
	}

	class ExtendedInteger
	{
		int oValue;
		long mValue;

		public ExtendedInteger(int original, int n)
		{
			String oStr = Integer.toString(original);
			StringBuilder sb = new StringBuilder(oStr);
			StringBuilder oSb = new StringBuilder();
			while(oStr.length() <= n+1)
			{
				oSb.append(sb);
				oStr+=original;
			}

			this.oValue = original;
			this.mValue = Long.valueOf(oStr.substring(0, n+1));
		}

	}

}
