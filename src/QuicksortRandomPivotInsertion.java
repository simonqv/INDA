public class QuicksortRandomPivotInsertion extends QuickSort{


    @Override
    public void sort(int[] v) {
        quicksortRandomPivotInsertion(v, 0, v.length - 1);
    }

    /**
     * Sorts the list with random pivot that cuts off to insertion sort
     * @param v the list sort
     * @param lo the first element
     * @param hi the last element
     */
    private void quicksortRandomPivotInsertion(int[] v, int lo, int hi) {
        int k = 10;
        if (lo < hi) {
            if (v.length < k) {
                new InsertionSort().sort(v);
            } else {
                int pivot = randomPartition(v, lo, hi);
                quicksortRandomPivotInsertion(v, lo, pivot - 1);
                quicksortRandomPivotInsertion(v, pivot + 1, hi);
            }
        }
    }
}
