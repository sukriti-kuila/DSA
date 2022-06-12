package LinkedList;

import java.util.Scanner;
class Node1 
{
	int data;
	Node1 link;
}

public class Reverse_139 {
	static Node1 start = null;
	static Node1 q = null;
		static void create ()
		{
			Scanner sc = new Scanner (System.in);
			char ch;
			do
			{
				Node1 p = new Node1();
				System.out.println("Enter Value");
				p.data=sc.nextInt();
				p.link=null;
				if (start==null)
				{
					start=p;
					q=p;
				}
				else 
				{
					q.link=p;
					q=p;
				}
				System.out.println("Press Y/y to continue");
				ch=sc.next().charAt(0);
			}while(ch=='Y'||ch=='y');
		}
		static void display ()
		{
			Node1 s = start;
			while (s!=null)
			{
				System.out.print (s.data);
				s=s.link;
				if (s!=null)
					System.out.print(",");
			}
			System.out.println();
		}
		static void reverse ()
		{
			Node1 curr = start;
			Node1 prev = null;
			Node1 next = null;
			while (curr!=null)
			{
				next = curr.link;
				curr.link = prev;
				prev = curr;
				curr = next;
			}
			start = prev;
		}
	public static void main(String[] args) {
		create();
		display();
		System.out.println("Reversed!");
		reverse();
		display();

	}

}
