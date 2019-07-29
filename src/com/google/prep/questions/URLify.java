package com.google.prep.questions;

import java.util.ArrayList;

/**
 * @author Heena Hussain
 *
 */
public class URLify
{
	public String modifiedString(String str, int size)
	{
		char[] chars = str.toCharArray();
		int k = size - 1;
		int space = 0;
		for (int l = 0; l< size; l++)
		{
			if(chars[l] == ' ')
			{
				space++;
			}
		}
		for (int i=0; i< size; i++)
		{
			if(chars[i] == ' ')
			{
				for (int j=k; j> i; j--)
				{
					chars[j+space] = chars[j]; //2 here is no. of spaces in the string
				}
				k = k+space;

				chars[i] = '%';
				chars[i+1] = '2';
				chars[i+2] = '0';

			}
		}
		return String.valueOf(chars);
	}

	public static void main(String[] args)
	{
		URLify s = new URLify();
		System.out.println(s.modifiedString("I am Heena                                                          ", 10));
		ArrayList arr = new ArrayList();

	}
}
