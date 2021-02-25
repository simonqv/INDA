public class QuicksortRandomPivotInsertionTest extends IntSorterTest {
    @Override
    protected IntSorter getSorter() {
        return new QuicksortRandomPivotInsertion();
    }
}
