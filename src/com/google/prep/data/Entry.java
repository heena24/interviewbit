package com.google.prep.data;

import com.sun.tools.javac.comp.Enter;

/**
 * @author Heena Hussain
 *
 */
public class Entry<K extends Comparable, V> implements Comparable<K>
{
	K key;
	V value;
	Entry left;
	Entry right;

	@Override public int compareTo(K o)
	{
		return this.key.compareTo(o); //-1, 0 , 1
	}

	public Entry()
	{
		this.left = null;
		this.right = null;
	}

	public K getKey()
	{
		return key;
	}
	public void setKey(K key)
	{
		this.key = key;
	}
	public V getValue()
	{
		return value;
	}
	public void setValue(V value)
	{
		this.value = value;
	}
	public Entry getLeft()
	{
		return left;
	}
	public void setLeft(Entry left)
	{
		this.left = left;
	}
	public Entry getRight()
	{
		return right;
	}
	public void setRight(Entry right)
	{
		this.right = right;
	}
}
