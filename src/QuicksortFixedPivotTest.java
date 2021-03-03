public class QuicksortFixedPivotTest extends IntSorterTest{
    @Override
    protected IntSorter getIntSorter() {
        return new QuicksortFixedPivot();
    }
}
