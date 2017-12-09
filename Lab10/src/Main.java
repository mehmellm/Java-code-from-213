
/**
 * A class that provides the main entry point into the application.
 * Constructs the graph and defines the test cases to test the student
 * generated code.
 * 
 * @author Benjamin Rood
 * Copyright (C) 2017 Canisius College of Buffalo
 */
public class Main 
{
	public static void main( String[] args )
	{
		Graph<String> 		  graph        = new UnweightedNonDirectionalGraph<String>();
		Visitor<Node<String>> graphVisitor = new Visitor<Node<String>>()
		{
			@Override
			public void visit( Node<String> element ) 
			{
				System.out.println( "Processing: " + element.getElement() );	
			}
		};
		
		Node<String> bos = new Node<String>();
		Node<String> jfk = new Node<String>();
		Node<String> pvd = new Node<String>();
		Node<String> bwi = new Node<String>();
		Node<String> mia = new Node<String>();
		Node<String> ord = new Node<String>();
		Node<String> dfw = new Node<String>();
		Node<String> lax = new Node<String>();
		Node<String> sfo = new Node<String>();
		
		bos.setElement( "Boston" );
		jfk.setElement( "New York City" );
		pvd.setElement( "Providence" );
		bwi.setElement( "Baltimore" );
		mia.setElement( "Miami" );
		ord.setElement( "Orlando" );
		dfw.setElement( "Dallas" );
		lax.setElement( "Los Angeles" );
		sfo.setElement( "San Francisco" );
		
		graph.addNode( bos );
		graph.addNode( jfk );
		graph.addNode( pvd );
		graph.addNode( bwi );
		graph.addNode( mia );
		graph.addNode( ord );
		graph.addNode( dfw );
		graph.addNode( lax );
		graph.addNode( sfo );
		
		// Boston <-> San Francisco
		graph.addEdge( new Edge<Node<String>>( bos, sfo ) );
		graph.addEdge( new Edge<Node<String>>( sfo, bos ) );
		
		// Boston <-> Orlando
		graph.addEdge( new Edge<Node<String>>( bos, ord ) );
		graph.addEdge( new Edge<Node<String>>( ord, bos ) );
		
		// Boston <-> JFK
		graph.addEdge( new Edge<Node<String>>( bos, jfk ) );
		graph.addEdge( new Edge<Node<String>>( jfk, bos ) );
		
		// Boston <-> Miami
		graph.addEdge( new Edge<Node<String>>( bos, mia ) );
		graph.addEdge( new Edge<Node<String>>( mia, bos ) );
	
		// Providence <-> Orlando
		graph.addEdge( new Edge<Node<String>>( pvd, ord ) );
		graph.addEdge( new Edge<Node<String>>( ord, pvd ) );
		
		// Providence <-> New York City
		graph.addEdge( new Edge<Node<String>>( pvd, jfk ) );
		graph.addEdge( new Edge<Node<String>>( jfk, pvd ) );
		
		// New York City <-> Orlando
		graph.addEdge( new Edge<Node<String>>( jfk, ord ) );
		graph.addEdge( new Edge<Node<String>>( ord, jfk ) );
		
		// New York City <-> Miami
		graph.addEdge( new Edge<Node<String>>( jfk, mia ) );
		graph.addEdge( new Edge<Node<String>>( mia, jfk ) );
		
		// New York City <-> Dallas
		graph.addEdge( new Edge<Node<String>>( jfk, dfw ) );
		graph.addEdge( new Edge<Node<String>>( dfw, jfk ) );
		
		// New York City <-> Baltimore
		graph.addEdge( new Edge<Node<String>>( jfk, bwi ) );
		graph.addEdge( new Edge<Node<String>>( bwi, jfk ) );
		
		// Baltimore <-> Orlando
		graph.addEdge( new Edge<Node<String>>( bwi, ord ) );
		graph.addEdge( new Edge<Node<String>>( ord, bwi ) );
		
		// Baltimore <-> Miami
		graph.addEdge( new Edge<Node<String>>( bwi, mia ) );
		graph.addEdge( new Edge<Node<String>>( mia, bwi ) );
		
		// Orlando <-> San Francisco
		graph.addEdge( new Edge<Node<String>>( ord, sfo ) );
		graph.addEdge( new Edge<Node<String>>( sfo, ord ) );
		
		// Orlando <-> Dallas
		graph.addEdge( new Edge<Node<String>>( ord, dfw ) );
		graph.addEdge( new Edge<Node<String>>( dfw, ord ) );
		
		// San Francisco <-> Dallas
		graph.addEdge( new Edge<Node<String>>( sfo, dfw ) );
		graph.addEdge( new Edge<Node<String>>( dfw, sfo ) );
		
		// San Francisco <-> Los Angeles
		graph.addEdge( new Edge<Node<String>>( sfo, lax ) );
		graph.addEdge( new Edge<Node<String>>( lax, sfo ) );
		
		// Los Angeles <-> Dallas
		graph.addEdge( new Edge<Node<String>>( lax, dfw ) );
		graph.addEdge( new Edge<Node<String>>( dfw, lax ) );
		
		// Los Angeles <-> Miami
		graph.addEdge( new Edge<Node<String>>( lax, mia ) );
		graph.addEdge( new Edge<Node<String>>( mia, lax ) );
		
		// Dallas <-> Miami
		graph.addEdge( new Edge<Node<String>>( dfw, mia ) );
		graph.addEdge( new Edge<Node<String>>( mia, dfw ) );
		
		// Test for exception on addNode( null )
		try
		{
			graph.addNode( null );
			System.out.println( "[FAILED]: Testing addNode() with null parameter - IllegalArgumentException NOT thrown" );
			System.exit( 1 );
		}
		catch( IllegalArgumentException iae )
		{
			System.out.println( "[PASSED]: Testing addNode() with null parameter - IllegalArgumentException thrown" );
		}
		catch( Exception e )
		{
			System.out.println( "[FAILED]: Testing addNode() with null parameter - IllegalArgumentException NOT thrown (incorrect exception type)" );
			System.exit( 1 );
		}
		
		// Test for exception on addNode( node already in graph )
		try
		{
			graph.addNode( bos );
			System.out.println( "[FAILED]: Testing addNode() with node already in graph - IllegalArgumentException NOT thrown" );
			System.exit( 1 );
		}
		catch( IllegalArgumentException iae )
		{
			System.out.println( "[PASSED]: Testing addNode() with node already in graph - IllegalArgumentException thrown" );
		}
		catch( Exception e )
		{
			System.out.println( "[FAILED]: Testing addNode() with node already in graph - IllegalArgumentException NOT thrown (incorrect exception type)" );
			System.exit( 1 );
		}
		
		// Test for exception on addEdge( null )
		try
		{
			graph.addEdge( null );
			System.out.println( "[FAILED]: Testing addEdge() with null parameter - IllegalArgumentException NOT thrown" );
			System.exit( 1 );
		}
		catch( IllegalArgumentException iae )
		{
			System.out.println( "[PASSED]: Testing addEdge() with null parameter - IllegalArgumentException thrown" );
		}
		catch( Exception e )
		{
			System.out.println( "[FAILED]: Testing addEdge() with null parameter - IllegalArgumentException NOT thrown (incorrect exception type)" );
			System.exit( 1 );
		}
		
		// Test for exception on addEdge( edge that references node that isn't in the graph )
		Node<String> testNode = new Node<String>();
		testNode.setElement( "Test" );
		try
		{
			graph.addEdge( new Edge<Node<String>>( testNode, bwi ) );
			System.out.println( "[FAILED]: Testing addEdge() with edge that contains node not in graph parameter - IllegalArgumentException NOT thrown" );
			System.exit( 1 );
		}
		catch( IllegalArgumentException iae )
		{
			System.out.println( "[PASSED]: Testing addEdge() with edge that contains node not in graph parameter - IllegalArgumentException thrown" );
		}
		catch( Exception e )
		{
			System.out.println( "[FAILED]: Testing addEdge() with edge that contains node not in graph parameter - IllegalArgumentException NOT thrown (incorrect exception type)" );
			System.exit( 1 );
		}
		
		try
		{
			graph.addEdge( new Edge<Node<String>>( bwi, testNode ) );
			System.out.println( "[FAILED]: Testing addEdge() with edge that contains node not in graph parameter - IllegalArgumentException NOT thrown" );
			System.exit( 1 );
		}
		catch( IllegalArgumentException iae )
		{
			System.out.println( "[PASSED]: Testing addEdge() with edge that contains node not in graph parameter - IllegalArgumentException thrown" );
		}
		catch( Exception e )
		{
			System.out.println( "[FAILED]: Testing addEdge() with edge that contains node not in graph parameter - IllegalArgumentException NOT thrown (incorrect exception type)" );
			System.exit( 1 );
		}
		
		// Test for exception on depthFirstSearch( null, Visitor )
		try
		{
			graph.depthFirstSearch( null, graphVisitor );
			System.out.println( "[FAILED]: Testing depthFirstSearch() with null starting node parameter - IllegalArgumentException NOT thrown" );
			System.exit( 1 );
		}
		catch( IllegalArgumentException iae )
		{
			System.out.println( "[PASSED]: Testing depthFirstSearch() with null starting node parameter - IllegalArgumentException thrown" );
		}
		catch( Exception e )
		{
			System.out.println( "[FAILED]: Testing depthFirstSearch() with null starting node parameter parameter - IllegalArgumentException NOT thrown (incorrect exception type)" );
			System.exit( 1 );
		}
		
		// Test for exception on depthFirstSearch( node not in graph, Visitor )
		try
		{
			graph.depthFirstSearch( testNode, graphVisitor );
			System.out.println( "[FAILED]: Testing depthFirstSearch() with node not in graph parameter - IllegalArgumentException NOT thrown" );
			System.exit( 1 );
		}
		catch( IllegalArgumentException iae )
		{
			System.out.println( "[PASSED]: Testing depthFirstSearch() with node not in graph parameter - IllegalArgumentException thrown" );
		}
		catch( Exception e )
		{
			System.out.println( "[FAILED]: Testing depthFirstSearch() with node not in graph parameter - IllegalArgumentException NOT thrown (incorrect exception type)" );
			System.exit( 1 );
		}
		
		// Test for exception on depthFirstSearch( node, null )
		try
		{
			graph.depthFirstSearch( bos, null );
			System.out.println( "[FAILED]: Testing depthFirstSearch() with null visitor parameter - IllegalArgumentException NOT thrown" );
			System.exit( 1 );
		}
		catch( IllegalArgumentException iae )
		{
			System.out.println( "[PASSED]: Testing depthFirstSearch() with null visitor parameter - IllegalArgumentException thrown" );
		}
		catch( Exception e )
		{
			System.out.println( "[FAILED]: Testing depthFirstSearch() with null visitor parameter - IllegalArgumentException NOT thrown (incorrect exception type)" );
			System.exit( 1 );
		}
		
		//////////////////////////
		//////////////////////////
		
		// Test for exception on breadthFirstSearch( null, Visitor )
		try
		{
			graph.breadthFirstSearch( null, graphVisitor );
			System.out.println( "[FAILED]: Testing breadthFirstSearch() with null starting node parameter - IllegalArgumentException NOT thrown" );
			System.exit( 1 );
		}
		catch( IllegalArgumentException iae )
		{
			System.out.println( "[PASSED]: Testing breadthFirstSearch() with null starting node parameter - IllegalArgumentException thrown" );
		}
		catch( Exception e )
		{
			System.out.println( "[FAILED]: Testing breadthFirstSearch() with null starting node parameter parameter - IllegalArgumentException NOT thrown (incorrect exception type)" );
			System.exit( 1 );
		}
		
		// Test for exception on breadthFirstSearch( node not in graph, Visitor )
		try
		{
			graph.breadthFirstSearch( testNode, graphVisitor );
			System.out.println( "[FAILED]: Testing breadthFirstSearch() with node not in graph parameter - IllegalArgumentException NOT thrown" );
			System.exit( 1 );
		}
		catch( IllegalArgumentException iae )
		{
			System.out.println( "[PASSED]: Testing breadthFirstSearch() with node not in graph parameter - IllegalArgumentException thrown" );
		}
		catch( Exception e )
		{
			System.out.println( "[FAILED]: Testing breadthFirstSearch() with node not in graph parameter - IllegalArgumentException NOT thrown (incorrect exception type)" );
			System.exit( 1 );
		}
		
		// Test for exception on breadthFirstSearch( node, null )
		try
		{
			graph.breadthFirstSearch( bos, null );
			System.out.println( "[FAILED]: Testing breadthFirstSearch() with null visitor parameter - IllegalArgumentException NOT thrown" );
			System.exit( 1 );
		}
		catch( IllegalArgumentException iae )
		{
			System.out.println( "[PASSED]: Testing breadthFirstSearch() with null visitor parameter - IllegalArgumentException thrown" );
		}
		catch( Exception e )
		{
			System.out.println( "[FAILED]: Testing breadthFirstSearch() with null visitor parameter - IllegalArgumentException NOT thrown (incorrect exception type)" );
			System.exit( 1 );
		}
		
		System.out.println();
		System.out.println( "Performing depth-first search starting at Boston:" );
		graph.depthFirstSearch( bos, graphVisitor );
		
		// Reset 'isVisited' property on Nodes to make subsequent DFS work
		bos.setIsVisited( false );
		pvd.setIsVisited( false );
		jfk.setIsVisited( false );
		bwi.setIsVisited( false );
		mia.setIsVisited( false );
		ord.setIsVisited( false );
		sfo.setIsVisited( false );
		lax.setIsVisited( false );
		dfw.setIsVisited( false );
		
		System.out.println();
		System.out.println( "Performing breadth-first search starting at Boston: " );
		graph.breadthFirstSearch( bos, graphVisitor );
		System.out.println();
		System.out.println( "Performing depth-first search starting at Dallas:" );
		graph.depthFirstSearch( dfw, graphVisitor );
		System.out.println();
		System.out.println( "Performing breadth-first search starting at Dallas: " );
		graph.breadthFirstSearch( dfw, graphVisitor );
		System.out.println();
	}
}
