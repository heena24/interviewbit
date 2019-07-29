package com.google.prep.datastructure;

import com.google.prep.data.HashNode;

import java.util.ArrayList;

/**
 * @author Heena Hussain
 *
 */
public class HashTableUsingArray<K, V>
{
	/**
	 * 1. Define dynamically increasing array - array list of node
	 * 2. To solve collision problem - extend the array with the definated collision factor
	 * https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/
	 * https://www.geeksforgeeks.org/hashing-set-1-introduction/
	 */

	ArrayList<HashNode<K, V>> bucket = new ArrayList<>();
	private int BUCKET_SIZE = 10;
	private int size;

	HashTableUsingArray()
	{
		for (int i=0; i< BUCKET_SIZE; i++)
		{
			bucket.add(null);

		}
	}

	void add(K key, V value)
	{
		HashNode<K, V> node = new HashNode<>();
		node.setKey(key);
		node.setValue(value);
		node.setNext(null);

		int index = getBucketIndex(key);
		System.out.println("Add, index of " + key + ":" + index);
		HashNode<K, V> headNode = bucket.get(index);

		if (headNode == null)
		{
			bucket.add(index, node);
			size++;
		} else
		{
			while(headNode.getNext() != null)
			{
				if(headNode.getKey().equals(key))
				{
					headNode.setValue(value);
					break;
				}
				headNode = headNode.getNext();

			}
			headNode.setNext(node);
			size++;
		}
	}

	V remove(K key)
	{
		int index = getBucketIndex(key);

		HashNode<K, V> headNode = bucket.get(index);
		if(headNode.getKey().equals(key))
		{
			V value = headNode.getValue();
			bucket.set(index,headNode.getNext()); //rewrite the value
			size--;
			return value;
		} else
		{
			HashNode<K, V> prevNode = headNode;
			HashNode<K, V> currNode = headNode.getNext();
			while(currNode != null)
			{
				if(currNode.getKey().equals(key))
				{
					prevNode.setNext(currNode.getNext());
					size--;
					return currNode.getValue();
				}
				prevNode = currNode;
				currNode = currNode.getNext();
			}
		}

		return null;
	}

	V get(K key) //best case O(1) worst case O(length of the linked list)
	{
		int index = getBucketIndex(key);

		HashNode<K, V> headNode = bucket.get(index);
		while(headNode != null)
		{
			if (headNode.getKey().equals(key))
			{
				return headNode.getValue();
			}

			headNode = headNode.getNext();
		}
		return null;
	}

	int getSize()
	{
		return size;
	}

	int getBucketIndex(K key)
	{
		int hashCode = key.hashCode();
		return hashCode%BUCKET_SIZE;
	}

	public static void main(String[] args)
	{
		HashTableUsingArray<String, Integer> map = new HashTableUsingArray<>();
		long t1 = System.currentTimeMillis();
		map.add("a",3);
		map.add("b",2);
		map.add("c",1);
		map.add("d",4);
		System.out.println("Itime: " + (System.currentTimeMillis() - t1));
		t1 = System.currentTimeMillis();
		System.out.println("search: " + map.get("a"));
		System.out.println("search: " + map.get("b"));
		System.out.println("Stime: " + (System.currentTimeMillis() - t1));

	}
}
