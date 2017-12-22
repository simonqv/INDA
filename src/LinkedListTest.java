import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;
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
 * Test cases that assert one of these invariants are marked with its number.
 *
 * @author Simon Larsén (PUT YOUR NAME HERE)
 * @version 2017-12-12
 */
public class LinkedListTest {
    private LinkedList<Integer> oddLengthList;
    private int[] oddLengthArray;
    private LinkedList<Integer> evenLengthList;
    private int[] evenLengthArray;

    private LinkedList<Integer> emptyList;

    @Before
    public void setUp() {
        oddLengthArray = new int[]{4, 2, 54, 12, -2};
        oddLengthList = arrayToLinkedList(oddLengthArray);

        evenLengthArray = new int[]{65, 234, 1234, 42, -123, 4, -2, 3, 1, -9000};
        evenLengthList = arrayToLinkedList(evenLengthArray);

        emptyList = new LinkedList<Integer>();
    }

    /**
     * Tests for getFirst()
     */

    @Test (expected=NoSuchElementException.class) // 2
    public void getFirstExceptionWhenListIsEmpty() {
        fail("Not implemented");
    }

    @Test // 3
    public void getFirstIsFirstElementWhenListIsNonEmpty() {
        // Arrange
        int evenExpectedFirstElem = evenLengthArray[0];
        int oddExpectedFirstElem = oddLengthArray[0];

        // Act
        int evenFirstElem = evenLengthList.getFirst();
        int oddFirstElem = oddLengthList.getFirst();

        // Assert
        assertThat(evenFirstElem, equalTo(evenExpectedFirstElem));
        assertThat(oddFirstElem, equalTo(oddExpectedFirstElem));
    }

    @Test // 4
    public void getFirstIsEqualToGetLastWhenListHasSingleElement() {
        // Arrange
        int elem = 1338;
        LinkedList<Integer> singleElementList = new LinkedList<>();
        singleElementList.addLast(elem);

        // Act
        int firstValue = singleElementList.getFirst();
        int lastValue = singleElementList.getLast();
        
        // Assert
        assertThat(firstValue, equalTo(lastValue));
    }

    /**
     * Tests for getLast()
     */

    @Test (expected=NoSuchElementException.class) // 2
    public void getLastExceptionWhenListIsEmpty() {
        // Act
        emptyList.getLast();
    }

    @Test // 3
    public void getLastIsLastElementWhenListIsNonEmpty() {
        fail("Not implemented");
    }

    @Test (expected=NoSuchElementException.class)
    public void removeFirstExceptionWhenListIsEmpty() {
        emptyList.removeFirst();
    }

    // use removeFirst to remove elements from all but one element!
    @Test // 4
    public void getFirstIsEqualToGetLastWhenAllButOneElementHaveBeenRemoved() {
        // Arrange
        int removeAmountFromEven = evenLengthArray.length - 1;
        int removeAmountFromOdd = oddLengthArray.length - 1;

        // Act
        removeElements(evenLengthList, removeAmountFromEven);
        removeElements(oddLengthList, removeAmountFromOdd);

        int evenFirstElem = evenLengthList.getFirst();
        int evenLastElem = evenLengthList.getLast();
        int oddFirstElem = oddLengthList.getFirst();
        int oddLastElem = oddLengthList.getLast();

        // Assert
        assertThat(evenFirstElem, equalTo(evenLastElem));
        assertThat(oddFirstElem, equalTo(oddLastElem));
    }

    /**
     * Tests for size()
     */

    @Test // 1
    public void sizeIs0WhenListIsEmpty() {
        fail("Not implemented");
    }

    @Test // 1
    public void sizeIsCorrectWhenListIsNonEmpty() {
        // Arrange
        int evenExpectedSize = evenLengthArray.length;
        int oddExpectedSize = oddLengthArray.length;

        // Act
        int evenLengthListSize = evenLengthList.size();
        int oddLengthListSize = oddLengthList.size();

        // Assert
        assertThat(evenLengthListSize, equalTo(evenExpectedSize));
        assertThat(oddLengthListSize, equalTo(oddExpectedSize));
    }

    /**
     * Tests for removeFirst/size
     */

    // Use removeFirst to remove elements for this test
    @Test // 1
    public void sizeIs0WhenAllElementsHaveBeenRemoved() {
        // Arrange
        // NOTE: We don't trust the LinkedList.size() method,
        // and take the length of the arrays instead (if LinkedList is
        // implemented correctly, arr.length and list.size() should be equal)
        int removeAmountFromEven = evenLengthArray.length;
        int removeAmountFromOdd = oddLengthArray.length;

        // Act
        removeElements(evenLengthList, removeAmountFromEven);
        removeElements(oddLengthList, removeAmountFromOdd);
        int evenLengthNewSize = evenLengthList.size();
        int oddLengthNewSize = oddLengthList.size();
        
        // Assert
        assertThat(evenLengthNewSize, equalTo(0));
        assertThat(oddLengthNewSize, equalTo(0));
    }

    // Use removeFirst to remove elements for this test
    @Test // 1
    public void sizeIs1WhenAllButOneElementHasBeenRemoved() {
        fail("Not implemented");
    }

    /**
     * Tests for clear/size
     */

    // Use clear to remove elements for this test
    @Test // 1
    public void sizeIs0WhenListHasBeenCleared() {
        fail("Not implemented");
    }

    /**
     * Tests for addFirst/size
     */
    
    @Test // 1
    public void addFirstFiveTimesIncreasesSizeByFive() {
        // Arrange
        int increase = 5;
        int emptyListExpectedSize = increase;
        int evenLengthListExpectedSize = evenLengthArray.length + increase;
        int oddLengthListExpectedSize = oddLengthArray.length + increase;

        // Act
        for (int i = 0; i < increase; i++) {
            emptyList.addFirst(i);
            evenLengthList.addFirst(i);
            oddLengthList.addFirst(i);
        }
        int emptyListActualSize = emptyList.size();
        int evenLengthListActualSize = evenLengthList.size();
        int oddLengthListActualSize = oddLengthList.size();

        // Assert
        assertThat(emptyListActualSize, equalTo(emptyListExpectedSize));
        assertThat(evenLengthListActualSize, equalTo(evenLengthListExpectedSize));
        assertThat(oddLengthListActualSize, equalTo(oddLengthListExpectedSize));
    }

    /**
     * This test only tests the speed of your implementation. It should be
     * passed with good margin on even to slowest of computers.
     */
    @Test(timeout=100)
    public void addFirstTenThousandTimesIsReasonablyFast() {
        // NOTE: 10_000 is the same as 10000, just more readable!
        for (int i = 0; i < 10_000; i++) {
            // Act
            emptyList.addFirst(i);
        }
    }

    /**
     * Tests for addLast/size
     */

    @Test // 1
    public void addLastFiveTimesIncreasesSizeByFive() {
        fail("Not implemented");
    }

    @Test(timeout=100)
    public void addLastTenThousandTimesIsReasonablyFast() {
        // NOTE: 10_000 is the same as 10000, just more readable!
        for (int i = 0; i < 10_000; i++) {
            // Act
            emptyList.addLast(i);
        }
    }
    
    /**
     * Tests for isEmpty
     */

    @Test
    public void isEmptyIsTrueWhenNoElementsHaveBeenAdded() {
        // Act
        boolean empty = emptyList.isEmpty();

        // Assert
        assertTrue(empty);
    }

    // Use removeFirst for this test
    @Test // 2
    public void isEmptyIsTrueWhenAllElementsHaveBeenRemoved() {
        fail("Not implemented");
    }

    // Use clear for this test
    @Test // 2
    public void isEmptyIsTrueWhenListHasBeenCleared() {
        // Act
        evenLengthList.clear();
        oddLengthList.clear();

        boolean evenIsEmpty = evenLengthList.isEmpty();
        boolean oddIsEmpty = oddLengthList.isEmpty();

        // Assert
        assertTrue(evenIsEmpty);
        assertTrue(oddIsEmpty);
    }

    @Test
    public void clearDoesNothingWhenListisEmpty() {
        // Act
        emptyList.clear();

        int emptyListSize = emptyList.size();
        boolean emptyIsEmpty = emptyList.isEmpty();

        // Assert
        assertThat(emptyListSize, equalTo(0));
        assertTrue(emptyIsEmpty);
    }

    /**
     * Test for get(int)
     */

    @Test
    public void getExceptionWhenIndexIsOutOfBounds() {
        // Arrange
        LinkedList<Integer> list = evenLengthList;
        int length = evenLengthArray.length;
        int[] outOfBoundsIndices = new int[]{-1, -200, length, length + 200};

        // Act
        for (int index : outOfBoundsIndices) {
            try {
                list.get(index); // Exception expected here!
                fail("Expected IndexOutOfBoundsException!");
            } catch(IndexOutOfBoundsException e) {
                // Assert (kind of)
            }
        }
    }

    @Test
    public void getCorrectlyReturnsAllElementsOfEvenLengthList() {
        assertGetCorrectlyReturnsEveryElement(evenLengthList, evenLengthArray);
    }

    @Test
    public void getCorrectlyReturnsAllElementsOfOddLengthList() {
        assertGetCorrectlyReturnsEveryElement(oddLengthList, oddLengthArray);
    }

    /**
     * Tests for toString()
     */

    @Test
    public void toStringIsCorrectWhenListIsNonEmpty() {
        // Arrange
        String expectedOddListString = Arrays.toString(oddLengthArray);
        String expectedEvenListString = Arrays.toString(evenLengthArray);

        // Act
        String oddLengthListString = oddLengthList.toString();
        String evenLengthListString = evenLengthList.toString();

        // Assert
        assertEquals(expectedOddListString, oddLengthListString);
        assertEquals(expectedEvenListString, evenLengthListString);
    }

    @Test
    public void toStringIsOnlyBracketsWhenListIsEmpty() {
        // Arrange
        String expectedEmptyListString = Arrays.toString(new int[0]);
        
        // Act
        String emptyListString = emptyList.toString();

        // Assert
        assertEquals(expectedEmptyListString, emptyListString);
    }

    // HELPERS

    /**
     * Remove the specified amount of elements.
     * fails the test if any exception is thrown.
     *
     * @param list An integer LinkedList
     * @param amount Amount of elements to remove
     */
    private void removeElements(LinkedList<Integer> list, int amount) {
        try {
            for (int i = 0; i < amount; i++) {
                list.removeFirst();
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception was thrown while removing elements");
        }
    }

    /**
     * @param array An integer arra.
     * @return A LinkedList filled with the values in array, in the same order.
     */
    private LinkedList<Integer> arrayToLinkedList(int[] array) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int value : array) {
            list.addLast(value);
        }
        return list;
    }

    /**
     * Class used for stream operations when both actual and expected values
     * need to be gathered in conjunction.
     */
    private class ResultPair<T> {
        public final T actual;
        public final T expected;

        public ResultPair(T actual, T expected) {
            this.actual = actual;
            this.expected = expected;
        }
    }

    /**
     * @param list A LinkedList.
     * @param expectedValues An array with the same values, in the same order, as list.
     */
    private void assertGetCorrectlyReturnsEveryElement(LinkedList<Integer> list,
                                                       int[] expectedValues) {
        IntStream.range(0, expectedValues.length)
            .mapToObj(i -> 
                    new ResultPair<Integer>(list.get(i), expectedValues[i]))
            .forEach(pair ->
                    assertThat(pair.actual, equalTo(pair.expected)));
    }
}
