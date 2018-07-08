package com.sangam.list;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyListImplTest {
	
	private MyList intList;
	private MyList stringList;
	
	@Before
	public void setup()
	{
		intList=new MyListImpl<Integer>();
		stringList=new MyListImpl<String>();
	}

	@Test
	public void testIsListEmpty() throws IllegalArgumentException, ListUnderFlowException
	{
		//Testing for int
		assertEquals(true, intList.isListEmpty());
		intList.insert(1);
		assertEquals(false, intList.isListEmpty());
		intList.remove(0);
		assertEquals(true, intList.isListEmpty());
		//Testing for String
		assertEquals(true, stringList.isListEmpty());
		stringList.insert("a");
		assertEquals(false, stringList.isListEmpty());
		stringList.remove(0);
		assertEquals(true, stringList.isListEmpty());
	}
	
	@Test
	public void testGetSize() throws IllegalArgumentException, ListUnderFlowException
	{
	//Testing for int	
	assertEquals(0, intList.getSize());
	intList.insert(1);
	assertEquals(1, intList.getSize());
	intList.insert(-1);
	assertEquals(2, intList.getSize());
	intList.remove(0);
	assertEquals(1, intList.getSize());
	//Testing for String
	assertEquals(0, stringList.getSize());
	stringList.insert("a");
	assertEquals(1, stringList.getSize());
	stringList.insert("b");
	assertEquals(2, stringList.getSize());
	stringList.remove(0);
	assertEquals(1, stringList.getSize());
	}
	
	
	@Test
	public void testBasicInsert() {
	//Testing for int
	assertEquals("[]",intList.traverse());
	intList.insert(1);
	assertEquals("[1]",intList.traverse());
	intList.insert(2);
	assertEquals("[1,2]",intList.traverse());
	intList.insert(3);
	assertEquals("[1,2,3]",intList.traverse());
	intList.insert(4);
	assertEquals("[1,2,3,4]",intList.traverse());
	intList.insert(5);
	assertEquals("[1,2,3,4,5]",intList.traverse());
	intList.insert(6);
	assertEquals("[1,2,3,4,5,6]",intList.traverse());
	
	//Testing for String
	assertEquals("[]",stringList.traverse());
	stringList.insert("a");
	assertEquals("[a]",stringList.traverse());
	stringList.insert("b");
	assertEquals("[a,b]",stringList.traverse());
	stringList.insert("c");
	assertEquals("[a,b,c]",stringList.traverse());
	stringList.insert("d");
	assertEquals("[a,b,c,d]",stringList.traverse());
	stringList.insert("e");
	assertEquals("[a,b,c,d,e]",stringList.traverse());
	stringList.insert("f");
	assertEquals("[a,b,c,d,e,f]",stringList.traverse());
	}
	
	@Test
	public void testAdvancedInsert() {
	
	assertEquals("[]",intList.traverse());	
	intList.insert(1,0);
	assertEquals("[1]",intList.traverse());
	intList.insert(2,1);
	assertEquals("[1,2]",intList.traverse());
	intList.insert(4,2);
	assertEquals("[1,2,4]",intList.traverse());
	intList.insert(3,2);
	assertEquals("[1,2,3,4]",intList.traverse());
	intList.insert(5,4);
	assertEquals("[1,2,3,4,5]",intList.traverse());
	intList.insert(6,5);
	assertEquals("[1,2,3,4,5,6]",intList.traverse());
	intList.insert(8,6);
	assertEquals("[1,2,3,4,5,6,8]",intList.traverse());
	intList.insert(7,6);
	assertEquals("[1,2,3,4,5,6,7,8]",intList.traverse());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveForIndexLesserThanZero() throws IllegalArgumentException, ListUnderFlowException
	{
	intList.insert(1);	
	intList.remove(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveForIndexMoreThanSize() throws IllegalArgumentException, ListUnderFlowException
	{
	intList.insert(100);
	intList.insert(200);
	intList.remove(2);
	}
	
	@Test(expected = ListUnderFlowException.class)
	public void testRemoveWhenListIsEmpty() throws IllegalArgumentException, ListUnderFlowException
	{
	intList.remove(0);
	}
	
	@Test
	public void testRemove() throws IllegalArgumentException, ListUnderFlowException
	{
		//Testing for int
		intList.insert(1);
		intList.insert(2);
		intList.insert(3);
		intList.remove(1);
		assertEquals(1, 1);
		assertEquals("[1,3]",intList.traverse());
		//Testing for String
		stringList.insert("a");
		stringList.insert("b");
		stringList.insert("c");
		stringList.remove(1);
		assertEquals("[a,c]",stringList.traverse());
	}

	@Test
	public void testGetElementAtIndex()
	{
		//Testing for int
		intList.insert(1);
		assertEquals(1, intList.getElementAtIndex(0));
		intList.insert(2);
		assertEquals(2, intList.getElementAtIndex(1));
		//Testing for String
		stringList.insert("a");
		assertEquals("a", stringList.getElementAtIndex(0));
		stringList.insert("b");
		assertEquals("b", stringList.getElementAtIndex(1));
	}
	
	@Test
	public void testSetElementAtIndex()
	{
		//Testing for int
		intList.insert(2);
		intList.insert(3);
		intList.setElementAtIndex(1, 0);
		assertEquals("[1,3]", intList.traverse());
		//Testing for String
		stringList.insert("b");
		stringList.insert("c");
		stringList.setElementAtIndex("a", 0);
		assertEquals("[a,c]", stringList.traverse());
	}
	
	@Test
	public void testTraverse()
	{
		//Testing for int
		assertEquals("[]", intList.traverse());
		intList.insert(1);
		assertEquals("[1]", intList.traverse());
		intList.insert(2);
		assertEquals("[1,2]", intList.traverse());
		//Testing for String
		assertEquals("[]", stringList.traverse());
		stringList.insert("a");
		assertEquals("[a]", stringList.traverse());
		stringList.insert("b");
		assertEquals("[a,b]", stringList.traverse());
	}
	
	
	@After
	public void cleanUp()
	{
		intList=null;//clearing up memory
		stringList=null;//clearing up memory
	}
}
