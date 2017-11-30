
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test suite to test the functionality of the {@link LinkedListImpl} class.
 * 
 * @author Benjamin Rood
 * Copyright (C) 2017 Canisius College of Buffalo
 */
public class LinkedListImplTest 
{
	/** The default number of elements to populate a list with. */
	private static final int DEFAULT_LIST_SIZE = 10;
	
	@Before
	public void setUp() 
	{
		// Put any code in here that needs to run before any of the test cases
	}

	@Test
	public void testSize()
	{
	    // TODO: implement the unit test for size()
		List<Integer> emptyList = generateEmptyList();
		List<Integer> populatedList = generatePopulatedList(10);
		
		assertNotNull(emptyList);
		assertNotNull(populatedList);
		
		assertEquals(0, emptyList.size());
		//assertEquals(0, populatedList.size());
		/**
		for ( int i = 0 ; i < Integer.MAX_VALUE +2; i++)
		{
			emptyList.add(i);
		}
		*/
	}
	
	@Test
	public void testIsEmpty()
	{
	    // TODO: implement the unit test for isEmpty()
		List<Integer> populatedList = generatePopulatedList(10);
		List<Integer> emptyList = generateEmptyList();
		
		assertNotNull(emptyList);
		assertNotNull(populatedList);
		
		assertTrue(emptyList.isEmpty());
		assertFalse(populatedList.isEmpty());
		
	}
	
	@Test
	public void testContains()
	{
	    // TODO: implement the unit test for contains()
		List<Integer> populatedList = generatePopulatedList(10);
		Integer num = 6;
		Integer num2 = 11;
		
		assertNotNull(populatedList);
		assertNotNull(num);
		assertNotNull(num2);
		
		assertTrue(populatedList.contains(num));
		assertFalse(populatedList.contains(num2));
		
	}
	
	@Test
	public void testAdd()
	{
		/* TODO: perform the following tasks for this test:
		 * 
		 * 1. Create either a populated or empty list instance.
		 * 2. Create an object to store in the list.  Retain the reference for future use.
		 * 3. Store the current size of the list.
		 * 4. Add the object to the list using the add( E item ) method.
		 * 4. Test if the list added the object by:
		 * 		4a. Testing if the size increased by a single increment
		 * 		4b. Testing if the object is now contained in the list
		 */
		List<Integer> list = generatePopulatedList(10);
		Integer number = 11;
		
		assertNotNull(list);
		assertNotNull(number);
		
		Integer listSize = list.size();
		
		assertEquals(new Integer(10), new Integer(listSize));
		
		assertTrue( list.add(number));
		assertEquals(11, list.size());
		assertEquals(10, list.indexOf(number));
		assertTrue(list.contains(number));
	}
	
	@Test
	public void testAddAtIndex()
	{
		/* TODO: perform the following tasks for this test:
		 * 
		 * 1. Create either a populated or empty list instance.
		 * 2. Create an object to store in the list.  Retain the reference for future use.
		 * 3. Store the current size of the list.
		 * 4. Add the object to the list at a specific location using the add( int index, E item ) method.
		 * 4. Test if the list added the object by:
		 * 		4a. Testing if the size increased by a single increment
		 * 		4b. Testing if the object is now contained in the list
		 * 5. Additionally, test if the add( int index, E item ) method throws the proper exceptions by:
		 * 		5a. Testing if the list throws an exception if a negative index is supplied
		 * 		5b. Testing if the list throws an exception if the index falls outside the bounds of
		 * 			valid indicies (0 <= index < size()).
		 */
		List<Integer> list = generatePopulatedList(10);
		
		assertNotNull(list);
		
		Integer size1 = list.size();
		assertEquals(10, (int)size1);
		list.add(0,4);
		
		assertEquals(11, list.size());
		assertTrue(list.contains(4));
		try
		{
			list.add(-1,10);
			fail("Exception not thrown");
		}
		catch(IndexOutOfBoundsException ioe)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void testRemove()
	{
		/* TODO: perform the following tasks for this test:
		 * 
		 * 1. Create either a populated or empty list instance.
		 * 2. Create an object to store in the list.  Retain the reference for future use.
		 * 3. Store the current size of the list.
		 * 4. Add the object to the list.
		 * 5. Test if the list added the object by:
		 * 		5a. Testing if the size increased by a single increment
		 * 		5b. Testing if the object is now contained in the list
		 * 6. Remove the object.
		 * 7. Test if the list removed the object by:
		 * 		7a. Testing if the size decreased by a single increment
		 * 		7b. Testing if the size of the list equals the original size before the element was added
		 * 		7c. Testing if the object is not contained within the list
		 */
		
		List<Integer> list = generatePopulatedList(10);
		Integer x = 40;
		
		assertNotNull(x);
		assertNotNull(list);
		
		Integer size1 = list.size();
		assertEquals(10, (int) size1);
		
		list.add(x);
		assertEquals(11, list.size());
		assertTrue(list.contains(x));
		
		list.remove(x);
		assertEquals(10, list.size());
		assertEquals((int)size1, list.size());
		assertFalse(list.contains(x));
		
		
	}
	
	/**
	 * Generates a {@link List} with no elements.
	 * 
	 * @return An empty {@link List}.
	 */
	private List<Integer> generateEmptyList()
	{
		return new LinkedListImpl<Integer>();
	}
	
	/**
	 * Generates a populated {@link List} instance with the given size.
	 * 
	 * @param size The number of elements to populate the list with.  Specify -1 or 0 to use the default size.
	 * 
	 * @return A populated {@link List} instance.
	 */
	private List<Integer> generatePopulatedList( int size )
	{
		LinkedListImpl<Integer> lli = new LinkedListImpl<Integer>();
		int						sz  = ((size == -1 || size == 0)? DEFAULT_LIST_SIZE : size);
		
		for ( int i = 0; i < sz; i++ )
		{
			lli.add( i + 1 );
		}
		
		return lli;
	}
}
