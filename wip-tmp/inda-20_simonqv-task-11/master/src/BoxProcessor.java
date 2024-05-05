import java.util.List;

public class BoxProcessor {

    /**
     * sorts this array
     *
     * @param array array to sort
     */
    public void sort(Box[] array) {
        int j;
        Box temp;
        for (int i = 1; i < array.length; i++) {
            j = i;
            while (j > 0 && array[j].compareTo(array[j - 1]) < 0) {
                temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                j--;
            }
        }
    }

    /**
     * sorts this list
     *
     * @param list list to sort
     */
    public void sort(List<Box> list) {
        int j;
        Box temp;
        for (int i = 1; i < list.size(); i++) {
            j = i;
            while (j > 0 && list.get(j).compareTo(list.get(j - 1)) < 0) {
                temp = list.get(j);
                list.set(j, list.get(j - 1));
                list.set(j-1, temp);
                j--;
            }
        }
    }

    /**
     * Brute force search for box in array
     *
     * @param array array to look for box in
     * @param box box to find in array
     * @return index of box
     */
    public int sequentialSearch(Box[] array, Box box) {
        for (int ind = 0; ind < array.length; ind++) {
            if (array[ind].compareTo(box) == 0) {
                return ind;
            }
        }
        return -1;
    }

    /**
     * Brute force search for box in list
     *
     * @param list list to look for box in
     * @param box box to find in list
     * @return index of box
     */
    public int sequentialSearch(List<Box> list, Box box) {
        for (int ind = 0; ind < list.size(); ind++) {
            if (list.get(ind).compareTo(box) == 0) {
                return ind;
            }
        }
        return -1;
    }

    /**
     * "divide and conquer" search for box in array
     *
     * @param array array to search in
     * @param box box to find in array
     * @return index of box
     */
    public int binarySearch(Box[] array, Box box) {
        int first = 0;
        int last = array.length - 1;
        int middle;
        while (first <= last) {
            middle = (first + last) / 2;
            if (box.compareTo(array[middle]) == 0) {
                return middle;
            } else if (box.compareTo(array[middle]) < 0) { // lower half
                last = middle - 1;
            } else if (box.compareTo(array[middle]) > 0) { // upper half
                first = middle + 1;
            }
        }
        return -1;
    }

    /**
     * "divide and conquer" search for box in list
     *
     * @param list list to search in
     * @param box box to find in list
     * @return index of box
     */
    public int binarySearch(List<Box> list, Box box) {
        int first = 0;
        int last = list.size() - 1;
        int middle;
        while (first <= last) {
            middle = (first + last) / 2;
            if (list.get(middle).compareTo(box) == 0) {
                return middle;
            } else if (box.compareTo(list.get(middle)) < 0) {
                last = middle - 1;
            } else if (box.compareTo(list.get(middle)) > 0) {
                first = middle + 1;
            }
        }
        return -1;
    }
}
