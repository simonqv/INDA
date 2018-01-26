import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;

/**
 * Test for the HashSet implementation of the Set interface. Runs both the
 * SetTest tests, as well as tests specific to hashing.
 *
 * @author Simon Larsén
 * @version 2018-01-15
 */
public class HashSetTest extends SetTest {
    private Set<SingleHashUnequal> uniqueObjsEqualHashesSet;
    private SingleHashUnequal[] uniqueObjsWithEqualHashes;

    /**
     * Returns an implementation of Set that can hold at least 'minCapacity'
     * Integers.
     *
     * @param minCapacity The least amount of elements the Set must be able to
     * hold.
     * @return An implementation of Set.
     */
    protected Set<Integer> getIntegerSet(int minCapacity) {
        return new HashSet<Integer>(minCapacity);
    }

    @Override
    @Before
    public void setUp() {
        // We are overriding the setUp method of SetTest, so we need to call
        // it explicitly to not break everything.
        super.setUp();

        int numDummies = 10;
        uniqueObjsWithEqualHashes = new SingleHashUnequal[numDummies];
        uniqueObjsEqualHashesSet = new HashSet<SingleHashUnequal>(numDummies*2);
        for (int i = 0; i < numDummies; i++) {
            SingleHashUnequal dummy = new SingleHashUnequal();
            uniqueObjsEqualHashesSet.add(dummy);
            uniqueObjsWithEqualHashes[i] = dummy;
        }
    }

    @Test
    public void containsIsTrueForAddedElementsWithEqualHashes() {
        // Arrange
        Arrays.stream(uniqueObjsWithEqualHashes)
            // Act
            .map(elem -> uniqueObjsEqualHashesSet.contains(elem))
            // Assert
            .forEach(contained -> assertThat(contained, is(true)));
    }
    
    @Test
    public void addIsTrueForUniqueElementsWithEqualHashes() {
        // Arrange
        int safeCapacity = 2*uniqueObjsWithEqualHashes.length;
        Set<SingleHashUnequal> set = new HashSet<SingleHashUnequal>(safeCapacity);
        Arrays.stream(uniqueObjsWithEqualHashes)
            // Act
            .map(elem -> set.add(elem))
            // Assert
            .forEach(wasAdded -> assertThat(wasAdded, is(true)));
    }

    @Test
    public void addUniqueElementsWithEqualHashesIncrementsSize() {
        // Arrange
        int safeCapacity = 2*uniqueObjsWithEqualHashes.length; 
        Set<SingleHashUnequal> set = new HashSet<SingleHashUnequal>(safeCapacity);
        int expectedSize = 0;
        for (SingleHashUnequal elem : uniqueObjsWithEqualHashes) {
            expectedSize++;
            // Act
            set.add(elem);
            // Assert
            assertThat(set.size(), equalTo(expectedSize));
        }
    }

    @Test
    public void removeUniqueElementsWithEqualHashesDecrementsSize() {
        fail("Not implemented!");
    }

    /**
     * A helper class for testing hash collisions. Instances equal only
     * themselves, and all instances have the same hashCode.
     */
    private static class SingleHashUnequal {
        private static final int HASH = 0;

        @Override
        public boolean equals(Object o) {
            return this == o;
        }

        @Override
        public int hashCode() {
            return HASH;
        }
    }
}
