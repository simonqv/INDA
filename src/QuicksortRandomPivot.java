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
            int pivot = randomPartition(v, lo, hi);
            quicksortRandomPivot(v, lo, pivot - 1);
            quicksortRandomPivot(v, pivot + 1, hi);
        }
    }
}
