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
            // Selects middle elem as pivot
            final int pivot = v[(lo + hi) / 2];

            int[] mid = partition(v, lo, hi, pivot);
            //int mid = (partition[0] + partition[1]) / 2;

            quicksortFixedPivot(v, lo, mid[0] - 1);
            quicksortFixedPivot(v, mid[1] + 1, hi);
        }
    }
}
