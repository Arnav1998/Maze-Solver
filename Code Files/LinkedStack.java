package hw4;

/**
 * <p>
 * The{@code LinkedStack} class implements
 * the {@code Stack} interface and provides
 * way to manipulate a stack data structure.
 * 
 * @author Arnav Singhania
 *
 * @param <E> A generic placeholder representing 
 * 			  the type of object to be stored in 
 * 			  the stack.
 */
public class LinkedStack<E> implements Stack<E> {
	
	private LinkedList<E> list = new LinkedList<>();
	
	/**
	 * Creates an empty {@code LinkedStack} object.
	 */
	public LinkedStack() {};
	
	/**
	 * Finds and returns the size of the
	 * stack.
	 * 
	 * @return An integer representing the 
	 * 		   size of the stack.
	 */
	public int size() {return list.size();}
	
	/**
	 * Tests if this stack is empty.
	 * 
	 * @return A boolean value representing whether
	 * 		   the stack is empty.
	 */
	public boolean isEmpty() {return list.isEmpty();}
	
	/**
	 * Pushes an item onto the top of this stack.
	 * 
	 * @param element A generic object to be pushed onto
	 * 				  the top of the stack.
	 */
	public void push(E element) {list.addFirst(element);}
	
	/**
	 * Looks at the object at the top of this stack without 
	 * removing it from the stack.
	 * 
	 * @return The object on the top of the stack.
	 */
	public E top() {return list.first();}
	
	/**
	 * Removes the object at the top of this stack and returns 
	 * that object as the value of this function.
	 * 
	 * @return The object on the top of the stack.
	 */
	public E pop() {return list.removeFirst();}

}
