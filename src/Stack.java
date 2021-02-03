import java.util.EmptyStackException;

public interface Stack<T> {

    /**
     * Adds an element to the top of the stack
     * @param elem what to add to the top of the stack
     */
    void push(T elem);

    /**
     * Removes the element added last to the stack
     * Throws EmptyStackException if the stack is empty
     * @return the element that was removed
     */
    T pop() throws EmptyStackException;

    /**
     * Does not modify the stack
     * Throws EmptyStackException if the stack is empty
     * @return the element that was added last to the stack, does not remove said element
     */
    T top() throws EmptyStackException;

    /**
     * Does not modify the stack
     * @return the number of elements in the stack
     */
    int size();

    /**
     * Does not modify the stack
     * @return True if the stack is empty, and False if it isn't empty
     */
    boolean isEmpty();
}
