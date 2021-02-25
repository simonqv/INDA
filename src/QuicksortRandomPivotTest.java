public class QuicksortRandomPivotTest extends IntSorterTest {
    @Override
    protected IntSorter getSorter() {
        return new QuicksortRandomPivot();
    }
}
