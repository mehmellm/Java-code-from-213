
/**
 * An interface that defines an object that visits other objects.
 * 
 * @author Benjamin Rood
 * Copyright (C) 2017 Canisius College of Buffalo
 */
public interface Visitor<E> 
{
	/**
	 * Called when this instance is to visit another object.  All
	 * processing should be handled within this method.
	 * 
	 * @param element The object to visit.
	 */
	public void visit( E element );
}
