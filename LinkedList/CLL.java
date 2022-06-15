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
	 	}
	 	else {			
	 	node.next = head;	
	 	head = node;
	 	tail.next = head;		
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
	 	Node temp = getPrevNode (size);
	 	temp.next = node;
	 	tail = node;
	 	tail.next = head;
	 	size++;
	 }
	 
	 public void removeFirst ()
	 {
		 if (head == null)
			 throw new IllegalStateException ("EmptyListException");
		 head = head.next;
		 tail.next = head;
		 size--;
	 }
	 
	 public void removeLast ()
	 {
		 if (head == null)
			 throw new IllegalStateException ("EmptyListException");
		 Node temp = getPrevNode(size-1);
		 tail = temp;
		 tail.next = head;
		 size--;
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
	 
	 public CLL copyList () {
		 CLL cl = new CLL ();
		 Node curr = tail.next;
		 Node head = curr;
		 
		 if (curr != null)
		 {
			 cl.addLast(curr.val);
			 curr = curr.next;
		 }
		 while (curr != head)
		 {
			 cl.addLast(curr.val);
			 curr = curr.next;
		 }
		 return cl;
	 }
	 public void display ()
	 {
	 	Node temp = head;
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
	 	CLL newCl = new CLL ();
	 	cl.addFirst(2000);
	 	cl.addFirst(1000);
	 	cl.display();	
	 	newCl = cl.copyList();
	 	newCl.display();
	 }
 }

