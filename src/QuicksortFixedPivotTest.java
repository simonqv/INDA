public class QuicksortFixedPivotTest extends IntSorterTest {
    @Override
    protected IntSorter getSorter() {
        return new QuicksortFixedPivot();
    }
}
