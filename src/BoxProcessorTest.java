import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Random;

/**
 * Test class for BoxProcessor.
 *
 * @author Simon Larsén
 * @version 2017-08-16
 */
public class BoxProcessorTest {
    // Arrange
    private BoxProcessor boxProcessor;
    private final int BOX_NOT_FOUND_INDEX = -1;

    private final int ARBITRARY_EVEN_LENGTH = 100;
    private final int EVEN_LENGTH_FIRST_INDEX = 0;
    private final int EVEN_LENGTH_MIDDLE_INDEX = ARBITRARY_EVEN_LENGTH/2;
    private final int EVEN_LENGTH_LAST_INDEX = ARBITRARY_EVEN_LENGTH - 1;
    private Box[] unsortedEvenLengthArray;
    private List<Box> unsortedEvenLengthList;
    private Box evenLengthFirstElementCopy;
    private Box evenLengthMiddleElementCopy;
    private Box evenLengthLastElementCopy;
    private Box[] sortedEvenLengthArray;

    private List<Box> sortedEvenLengthList;
    private Box sortedEvenLengthFirstElementCopy;
    private Box sortedEvenLengthMiddleElementCopy;
    private Box sortedEvenLengthLastElementCopy;

    private final int ARBITRARY_ODD_LENGTH = 99;
    private final int ODD_LENGTH_FIRST_INDEX = 0;
    private final int ODD_LENGTH_MIDDLE_INDEX = ARBITRARY_ODD_LENGTH/2;
    private final int ODD_LENGTH_LAST_INDEX = ARBITRARY_ODD_LENGTH - 1;
    private Box[] unsortedOddLengthArray;
    private List<Box> unsortedOddLengthList;
    private Box oddLengthFirstElementCopy;
    private Box oddLengthMiddleElementCopy;
    private Box oddLengthLastElementCopy;

    private Box[] sortedOddLengthArray;
    private List<Box> sortedOddLengthList;
    private Box sortedOddLengthFirstElementCopy;
    private Box sortedOddLengthMiddleElementCopy;
    private Box sortedOddLengthLastElementCopy;

    private Box[] singleElementArray;
    private List<Box> singleElementList;

    private Box[] emptyArray;
    private List<Box> emptyList;

    @Before
    public void setUp() {
        // Arrange
        boxProcessor = new BoxProcessor();

        setUpUnsorted();
        setUpSorted();

        Box box = new Box(1, 2, 3);
        singleElementArray = new Box[]{box};
        singleElementList = new ArrayList<>();
        singleElementList.add(box);

        emptyArray = new Box[0];
        emptyList = new ArrayList<>();
    }

    private void setUpUnsorted() {
        unsortedEvenLengthList = generateUniqueBoxList(ARBITRARY_EVEN_LENGTH);
        unsortedEvenLengthArray = unsortedEvenLengthList.toArray(new Box[0]);

        evenLengthFirstElementCopy = new Box(unsortedEvenLengthArray[EVEN_LENGTH_FIRST_INDEX]);
        evenLengthMiddleElementCopy = new Box(unsortedEvenLengthArray[EVEN_LENGTH_MIDDLE_INDEX]);
        evenLengthLastElementCopy = new Box(unsortedEvenLengthArray[EVEN_LENGTH_LAST_INDEX]);

        unsortedOddLengthList = generateUniqueBoxList(ARBITRARY_ODD_LENGTH);
        unsortedOddLengthArray = unsortedEvenLengthList.toArray(new Box[0]);

        oddLengthFirstElementCopy = unsortedOddLengthArray[ODD_LENGTH_FIRST_INDEX];
        oddLengthMiddleElementCopy = unsortedOddLengthArray[ODD_LENGTH_MIDDLE_INDEX];
        oddLengthLastElementCopy = unsortedOddLengthArray[ODD_LENGTH_LAST_INDEX];
    }

    private void setUpSorted() {
        sortedEvenLengthList = new ArrayList<>(unsortedEvenLengthList);
        Collections.sort(sortedEvenLengthList);
        sortedEvenLengthArray = sortedEvenLengthList.toArray(new Box[0]);

        sortedEvenLengthFirstElementCopy = new Box(sortedEvenLengthArray[EVEN_LENGTH_FIRST_INDEX]);
        sortedEvenLengthMiddleElementCopy = new Box(sortedEvenLengthArray[EVEN_LENGTH_MIDDLE_INDEX]);
        sortedEvenLengthLastElementCopy = new Box(sortedEvenLengthArray[EVEN_LENGTH_LAST_INDEX]);

        sortedOddLengthList = new ArrayList<>(unsortedOddLengthList);
        Collections.sort(sortedOddLengthList);
        sortedOddLengthArray = sortedOddLengthList.toArray(new Box[0]);

        sortedOddLengthFirstElementCopy = new Box(sortedOddLengthArray[ODD_LENGTH_FIRST_INDEX]);
        sortedOddLengthMiddleElementCopy = new Box(sortedOddLengthArray[ODD_LENGTH_MIDDLE_INDEX]);
        sortedOddLengthLastElementCopy = new Box(sortedOddLengthArray[ODD_LENGTH_LAST_INDEX]);
    }

    /**
     * Tests for sort(Box[])
     */

    @Test
    public void sortCorrectlySortsWhenArrayIsUnsorted() {
        // Arrange
        Box[] unsortedEvenLengthArrayCopy = Arrays.copyOf(unsortedEvenLengthArray, unsortedEvenLengthArray.length);
        Box[] unsortedOddLengthArrayCopy = Arrays.copyOf(unsortedOddLengthArray, unsortedOddLengthArray.length);

        // Act
        boxProcessor.sort(unsortedEvenLengthArray);
        Arrays.sort(unsortedEvenLengthArrayCopy);
        boxProcessor.sort(unsortedOddLengthArray);
        Arrays.sort(unsortedOddLengthArrayCopy);

        // Assert
        assertThat(unsortedEvenLengthArray, equalTo(unsortedEvenLengthArrayCopy));
        assertThat(unsortedOddLengthArray, equalTo(unsortedOddLengthArrayCopy));
    }

    @Test
    public void sortCorrectlySortsWhenArrayIsSorted() {
        // Arrange
        Box[] sortedEvenLengthArrayCopy = Arrays.copyOf(sortedEvenLengthArray, sortedEvenLengthArray.length);
        Box[] sortedOddLengthArrayCopy = Arrays.copyOf(sortedOddLengthArray, sortedOddLengthArray.length);

        // Act
        boxProcessor.sort(sortedEvenLengthArray);
        Arrays.sort(sortedEvenLengthArrayCopy);
        boxProcessor.sort(sortedOddLengthArray);
        Arrays.sort(sortedOddLengthArrayCopy);

        // Assert
        assertThat(sortedEvenLengthArray, equalTo(sortedEvenLengthArrayCopy));
        assertThat(sortedOddLengthArray, equalTo(sortedOddLengthArrayCopy));
    }

    @Test
    public void sortCorrectlySortsWhenArrayContainsSingleElement() {
        // Arrange
        Box boxCopy = new Box(singleElementArray[0]);

        // Act
        boxProcessor.sort(singleElementArray);

        // Assert
        assertThat(singleElementArray.length, equalTo(1));
        assertThat(singleElementArray[0], equalTo(boxCopy));
    }

    @Test
    public void sortDoesNothingWhenArrayIsEmpty() {
        // Act
        boxProcessor.sort(emptyArray);
        // Assert
        assertThat(emptyArray.length, equalTo(0));
    }

    /**
     * Tests for sort(List<Box>)
     */

    @Test
    public void sortCorrectlySortsWhenListIsUnsorted() {
        // Arrange
        List<Box> unsortedEvenLengthListCopy = new ArrayList<>(unsortedEvenLengthList);
        List<Box> unsortedOddLengthListCopy = new ArrayList<>(unsortedOddLengthList);

        // Act
        boxProcessor.sort(unsortedEvenLengthList);
        Collections.sort(unsortedEvenLengthListCopy);
        boxProcessor.sort(unsortedOddLengthList);
        Collections.sort(unsortedOddLengthListCopy);

        // Assert
        assertThat(unsortedEvenLengthList, equalTo(unsortedEvenLengthListCopy));
        assertThat(unsortedOddLengthList, equalTo(unsortedOddLengthListCopy));
    }

    @Test
    public void sortCorrectlySortsWhenListIsSorted() {
        fail("Not implemented");
    }

    @Test
    public void sortCorrectlySortsWhenListContainsSingleElement() {
        // Arrange
        Box boxCopy = new Box(singleElementList.get(0));

        // Act
        boxProcessor.sort(singleElementList);

        // Assert
        assertThat(singleElementList.size(), equalTo(1));
        assertThat(singleElementList.get(0), equalTo(boxCopy));
    }

    @Test
    public void sortDoesNothingWhenListIsEmpty() {
        fail("Not implemented");
    }

    /**
     * Tests for sequentialSearch(Box[])
     */

    @Test
    public void sequentialSearchFindsBoxThatIsInArray() {
        // Act
        int firstBoxIndex = boxProcessor.sequentialSearch(unsortedEvenLengthArray, evenLengthFirstElementCopy);
        int middleBoxIndex = boxProcessor.sequentialSearch(unsortedEvenLengthArray, evenLengthMiddleElementCopy);
        int lastBoxIndex = boxProcessor.sequentialSearch(unsortedEvenLengthArray, evenLengthLastElementCopy);

        // Assert
        assertThat(firstBoxIndex, equalTo(EVEN_LENGTH_FIRST_INDEX));
        assertThat(middleBoxIndex, equalTo(EVEN_LENGTH_MIDDLE_INDEX));
        assertThat(lastBoxIndex, equalTo(EVEN_LENGTH_LAST_INDEX));
    }

    @Test
    public void sequentialSearchDoesNotFindBoxThatIsNotInUnsortedArray() {
        // Arrange
        Box[] newOddLengthArray = Arrays.copyOf(unsortedEvenLengthArray, unsortedEvenLengthArray.length - 1);
        Box boxNotInNewOddLengthArray = evenLengthLastElementCopy;
        Box[] newEvenLengthArray = Arrays.copyOf(unsortedOddLengthArray, unsortedOddLengthArray.length - 1);
        Box boxNotInNewEvenLengthArray = oddLengthLastElementCopy;

        // Act
        int boxNotInNewEvenArrayIndex = boxProcessor.sequentialSearch(
            newEvenLengthArray, boxNotInNewEvenLengthArray);
        int boxNotInNewOddArrayIndex = boxProcessor.sequentialSearch(
            newOddLengthArray, boxNotInNewOddLengthArray);

        // Assert
        assertThat(boxNotInNewOddArrayIndex, equalTo(BOX_NOT_FOUND_INDEX));
        assertThat(boxNotInNewOddArrayIndex, equalTo(BOX_NOT_FOUND_INDEX));
    }

    /**
     * Tests for sequentialSearch(List<Box>)
     */

    @Test
    public void sequentialSearchFindsBoxThatIsInList() {
        // Act
        int firstBoxIndex = boxProcessor.sequentialSearch(unsortedEvenLengthList, evenLengthFirstElementCopy);
        int middleBoxIndex = boxProcessor.sequentialSearch(unsortedEvenLengthList, evenLengthMiddleElementCopy);
        int lastBoxIndex = boxProcessor.sequentialSearch(unsortedEvenLengthList, evenLengthLastElementCopy);

        // Assert
        assertThat(firstBoxIndex, equalTo(EVEN_LENGTH_FIRST_INDEX));
        assertThat(middleBoxIndex, equalTo(EVEN_LENGTH_MIDDLE_INDEX));
        assertThat(lastBoxIndex, equalTo(EVEN_LENGTH_LAST_INDEX));
    }

    @Test
    public void sequentialSearchDoesNotFindBoxThatIsNotInUnsortedList() {
        fail("Not implemented");
    }

    /**
     * Tests for binarySearch(Box[])
     */

    @Test
    public void binarySearchFindsBoxWhenItisInSortedEvenLengthArray() {
        // Act
        int firstBoxIndex = boxProcessor.binarySearch(sortedEvenLengthArray, sortedEvenLengthFirstElementCopy);
        int middleBoxIndex = boxProcessor.binarySearch(sortedEvenLengthArray, sortedEvenLengthMiddleElementCopy);
        int lastBoxIndex = boxProcessor.binarySearch(sortedEvenLengthArray, sortedEvenLengthLastElementCopy);

        // Assert
        assertThat(firstBoxIndex, equalTo(EVEN_LENGTH_FIRST_INDEX));
        assertThat(middleBoxIndex, equalTo(EVEN_LENGTH_MIDDLE_INDEX));
        assertThat(lastBoxIndex, equalTo(EVEN_LENGTH_LAST_INDEX));
    }

    @Test
    public void binarySearchFindsBoxWhenItisInSortedOddLengthArray() {
        // Act
        int firstBoxIndex = boxProcessor.binarySearch(sortedOddLengthArray, sortedOddLengthFirstElementCopy);
        int middleBoxIndex = boxProcessor.binarySearch(sortedOddLengthArray, sortedOddLengthMiddleElementCopy);
        int lastBoxIndex = boxProcessor.binarySearch(sortedOddLengthArray, sortedOddLengthLastElementCopy);

        // Assert
        assertThat(firstBoxIndex, equalTo(ODD_LENGTH_FIRST_INDEX));
        assertThat(middleBoxIndex, equalTo(ODD_LENGTH_MIDDLE_INDEX));
        assertThat(lastBoxIndex, equalTo(ODD_LENGTH_LAST_INDEX));
    }

    @Test
    public void binarySearchFindsBoxInSingleElementArray() {
        // Arrange
        Box boxCopy = new Box(singleElementArray[0]);

        // Act
        int foundIndex = boxProcessor.binarySearch(singleElementArray, boxCopy);

        // Assert
        assertThat(foundIndex, equalTo(0));
    }

    @Test
    public void binarySearchDoesNotFindBoxThatIsNotInSortedArray() {
        // Arrange
        Box[] newOddLengthArray = Arrays.copyOf(sortedEvenLengthArray, sortedEvenLengthArray.length - 1);
        Box boxNotInNewOddLengthArray = sortedEvenLengthLastElementCopy;
        Box[] newEvenLengthArray = Arrays.copyOf(sortedOddLengthArray, sortedOddLengthArray.length - 1);
        Box boxNotInNewEvenLengthArray = sortedOddLengthLastElementCopy;

        // Act
        int boxNotInNewEvenArrayIndex = boxProcessor.binarySearch(
            newEvenLengthArray, boxNotInNewEvenLengthArray);
        int boxNotInNewOddArrayIndex = boxProcessor.binarySearch(
            newOddLengthArray, boxNotInNewOddLengthArray);

        // Assert
        assertThat(boxNotInNewOddArrayIndex, equalTo(BOX_NOT_FOUND_INDEX));
        assertThat(boxNotInNewOddArrayIndex, equalTo(BOX_NOT_FOUND_INDEX));
    }

    /**
     * Tests for binarySearch(List<Box>)
     */

    @Test
    public void binarySearchFindsBoxWhenItisInSortedEvenLengthList() {
        fail("Not implemented");
    }

    @Test
    public void binarySearchFinsBoxWhenItisInSortedOddLengthList() {
        fail("Not implemented");
    }

    @Test
    public void binarySearchDoesNotFindBoxThatIsNotInSortedList() {
        fail("Not implemented");
    }

    @Test
    public void binarySearchFindsBoxInSingleElementList() {
        // Arrange
        Box boxCopy = new Box(singleElementList.get(0));

        // Act
        int foundIndex = boxProcessor.binarySearch(singleElementList, boxCopy);

        // Assert
        assertThat(foundIndex, equalTo(0));
    }

    /**
     * Helper methods for setting up the box collections.
     */

    /**
     * Generate a List of boxes with unique volumes.
     * The generation is deterministic.
     *
     * NOTE: If it is important that the list is unsorted, you have to verify
     * this yourself. The shorter the length, the larger a chance of it being
     * sorted.
     *
     * @param length Length of the generated List.
     * @return An array of Box.
     */
    private List<Box> generateUniqueBoxList(int length) {
        int[] dims = new int[]{1, 1, 1};
        List<Box> boxes = new ArrayList<Box>(length);
        for (int i = 0; i < length; i++) {
            Box box = new Box(dims[0], dims[1], dims[2]);
            boxes.add(box);
            dims[i % dims.length]++;
        }
        deterministicShuffle(boxes);
        return boxes;
    }

    /**
     * Deterministically shuffles a List of boxes.
     *
     * @param boxes A List of boxes.
     */
    private void deterministicShuffle(List<Box> boxes) {
        // Seeding the random generator ensures that the same sequence is
        // always generated.
        int arbitrarySeed = 1012039;
        Random random = new Random(arbitrarySeed);
        // Provide shuffle with the seeded Random to ensure deterministic shuffle
        Collections.shuffle(boxes, random);
    }
}
