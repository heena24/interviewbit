package com.google.prep.data;

/**
 * @author Heena Hussain
 *
 */
public class HashNode<K, V>
{
	K key;
	V value;
	HashNode next;

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
	public HashNode getNext()
	{
		return next;
	}
	public void setNext(HashNode next)
	{
		this.next = next;
	}
}
