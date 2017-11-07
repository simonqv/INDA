import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
/**
 * Test class for the ListProcessor.
 *
 * @author Simon Larsén
 * @version 2017-08-17
 */
public class ListProcessorTest {
    // Arrange
    private ListProcessor listProcessor;

    private final int ARBITRARY_LOWER_POSITIVE_BOUND = 5;
    private final int ARBITRARY_UPPER_POSITIVE_BOUND = ARBITRARY_LOWER_POSITIVE_BOUND + 99;
    private final int POSITIVE_BOUND_SEQUENCE_FIRST_VALUE = ARBITRARY_LOWER_POSITIVE_BOUND;
    private final int POSITIVE_BOUND_SEQUENCE_LAST_VALUE = ARBITRARY_UPPER_POSITIVE_BOUND - 1;
    private final int POSITIVE_BOUND_SEQUENCE_LENGTH =
        ARBITRARY_UPPER_POSITIVE_BOUND - ARBITRARY_LOWER_POSITIVE_BOUND;

    private final int ARBITRARY_LOWER_NEGATIVE_BOUND = -924;
    private final int ARBITRARY_UPPER_NEGATIVE_BOUND = ARBITRARY_LOWER_NEGATIVE_BOUND + 700;
    private final int NEGATIVE_BOUND_SEQUENCE_FIRST_VALUE = ARBITRARY_LOWER_NEGATIVE_BOUND;
    private final int NEGATIVE_BOUND_SEQUENCE_LAST_VALUE = ARBITRARY_UPPER_NEGATIVE_BOUND - 1;
    private final int NEGATIVE_BOUND_SEQUENCE_LENGTH =
        ARBITRARY_UPPER_NEGATIVE_BOUND - ARBITRARY_LOWER_NEGATIVE_BOUND;

    private final int ARBITRARY_LOWER_MIXED_BOUND = -32;
    private final int ARBITRARY_UPPER_MIXED_BOUND = ARBITRARY_LOWER_MIXED_BOUND + 64;
    private final int MIXED_BOUND_SEQUENCE_FIRST_VALUE = ARBITRARY_LOWER_MIXED_BOUND;
    private final int MIXED_BOUND_SEQUENCE_LAST_VALUE = ARBITRARY_UPPER_MIXED_BOUND - 1;
    private final int MIXED_BOUND_SEQUENCE_LENGTH =
        ARBITRARY_UPPER_MIXED_BOUND - ARBITRARY_LOWER_MIXED_BOUND;

    private int[] nonEmptyArray;
    private List<Integer> nonEmptyList;
    private int nonEmptySequenceSum;

    private int[] emptyArray;
    private List<Integer> emptyList;

    @Before
    public void setUp() {
        // Arrange
        listProcessor = new ListProcessor();
        nonEmptyArray = new int[]{1, 5, -23, 2, 3, 1};
        nonEmptyList = new ArrayList<Integer>(Arrays.asList(1, 5, -23, 2, 3, 1));
        nonEmptySequenceSum = 1 + 5 - 23 + 2 + 3 + 1;
        emptyArray = new int[0];
        emptyList = new ArrayList<Integer>();
    }

    /**
     * Tests for filledArray(int, int)
     */
    @Test(expected=IllegalArgumentException.class)
    public void filledArrayExceptionWhenToIs1LessThanFrom() {
        // Arrange
        int from = 2;
        int to = from - 1;

        // Act
        listProcessor.filledArray(from, to);
    }

    @Test
    public void filledArrayLengthIsZeroWhenFromAndToAreEqual() {
        // Arrange
        int from = 1;
        int to = from;

        // Act
        int[] actualArray = listProcessor.filledArray(from, to);

        // Assert
        assertEquals(0, actualArray.length);
    }

    @Test
    public void filledArrayLengthIsCorrectWhenFromIsLessThanTo() {
        // Act
        int filledArrayPositiveBoundLength = listProcessor.filledArray(
            ARBITRARY_LOWER_POSITIVE_BOUND, ARBITRARY_UPPER_POSITIVE_BOUND).length;
        int filledArrayNegativeBoundLength = listProcessor.filledArray(
            ARBITRARY_LOWER_NEGATIVE_BOUND, ARBITRARY_UPPER_NEGATIVE_BOUND).length;
        int filledArrayMixedBoundLength = listProcessor.filledArray(
            ARBITRARY_LOWER_MIXED_BOUND, ARBITRARY_UPPER_MIXED_BOUND).length;

        // Assert
        assertThat(filledArrayPositiveBoundLength, equalTo(POSITIVE_BOUND_SEQUENCE_LENGTH));
        assertThat(filledArrayNegativeBoundLength, equalTo(NEGATIVE_BOUND_SEQUENCE_LENGTH));
        assertThat(filledArrayMixedBoundLength, equalTo(MIXED_BOUND_SEQUENCE_LENGTH));
    }

    @Test
    public void filledArrayFirstAndLastValuesAreCorrectWhenFromIsLessThanTo() {
        // Act
        int[] filledArrayPositiveBounds = listProcessor.filledArray(
            ARBITRARY_LOWER_POSITIVE_BOUND, ARBITRARY_UPPER_POSITIVE_BOUND);
        int[] filledArrayNegativeBounds = listProcessor.filledArray(
            ARBITRARY_LOWER_NEGATIVE_BOUND, ARBITRARY_UPPER_NEGATIVE_BOUND);
        int[] filledArrayMixedBounds = listProcessor.filledArray(
            ARBITRARY_LOWER_MIXED_BOUND, ARBITRARY_UPPER_MIXED_BOUND);

        // Assert
        // Note that these asserts are a private helper method.
        assertFirstAndLastValuesAre(filledArrayPositiveBounds,
                                    POSITIVE_BOUND_SEQUENCE_FIRST_VALUE,
                                    POSITIVE_BOUND_SEQUENCE_LAST_VALUE);
        assertFirstAndLastValuesAre(filledArrayNegativeBounds,
                                    NEGATIVE_BOUND_SEQUENCE_FIRST_VALUE,
                                    NEGATIVE_BOUND_SEQUENCE_LAST_VALUE);
        assertFirstAndLastValuesAre(filledArrayMixedBounds,
                                    MIXED_BOUND_SEQUENCE_FIRST_VALUE,
                                    MIXED_BOUND_SEQUENCE_LAST_VALUE);
    }

    /**
     * Assert that params first and last match the first and last elements of the array.
     *
     * @param array An int array.
     * @param first Supposedly the first value of array.
     * @param last Supposedly the last value of array.
     */
    private void assertFirstAndLastValuesAre(int[] array, int first, int last) {
        assertThat(first, equalTo(array[0]));
        assertThat(last, equalTo(array[array.length - 1]));
    }

    @Test
    public void filledArrayContainsIncrementingRangeWhenFromIsLessThanTo() {
        // Act
        int[] filledArrayPositiveBounds = listProcessor.filledArray(
            ARBITRARY_LOWER_POSITIVE_BOUND, ARBITRARY_UPPER_POSITIVE_BOUND);
        int[] filledArrayNegativeBounds = listProcessor.filledArray(
            ARBITRARY_LOWER_NEGATIVE_BOUND, ARBITRARY_UPPER_NEGATIVE_BOUND);
        int[] filledArrayMixedBounds = listProcessor.filledArray(
            ARBITRARY_LOWER_MIXED_BOUND, ARBITRARY_UPPER_MIXED_BOUND);

        // Assert
        // Note that these asserts are a private helper method.
        assertIncrementingRange(filledArrayPositiveBounds);
        assertIncrementingRange(filledArrayNegativeBounds);
        assertIncrementingRange(filledArrayMixedBounds);
    }

    /**
     * Assert that the array contains values that increment by exactly 1 when
     * iterating from left to right.
     *
     * @param array An int array.
     */
    private void assertIncrementingRange(int[] array) {
        int expectedValue = array[0];
        for (int actualValue : array) {
            assertThat(actualValue, equalTo(expectedValue));
            expectedValue++;
        }
    }

    /**
     * Tests for filledList(int, int)
     */

    @Test(expected=IllegalArgumentException.class)
    public void filledListExceptionWhenToIs1LessThanFrom() {
        // Arrange
        int from = 2;
        int to = from - 1;

        // Act
        listProcessor.filledList(from, to);
    }

    @Test
    public void filledListLengthIsZeroWhenFromAndToAreEqual() {
        // Arrange
        int from = 1;
        int to = from;

        // Act
        List<Integer> actualList = listProcessor.filledList(from, to);

        // Assert
        assertThat(actualList.size(), equalTo(0));
    }

    @Test
    public void filledListLengthIsCorrectWhenFromIsLessThanTo() {
        // Act
        int filledListPositiveBoundLength = listProcessor.filledList(
            ARBITRARY_LOWER_POSITIVE_BOUND, ARBITRARY_UPPER_POSITIVE_BOUND).size();
        int filledListNegativeBoundLength = listProcessor.filledList(
            ARBITRARY_LOWER_NEGATIVE_BOUND, ARBITRARY_UPPER_NEGATIVE_BOUND).size();
        int filledListMixedBoundLength = listProcessor.filledList(
            ARBITRARY_LOWER_MIXED_BOUND, ARBITRARY_UPPER_MIXED_BOUND).size();

        // Assert
        assertThat(filledListPositiveBoundLength, equalTo(POSITIVE_BOUND_SEQUENCE_LENGTH));
        assertThat(filledListNegativeBoundLength, equalTo(NEGATIVE_BOUND_SEQUENCE_LENGTH));
        assertThat(filledListMixedBoundLength, equalTo(MIXED_BOUND_SEQUENCE_LENGTH));
    }

    @Test
    public void filledListFirstAndLastValuesAreCorrectWhenFromIsLessThanTo() {
        // Act
        List<Integer> filledListPositiveBounds = listProcessor.filledList(
            ARBITRARY_LOWER_POSITIVE_BOUND, ARBITRARY_UPPER_POSITIVE_BOUND);
        List<Integer> filledListNegativeBounds = listProcessor.filledList(
            ARBITRARY_LOWER_NEGATIVE_BOUND, ARBITRARY_UPPER_NEGATIVE_BOUND);
        List<Integer> filledListMixedBounds = listProcessor.filledList(
            ARBITRARY_LOWER_MIXED_BOUND, ARBITRARY_UPPER_MIXED_BOUND);

        // Assert
        // Note that these asserts are a private helper method.
        assertFirstAndLastValuesAre(filledListPositiveBounds,
                                    POSITIVE_BOUND_SEQUENCE_FIRST_VALUE,
                                    POSITIVE_BOUND_SEQUENCE_LAST_VALUE);
        assertFirstAndLastValuesAre(filledListNegativeBounds,
                                    NEGATIVE_BOUND_SEQUENCE_FIRST_VALUE,
                                    NEGATIVE_BOUND_SEQUENCE_LAST_VALUE);
        assertFirstAndLastValuesAre(filledListMixedBounds,
                                    MIXED_BOUND_SEQUENCE_FIRST_VALUE,
                                    MIXED_BOUND_SEQUENCE_LAST_VALUE);
    }

    /**
     * Assert that params first and last match the first and last elements of the list.
     *
     * @param list An int list.
     * @param first Supposedly the first value of list.
     * @param last Supposedly the last value of list.
     */
    private void assertFirstAndLastValuesAre(List<Integer> list, Integer first, Integer last) {
        assertThat(first, equalTo(list.get(0)));
        assertThat(last, equalTo(list.get(list.size() - 1)));
    }

    @Test
    public void filledListContainsIncrementingRangeWhenFromIsLessThanTo() {
        // Act
        List<Integer> filledListPositiveBounds = listProcessor.filledList(
            ARBITRARY_LOWER_POSITIVE_BOUND, ARBITRARY_UPPER_POSITIVE_BOUND);
        List<Integer> filledListNegativeBounds = listProcessor.filledList(
            ARBITRARY_LOWER_NEGATIVE_BOUND, ARBITRARY_UPPER_NEGATIVE_BOUND);
        List<Integer> filledListMixedBounds = listProcessor.filledList(
            ARBITRARY_LOWER_MIXED_BOUND, ARBITRARY_UPPER_MIXED_BOUND);

        // Assert
        // Note that these asserts are a private helper method.
        assertIncrementingRange(filledListPositiveBounds);
        assertIncrementingRange(filledListNegativeBounds);
        assertIncrementingRange(filledListMixedBounds);
    }

    /**
     * Assert that the list contains values that increment by exactly 1 when
     * iterating from left to right.
     *
     * @param array An int list.
     */
    private void assertIncrementingRange(List<Integer> list) {
        int expectedValue = list.get(0);
        for (int actualValue : list) {
            assertThat(actualValue, equalTo(expectedValue));
            expectedValue++;
        }
    }

    /**
     * Tests for shuffled(int[])
     */

    @Test
    public void shuffledArrayIsEmptyWhenOriginalIsEmpty() {
        // Arrange
        int[] array = new int[0];

        // Act
        int[] shuffledArray = listProcessor.shuffled(array);

        // Assert
        assertThat(shuffledArray.length, equalTo(0));
    }

    @Test
    public void shuffledArrayIsEqualToOriginalWhenOriginalHasSingleElement() {
        // Arrange
        int[] array = new int[]{34};

        // Act
        int[] shuffledArray = listProcessor.shuffled(array);

        // Assert
        assertThat(shuffledArray, equalTo(array));
    }

    @Test
    public void shuffledArrayIsSameLengthAsOriginalWhenNonEmpty() {
        // Arrange
        int[] array = new int[]{1, 5, 3, 234, 8, 8, 1, 3};

        // Act
        int[] shuffledArray = listProcessor.shuffled(array);

        // Assert
        assertThat(shuffledArray.length, equalTo(array.length));
    }

    @Test
    public void shuffledArrayContainsSameElementsAsOriginalWhenNonEmpty() {
        // Arrange
        int[] array = new int[]{1, 4, 23, -123, 43, 2, 1, 2, 3, 3};

        // Act
        int[] shuffledArray = listProcessor.shuffled(array);
        Arrays.sort(array);
        Arrays.sort(shuffledArray);

        // Assert
        assertThat(shuffledArray, equalTo(array));
    }

    @Test
    public void shuffledArrayDoesNotMutateOriginalArrayWhenNonEmpty() {
        // Arrange
        int[] array = new int[]{1, 45, -342, 42, -32, -2, 1, 1, 1, 23, 43};
        int[] arrayCopy = Arrays.copyOf(array, array.length);

        // Act
        listProcessor.shuffled(array);

        // Assert
        assertThat(array, equalTo(arrayCopy));
    }

    /**
     * Tests for shuffle(List<Integer>)
     */

    @Test
    public void shuffledListIsEmptyWhenOriginalIsEmpty() {
        // Arrange
        List<Integer> list = new ArrayList<Integer>();

        // Act
        List<Integer> shuffledList = listProcessor.shuffled(list);

        // Assert
        assertThat(shuffledList.size(), equalTo(0));
    }

    @Test
    public void shuffledListIsEqualToOriginalWhenOriginalHasSingleElement() {
        // Arrange
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(34));

        // Act
        List<Integer> shuffledList = listProcessor.shuffled(list);

        // Assert
        assertThat(shuffledList, equalTo(list));
    }

    @Test
    public void shuffledListIsSameLengthAsOriginalWhenNonEmpty() {
        // Arrange
        List<Integer> list = new ArrayList<Integer>(
            Arrays.asList(1, 5, 3, 234, 8, 8, 1, 3));

        // Act
        List<Integer> shuffledList = listProcessor.shuffled(list);

        // Assert
        assertThat(shuffledList.size(), equalTo(list.size()));
    }

    @Test
    public void shuffledListContainsSameElementsAsOriginalWhenNonEmpty() {
        // Arrange
        List<Integer> list = new ArrayList<Integer>(
            Arrays.asList(1, 4, 23, -123, 43, 2, 1, 2, 3, 3));

        // Act
        List<Integer> shuffledList = listProcessor.shuffled(list);
        Collections.sort(list);
        Collections.sort(shuffledList);

        // Assert
        assertThat(shuffledList, equalTo(list));
    }

    @Test
    public void shuffledListDoesNotMutateOriginalListWhenNonEmpty() {
        // Arrange
        List<Integer> list = new ArrayList<Integer>(
            Arrays.asList(1, 45, -342, 42, -32, -2, 1, 1, 1, 23, 43));
        List<Integer> listCopy = new ArrayList<Integer>(list);

        // Act
        listProcessor.shuffled(list);

        // Assert
        assertThat(list, equalTo(listCopy));
    }

    /**
     * Tests for sumIterative(int[])
     */

    @Test
    public void sumIterativeIsZeroWhenArrayIsEmpty() {
        // Act
        int sum = listProcessor.sumIterative(emptyArray);

        // Assert
        assertThat(sum, equalTo(0));
    }

    @Test
    public void sumIterativeIsCorrectWhenArrayIsNonEmpty() {
        // Act
        int sum = listProcessor.sumIterative(nonEmptyArray);

        // Assert
        assertThat(sum, equalTo(nonEmptySequenceSum));
    }

    /**
     * Tests for sumIterative(List<Integer>)
     */

    @Test
    public void sumIterativeIsZeroWhenListIsEmpty() {
        // Act
        int sum = listProcessor.sumIterative(emptyList);

        // Assert
        assertThat(sum, equalTo(0));
    }

    @Test
    public void sumIterativeIsCorrectWhenListIsNonEmpty() {
        // Act
        int sum = listProcessor.sumIterative(nonEmptyList);

        // Assert
        assertThat(sum, equalTo(nonEmptySequenceSum));
    }

    /**
     * Tests for sumRecursive(List<Integer>)
     */

    @Test
    public void sumRecursiveIsZeroWhenArrayIsEmpty() {
        // Act
        int sum = listProcessor.sumRecursive(emptyArray);

        // Assert
        assertThat(sum, equalTo(0));
    }

    @Test
    public void sumRecursiveIsCorrectWhenArrayIsNonEmpty() {
        // Act
        int sum = listProcessor.sumRecursive(nonEmptyArray);

        // Assert
        assertThat(sum, equalTo(nonEmptySequenceSum));
    }

    /**
     * Tests for sumRecursive(List<Integer>)
     */

    @Test
    public void sumRecursiveIsZeroWhenListIsEmpty() {
        // Act
        int sum = listProcessor.sumRecursive(emptyList);

        // Assert
        assertThat(sum, equalTo(0));
    }

    @Test
    public void sumRecursiveIsCorrectWhenListIsNonEmpty() {
        // Act
        int sum = listProcessor.sumRecursive(nonEmptyList);

        // Assert
        assertThat(sum, equalTo(nonEmptySequenceSum));
    }
}
