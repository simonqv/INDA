import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Test class for LinkedList
 *
 * The following invariants are checked for several different states and for
 * each of the methods that mutate the list.
 * 
 *   1. size equals the number of list elements,
 *   2. if size == 0, first == null and last == null,
 *   3. if size > 0, first != null and last != null,
 *   4. if size == 1, first == last,
 *
 *   The 5th invariant is not tested, but keep it in mind ...
 *   5. last.next == null.
 *
 * @author Simon Larsén
 * @author Anton Lyxell
 * @author (PUT YOUR NAME HERE)
 * @version 2018-12-20
 */
public class LinkedListTest {

    private int[] elements;

    private LinkedList<Integer> list;
    private LinkedList<Integer> emptyList;

    @Before
    public void setUp() {
        emptyList = new LinkedList<Integer>();
        list = new LinkedList<Integer>();
        elements = new int[]{-919,  388,   67, -248, -309, -725,  904,   53,
                               90, -469, -559,  256,  612,  366, -412, -221,
                              347, -921, -978,  324, -858,  480, -443,  891,
                              329,   -5,  878, -538,  445, -366,  760,   52};
        for (int element : elements) {
            list.addLast(element);
        }
    }

    /**
     * Tests for size()
     */

    /**
     * Assert that the size of an empty list is exactly 0. 
     */
    @Test
    public void sizeIsZeroWhenListIsEmpty() {
        fail("Not implemented");
    }

    /**
     * Tests for addFirst(T)
     */
    
    /**
     * Assert that adding an element to the beginning
     * of the list increments the size of the list by 1.
     */
    @Test
    public void addFirstIncrementsSizeByOne() {
        for (int i = 0; i < elements.length; i++) {
            // Act
            emptyList.addFirst(elements[i]);
            // Assert
            assertThat(emptyList.size(), equalTo(i + 1));
        }
    }

    /**
     * Tests for addLast(T)
     */

    /**
     * Assert that adding an element to the end
     * of the list increments the size of the list by 1.
     */
    @Test
    public void addLastIncrementsSizeByOne() {
        fail("Not implemented");
    }

    /**
     * Tests for removeFirst()
     */

    /**
     * Assert that removing the first element of an empty
     * list throws an exception.
     */
    @Test (expected=NoSuchElementException.class)
    public void removeFirstThrowsExceptionWhenListIsEmpty() {
        emptyList.removeFirst();
    }

    /**
     * Assert that removing the first element of a list
     * decrements the size by 1.
     */
    @Test
    public void removeFirstDecrementsSizeByOne() {
        for (int i = 0; i < elements.length; i++) {
            // Act
            list.removeFirst();
            // Assert
            assertThat(list.size(), equalTo(elements.length - i - 1));
        }
    }

    /**
     * Tests for getFirst()
     */

    /**
     * Assert that getting the first element of an empty
     * list throws an exception.
     */
    @Test (expected=NoSuchElementException.class)
    public void getFirstThrowsExceptionWhenListIsEmpty() {
        fail("Not implemented");
    }

    /**
     * Assert that getting the first element of a list
     * returns the correct element after adding an element
     * to the beginning of the list.
     */
    @Test
    public void getFirstIsCorrectAfterAddFirst() {
        for (int i = 0; i < elements.length; i++) {
            // Arrange
            emptyList.addFirst(elements[i]);
            // Act, Assert
            assertThat(emptyList.getFirst(), equalTo(elements[i]));
        }
    }

    /**
     * Assert that getting the first element of a list
     * returns the correct element after adding an element
     * to the end of the list.
     */
    @Test
    public void getFirstIsCorrectAfterAddLast() {
        for (int i = 0; i < elements.length; i++) {
            // Arrange
            emptyList.addLast(elements[i]);
            // Act, Assert
            assertThat(emptyList.getFirst(), equalTo(elements[0]));
        }
    }

    /**
     * Tests for getLast()
     */

    /**
     * Assert that getting the last element of an empty
     * list throws an exception.
     */
    @Test (expected=NoSuchElementException.class)
    public void getLastThrowsExceptionWhenListIsEmpty() {
        // Act
        emptyList.getLast();
    }

    /**
     * Assert that getting the last element of a list
     * returns the correct element after adding an element
     * to the beginning of the list.
     */
    @Test
    public void getLastIsCorrectAfterAddFirst() {
        for (int i = 0; i < elements.length; i++) {
            // Arrange
            emptyList.addFirst(elements[i]);
            // Act, Assert
            assertThat(emptyList.getLast(), equalTo(elements[0]));
        }
    }

    /**
     * Assert that getting the last element of a list
     * returns the correct element after adding an element
     * to the end of the list.
     */
    @Test
    public void getLastIsCorrectAfterAddLast() {
        for (int i = 0; i < elements.length; i++) {
            // Arrange
            emptyList.addLast(elements[i]);
            // Act, Assert
            assertThat(emptyList.getLast(), equalTo(elements[i]));
        }
    }

    /**
     * Test for get(int)
     */

    /**
     * Assert that getting an element of an empty list
     * throws an exception. 
     */
    @Test (expected=IndexOutOfBoundsException.class)
    public void getThrowsExceptionWhenListIsEmpty() {
        // Act
        emptyList.get(0);
    }

    /**
     * Assert that getting any element of a list
     * returns the correct element after an element
     * is added to the end of the list.
     */
    @Test
    public void getIsCorrectAfterAddLast() {
        for (int i = 0; i < elements.length; i++) {
            // Arrange
            emptyList.addLast(elements[i]);
            // Act, Assert
            for (int j = 0; j < i + 1; j++) {
                assertThat(emptyList.get(j), equalTo(elements[j]));
            }
        }
    }

    /**
     * Assert that getting any element of a list
     * returns the correct element after an element
     * is added to the beginning of the list.
     */
    @Test
    public void getIsCorrectAfterAddFirst() {
        for (int i = 0; i < elements.length; i++) {
            // Arrange
            emptyList.addFirst(elements[i]);
            // Act, Assert
            for (int j = 0; j < i + 1; j++) {
                assertThat(emptyList.get(j), equalTo(elements[i-j]));
            }
        }
    }

    /**
     * Assert that getting an index outside the bounds
     * of a list throws an exception.
     */
    @Test
    public void getThrowsExceptionWhenIndexIsOutOfBounds() {
        // Arrange
        int length = elements.length;
        int[] outOfBoundsIndices = new int[]{-100, -1, length, length + 100};

        // Act
        for (int index : outOfBoundsIndices) {
            // Assert
            try {
                /* Exception expected here */
                list.get(index);
            } catch(IndexOutOfBoundsException e) {
                continue;
            }
            fail(String.format(
                "Expected IndexOutOfBoundsException for index %d", index));
        }
    }
    
    /**
     * Tests for isEmpty
     */

    /**
     * Assert that isEmpty returns true for
     * an empty list.
     */
    @Test
    public void isEmptyIsTrueForEmptyList() {
        // Act, Assert
        assertTrue(emptyList.isEmpty());
    }

    /**
     * Assert that isEmpty returns false 
     * after adding an element to the beginning
     * of the list.
     */
    @Test
    public void isEmptyIsFalseAfterAddFirst() {
        // Arrange
        emptyList.addFirst(elements[0]);
        // Act, Assert
        assertFalse(emptyList.isEmpty());
    }

    /**
     * Assert that isEmpty returns false 
     * after adding an element to the end
     * of the list.
     */
    @Test
    public void isEmptyIsFalseAfterAddLast() {
        // Arrange
        emptyList.addLast(elements[0]);
        // Act, Assert
        assertFalse(emptyList.isEmpty());
    }

    /**
     * Assert that isEmpty returns true
     * after all elements of a non empty list
     * has been removed by the removeFirst method.
     */
    @Test
    public void isEmptyIsTrueWhenAllElementsHaveBeenRemovedByRemoveFirst() {
        fail("Not implemented");
    }

    /**
     * Assert that isEmpty returns true
     * after all elements of a non empty list
     * has been removed by the clear method.
     */
    @Test
    public void isEmptyIsTrueWhenAllElementsHasBeenRemovedByClear() {
        // Act
        list.clear();

        // Assert
        assertTrue(list.isEmpty());
    }

    /**
     * Tests for clear()
     */

    /**
     * Assert that clearing a non empty list sets the
     * size of the list to 0.
     */
    @Test
    public void clearSetsSizeToZero() {
        fail("Not implemented");
    }

    /**
     * Assert that clearing an empty list
     * has no effect.
     */
    @Test
    public void clearDoesNothingWhenListIsEmpty() {
        // Act
        emptyList.clear();

        // Assert
        assertThat(emptyList.size(), equalTo(0));
        assertTrue(emptyList.isEmpty());
    }

    /**
     * Tests for toString()
     */

    /**
     * Assert that toString returns the correct
     * representation on an empty list.
     */
    @Test
    public void toStringIsCorrectWhenListIsEmpty() {
        // Act, Assert
        assertThat(emptyList.toString(), equalTo("[]"));
    }

    /**
     * Assert that toString returns the correct
     * representation on a non empty list.
     */
    @Test
    public void toStringIsCorrectWhenListIsNonEmpty() {
        // Act, Assert
        assertThat(list.toString(),
            equalTo(Arrays.toString(elements)));
    }

    /**
     * These tests only tests the speed of your implementation.
     * For a correct implementation they should be
     * passed with good margin on even to slowest of computers.
     */

    /**
     * Assert that the addFirst method runs reasonably fast.
     */
    @Test(timeout=100)
    public void addFirstTenThousandTimesIsReasonablyFast() {
        for (int i = 0; i < 10000; i++) {
            // Act
            emptyList.addFirst(i);
        }
    }

    /**
     * Assert that the addLast method runs reasonably fast.
     */
    @Test(timeout=100)
    public void addLastTenThousandTimesIsReasonablyFast() {
        for (int i = 0; i < 10000; i++) {
            // Act
            emptyList.addLast(i);
        }
    }

}
