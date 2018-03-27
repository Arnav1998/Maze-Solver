package hw4;

/**
 * The {@code Stack} interface represents
 * the public methods for the {@code LinkedStack}
 * class.
 * 
 * @author Arnav Singhania
 *
 * @param <E> A generic placeholder representing 
 * 			  the type of object to be stored in 
 * 			  the stack.
 */
public interface Stack<E> {
	
	/**
	 * Finds and returns the size of the
	 * stack.
	 * 
	 * @return An integer representing the 
	 * 		   size of the stack.
	 */
	int size();
	
	/**
	 * Tests if this stack is empty.
	 * 
	 * @return A boolean value representing whether
	 * 		   the stack is empty.
	 */
	boolean isEmpty();
	
	/**
	 * Pushes an item onto the top of this stack.
	 * 
	 * @param e A generic object to be pushed onto
	 * 			the top of the stack.
	 */
	void push(E e);
	
	/**
	 * Looks at the object at the top of this stack without 
	 * removing it from the stack.
	 * 
	 * @return The object on the top of the stack.
	 */
	E top();
	
	/**
	 * Removes the object at the top of this stack and returns 
	 * that object as the value of this function.
	 * 
	 * @return The object on the top of the stack.
	 */
	E pop();

}
