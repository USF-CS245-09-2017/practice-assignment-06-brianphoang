
public class ArrayStack<Item> implements Stack<Item> 
{
	public int top;
	public Item[] arr;
	
	public ArrayStack() 
	{
		arr = (Item[]) new Object[10];
		top = 0;
	}
	
	@Override
	public void push(Item item) //add
	{
		// check not greater than arr.length
		if (top == arr.length) 
		{
			grow_stack();
		}
		arr[top++] = item;
	}
	
	protected void grow_stack() //increase array if full
	{
		Item[] newArr = (Item[]) new Object[arr.length * 2];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		arr = newArr;
	}

	@Override
	public Item pop() //remove
	{
		if (!empty()) 
		{
			return arr[--top];
		}
		return null;
	}

	@Override
	public Item peek() //get
	{
		if (!empty()) 
		{
			return arr[top-1];
		}
		return null;
	}

	@Override
	public boolean empty() //checks for empty arry
	{
		if (top == 0) 
		{
			return true;
		}
		return false;
	}
}