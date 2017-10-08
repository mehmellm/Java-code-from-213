import java.util.Comparator;

public class CSList<E> implements ICSList<E>
{
	
	private CSNode<E> head = new CSNode<E>();
	private CSNode<E> tail = new CSNode<E>();
	private CSNode<E> runner = new CSNode<E>();
	
	/**
     * Returns the number of elements in this list.  If this list contains
     * more than <tt>Integer.MAX_VALUE</tt> elements, returns
     * <tt>Integer.MAX_VALUE</tt>.
     *
     * @return the number of elements in this list
     */
	@Override
    public int size()
    {
    	int count = 0;
    	if (head.getNext() == null)
    	{
    		return 0;
    	}
    	runner = head.getNext();
    	while (runner != tail)
    	{
    		count = count + 1;
    		runner = runner.getNext();
    	}
    	return count;
    }

    /**
     * Returns <tt>true</tt> if this list contains no elements.
     *
     * @return <tt>true</tt> if this list contains no elements
     */
	@Override
    public boolean isEmpty()
	{
		if (head.getNext() == null)
		{
			return true;
		}
		return false;
	}
    /**
     * Returns <tt>true</tt> if this list contains the specified element.
     *
     * @param o element whose presence in this list is to be tested
     * 
     * @return <tt>true</tt> if this list contains the specified element
     */
	@Override
    public boolean contains( E o )
    {
		if (head.getNext() == null)
		{
			return false;
		}
		runner = head.getNext();
		while (runner != null )
		{
			if (runner.getElements() == o)
			{
				return true;
			}
			runner = runner.getNext();
		}
		return false;
		
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param e element to be appended to this list
     * 
     * @return <tt>true</tt> if the element was appended to this list
     */
	@Override
    public boolean add( E e )
    {
		CSNode<E> newNode = new CSNode<E>();
		newNode.setElements(e);
		
		if (head.getNext() == null)
		{
			head.setNext(newNode);
			tail.setPrev(newNode);
			newNode.setPrev(head);
			newNode.setNext(tail);
			return true;
		}
		runner = head.getNext();
		while (runner.getNext() != tail)
		{
			runner = runner.getNext();
		}
		runner.setNext(newNode);
		newNode.setPrev(runner);
		newNode.setNext(tail);
		tail.setPrev(newNode);
		
		return true;
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present.
     *
     * @param o element to be removed from this list, if present
     * 
     * @return <tt>true</tt> if this list contained the specified element
     */
	@Override
    public boolean remove( E o )
    {
		CSNode<E> newNode = new CSNode();
		
		
		if (head.getNext() == null)
		{
			return false;
		}

		if (head.getNext().getElements() == o)
		{
			head = head.getNext();
			head.setElements(null);
			head.setPrev(null);
			return true;
		}
		if (tail.getPrev().getElements() == o)
		{
			tail = tail.getPrev();
			tail.setElements(null);
			tail.setNext(null);
			return true;
			
		}
		runner = head.getNext();
		while (runner != tail)
		{
			if(runner.getElements() == o )
			{
				newNode = runner.getNext();
				newNode.setPrev(runner.getPrev());
				runner.getPrev().setNext(newNode);
				runner = null;
				return true;
			}
			runner = runner.getNext();
		}
		return false;
    }
    /**
     * Removes all of the elements from this list.  The list will be empty after this call returns.
     */
	@Override
    public void clear()
    {
		head.setNext(null);
		tail.setPrev(null);
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * 
     * @return the element at the specified position in this list
     * 
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
	@Override
    public E get( int index )
    {
		int in = index;
		int count = 0;
		if (in > size() || in < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		if (in == 0 )
		{
			return (E) head.getNext().getElements();
		}
		runner = head.getNext();
		while (runner != tail)
		{
			if (count == in)
			{
				return runner.getElements();
			}
			count = count + 1;
			runner = runner.getNext();
		}
		return null;
    }	

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * 
     * @return the element previously at the specified position
     * 
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
	@Override
    public E set( int index, E element )
    {
		int in = index;
		int count = 0;
		E data = null;
		
		if (in > size() || in < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		if (in == 0 )
		{
			data = (E) head.getNext().getElements();
			head.getNext().setElements(element);
			return data;
		}
		runner = head.getNext();
		while ( runner != tail )
		{
			if (count == in)
			{
				data = runner.getElements();
				runner.setElements(element);
				return data;
				
			}
			count = count + 1;
			runner = runner.getNext();
		}
		return null;
		
    }	

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent 
     * elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * 
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt; size()</tt>)
     */
	@Override
    public void add( int index, E element )
    {
		int count = 0;
		int in = index;
		CSNode<E> newNode = new CSNode<E>();
		newNode.setElements(element);
		CSNode<E> temp = new CSNode<E>();
		
		if (in > size() || in < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		if( in == 0)
		{
			temp = head.getNext();
			head.setNext(newNode);
			newNode.setNext(temp);
			newNode.setPrev(head);
		}
		runner = head.getNext();
		while (runner!= tail)
		{
			if (count == in)
			{
				temp = runner.getPrev();
				runner.getPrev().setNext(newNode);
				newNode.setPrev(temp);
				newNode.setNext(runner);
				runner.setPrev(newNode);
			}
			count = count + 1;
			runner = runner.getNext();
		}
    }
	

    /**
     * Removes the element at the specified position in this list.  Shifts any 
     * subsequent elements to the left (subtracts one from their indices).  Returns 
     * the element that was removed from the list.
     *
     * @param index the index of the element to be removed
     * 
     * @return the element previously at the specified position
     * 
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
	@Override
    public E remove( int index )
    {
		int in = index;
		CSNode<E> newNode = new CSNode<E>();
		E data = null;
		int count = 0;
		
		if (in > size() || in < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		if (in == 0 )
		{
			data = (E) head.getNext().getElements();
			head = head.getNext();
			head.setPrev(null);
			head.setElements(null);
			return data;
		}
		runner = head.getNext();
		while ( runner != tail )
		{
			if (count == in)
			{
				data = runner.getElements();
				newNode.setPrev(runner.getPrev());
				runner = runner.getNext();
				runner.setPrev(newNode.getPrev());
				return data;
				
			}
			count = count + 1;
			runner = runner.getNext();
		}
		return null;
		
    }	

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     *
     * @param o element to search for
     * 
     * @return the index of the first occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
	@Override
    public int indexOf( E o )
    {
		int in = 0;
		if (head.getNext().getElements() == o)
		{
			return 0;
		}
		runner = head.getNext();
		while (runner != tail)
		{
			if (runner.getElements() == o)
			{
				return in;
			}
			in = in + 1;
			runner = runner.getNext();
		}
		return -1;
    }
    
    /**
     * Sorts the elements in this instance in descending order according to the input
     * {@link Comparator}.
     * 
     * @param comparator The {@link Comparator} instance to use that defines the sorting
     *                   order of the elements.
     */
	@Override
    public void sort( Comparator<E> comparator )
    {
		CSNode<E> tempNode = new CSNode<E>();
		E el1 = null;
		E el2 = null;
		
		for (int n = 1;  n < size(); n++)
		{
			for (int m = n; m > 0; m--)
			{
				el1 = get(m);
				el2 = get(m-1);
				if (comparator.compare(el1, el2) == -1)
				{
					tempNode.setElements(el1);
					set(m,el2);
					set(m-1, tempNode.getElements());
				}
			}
		}
    }
    
}