import java.util.Arrays;

public class QuicksortFixedPivotInsertion extends QuickSort{
    @Override
    public void sort(int[] v) {
        quicksortFixedPivotInsertion(v, 0, v.length - 1);
    }

    /**
     * sorts the list with fixed pivot that cuts off to insertion sort
     * @param v the list to sort
     * @param lo first elem
     * @param hi last elem
     */
    private void quicksortFixedPivotInsertion(int[] v, int lo, int hi) {
        int k = 20;
        if (lo < hi) {
            // if the list is shorter than k, cut off to insertion sort
            if (v.length < k) {
                new InsertionSort().sort(v);
            // else continue with quicksort
            } else {
                // Selects middle element as pivot
                final int pivot = v[(lo + hi) / 2];

                int[] mid = partition(v, lo, hi, pivot);
                //int mid = (partition[0] + partition [1]) / 2;
                quicksortFixedPivotInsertion(v, lo, mid[0] - 1);
                quicksortFixedPivotInsertion(v, mid[1] + 1, hi);
            }
        }
    }
}
