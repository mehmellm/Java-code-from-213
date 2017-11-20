
/**
 * A class that represents an edge that links two {@link Node} instances in
 * a graph.
 * 
 * @author Benjamin Rood
 * Copyright (C) 2017 Canisius College of Buffalo
 */
public class Edge<E> 
{
	/** The first node in the {@link Edge} link. */
	private E startNode;
	
	/** The second node in the {@link Edge} link. */
	private E finishNode;
	
	/** The cost/weight associated with traversing this {@link Edge}. */
	private double cost;
	
	/**
	 * Creates a new {@link Edge} instance with a cost of 0.0.
	 * 
	 * @param start The first {@link Node} in the {@link Edge}
	 * @param finish The second {@link Node} in the {@link Edge}
	 */
	public Edge( E start, E finish )
	{
		this( start, finish, 0.0 );
	}
	
	/**
	 * Creates a new {@link Edge} instance with an associated
	 * cost of traversal.
	 * 
	 * @param start The first {@link Node} in the {@link Edge}
	 * @param finish The second {@link Node} in the {@link Edge}
	 * @param cost The cost of traversing the {@link Edge}
	 */
	public Edge( E start, E finish, double cost )
	{
		if ( start == null )
			throw new IllegalArgumentException( "The start parameter cannot be null" );
		
		if ( finish == null )
			throw new IllegalArgumentException( "The finish parameter cannot be null" );
		
		this.startNode  = start;
		this.finishNode = finish;
		this.cost       = 0.0;
	}
	
	/**
	 * Retrieves the first {@link Node} in the {@link Edge} link.
	 * 
	 * @return The first {@link Node} in the {@link Edge} link.
	 */
	public E getStart()
	{
		return startNode;
	}
	
	/**
	 * Retrieves the second {@link Node} in the {@link Edge} link.
	 * 
	 * @return The second {@link Node} in the {@link Edge} link.
	 */
	public E getFinish()
	{
		return finishNode;
	}
	
	/**
	 * Retrieves the cost of traversing this {@link Edge}.
	 * 
	 * @return The cost of traversing this {@link Edge}.
	 */
	public double getCost()
	{
		return cost;
	}
}
