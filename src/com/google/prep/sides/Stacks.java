package com.google.prep.sides;

import java.util.*;

/**
 * @author Heena Hussain
 *
 */
public class Stacks
{
	public static void main(String[] args)
	{

		ArrayList<Integer> songDurations = new ArrayList<>();
//		songDurations.ad
		songDurations.add(100);
		songDurations.add(180);
		songDurations.add(40);
		songDurations.add(120);
		songDurations.add(10);
//		songDurations.add(110);

		Stacks s = new Stacks();
		s.IDsOfSongs(250, songDurations);

		HashMap map = new HashMap();
		String str = "";
		int [] arr;
//		listOfLists.size()
//		ArrayList<Integer> l = listOfLists.get(0);

//		Size
		// 		listOfLists.size()
		// 		map.size()
		//		str.length()
		//		arr.length;


	}

	ArrayList<Integer> IDsOfSongs(int rideDuration,
			ArrayList<Integer> songDurations)
	{
		if(songDurations == null || songDurations.size() == 0)
		{
			return null;
		}

		ArrayList<Integer> index = new ArrayList<>();
		ArrayList<Integer> result = new ArrayList<>();

		Stack<Integer> res = new Stack<Integer>();
		int offset = rideDuration - 30;
		int k = 0;
		for (int i=0; i< songDurations.size()-1; i++)
		{
			for (int j=i+1; j< songDurations.size(); j++)
			{
				if(songDurations.get(i)+songDurations.get(j) == offset)
				{
					index.add(i);
					index.add(j);
					k++;
				}
			}
		}


		if(k > 1)
		{
			int max = 0;
			for (int i=0; i<k-1; i++)
			{
				for (int j=i+1; j<k;j++)
				{
					int sum = songDurations.get(index.get(i)) +
							songDurations.get(index.get(j));
					if (max < sum )
					{
						max = sum;
						while(!res.isEmpty())
						{
							res.pop();
						}
						res.push(new Integer(index.get(i)));
						res.push(new Integer(index.get(j)));
					}
				}

			}
			while(!res.isEmpty())
			{
				result.add(res.pop());
			}

			return result;
		} else{
			return index;
		}
	}
}
