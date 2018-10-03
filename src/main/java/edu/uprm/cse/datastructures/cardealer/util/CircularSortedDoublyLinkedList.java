package edu.uprm.cse.datastructures.cardealer.util;

import java.util.Iterator;
import edu.uprm.cse.datastructures.cardealer.util.SortedList;

public class CircularSortedDoublyLinkedList<E> implements SortedList<E>
{
	private DNode<E> first;
	//private DNode<E> last;
	private int size;
	
	public CircularSortedDoublyLinkedList()
	{
		this.first = new DNode<E>(null,this.first,this.first);
		this.size = 0;
	}
	
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean add(E obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public int size() {
		return this.size;
	}

	public boolean remove(E obj) {
		if(!contains(obj))
			return false;
		
		if(this.first().equals(obj))
		{
			this.first.getPrev().setNext(this.first.getNext());
			this.first.getNext().setPrev(this.first.getPrev());
			
			this.first = this.first.getNext();
			this.first.cleanLinks();
			this.first.setElement(null);
			
			this.size--;
			return true;
		}
		
		DNode<E> ptr = this.first;
		while(!ptr.getElement().equals(obj))
		{
			ptr = ptr.getNext();
		}
		
		ptr.getPrev().setNext(ptr.getNext());
		ptr.getNext().setPrev(ptr.getPrev());
		
		ptr.setElement(null);
		ptr.cleanLinks();
		this.size--;
		
		return true;
	}

	public boolean remove(int index) {
		if(index < 0 | index > this.size())
			return false;
		
		DNode<E> ptr = this.first;
		int i = 0;
		while(i != index)
		{
			ptr = ptr.getNext();
			i++;
		}
		ptr.getPrev().setNext(ptr.getNext());
		ptr.getNext().setPrev(ptr.getPrev());
		
		ptr.setElement(null);
		ptr.cleanLinks();
		
		this.size--;
		
		return false;
	}

	public int removeAll(E obj) 
	{
		if(!contains(obj))
			return 0;
		
		int i = 0;
		while(contains(obj))
		{
			remove(obj);
			i++;
		}
		return i;
	}

	public E first() {
		return this.first.getElement();
	}

	public E last() {
		DNode<E> ptr = this.first;
		
		while(!ptr.getNext().equals(this.first))
		{
			ptr = ptr.getNext();
		}
		return ptr.getElement();
	}

	public E get(int index) {
		if(index < 0 |index > this.size())
			return null;
		
		DNode<E> ptr = this.first;
		int i = 0;
		while(i <= index)
		{
			ptr = ptr.getNext();
			i++;
		}
		return ptr.getElement();
	}

	public void clear() {
		// TODO Auto-generated method stub
		DNode<E> temp = this.first;
		while(this.size()>0)
		{
			
		}
	}

	public boolean contains(E e) 
	{
		if(isEmpty())return false;
		
		DNode<E> ptr = this.first;
		int i = 0;
		boolean contains = false;
		
		while(i < this.size())
		{
			if(ptr.getElement().equals(e))
				contains = true;
			ptr = ptr.getNext();
			
		}
		ptr = null;
		return contains;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	
	public int firstIndex(E e) {
		//Returns -1 if list is empty
		if(this.isEmpty())
			return -1;
		return 0;
	}

	public int lastIndex(E e) {
		return this.size()-1 % this.size();
	}

	private static class DNode<E>  {
		private E element; 
		private DNode<E> prev, next; 

		// Constructors
		public DNode() {this(null);}
		
		public DNode(E e) { 
			this( e,null,null); 
			
		}
		
		public DNode(E e, DNode<E> p, DNode<E> n) { 
			prev = p; 
			next = n;
			element = e;
		}
		
		// Methods
		public DNode<E> getPrev() {
			return prev;
		}
		public void setPrev(DNode<E> prev) {
			this.prev = prev;
		}
		public DNode<E> getNext() {
			return next;
		}
		public void setNext(DNode<E> next) {
			this.next = next;
		}
		public E getElement() {
			return element; 
		}

		public void setElement(E data) {
			element = data; 
		} 
		
		/**
		 * Just set references prev and next to null. Disconnect the node
		 * from the linked list.... 
		 */
		public void cleanLinks() { 
			prev = next = null; 
		}
		
	}

}

	
