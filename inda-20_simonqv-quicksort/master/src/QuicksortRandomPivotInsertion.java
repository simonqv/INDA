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
        int k = 20;
        if (lo < hi) {
            if (v.length < k) {
                new InsertionSort().sort(v);
            } else {
                final int pivot = randomPivot(v, lo, hi);
                int[] mid = partition(v, lo, hi, pivot);
                //int mid = (partition[0] + partition[1]) / 2;
                quicksortRandomPivotInsertion(v, lo, mid[0] - 1);
                quicksortRandomPivotInsertion(v, mid[1] + 1, hi);
            }
        }
    }
}
