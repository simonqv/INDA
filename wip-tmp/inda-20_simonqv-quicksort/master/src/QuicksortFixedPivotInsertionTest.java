public class QuicksortFixedPivotInsertionTest extends IntSorterTest{
    @Override
    protected IntSorter getIntSorter() {
        return new QuicksortFixedPivotInsertion();
    }
}
