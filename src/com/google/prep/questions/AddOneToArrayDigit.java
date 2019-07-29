package com.google.prep.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Heena Hussain
 *
 */
public class AddOneToArrayDigit
{
	public static void main(String[] args)
	{
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0,0);
		list.add(1,0);
		list.add(2,9);
//		list.add(3,1);
//		list.add(4,2);
//		list.add(5,3);

		System.out.println("Array: " + Arrays.toString(list.toArray()));

//		int j = 0;
//		while(j < list.size()-1 && list.get(j) == 0)
//		{
//			list.remove(j);
//		}
//
//		Collections.reverse(list);
//
//		j = 0;
//		int sum = 1;
//		int carry = 1;
//		while(j < list.size())
//		{
//			sum = list.get(j) + carry;
//			if(sum > 9)
//			{
//				list.remove(j);
//				list.add(j, sum%10);
//				carry = sum/10;
//			} else
//			{
//				list.remove(j);
//				list.add(j, sum);
//				carry = 0;
//			}
//
//			j++;
//		}
//
//		if (carry > 0)
//		{
//			list.add(j, carry);
//		}
//
//		Collections.reverse(list);

		int car=1;
		int i=list.size()-1;
		ArrayList<Integer> ans=new ArrayList<>();
		while(i>=0){
			int sum=list.get(i)+car;
			car=sum/10;
			ans.add(0,sum%10);
			i--;
		}
		if(car!=0){
			ans.add(0,car);
		}
//		i=0;
//		while(ans.size()>0&&ans.get(0)==0){
//			ans.remove(0);
//		}
		System.out.println("Array: " + Arrays.toString(ans.toArray()));
	}
}
