 import org.junit.Test;
 import org.junit.Before;
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
     /**
      * Returns an implementation of the IntSorter interface. Extending classes
      * must override this method.
      *
      * @return An implementation of IntSorter.
      */
     protected abstract IntSorter getIntSorter();

     @Before
     public void setUp() {
     }
 }
