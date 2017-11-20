
/**
 * An interface that defines the basic functionality in a graph data structure.
 * 
 * @author Benjamin Rood
 * Copyright (C) 2017 Canisius College of Buffalo
 */
public interface Graph<E> 
{
	/**
	 * Adds the input {@link Node} to the graph.
	 * 
	 * @param node The {@link Node} to add to the graph.
	 * 
	 * @throws IllegalArgumentException if the input <tt>node</tt> instance is <tt>null</tt>
	 * 									or the input <tt>node</tt> instance already exists in
	 * 									the graph
	 */
	public void addNode( Node<E> node );
	
	/**
	 * Adds the input {@link Edge} to the graph.
	 * 
	 * @param edge The {@link Edge} to add to the graph.
	 * 
	 * @throws IllegalArgumentException if the input <tt>edge</tt> is <tt>null</tt> or
	 * 									if the input <tt>edge</tt> references a {@link Node} that is
	 * 									not in the graph
	 */
	public void addEdge( Edge<Node<E>> edge );
	
	/**
	 * Performs a depth-first search traversal of all the nodes in the graph.
	 * 
	 * @param start The {@link Node} to begin the search at
	 * @param visitor The {@link Visitor} to use to process each visited {@link Node}
	 * 
	 * @throws IllegalArgumentException if the <tt>start</tt> parameter is <tt>null</tt>,
	 * 									if the <tt>start</tt> parameter is not contained within
	 * 									the graph, or if the <tt>visitor</tt> parameter is <tt>null</tt>
	 */
	public void depthFirstSearch( Node<E> start, Visitor<Node<E>> visitor );
	
	/**
	 * Performs a breadth-first search traversal of all the nodes in the graph.
	 * 
	 * @param start The {@link Node} to begin the search at
	 * @param visitor The {@link Visitor} to use to process each visited {@link Node}
	 * 
	 * @throws IllegalArgumentException if the <tt>start</tt> parameter is <tt>null</tt>,
	 * 									if the <tt>start</tt> parameter is not contained within
	 * 									the graph, or if the <tt>visitor</tt> parameter is <tt>null</tt>
	 */
	public void breadthFirstSearch( Node<E> start, Visitor<Node<E>> visitor );
}
