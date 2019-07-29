package com.google.prep.datastructure;

import com.google.prep.data.Entry;
import com.google.prep.data.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Heena Hussain
 * 1. Make use of java.questions.Comparable - to compare the keys
 */
public class HashTableUsingBST<K extends Comparable, V>
{
	private Entry<K, V> root;

	public void insert(K key, V value)
	{
		Entry<K, V> node = new Entry<>();
		node.setKey(key);
		node.setValue(value);
		root = insertRec(node, root);
	}

	private Entry insertRec(Entry node, Entry root)
	{
		if (root == null)
		{
			root = node;
			return root;
		} else
		{
			if (root.compareTo(node.getKey()) > 0)
			{
				root.setLeft(insertRec(node, root.getLeft()));
			} else if (root.compareTo(node.getKey()) < 0)
			{
				root.setRight(insertRec(node, root.getRight()));
			}
		}
		return root;
	}

	public V search(K key)
	{
		Entry<K, V> node = new Entry<>();
		node.setKey(key);
		node = searchRec(node, root);

		return node.getValue();
	}

	private Entry searchRec(Entry node, Entry root)
	{
		if (root.compareTo(node.getKey()) == 0)
		{
			return root;
		}

		if(root.compareTo(node.getKey()) > 0)
		{
			root = searchRec(node, root.getLeft());
		} else
		{
			root = searchRec(node, root.getRight());
		}

		return root;
 	}

 	public void delete(K key)
	{
		Entry<K, V> node = new Entry<>();
		node.setKey(key);
		root = deleteRec(node, root);
	}

	// Not working
	public Entry deleteRec(Entry node, Entry root)
	{
		if(root == null) return root;

		if(root.compareTo(node.getKey()) > 0)
		{
			root.setLeft(deleteRec(node, root.getLeft()));
		} else if (root.compareTo(node.getKey()) < 0)
		{
			root.setRight(deleteRec(node, root.getRight()));
		} else {
			if(root.getLeft() == null) return root.getRight();
			if(root.getRight() == null) return root.getLeft();

			root.setKey(minKey(root.getRight()));
			root.setValue(minValue(root.getRight()));

			root.setRight(deleteRec(root, root.getRight()));
		}
		return root;
	}

	private K minKey(Entry root)
	{
		K min = (K)root.getKey();
		while (root.getLeft() != null)
		{
			min = (K) root.getKey();
			root = root.getLeft();
		}

		return min;
	}

	private V minValue(Entry root)
	{
		V min = (V)root.getValue();
		while (root.getLeft() != null)
		{
			min = (V) root.getValue();
			root = root.getLeft();
		}

		return min;
	}

	public static void main(String[] args)
	{

		Queue<Node> q = new LinkedList<Node>();
		HashTableUsingBST<String, Integer> map = new HashTableUsingBST<>();
		map.insert("a", 3);
		map.insert("b", 2);
		map.insert("c", 1);
		map.insert("d", 4);
		System.out.println("search: " + map.search("c"));
		map.delete("c");
		System.out.println("search: " + map.search("c"));


	}
}
