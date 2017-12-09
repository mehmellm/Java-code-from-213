
/**
 * An class that represents an item in a linked data structure, to which any type may be mapped.
 * 
 * @author Benjamin Rood
 * Copyright (C) 2017 Canisius College of Buffalo
 */
public class Node<E>
{
	
	/** The element to associate (or store) with the {@link Node}. */
	private E element;
	
	/** A flag that indicates if this {@link Node} has been visited. */
	private boolean isVisited;
	
	/**
	 * Creates a new empty and unlinked {@link Node}.
	 */
	public Node()
	{
		this.element   = null;
		this.isVisited = false;
	}
	
	/**
	 * Retrieves the element that is associated with this {@link Node}.
	 * 
	 * @return The element that is associated with this {@link Node}, or <tt>null</tt> if no element is associated.
	 */
	public E getElement()
	{
		return element;
	}
	
	/**
	 * Sets the element that is associated with this {@link Node}.
	 * 
	 * @param element The element to associate with this {@link Node}.
	 */
	public void setElement( E element )
	{
		this.element = element;
	}
	
	/**
	 * Returns <tt>true</tt> if this node has been visited, <tt>false</tt> otherwise.
	 * 
	 * @return <tt>True</tt> if this node has been visited, <tt>false</tt> otherwise.
	 */
	public boolean isVisited()
	{
		return isVisited;
	}
	
	/**
	 * Sets the 'isVisited' flag to the input parameter.
	 * 
	 * @param isVisited Set to <tt>true</tt> to indicate that this {@link Node} has been visited,
	 * 					<tt>false</tt> otherwise.
	 */
	public void setIsVisited( boolean isVisited )
	{
		this.isVisited = isVisited;
	}
}
