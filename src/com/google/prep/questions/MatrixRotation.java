package com.google.prep.questions;

/**
 * @author Heena Hussain
 *
 * 1. Rotate in clock-wise direction
 * 2. Do in-place rotation
 * 3. due to 2, matric has to be a sqaure matric nXn
 */
public class MatrixRotation
{
	public int[][] rotateClockwise(int[][] matrix, int n)
	{
		//no. of layers - n/2
		for (int l= 0; l < n/2; l++)
		{
			for (int i=0; i< n; i++)
			{
//				int t
			}
		}
		return null;
	}

	public static void main(String[] args)
	{
		MatrixRotation mr = new MatrixRotation();
		int[][] matrix = {{1,2,3}, {5,6,7}, {9,10,11}};
		matrix = mr.rotateClockwise(matrix, 3);
	}

}
