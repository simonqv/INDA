import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An example demonstrating the effects of just-in-time compilation
 * on time measurements.
 *
 * @author Stefan Nilsson
 * @version 2011-02-07
 */
public final class TimingExample {
    /**
     * If you're using a JVM with just-in-time compilation,
     * chanses are that the first reported time is much
     * larger than the rest: during most of the first
     * invocation of the sum() method, the code has yet
     * to be compiled and optimized.
     */
    public static void main(String[] args) {
        final int reps = 100;
        final int n = 1000000;
        final long[] timeList = new long[reps];
        long min = -1;
        long max = 0;
        long avg = 0;
        final Stopwatch clock = new Stopwatch();
        for (int l = 0; l < 100; l++) {
            {
                long dummy = sum(n);
            }
        }

        for (int i = 0; i < reps; i++) {
            clock.reset().start();
            {
                long dummy = sum(n);
            }
            long time = clock.stop().nanoseconds();
            timeList[i] = time;

            if (min > time || min == -1) {
                min = time;
            }
            if (max < time) {
                max = time;
            }
            //System.out.printf("Time to run sum(%d): %d ms%n", n, time);

        }


        double avg1 = Arrays.stream(timeList).average().orElseThrow();
        System.out.println(Arrays.toString(timeList));
        System.out.println("Old average = " + avg1);
        System.out.println("Old minimum = " + min +
                "\nOld maximum = " + max);

        long[] withoutAnomalies = Arrays.stream(timeList)
                .filter(x -> !(x > avg1 * 1.5))
                .toArray();

        double newAvg =
                Arrays.stream(withoutAnomalies)
                .average()
                .orElseThrow();

        long newMax = Arrays.stream(withoutAnomalies).max().orElseThrow();
        long newMin = Arrays.stream(withoutAnomalies).min().orElseThrow();

        System.out.println("\n" + Arrays.toString(withoutAnomalies));
        System.out.println("Minimum = " + newMin +
                "\nMaximum = " + newMax +
                "\nAverage = " + newAvg);




    }

    /**
     * Returns the sum 1 + 2 + ... + n.
     */
    private static long sum(int n) {
       long sum = 0;
       for (int i = 1; i <= n; i++) {
           sum += i;
       }
       return sum;
   }
}
