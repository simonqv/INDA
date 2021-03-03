 import org.junit.Test;
 import org.junit.Before;

 import java.util.Arrays;

 import static org.junit.Assert.*;

 import static org.hamcrest.MatcherAssert.assertThat;
 import static org.hamcrest.CoreMatchers.*;

 /**
  * Abstract test class for  implementations.
  *
  * Implementing test classes must override the getIntSorter method.
  *
  * @author Simon Larsén
  * @version 2018-01-16
  */
 public abstract class IntSorterTest {
     Data evenRandom;
     Data oddRandom;
     Data evenAscending;
     Data oddAscending;
     Data evenDescending;
     Data oddDescending;
     Data oneElem;
     Data sameElem;
     Data empty;
     Data veryLarge;

     /**
      * Returns an implementation of the IntSorter interface. Extending classes
      * must override this method.
      *
      * @return An implementation of IntSorter.
      */
     protected abstract IntSorter getIntSorter();

     @Before
     public void setUp() {
         evenRandom = new Data(2000, 20, Data.Order.RANDOM);
         oddRandom = new Data(2001, 20, Data.Order.RANDOM);
         evenAscending = new Data(1000000, 10000000, Data.Order.ASCENDING);
         oddAscending = new Data(2001, 5, Data.Order.ASCENDING);
         evenDescending = new Data(2000, 5, Data.Order.DESCENDING);
         oddDescending = new Data(2001, 5, Data.Order.DESCENDING);
         oneElem = new Data(1, 1, Data.Order.RANDOM);
         sameElem = new Data(10000, 1, Data.Order.RANDOM);
         empty = new Data(0, 20, Data.Order.RANDOM);
         veryLarge = new Data(10000000, 100000, Data.Order.RANDOM);
     }

     @Test
     public void quicksortHasNoEffectWhenArrayIsEmpty() {
         // Arrange
         int[] emptyArray = empty.get();
         // Act
         getIntSorter().sort(emptyArray);
         // Assert
         assertThat(emptyArray.length, equalTo(0));
     }

     @Test
     public void quicksortHasNoEffectWhenArrayHasOneElement() {
         // Arrange
         int[] actual = oneElem.get();
         int[] expected = actual.clone();
         // Act
         getIntSorter().sort(actual);
         // Assert
         assertThat(actual, equalTo(expected));
     }

     @Test
     public void quicksortMultipleRandomElementArrayGivesCorrectOrdering() {
         // Arrange
         int[] actualEven = evenRandom.get();
         int[] expectedEven = actualEven.clone();
         int[] actualOdd = oddRandom.get();
         int[] expectedOdd = actualOdd.clone();
         // Act
         getIntSorter().sort(actualEven);
         Arrays.sort(expectedEven);
         getIntSorter().sort(actualOdd);
         Arrays.sort(expectedOdd);
         // Assert
         assertThat(actualEven, equalTo(expectedEven));
         assertThat(actualOdd, equalTo(expectedOdd));
     }

     @Test
     public void quicksortMultipleAscendingElementArrayGivesCorrectOrdering() {
         // Arrange
         int[] actualEven = evenAscending.get();
         int[] expectedEven = actualEven.clone();
         int[] actualOdd = oddAscending.get();
         int[] expectedOdd = actualOdd.clone();
         // Act
         getIntSorter().sort(actualEven);
         Arrays.sort(expectedEven);
         getIntSorter().sort(actualOdd);
         Arrays.sort(expectedOdd);
         // Assert
         assertThat(actualEven, equalTo(expectedEven));
         assertThat(actualOdd, equalTo(expectedOdd));
     }

     @Test
     public void quicksortMultipleDescendingElementArrayGivesCorrectOrdering() {
         // Arrange
         int[] actualEven = evenDescending.get();
         int[] expectedEven = actualEven.clone();
         int[] actualOdd = oddDescending.get();
         int[] expectedOdd = actualOdd.clone();
         // Act
         getIntSorter().sort(actualEven);
         Arrays.sort(expectedEven);
         getIntSorter().sort(actualOdd);
         Arrays.sort(expectedOdd);
         // Assert
         assertThat(actualEven, equalTo(expectedEven));
         assertThat(actualOdd, equalTo(expectedOdd));
     }

     @Test
     public void quicksortEqualElementsHasNoEffect() {
         // Arrange
         int[] equalElem = sameElem.get();
         int[] expected = equalElem.clone();
         // Act
         getIntSorter().sort(equalElem);
         Arrays.sort(expected);
         // Assert
         assertThat(equalElem, equalTo(expected));
     }

     @Test
     public void quicksortVeryLargeArrayGivesCorrectOrdering() {
         // Arrange
         int[] veryLargeArray = veryLarge.get();
         int[] expected = veryLargeArray.clone();
         // Act
         getIntSorter().sort(veryLargeArray);
         Arrays.sort(expected);
         // Assert
         assertThat(veryLargeArray, equalTo(expected));
     }

 }
