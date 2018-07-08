package com.sangam.list;

public interface MyList<T> {

	boolean isListEmpty();
	
	int getSize();
	
	void insert(T item);
	
	void insert(T item, int index);
	
	void remove(int index) throws IllegalArgumentException,ListUnderFlowException;
	
	T getElementAtIndex(int index);
	
	void setElementAtIndex(T item, int index);
	
	String traverse();
		
}
