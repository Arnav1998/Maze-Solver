package hw4;


/**
 * <p>
 * The {@code LinkedList} class represents
 * a data structure involving {@code Node}
 * objects interlinked to one another. This
 * class contains methods to add {@code Node}
 * objects to the data structure, to delete
 * {@code Node} objects, to get {@code Node}
 * objects at a particular position and to get
 * the size of the data structure represented
 * by the {@code LinkedList} class. It also contains
 * several constructors to initialize the data 
 * structure represented by the {@code LinkedList}
 * class in different ways. 
 * 
 * @author Arnav Singhania
 *
 * @param <E> A generic placeholder representing 
 * 			  the type of object to be stored in 
 * 			  the LinkedList.
 */
public class LinkedList<E> {

	/**
	 *  <p>
	 * The {@code Node} class represents a single
	 * {@code Node} object in the {@code LinkedList}
	 * class. 
	 * 
	 * @author Arnav Singhania
	 *
	 * @param <E> A generic placeholder representing 
 * 			 	 the type of object to be stored in 
 * 			 	 the LinkedList.
	 */
	private static class Node<E> {
		
		private E element;
		private Node<E> next;
		
		public Node(E e, Node<E> n) {
			
			element = e;
			next = n;
			
		}
		
		public E getElement() {return element;}
		public Node<E> getNext() {return next;}
		public void setNext(Node<E> n) {next = n;}
		
	}
	
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	/**
	 * Initializes an empty
	 * {@code LinkedList} object.
	 */
	public LinkedList() {};
	
	/**
	 * Finds and return the number of
	 * {@code Node} objects in the 
	 * LinkedList structure.
	 * 
	 * @return An integer representing the
	 * 		   size of the LinkedList.
	 */
	public int size() {return size;}
	
	/**
	 * Checks whether the LinkedList
	 * is empty or not.
	 * 
	 * @return A boolean indicating whether the
	 * 		   LinkedList is empty or not.
	 */
	public boolean isEmpty() {return size==0;}
	
	/**
	 * Returns the first {@code Node}
	 * object in the LinkedList.
	 * 
	 * @return The first {@code Node} object
	 * 		   object in the LinkedList.	
	 */
	public E first() {
		if (isEmpty()) return null;
		return head.getElement();
	}
	
	/**
	 * Returns the last {@code Node}
	 * object in the LinkedList.
	 * 
	 * @return The last {@code Node} object
	 * 		   object in the LinkedList.	
	 */
	public E last() {
		if (isEmpty()) return null;
		return tail.getElement();
	}
	
	/**
	 * Adds a {@code Node} object
	 * onto the beginning of the LinkedList.
	 * 
	 * @param e A generic object to be added to
	 * 			the LinkedList.
	 */
	public void addFirst(E e) {
		head = new Node<>(e, head);
		if (size == 0) tail = head;
		size++;
	}
	
	/**
	 * Adds a {@code Node} object
	 * onto the end of the LinkedList.
	 * 
	 * @param e A generic object to be added to
	 * 			the LinkedList.
	 */
	public void addLast(E e) {
		Node<E> newest = new Node<>(e, null);
		if (isEmpty()) 
			head = newest;
		else 
			tail.setNext(newest);
		tail = newest;
		size++;
	}
	
	/**
	 * Removes the first {@code Node}
	 * object in the {@code LinkedList}
	 * data structure.
	 * 
	 * @return A generic object at the beginning
	 * 		   of the LinkedList.
	 */
	public E removeFirst() {
		if (isEmpty()) return null;
		E answer = head.getElement();
		head = head.getNext();
		size--;
		if (size == 0)
			tail = null;
		return answer;
	}

}
