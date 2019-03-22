public class ArrayQueue<Item> implements Queue<Item> 
{
	public Item[] arr;
	public int head;
	public int tail;
	
	public ArrayQueue() 
	{
		arr = (Item[]) new Object[10];
		head = 0;
		tail = 0;
	}
	
	@Override
	public Item dequeue() //remove
	{
		if (empty()) 
		{
			return null;
		}
		Item item = arr[head];
		head = (head + 1) % arr.length;
		
		if (head == arr.length)
		{
			head = 0;
		}
		return item;
	}

	@Override
	public void enqueue(Item item) //add
	{
		if ((tail + 1)% arr.length == head) 
		{
			grow_queue();
		}
		arr[tail] = item;
		tail = (tail + 1) % arr.length;
		
		if (tail == arr.length) 
		{
			tail = 0;
		}	
	}
	
	protected void grow_queue() 
	{
		Item[] newArr = (Item[]) new Object[arr.length * 2];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		arr = newArr;
	}
	
	@Override
	public boolean empty() //checks for empty arry
	{
		if (head == tail) 
		{
			head = tail = 0;
			return true;
		}
		return false;
	}
}