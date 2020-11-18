import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListProcessor {
    private final Random rand = new Random();

    /**
     * Copies an array
     * @param array The array to copy
     * @return copy of the array
     */
    public int[] copyArray(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    /**
     * Copies a list, using the copyArray above
     * @param list The list to copy
     * @return copy of the list
     */
    public List<Integer> copyList(List<Integer> list) {
        return toList(copyArray(toArray(list)));

    }

    /**
     * converts array to list
     * @param array the array to convert
     * @return converted list
     */
    public List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }
        return list;
    }

    /**
     * converts list to array
     * @param list the list to convert
     * @return converted array
     */
    public int[] toArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    /**
     * creates sequence from one integer to another
     * @param from the integer to start at
     * @param to the integer to stop at
     * @return sequence as an array
     */
    public int[] arraySequence(int from, int to) {
        if (from > to) {
            throw new IllegalArgumentException("Lower bound greater than upper bound.");
        }
        int len = to - from;
        int[] seq = new int[len];
        for (int i = 0; i < seq.length; i++) {
            seq[i] = i + from;
        }
        return seq;
    }

    /**
     * creates sequence from one integer to another using the arraySequence above
     * @param from the integer to start at
     * @param to the integer to stop at
     * @return sequence as a list
     */
    public List<Integer> listSequence(int from, int to) {
        return toList(arraySequence(from, to));
    }

    /**
     * shuffles the numbers in a list
     * @param numbers the numbers to shuffle
     * @return shuffled list
     */
    public List<Integer> shuffled(List<Integer> numbers) {
        return toList(shuffled(toArray(copyList(numbers))));
    }

    /**
     * shuffles the numbers in a list
     * @param numbers the numbers to shuffle
     * @return shuffled array
     */
    public int[] shuffled(int[] numbers) {
        int[] num_copy = copyArray(numbers);
        int ind, x;
        for (int i = 0; i < num_copy.length; i++) {
            ind = rand.nextInt(num_copy.length);
            x = num_copy[ind];
            num_copy[ind] = num_copy[i];
            num_copy[i] = x;
        }
        return num_copy;
    }

    /**
     * iterative way to add every element in an array
     * @param numbers the numbers to sum
     * @return the sum
     */
    public int sumIterative(int[] numbers) {
        int acc = 0;

        for (int number : numbers) {
            acc += number;
        }
        return acc;
    }

    /**
     * iterative way to add every element in a list, using the sumIterative above
     * @param numbers the numbers to sum
     * @return the sum
     */
    public int sumIterative(List<Integer> numbers) {
        return sumIterative(toArray(numbers));
    }

    /**
     * Recursive method to sum
     * @param numbers the numbers to sum
     * @param length how many elements to add together
     * @return the sum
     */
    public int sumRecursiveCounter(int[] numbers, int length) {
        if (length <= 0) {
            return 0;
        }
        return (sumRecursiveCounter(numbers, length - 1) + numbers[length -1]);
    }

    /**
     * sum of array
     * @param numbers array to sum
     * @return the sum
     */
    public int sumRecursive(int[] numbers) {
        return sumRecursiveCounter(numbers, numbers.length);
    }

    /**
     * sum of list
     * @param numbers list to sum
     * @return the sum
     */
    public int sumRecursive(List<Integer> numbers) {
        return sumRecursive(toArray(numbers));
    }

}