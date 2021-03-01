import java.util.Arrays;
import java.util.Random;

public class QuicksortRandomPivot extends Quicksort {
    @Override
    public void sort(int[] v) {
        quicksortRandomPivot(v, 0, v.length - 1);
    }

    private void quicksortRandomPivot(int[] v, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(v, lo, hi);
            quicksortRandomPivot(v, lo, pivot - 1);
            quicksortRandomPivot(v, pivot + 1, hi);
        }
    }

    // Random
    private int partition(int[] v, int lo, int hi) {
        Random rand = new Random();

        // Creates random int
        int pivotInd = rand.nextInt((hi - lo) + 1) + lo;

        // Use random int to find pivot
        int pivot = v[pivotInd];

        // Place the pivot in the end
        swap(v, pivotInd, hi);
        return partition(v, lo, hi, pivot);
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{4, 7, 5, 8, 6};
        System.out.println("test1:        " + Arrays.toString(test1));
        new QuicksortRandomPivot().sort(test1);
        System.out.println("test1 sorted: " + Arrays.toString(test1));


        int[] test2 = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println("test2:        " + Arrays.toString(test2));
        new QuicksortRandomPivot().sort(test2);
        System.out.println("test2 sorted: " + Arrays.toString(test2));

        int[] test3 = new int[]{10,9,8,7,6,5,4,3,2,1};
        System.out.println("test3:        " + Arrays.toString(test3));
        new QuicksortRandomPivot().sort(test3);
        System.out.println("test3 sorted: " + Arrays.toString(test3));

        int[] test4 = new int[]{1,8,3,7,2,6};
        System.out.println("test4:        " + Arrays.toString(test4));
        new QuicksortRandomPivot().sort(test4);
        System.out.println("test4 sorted: " + Arrays.toString(test4));



    }
}
