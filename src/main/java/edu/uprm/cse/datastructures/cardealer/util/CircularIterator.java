
package edu.uprm.cse.datastructures.cardealer.util;

import java.util.Iterator;

public class CircularIterator<T> implements Iterator<Node<T>> {

	 private final Node<T> first;
	    private Node<T> mPosition;


	    public CircularIterator(Node<T> first) {
	        this.first = first;
	        this.mPosition = this.first;
	        
	    }

	   
	    public boolean hasNext() {
	        return !this.mPosition.getNext().equals(this.first);
	    }

	    
	    public Node<T> next() {
	        if (!hasNext())
	            return this.first;

	        mPosition = mPosition.getNext();

	        return  mPosition;
	    }
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return (Iterator<T>) new CircularIterator(this.first);
	}

}
