package stack;
/*create one array
declare deafult_size = 10 
int top = -1
create constructor (size) {this.array = new int [size]}
create another constructor ()
create boolean size () --> return size == array.len-1
create boolean isEmpty --> return top == -1
push ()
pop() 
print () reverse order **Important**
*/

public class stack_Array {
	protected int [] data;
	private final static int DEFAULT_SIZE = 10;
	private int top = -1; 
	public stack_Array (int size)
	{
		this.data = new int [size];
	}
	public stack_Array ()
	{
		this (DEFAULT_SIZE);
	}
	public void push (int val)
	{
		if (size() == data.length)
		{
			System.out.println("IndexOutOfBound Exception");
			return;
		}
		top++;
		data [top] = val;
	}
	public int pop ()
	{
		if (isEmpty())
		{
			throw new IllegalStateException ("Stack is Empty");
		}
		int val = data[top];
		top--;
		return val;
	}
	public void print ()
	{
		if (top==-1)
		{
			System.out.println("Stack is Empty");
			return;
		}
		for (int i=top; i>=0; i--)
		{
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
	public int size ()
	{
		return top+1;
	}
	public boolean isEmpty ()
	{
		return top==-1;
	}
	
	public static void main(String[] args) {
		stack_Array s = new stack_Array (4);
		s.push(10);
		s.push(12);
		s.print();
	}

}
