package com.google.prep.datastructure;

import com.google.prep.data.Node;
import java.util.ArrayList;
/**
 * @author Heena Hussain
 *
 */
public class BinarySearchTree
{
	private Node root;
	private ArrayList<Integer> arr = new ArrayList<>();

	public void insert(int value)
	{
		root = insertRec(value, root);
	}

	public Node insertRec(int value, Node node)
	{
		Node newNode = new Node(value);
		if (node == null)
		{
			node = newNode;
			return node;
		}

		if(node.getValue() > value)
		{
			node.setLeft(insertRec(value, node.getLeft()));
		} else
		{
			node.setRight(insertRec(value, node.getRight()));
		}

		return node;
	}

	public Node getRoot()
	{
		return root;
	}
	public void setRoot(Node root)
	{
		this.root = root;
	}
	public boolean search(int key)
	{
		return true;
	}

	public String delete(int key)
	{
		return null;
	}

	public int findTheNodeInRange(int l, int h)
	{
		return findCount(root, l, h);
	}

	private int findCount(Node node, int l, int h)
	{
		if (node == null) return 0;

		int left = findCount(node.getLeft(), l, h);
		int right = findCount(node.getRight(), l , h);

		if (l <= node.getValue() && node.getValue() <= h)
		{
			return left + right + 1;
		} else{
			return left + right;
		}
	}

	public int findKthNode(int k)
	{
		ArrayList<Integer> arrayList = inorder();
		return arrayList.get(k-1);
	}

	public ArrayList<Integer> inorder()
	{
		inorderTraverse(root);
		return arr;
	}

	private void inorderTraverse(Node node)
	{
		if(node == null) return ;
		inorderTraverse(node.getLeft());
		arr.add(node.getValue());
		inorderTraverse(node.getRight());
	}

	public Node findClosest( int k)
	{
		if (root == null) return null;

		int d = k - root.getValue();
		return closest(root, k, abs(d));

	}

	private Node closest(Node node, int k, int d)
	{
		if (node == null) return null;

		if (d == 0) return node;

		if (k >= node.getValue() && node.getRight() != null && abs((k-node.getRight().getValue())) <= d)
		{
			node = closest(node.getRight(), k, abs(k-node.getRight().getValue()));
		}

		if (k <= node.getValue() && node.getLeft() != null && abs((k-node.getLeft().getValue())) <= d)
		{
			node = closest(node.getLeft(), k, abs(k-node.getLeft().getValue()));
		}

		return node;
	}

	private int abs(int value)
	{
		return (value < 0) ? -value : value;
	}
}
