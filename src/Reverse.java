import java.util.ArrayList;
import java.util.List;
/**
 * A class for reversing List and array types.
 *
 * @author PUT YOUR NAME HERE
 * @version 2017-08-09
 */
public class Reverse {

    /**
     * Return a reversed copy of the argument array.
     * The passed array is NOT mutated.
     *
     * @param array An array.
     * @return A reversed copy of array.
     */
    public int[] reversed(int[] array) {
        int[] reversed = new int[array.length];
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length-1-i];
            counter ++;
        }
        System.out.println(counter);
        return reversed;
    }

    /**
     * Return a reversed copy of the argument List.
     * The passed List is NOT mutated.
     *
     * @param list A List.
     * @return A reversed copy of list.
     */
    public List<Integer> reversed(List<Integer> list) {
        List<Integer> reversed = new ArrayList<>(list);
        int counter = 0;
        for (int i = 0; i < list.size(); i++) {
            reversed.set(i, list.get(list.size()-1-i));
            counter ++;
        }
        System.out.println("Antal loopar" + counter);
        return reversed;
    }
}
