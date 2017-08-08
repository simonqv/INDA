/**
 * A singly linked list.
 * 
 * @author 
 * @version
 */
public class LinkedList<T> { 
    private ListElement<T> first;   // First element in list.
    private ListElement<T> last;    // Last element in list.
    private int size;               // Number of elements in list.
    
    /**
     * A list element.
     */
    private static class ListElement<T> {
        public T data;
        public ListElement<T> next;
        
        public ListElement(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    /**
     * This TEST METHOD returns true if the following invariants hold:
     * <ul>
     *   <li> size equals the number of list elements, </li>
     *   <li> if size == 0, first == null and last == null, </li>
     *   <li> if size > 0, first != null and last != null, </li>
     *   <li> if size == 1, first == last, </li>
     *   <li> last.next == null. </li>
     * </ul>
     */
    public boolean isHealthy() {
    	// TODO
    	return false;
    }
    
    /**
     * Creates an empty list.
     */
    public LinkedList() {
        // TODO
    }

    /**
     * Inserts the given element at the beginning of this list.
     */
    public void addFirst(T element) {
        // TODO
    }

    /**
     * Inserts the given element at the end of this list.
     */
    public void addLast(T element) {
        // TODO
    }

    /**
     * Returns the first element of this list.
     * Returns <code>null</code> if the list is empty.
     */
    public T getFirst() {
        // TODO
        return null;
    }

    /**
     * Returns the last element of this list.
     * Returns <code>null</code> if the list is empty.
     */
    public T getLast() {
        // TODO
        return null;
    }

    /**
     * Returns the element at the specified position in this list.
     * Returns <code>null</code> if <code>index</code> is out of bounds.
     */
    public T get(int index) {
        // TODO
        return null;
    }

    /**
     * Removes and returns the first element from this list.
     * Returns <code>null</code> if the list is empty.
     */
    public T removeFirst() {
        // TODO
        return null;
    }

    /**
     * Removes all of the elements from this list.
     */
    public void clear() {
        // TODO
    }

    /**
     * Returns the number of elements in this list.
     */
    public int size() {
        // TODO
        return 0;
    }

    /**
     * Returns <code>true</code> if this list contains no elements.
     */
    public boolean isEmpty() {
        // TODO
        return false;
    }

    /**
     * Returns a string representation of this list. The string
     * representation consists of a list of the elements enclosed in
     * square brackets ("[]"). Adjacent elements are separated by the
     * characters ", " (comma and space). Elements are converted to
     * strings by the method toString() inherited from Object.
     */
    public String toString() {
        // TODO
        return null;
    }
}
