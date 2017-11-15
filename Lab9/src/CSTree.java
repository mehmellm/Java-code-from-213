import java.io.PrintWriter;
import java.util.Comparator;
import java.util.LinkedList;
/*
 * Author: Lucas Mehmel
 * 
 */

public class CSTree<T>
{
	int count = 0 ;
	//CSTreeNode<T> newnode; 
	private CSTreeNode<T> root = new CSTreeNode<T>();
	//CSTreeNode<T> node;
	private Comparator<T> comparator;
    public CSTree( Comparator<T> comparator )
    {
        this.comparator = comparator;
    }
    private CSTreeNode<T> insertNode(CSTreeNode<T> node, T value)
    {
    	if  (node == null )
    	{
    		node = new CSTreeNode<T>();
    		//newnode.setParent(null);
    		//newnode.setRoot(true);
    		node.setValue(value);
    		
    	}
    	else
    	{
    		int num = comparator.compare(value, node.getValue());
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
    	if (root.getValue() == null)
    	{
    		root.setValue(value);
    		root.setRoot(true);
    	}
    	else
    	{
    		insertNode(root, value); 
    	}
    	count = count + 1;
    
    }
    
    public void remove( T value )
    {
        // TODO: remove the value from the tree - this is tricky! (AND OPTIONAL - 20 points if you complete it!)
    }
    
    public boolean contains( T value )
    {
        // TODO: determine if the value is contained within the tree - note this requires a traversal!
    	CSTreeNode<T> found = new CSTreeNode<T>(); 
    	found = findNode(root, value);
    	if (!found.getValue().equals(null))
    	{
    		return true;
    	}
    	
    	return false;
    	
    }
    private CSTreeNode<T> findNode(CSTreeNode<T> node, T value)
    {
    	if (node.getValue().equals(null))
    	{
    		return null;
    	}
    	int num = comparator.compare(value, node.getValue());
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
    		return findNode(node.getRightChild(), value);
    	}
    }
    public int size()
    {
        // TODO: return the number of data items stored in the tree
    	if ( root == null)
    	{
    		return 0;
    	}
    	return count;
    	
    }
    
    public void traverseInorder( PrintWriter pw )
    {
        // TODO: perform in-order traversal
    	inorderTraverse (root, pw);
    }
    private void inorderTraverse(CSTreeNode<T> node, PrintWriter pw)
    {
    	if (node != null)
    	{
    		inorderTraverse(node.getLeftChild(), pw);
    		pw.println("Node: " + node.getValue() );
    		pw.flush();
    		inorderTraverse( node.getRightChild(), pw);
    	}
    }
    
    public void traversePreorder( PrintWriter pw )
    {
        // TODO: perform pre-order traversal
    	preorderTraverse (root, pw);
    }
    private void preorderTraverse(CSTreeNode<T> node, PrintWriter pw)
    {
    	if (node != null)
    	{
    		pw.println("Node: " + node.getValue() );
    		pw.flush();
    		inorderTraverse(node.getLeftChild(), pw);
    		inorderTraverse( node.getRightChild(), pw);
    	}
    }
    public void traversePostOrder( PrintWriter pw )
    {
        // TODO: perform post-order traversal
    	postorderTraverse( root, pw);
    }
    private void postorderTraverse(CSTreeNode<T> node, PrintWriter pw)
    {
    	if (node != null)
    	{
    		inorderTraverse(node.getLeftChild(), pw);
    		inorderTraverse( node.getRightChild(), pw);
    		pw.println("Node: " + node.getValue() );
    		pw.flush();
    	}
    }
}
