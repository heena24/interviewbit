package com.google.prep.sides;

import com.google.prep.datastructure.BinarySearchTree;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author Heena Hussain
 *
 */
public class BST
{
	public static void main(String[] args)
	{
		BinarySearchTree tree = new BinarySearchTree();
		//962 29 643 291 8 298 133 481 175 916 948
		tree.insert(9);
		tree.insert(4);
		tree.insert(17);
		tree.insert(3);
		tree.insert(6);
		tree.insert(22);
		tree.insert(5);
		tree.insert(7);
		tree.insert(20);
//		System.out.println("count: " + tree.findTheNodeInRange(2, 8));
//		System.out.println("kth: " + tree.findKthNode(6));
//		System.out.println(tree.inorder());
		System.out.println("Min:" + tree.findClosest(5).getValue());
	}


}
