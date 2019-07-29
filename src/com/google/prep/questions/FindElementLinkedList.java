package com.google.prep.questions;

import com.google.prep.data.ListNode;

/**
 * @author Heena Hussain
 *
 */
public class FindElementLinkedList
{
	ListNode head;

	public int findKthElement(int k)
	{
		if(head == null) return -1;
		ListNode fastRunner = head;
		ListNode slowRunner = head;

		for (int i=0; i<k; i++)
		{
			fastRunner = fastRunner.getNext();
			if(fastRunner == null) return -1;
		}

		while(fastRunner != null)
		{
			fastRunner = fastRunner.getNext();
			slowRunner = slowRunner.getNext();
		}

		return slowRunner.getData();
	}

	public ListNode addElementIntoList(int data)
	{
		ListNode newlyCreatedNode = new ListNode(data);

		if(head == null)
		{
			head = newlyCreatedNode;
		} else
		{
			ListNode traverser = head;
			while(traverser.getNext() != null)
			{
				traverser = traverser.getNext();
			}

			traverser.setNext(newlyCreatedNode);
		}

		return head;
	}

	public ListNode deleteNode(ListNode nodeToDelete)
	{
		while(nodeToDelete.getNext()!=null)
		{
			ListNode nextNode = nodeToDelete.getNext();
			int tempData = nodeToDelete.getData();
			nodeToDelete.setData(nextNode.getData());
			nextNode.setData(tempData);
			nodeToDelete = nextNode;
		}
		nodeToDelete = null;

		return head;
	}

	public void testing()
	{
		ListNode node = new ListNode(1);
		ListNode nextNode = new ListNode(2);
		node.setNext(nextNode);
		ListNode temp = node;
		System.out.println("node: "  +node.hashCode());
		System.out.println("temp: "  +temp.hashCode());
		System.out.println("nextNode: "  +nextNode.hashCode());
		node.setNext(temp);
		System.out.println("node->nextNode: "  +node.getNext().hashCode());

	}

	ListNode addLists(ListNode l1, ListNode l2, int carry)
	{
		if(l1 == null && l2 == null)
		{
			return null;
		}

		int sum = carry;

		ListNode head = new ListNode(0);

		if(l1 != null)
		{
			sum += l1.getData();
		}

		if(l2 != null)
		{
			sum += l2.getData();
		}

		head.setData(sum%10);

		if(l1 != null || l2 != null)
		{
			ListNode next = addLists((l1 != null ? l1.getNext() : null), (l2 != null ? l2.getNext() : null), sum > 10 ? 1 : 0);
			head.setNext(next);
		}
		return head;
	}


	public void initializeLinkedList(int n)
	{
		for (int i=1; i<=n; i++)
		{
			head = addElementIntoList(i);
		}

	}

	public ListNode getHead()
	{
		return head;
	}

	ListNode reverse(ListNode head)
	{
		if (head == null) return null;

		ListNode result = reverse(head.getNext());

//		System.out.println("head");
//		print(head);
//		System.out.println("resultA");
//		print(result);

		result = addLast(result, head.getData());
//		System.out.println("resultB");
//		print(result);
		return result;
	}

	ListNode addLast(ListNode node, int data)
	{
		ListNode tail = node;
		ListNode add = new ListNode(data);
//		add.setData(data);
		add.setNext(null);

		if(node == null)
		{
			return add;
		} else
		{
			while (tail.getNext() != null)
			{
				tail = tail.getNext();
			}
			tail.setNext(add);
		}

		return node;
	}

	public void print(ListNode print)
	{
		ListNode node = print;
		while(node != null)
				{
					System.out.println(node.getData());
					node = node.getNext();
				}
	}

	public static void main(String[] args)
	{
		FindElementLinkedList findElement = new FindElementLinkedList();
//		int n = Integer.parseInt(args[0]);
//		int k = Integer.parseInt(args[1]);
		int n = 4;
//		int k = 3;
		findElement.initializeLinkedList(n);
//
		ListNode nextNode = findElement.getHead();
//		for(int i=1; i<=k; i++)
//		{
//			nextNode = nextNode.getNext();
//		}
//
//		ListNode node = findElement.deleteNode(nextNode);
//
//		while(node != null)
//		{
//			System.out.println(node.getData());
//			node = node.getNext();
//		}

//		int result = findElement.findKthElement(k);
//		System.out.println("Kth element:" + result);

//		findElement.testing();

		ListNode node = findElement.reverse(nextNode);
		findElement.print(node);
	}
}

