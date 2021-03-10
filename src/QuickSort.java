import java.util.Random;

public abstract class QuickSort implements IntSorter {
    /**
     *
     * @param v the list to sort
     * @param lo first elem in v
     * @param hi last elem in v
     * @param pivot the pivot to compare too
     * @return an array with the low and high index of the middle section of the array
     */
    final protected int[] partition(int[] v, int lo, int hi, int pivot) {
        int mid = lo;
        while (mid <= hi) {
            int a = v[mid];
            if (a < pivot) {
                swap(v, mid, lo);
                lo++;
                mid++;
            } else if (a == pivot) {
                mid++;
            } else {
                swap(v, mid, hi);
                hi--;
            }
        }
        return new int[]{lo, hi};
    }

    /**
     * Takes a random index and chooses that as pivot
     * @param v the list to sort
     * @param lo first elem
     * @param hi last elem
     * @return the index of the pivot in its correct place
     */
    final protected int randomPivot(int[] v, int lo, int hi) {
        Random rand = new Random();

        // Creates random int
        int pivotInd = rand.nextInt((hi - lo) + 1) + lo;

        // Use random int to find pivot
        int pivot = v[pivotInd];

        return  pivot;
    }


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
