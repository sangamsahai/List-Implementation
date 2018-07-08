package com.sangam.list;

import java.util.Arrays;

public class MyListImpl<T> implements MyList<T> {

	private Object arr[]=new Object[5];
	int currentPointer=-1; //always points at the last element in the list
	
	@Override
	public boolean isListEmpty() {
		return currentPointer==-1;
	}

	@Override
	public int getSize() {
		return currentPointer+1;
	}

	@Override
	public void insert(T item) {
		if(currentPointer==arr.length-1)
		{
			arr=Arrays.copyOf(arr, arr.length*2);//Dynamically double the size of the array
		}
		arr[currentPointer+1]=item;
		currentPointer++;
	}

	@Override
	public void insert(T item, int index) {
		if(currentPointer==arr.length-1)
		{
			arr=Arrays.copyOf(arr, arr.length*2);//Dynamically double the size of the array
		}
			for(int i=currentPointer;i>=index;i--)
			{
				arr[i+1]=arr[i];
			}
			arr[index]=item;
			currentPointer++;
	}

	@Override
	public void remove(int index) throws IllegalArgumentException, ListUnderFlowException {
		if(currentPointer==-1)
		{
			throw new ListUnderFlowException();
		}
		else if(index<0 || index>=this.getSize())
		{
			throw new IllegalArgumentException();
		}
		else
		{
			for(int i=index+1;i<=currentPointer;i++)
			{
				arr[i-1]=arr[i];
			}
			currentPointer--;
		}

	}

	@Override
	public T getElementAtIndex(int index) {
		return (T)arr[index];
	}

	@Override
	public void setElementAtIndex(T item, int index) {
		arr[index]=item;
	}

	@Override
	public String traverse()
	{
		if(currentPointer==-1)
		{
			return"[]";
		}
		else if(currentPointer==0)
		{
			return "["+""+arr[currentPointer]+"]";
		}
		else
		{
			String str="[";
			for(int i=0;i<=currentPointer;i++)
			{
				str+=""+(T)arr[i];
				if(i!=currentPointer)
				{
					str+=",";
				}
			}
			str+="]";
			return str;
		}
	}
	
	
}
