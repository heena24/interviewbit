package com.google.prep.data;

/**
 * @author Heena Hussain
 *
 */
public class ListNode
{
	ListNode next;
	int data;

	public ListNode(int data)
	{
		next = null;
		this.data = data;
	}

	public ListNode getNext()
	{
		return this.next;
	}

	public void setNext(ListNode listNode)
	{
		this.next = listNode;
	}



	public int getData()
	{
		return this.data;
	}

	public void setData(int data)
	{
		this.data = data;
	}
}

