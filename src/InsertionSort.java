public class InsertionSort implements IntSorter {

    @Override
    public void sort(int[] v) {
        int j;
        int temp;
        for (int i = 1; i < v.length; i++) {
            j = i;
            while (j > 0 && v[j] < v[j - 1]) {
                temp = v[j];
                v[j] = v[j - 1];
                v[j - 1] = temp;
                j--;
            }
        }
    }
}
