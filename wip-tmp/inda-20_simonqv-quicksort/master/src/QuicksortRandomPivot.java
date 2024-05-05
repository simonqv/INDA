public class QuicksortRandomPivot extends QuickSort {
    @Override
    public void sort(int[] v) {
        quicksortRandomPivot(v, 0, v.length - 1);
    }

    /**
     * Sorts the list with random pivot
     * @param v the list to sort
     * @param lo the first element
     * @param hi the last element
     */
    private void quicksortRandomPivot(int[] v, int lo, int hi) {
        if (lo < hi) {
            final int pivot = randomPivot(v, lo, hi);

            int[] mid = partition(v, lo, hi, pivot);
            //int mid = (partition[0] + partition[1]) / 2;

            quicksortRandomPivot(v, lo, mid[0] - 1);
            quicksortRandomPivot(v, mid[1] + 1, hi);
        }
    }
}
