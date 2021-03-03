public class QuicksortFixedPivot extends QuickSort {

    @Override
    public void sort(int[] v) {
        quicksortFixedPivot(v, 0, v.length - 1);
    }

    /**
     * sorts the list with fixed pivot
     * @param v the list to sort
     * @param lo first elem
     * @param hi last elem
     */
    private void quicksortFixedPivot(int[] v, int lo, int hi) {
        if (lo < hi) {
            int pivot = fixedPartition(v, lo, hi);
            quicksortFixedPivot(v, lo, pivot - 1);
            quicksortFixedPivot(v, pivot + 1, hi);
        }
    }
}
