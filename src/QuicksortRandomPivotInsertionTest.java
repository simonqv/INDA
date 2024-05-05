public class QuicksortRandomPivotInsertionTest extends IntSorterTest{
    @Override
    protected IntSorter getIntSorter() {
        return new QuicksortRandomPivotInsertion();
    }
}
