package LinkedList;
public class CLL {
	 class Node {
	 	private int val;
	 	private Node next;
	 	private Node prev;
	 	Node (int val)
	 	{
	 		this.val = val;
	 	}
	 }
	 private static Node head;
	 private static Node tail;
	 private int size;
	 public void addFirst (int val)
	 {
	 	Node node = new Node (val);
	 	if (head == null)
	 	{
	 		head = node;
	 		tail=node;
	 		node.next = node;
	 	}
	 	else {		
	 	node.next = head;	
	 	head = node;
	 	tail.next = node;		
	 	}
	 	size++;
	 }
	 public void addLast (int val)
	 {
	 	Node node = new Node (val);
	 	if (head==null)
	 	{
	 		addFirst(val);
	 		return;
	 	}
	 	tail.next = node;
	 	tail = node;
	 	node.next = head;
	 	size++;
	 }
	 
	 public void removeFirst ()
	 {
		 if (head == null)
			 throw new IllegalStateException ("EmptyListException");
		 if (size==1)
		 {
			 deleteList ();
			 return;
		 }
		 head = head.next;
		 tail.next = head;
		 size--;
	 }
	 
	 public void removeLast ()
	 {
		 if (head == null)
			 throw new IllegalStateException ("EmptyListException");
		 if (size==1)
		 {
			 deleteList ();
			 return;
		 }
		 Node temp = getPrevNode(size-1);
		 tail = temp;
		 tail.next = head;
		 size--;
	 }
	 
	 public void deleteList ()
	 {
		 head = null;
		 tail = null;
		 size = 0;
	 }
	 public Node getPrevNode (int index)
	 {
	 	Node temp = head;
	 	for (int i=0; i<index-1; i++)
	 	{
	 		temp = temp.next;
	 	}
	 	return temp;
	 }
	 
	 public void display ()
	 {
	 	Node temp = head;
	 	if (temp == null)
	 	{
	 		System.out.println("List is Empty");
	 		return;
	 	}
	 	while (temp != tail)
	 	{
	 		System.out.print(temp.val+" ");
	 		temp = temp.next;
	 	}
	 	System.out.print(temp.val+"-->"+temp.next);
	 	System.out.println();
	 }
	 
	 public static void main(String[] args) {
	 	CLL cl = new CLL ();
	 	cl.addFirst(2000);
//	 	cl.addFirst(1000);
//	 	cl.addLast(4000);
//	 	cl.addLast(5000);
//	 	cl.addLast(5001);
//	 	cl.addLast(5002);
	 	cl.removeLast();
	 	cl.display();	
	 }
 }

