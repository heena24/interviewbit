package com.google.prep.questions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author Heena Hussain
 *
 */
public class UniquePaths
{
	int x =0;
	int y = 0;

	public static void main(String[] args)
	{
		UniquePaths p = new UniquePaths();
		System.out.println(p.uniquePaths(2,2));
	}
	public int uniquePaths(int A, int B)
	{
		x = A;
		y = B;

		ArrayList<ArrayList<Integer>> visit = new ArrayList(Collections.nCopies(x, new ArrayList(Collections.nCopies(y, 0))));
		return paths(0, 0, visit);
	}

	private int paths(int a, int b, ArrayList<ArrayList<Integer>> visit)
	{
		if(!isValidSquare(a, b)) return 0;
		if(isAtEnd(a, b)) return 1;

		if(visit.get(a).get(b) == 0)
		{
			int v = paths(a, b+1, visit) + paths(a+1, b, visit);
			visit.get(a).set(b, v);
		}

		return visit.get(a).get(b);
	}

	private boolean isValidSquare(int i, int j)
	{
		if( i<x && j<y) return true;

		return false;
	}

	private boolean isAtEnd(int i, int j)
	{
		if(i == x-1 && j == y-1) return true;
		return false;
	}
}
