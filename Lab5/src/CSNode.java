

public class CSNode<T>
{
	private CSNode next;
	private CSNode prev;
	private T data;
	
	public CSNode()
	{
		this.next = null;
		this.prev = null;
		this.data = null;
	}
	
	public CSNode(CSNode prev, CSNode next, T data )
	{
		this.prev = prev;
		this.next = next;
		this.data = data;
		
	}
	
	
	
	public CSNode getNext()
	{
		return next;
	}
	
	public void setNext(CSNode next)
	{
		this.next = next;
	}
	
	public CSNode getPrev()
	{
		return prev;
	}
	
	public void setPrev(CSNode prev)
	{
		this.prev = prev;
	}
	
	public T getElements()
	{
		return data;
	}
	
	public void setElements(T data)
	{
		this.data = data;
	}
}