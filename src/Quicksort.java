import java.util.Random;

public abstract class Quicksort implements IntSorter {
/*
    protected int fixedPartition(int[] v, int lo, int hi) {
        int pivot = v[hi];
        return partition(v, lo, hi, pivot);
    }
*/

    protected int partition(int[] v, int lo, int hi, int pivot) {
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (v[j] <= pivot) {
                i++;
                swap(v, j, i);
            }
        }
        swap(v, i + 1, hi);
        return i+1;
    }

    protected void swap(int[] v, int i, int j) {
        int temp = v[j];
        v[j] = v[i];
        v[i] = temp;
    }


}
