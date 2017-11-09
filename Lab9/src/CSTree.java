import java.io.PrintWriter;

import java.util.Comparator;

public class CSTree<T>
{
	CSTreeNode<T >node;
	Comparator<T> comparator;
    public CSTree( Comparator<T> comparator )
    {
        comparator = comparator;
    }
    private CSTreeNode<T> insertNode(CSTreeNode<T> node, T value)
    {
    	if  (node == null )
    	{
    		node = new CSTreeNode<T>();
    		node.setValue(value);
    		node.setLeftChild(null);
    		node.setRightChild(null);
    		return null;
    	}
    	else
    	{
    		int num = comparator.compare(value,node.getValue());
    		if ( num == 0)
    		{
    			return null;
    		}
    		else if(num < 0)
    		{
    			node.setLeftChild(insertNode(node.getLeftChild(), value));
    		}
    		else 
    		{
    			node.setRightChild(insertNode(node.getRightChild(), value));
    		}
    	}
    	return node;
    }
    public void add( T value )
    {
        // TODO: add the value to the tree
    	
    	insertNode(node, value); 
    
    }
    
    public void remove( T value )
    {
        // TODO: remove the value from the tree - this is tricky! (AND OPTIONAL - 20 points if you complete it!)
    }
    
    public boolean contains( T value )
    {
        // TODO: determine if the value is contained within the tree - note this requires a traversal!
    	node = findNode( node, value);
    	if (node == null)
    	{
    		return false;
    	}
    	else {
    	return true;
    	}
    }
    private CSTreeNode<T> findNode( CSTreeNode<T> node, T value)
    {
    	if (node == null)
    	{
    		return null;
    	}
    	int num = comparator.compare(node.getValue(), value);
    	if (num == 0)
    	{
    		return node;
    	}
    	if (num < 0)
    	{
    		return findNode(node.getLeftChild(), value);
    	}
    	else
    	{
    		return findNode(node.getRightChild(),value);
    	}
    }
    public int size()
    {
        // TODO: return the number of data items stored in the tree
        return 0;
    }
    
    public void traverseInorder( PrintWriter pw )
    {
        // TODO: perform in-order traversal
    }
    
    public void traversePreorder( PrintWriter pw )
    {
        // TODO: perform pre-order traversal
    }
    
    public void traversePostOrder( PrintWriter pw )
    {
        // TODO: perform post-order traversal
    }
}
