package LinkedList;
public class DLL {
	private class $Node {
		private int val;
		private $Node next;
		private $Node prev;
		$Node (int val)
		{
			this.val = val;
		}
		$Node (int val, $Node next, $Node prev)
		{
			this.val = val;
			this.next = next;
			this.prev = prev;
		}
	}
	private static $Node head;
	private static $Node tail;
	private int size;
	public void addFirst (int val)
	{
		$Node node = new $Node (val);
		if (size == 0)
		{
			tail = head = node;
		}
		else
		{
			head.prev = node;
			node.next = head;
			head = node;	
		}
		size++;
	}
	public void addLast (int val)
	{
		$Node node = new $Node (val);
		if (head==null)
		{
			addFirst(val);
			size++;
			return;
		}
		
		tail.next = node;
		node.prev = tail;
		tail = node;
		size++;
	}
	public void sortedInsert (int val)
	{
			$Node node = new $Node (val);
			$Node temp = head;
			
			if (temp == null || temp.val>=val)
			{
				addFirst(val);
				return;
			}
			if (tail.val<=val)
			{
				addLast(val);
				return;
			}
			while (temp.next != null && temp.next.val<val)
			{
				int v = temp.next.val;
				temp = temp.next;
			}
			temp.next.prev = node;
			node.prev = temp;
			node.next = temp.next;
			temp.next = node;
			size++;
	}
	public void removeFirst ()
	{
		if (size==0)
			throw new IllegalStateException ("EmptyListExecption");
		head = head.next;
		head.prev = null;
		size--;
	}
	public void removeLast ()
	{
		if (size==0)
			throw new IllegalStateException ("EmptyListExecption");
		tail = tail.prev;
		tail.next = null;
		size--;
	}
	public boolean removeByValue (int val)
	{
		if (size==0)
			throw new IllegalStateException ("EmptyListExecption");
		$Node temp = head;
		if (temp.val == val)
		{
			removeFirst ();
			return true;
		}
		while (temp != null)
		{
			if (temp.val == val)
			{
				temp.prev.next = temp.next;
				if (temp.next == null )
					tail = temp.prev;
				size--;
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	public void removeDuplicate () // given sorted list
	{
		$Node temp = head;
		 while (temp.next != null)
	     {
			 if (temp.val == temp.next.val)
	         {
				 if (temp.next == tail)
				 {
					 tail = temp;	        		 
				 }
	        	 else {
	        		 temp.next.next.prev = temp;	        		 
	        	 }
				 temp.next = temp.next.next;
				 size--;
	         }
	          else
	            temp = temp.next;
	      }
	}
	
	public void reverse ()
	{
		$Node curr = head;
		$Node temp = null;
		while (curr != null)
		{
			temp = curr.next;
			curr.next = curr.prev;
			curr.prev = temp;
			if (curr.prev == null)
			{
				tail = head;
				head = curr;
				return;
			}
			curr = curr.prev;
		}

	}
	
	public void display ()
	{
		$Node temp = head;
		while (temp != null)
		{
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
		System.out.println();
		
		
	}
	public static void main(String[] args) {
		DLL dl = new DLL ();
//		dl.addFirst(12);
//		dl.addFirst(31);
//		dl.addLast(50);
//		dl.addFirst(10);
//		dl.addLast(1000);
//		dl.addLast(2000);
//		dl.addLast(3000);
//		dl.addFirst(400);
		dl.sortedInsert(12);
		dl.sortedInsert(23);
		dl.sortedInsert(24);
		dl.sortedInsert(11);
		dl.sortedInsert(29);
		dl.sortedInsert(25);
		dl.sortedInsert(24);
		dl.sortedInsert(11);
		dl.sortedInsert(23);
//		dl.removeFirst();
//		dl.removeLast();
//		dl.removeByValue(2000);
//		System.out.println("Tail Value "+dl.tail.val+" -->"+dl.tail);
//		dl.removeDuplicate();
		dl.removeByValue(24);
//		dl.display();
//		dl.reverse(); 
		System.out.println(dl.size);
		dl.display();
	}
}
