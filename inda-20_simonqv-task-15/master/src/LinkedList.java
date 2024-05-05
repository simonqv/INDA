import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A singly linked list.
 * 
 * @author (Simon Larspers Qvist)
 * @version (28/01/21)
 */
public class LinkedList<T> implements Stack<T> {
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

        public ListElement(T data, ListElement<T> next) {
            this.data = data;
            this.next = next;
        }
    }
    
    /**
     * Creates an empty list.
     */
    public LinkedList() {
        size = 0;
        first = null;
        last = null;
    }

    /**
     * Inserts the given element at the beginning of this list.
     *
     * @param element An element to insert into the list.
     */
    public void addFirst(T element) {
        ListElement<T> prevFirst = first;
        ListElement<T> newFirst = new ListElement<>(element, prevFirst);
        first = newFirst;
        if (size == 0 && last == null) {
            last = newFirst;
        }
        size++;
    }

    /**
     * Inserts the given element at the end of this list.
     *
     * @param element An element to insert into the list.
     */
    public void addLast(T element) {
        ListElement<T> prevLast = last;
        ListElement<T> newLast = new ListElement<>(element);
        last = newLast;
        if (size == 0) {
            first = last;
        } else {
            prevLast.next = last;
        }
        size ++;
    }

    /**
     * @return The head of the list.
     * @throws NoSuchElementException if the list is empty.
     */
    public T getFirst() {
        if (size == 0) throw new NoSuchElementException();

        return first.data;
    }

    /**
     * @return The tail of the list.
     * @throws NoSuchElementException if the list is empty.
     */
    public T getLast() {
        if (size == 0) throw new NoSuchElementException();

        return last.data;
    }

    /**
     * Returns an element from a specified index.
     *
     * @param index A list index.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        ListElement<T> temp = first;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.data;
    }

    /**
     * Removes the first element from the list.
     *
     * @return The removed element.
     * @throws NoSuchElementException if the list is empty.
     */
    public T removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        T removedFirst = first.data;
        ListElement<T> newFirst = first.next;
        first = newFirst;
        if (newFirst == null) {
            last = null;
        }
        size --;

        return removedFirst;
    }

    /**
     * Removes all of the elements from the list.
     */
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void push(T elem) {
        addFirst(elem);
    }

    @Override
    public T pop() throws EmptyStackException {
        try {
            return removeFirst();
        } catch (NoSuchElementException e) {
            throw new EmptyStackException();
        }
    }

    @Override
    public T top() throws EmptyStackException {
        try {
            return getFirst();
        } catch (NoSuchElementException e) {
            throw new EmptyStackException();
        }
    }

    /**
     * @return The number of elements in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Note that by definition, the list is empty if both first and last
     * are null, regardless of what value the size field holds (it should
     * be 0, otherwise something is wrong).
     *
     * @return <code>true</code> if this list contains no elements.
     */
    public boolean isEmpty() {
        return first == null && last == null;
    }

    /**
     * Creates a string representation of this list. The string
     * representation consists of a list of the elements enclosed in
     * square brackets ("[]"). Adjacent elements are separated by the
     * characters ", " (comma and space). Elements are converted to
     * strings by the method toString() inherited from Object.
     *
     * Examples:
     *  "[1, 4, 2, 3, 44]"
     *  "[]"
     *
     * @return A string representing the list.
     */
    public String toString() {
        List<T> elemList = new ArrayList<>();
        ListElement<T> elem = first;
        if (elem != null) {
            while (elem != null) {
                elemList.add(elem.data);
                elem = elem.next;
            }
        }

        return elemList.toString();
    }
}
