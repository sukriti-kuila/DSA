package LinkedList;
public class LL_NoTail {
	private class _Node 
	{
		private _Node next;
		private int val; 
		public _Node (int val)
		{
			this.val = val;
		}
	}
	private static _Node head;
	private int size;
	
	public void addFirst (int val)
	{
		_Node node = new _Node (val);
		node.next = head;
		head = node;
		size++;
	}
	
	public void addLast (int val)
	{
		_Node node = new _Node (val);
		if (head==null)
		{
//			node.next = head;
//			head = node;
//			size++;
			addFirst(val);
			return;
		}
		_Node temp = getPrevNode (size);
		temp.next = node;
		size++;
	}
	
	public void add (int index, int val)
	{
		_Node node = new _Node (val);
		if (head == null && index==0)
		{
			addFirst(val);
			return;
		}
		if (index>size)
			throw new IllegalStateException ("IndexOutOfBound");
		if (index == 0)
		{
			addFirst(val);
			return;
		}
		if (index == size)
		{
			addLast(val);
			return;
		}
		_Node temp = getPrevNode (index);
		node.next = temp.next;
		temp.next = node;
		size++;
	}
	
	public void sortedInsert (int val)
	{
		_Node node = new _Node (val);
		_Node temp = head;
		if (temp == null || temp.val>val)
		{
			addFirst(val);
			return;
		}
		while (temp.next != null && temp.next.val<val)
		{
			temp = temp.next;
		}
		node.next = temp.next;
		temp.next = node;
		size++;
	}
	
	public void removeFirst ()
	{
		if (size==0)
			throw new IllegalStateException ("EmptyListExecption");
		head = head.next;
		size--;
	}
	
	public void removeLast ()
	{
		if (size==0)
			throw new IllegalStateException ("EmptyListException");
		if (size==1)
		{
			deleteList();
			return;
		}
		_Node temp = getPrevNode (size-1);
		temp.next = null;
		size--;
	}
	
	public void deleteList ()
	{
		head = null;
		size = 0;
	}
	public void remove (int index)
	{
		if (size==0)
			throw new IllegalStateException ("EmptyListException");
		if (index>=size)
			throw new IllegalStateException ("IndexOutOfBoundException");
		if (index==0)
		{
			removeFirst();
			return;
		}
		if (index==size-1)
		{
			removeLast();
			return;
		}
		_Node temp = getPrevNode(index);
		temp.next = temp.next.next;
		size--;
	}
	
	public void reverse ()
	{
		_Node curr = head;
		_Node prev = null;
		_Node next = null;
		while (curr != null) 
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}
	
	public static void reverseRecursive (_Node curr, _Node prev)
	{
		if (head == null)
			return;
		if (curr.next == null)
		{
			head = curr;
			curr.next = prev; 
			return;
		}
		_Node next1 = curr.next;
		curr.next = prev;
		reverseRecursive (next1, curr);	
	}
	
//	Delete node from the linked list given its value
	public boolean removeByValue (int val)	
	{
		_Node temp = head;
		if (temp.val == val)
		{
			removeFirst();
			return true;
		}
		while (temp.next != null)
		{
			if (temp.next.val == val)
			{
				temp.next = temp.next.next;
				size--;
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	public void removeDuplicate () // given sorted list
	{
		_Node temp = head;
		 while (temp.next != null)
	     {
	         if (temp.val == temp.next.val)
	            temp.next = temp.next.next;
	          else
	            temp = temp.next;
	      }
	}
	public _Node getPrevNode (int index)
	{
		_Node temp = head;
		for (int i=0; i<index-1; i++)
		{
			temp = temp.next;
		}
		return temp;
	}

	public void display ()
	{
		_Node temp = head;
		if (temp == null)
		{
			System.out.println("List is empty");
			return;
		}
		while (temp != null)
		{
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		LL_NoTail ll = new LL_NoTail ();
//		ll.addFirst(10);
//		ll.addFirst(20);
//		ll.addFirst(40);
//		ll.addFirst(50);
		ll.addLast(100);
//		ll.addLast(200);
//		ll.add(0, 40);
//		ll.add(1, 50);
//		ll.addLast(300);
////		ll.display();
//		ll.add(5, 500);
////		ll.display();
//		ll.removeFirst();
////		ll.display();
////		System.out.println(ll.size);
//		ll.removeLast();
////		ll.display(); 
//		ll.remove(3);
////		ll.display();
//		ll.reverse();
//		ll.display();
		
//		ll.sortedInsert(27);
//		ll.sortedInsert(12);
//		ll.sortedInsert(23);
//		ll.sortedInsert(2);
//		ll.sortedInsert(29);
//		ll.sortedInsert(29);
//		ll.sortedInsert(12);
//		ll.removeByValue(2);
//		reverseRecursive(ll.head,null);
//		ll.display();
//		ll.addFirst(200);
//		ll.addFirst(45);
//		ll.addFirst(300);
//		ll.sortedInsert(201);
//		ll.sortedInsert(1);
//		ll.sortedInsert(25);
//		ll.sortedInsert(6);
//		ll.sortedInsert(12);
//		ll.sortedInsert(11);
//		ll.sortedInsert(10);
//		ll.sortedInsert(12);
//		ll.display();
//		ll.removeDuplicate();
//		ll.reverse();
		ll.removeLast();
		ll.display();
		System.out.println(ll.size);
	}

}
