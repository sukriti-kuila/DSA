package stack;

public class stack_array_memory {
	private int [] data;
	private int capacity;
	private int minCapacity;
	private int top = -1;
	public stack_array_memory (int size)
	{
		this.data = new int [size];
		capacity = minCapacity = size;
	}
	public stack_array_memory ()
	{
		this (4);
	}
	public void push (int val)
	{
		int val1 = size(); 
		if (size() == capacity)
		{
			System.out.println("Size Doubled");
			int [] newData = new int [capacity*2];
			System.arraycopy(data, 0, newData, 0, capacity);
			data = newData;
			capacity *= 2;
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
		int val = data [top];
		top--;
		if (capacity/2 == size () && capacity > minCapacity)
		{
			System.out.println("Size halved");
			capacity /= 2;
			int [] newData = new int [capacity];
			System.arraycopy(data,0,newData,0,capacity);
			data = newData;
		}
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
	public boolean isEmpty()
	{
		return top == -1;
	}
	public static void main(String[] args) {
		stack_array_memory s = new stack_array_memory ();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		s.print();
		System.out.println("Pop = "+s.pop());
		System.out.println("Pop = "+s.pop());
		s.print();
		
		

	}

}
