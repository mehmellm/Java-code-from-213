/*
 * Author: Lucas Mehmel
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class UnweightedNonDirectionalGraph<E> implements Graph<E>
{
	Set<Node<E>> nodeSet;
	Set<Edge<Node<E>>> edgeSet;
	public UnweightedNonDirectionalGraph()
	{
		nodeSet = new HashSet<Node<E>>();
		edgeSet = new HashSet<Edge<Node<E>>>();
	}
	
	@Override
	public void addNode( Node<E> node ) throws IllegalArgumentException
	{
		if (node == null)
		{
			throw new IllegalArgumentException("Node can't be null");
			
		}
		else if ( nodeSet.contains(node))
		{
			throw new IllegalArgumentException("Can't have duplicate nodes in graph");
		}
		else
		{
			nodeSet.add(node);
		}
	}

	@Override
	public void addEdge( Edge<Node<E>> edge ) throws IllegalArgumentException
	{
		if (edge == null)
		{
			throw new IllegalArgumentException("edge can't be null");
		}
		else if (edgeSet.contains(edge))
		{
			throw new IllegalArgumentException("Can't have duplicate edges in graph");           
		}
		else if ( !nodeSet.contains(edge.getStart()) || !nodeSet.contains(edge.getFinish()))
		{
			throw new IllegalArgumentException("Edge must reference nodes in the graph"); 
		}
		else
		{
			edgeSet.add(edge);
		}
	}
	
	public ArrayList<Edge<Node<E>>> getAdjacentEdges (Node<E> node)
	{
		ArrayList<Edge<Node<E>>> adj = new ArrayList<Edge<Node<E>>>();
		for (Edge<Node<E>> edge : edgeSet)
		{
			if (edge.getStart().equals(node) || edge.getStart().equals(node))
			{
				adj.add(edge);
			}
		}
		return adj;
		
	}

	@Override
	public void depthFirstSearch( Node<E> start, Visitor<Node<E>> visitor ) throws IllegalArgumentException
	{
		if (!nodeSet.contains(start))
		{
			throw new IllegalArgumentException("Starting node must be in graph");
		}
		else if (start == null || visitor == null)
		{
			throw new IllegalArgumentException("neither start node or vistor node can equal null");
		}
		else
		{
			visitor.visit(start);
			start.setIsVisited(true);
			for (Edge<Node<E>> eeg: getAdjacentEdges(start))
			{
				Node<E> bor = null;
				if (eeg.getStart().equals(start))
				{
					bor = eeg.getFinish();
				}
				else
				{
					bor = eeg.getStart();
				}
				if (!bor.isVisited())
				{
					depthFirstSearch(bor, visitor);
				}
			}
		}
		
	}

	@Override
	public void breadthFirstSearch( Node<E> start, Visitor<Node<E>> visitor ) throws IllegalArgumentException
	{
		Set<Node<E>> visited = new HashSet<Node<E>>();
		Queue<Node<E>> next = new LinkedList<Node<E>>();
		next.add(start);
		if (!nodeSet.contains(start))
		{
			throw new IllegalArgumentException("start must be inside graph");
		}
		else if(start == null || visitor == null)
		{
			throw new IllegalArgumentException("neither start node or vistor node can equal null");
		}
		else
		{
			while ( !next.isEmpty())
			{
				Node<E> x = next.remove();
				if (!visited.contains(x))
				{
					visitor.visit(x);
					visited.add(x);
					for (Edge<Node<E>> eeg : getAdjacentEdges(x))
					{
						if (eeg.getStart().equals(x))
						{
							next.add(eeg.getFinish());
						}
						else
						{
							next.add(eeg.getStart());
						}
					}
				}
			}
		}
	}
}
