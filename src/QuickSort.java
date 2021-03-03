import java.util.Random;

public abstract class QuickSort implements IntSorter {
    /**
     *
     * @param v the list to sort
     * @param lo first elem in v
     * @param hi last elem in v
     * @param pivot the pivot to compare too
     * @return the index of the pivot in its correct place
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

    /**
     * Decides which of 3 to use as pivot. I think this counts as fixed.
     * @param v the list to sort
     * @param lo first elem
     * @param hi last elem
     * @return index of pivot in correct place.
     */
    protected int fixedPartition(int[] v, int lo, int hi) {
        int medInd = median(v, lo, hi);
        int pivot = v[medInd];
        swap(v, medInd, hi);

        return partition(v, lo, hi, pivot);
    }

    /**
     * Takes a random index and chooses that as pivot
     * @param v the list to sort
     * @param lo first elem
     * @param hi last elem
     * @return the index of the pivot in its correct place
     */
    protected int randomPartition(int[] v, int lo, int hi) {
        Random rand = new Random();

        // Creates random int
        int pivotInd = rand.nextInt((hi - lo) + 1) + lo;

        // Use random int to find pivot
        int pivot = v[pivotInd];

        // Place the pivot in the end
        swap(v, pivotInd, hi);
        return partition(v, lo, hi, pivot);
    }

    /**
     * Finds the median
     * @param v the list to sort, needed for index
     * @param lo first elem in v
     * @param hi last elem in v
     * @return the index of the median value
     */
    protected int median(int[] v, int lo, int hi) {
        int f = v[lo];
        int l = v[hi];
        int m = v[hi - ((hi-lo)/2)];
        int med = Math.max(Math.min(f, m), Math.min(Math.max(f, m), l));
        if (med == f) {
            return lo;
        } else if (med == l) {
            return hi;
        } else {
            return hi - ((hi-lo)/2);
        }
    };

    /**
     * Swaps two elements in the list
     * @param v the list
     * @param i the first element
     * @param j the second element
     */
    protected void swap(int[] v, int i, int j) {
        int temp = v[j];
        v[j] = v[i];
        v[i] = temp;
    }
}
