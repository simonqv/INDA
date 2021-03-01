import java.util.Arrays;

public class QuicksortFixedPivot extends Quicksort {

    @Override
    public void sort(int[] v) {
        quicksortFixedPivot(v, 0, v.length - 1);
    }

    private void quicksortFixedPivot(int[] v, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(v, lo, hi, v[hi]);
            quicksortFixedPivot(v, lo, pivot - 1);
            quicksortFixedPivot(v, pivot + 1, hi);
        }
    }




    public static void main(String[] args) {
        int[] test1 = new int[]{4, 7, 5, 8, 6};
        System.out.println("test1:        " + Arrays.toString(test1));
        new QuicksortFixedPivot().sort(test1);
        System.out.println("test1 sorted: " + Arrays.toString(test1));

        int[] test2 = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println("test2:        " + Arrays.toString(test2));
        new QuicksortFixedPivot().sort(test2);
        System.out.println("test2 sorted: " + Arrays.toString(test2));

        int[] test3 = new int[]{10,9,8,7,6,5,4,3,2,1};
        System.out.println("test3:        " + Arrays.toString(test3));
        new QuicksortFixedPivot().sort(test3);
        System.out.println("test3 sorted: " + Arrays.toString(test3));

        int[] test4 = new int[]{1,8,3,7,2,6};
        System.out.println("test4:        " + Arrays.toString(test4));
        new QuicksortFixedPivot().sort(test4);
        System.out.println("test4 sorted: " + Arrays.toString(test4));

    }
}
