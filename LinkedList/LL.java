package LinkedList;
import java.util.*;
public class LL {
	private class Node 
	{
		private int value;
		private Node next;	
		public Node (int value)
		{
			this.value = value;
		}
		public Node (int value, Node next)
		{
			this.value = value;
			this.next = next;
		}
		
	}
	private Node head;
	private Node tail;
	private int size;
	public LL ()
	{
		this.size = 0;
	}
	//Insert at First
	public void addFirst (int val)
	{
		Node node = new Node (val);
		node.next = head;
		head = node;
		if (tail==null)
		{
			tail = head;
		}
		
		size++;
	}
	// insert at last
	public void addLast (int val)
	{
		Node node = new Node(val);
		if (tail == null)
		{
			addFirst (val);
			return;
		}
		tail.next = node;
		tail = node;
		size++;
	}
	//insert anywhere 
	public void add (int val, int index)
	{
		Node node = new Node (val);
		Node temp = head;
		Node prev = null;
		if (index == 0)
		{
			addFirst (val);
			return;
		}
		if (index == size)
		{
			addLast (val);
			return;
		}
		while (index != 0)
		{
			prev = temp;
			temp = temp.next;
			index--;
		}
		prev.next = node;
		node.next = temp;
		size++;
	}
	// delete from first
	public void removeFirst ()
	{
		head = head.next;
		if (head==null) // when there will be only one element... head & tail will 
			tail = null; // be same ... so in that case head = head.next = null
		size--;          // we also need to update tail to null
	}
	//delete from last
	public void removeLast ()
	{
		if (size <=1)
		{
			removeFirst ();
			return;
		}
		Node secondLast = get (size-2);
		tail = secondLast;
		secondLast.next = null;
		size--;
	}
	// get a praticular node address 
	public Node get (int index)
	{
		Node temp = head;
		for (int i=0; i<index; i++)
		{
			temp = temp.next;
		}
		return temp;
	}
	//reverse a LinkedList
	public void reverse ()
	{
		Node curr = head;
		Node next = null, prev = null;
		while (curr != null)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}
	// display 
	public void display ()
	{
		Node temp = head;
		while (temp != null) 
		{
			System.out.print(temp.value+" ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LL ll = new LL ();
		ll.addFirst(2);
		ll.addFirst(3);
		ll.addFirst(4);
		ll.addFirst(5);
		ll.addFirst(6);
//		ll.addLast(5);
		ll.add(50, 0);
		ll.display();
		ll.removeFirst();
		ll.display();
		ll.removeLast();
		ll.display();
//		System.out.println(ll.size);
		ll.reverse();
		ll.display();
		

	}

}
