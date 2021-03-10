import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Timing {
    final static Data[] randomData = {
            new Data(100, 100, Data.Order.RANDOM),
            new Data(1000, 1000, Data.Order.RANDOM),
            new Data(10000, 10000, Data.Order.RANDOM),
            new Data(100000, 100000, Data.Order.RANDOM),
            new Data(1000000, 1000000, Data.Order.RANDOM)
    };
    final static Data[] sortedData = {
            new Data(100, 100, Data.Order.ASCENDING),
            new Data(1000, 1000, Data.Order.ASCENDING),
            new Data(10000, 10000, Data.Order.ASCENDING),
            new Data(100000, 100000, Data.Order.ASCENDING),
            new Data(1000000, 1000000, Data.Order.ASCENDING)
    };
    final static Data[] reversedData = {
            new Data(100, 100, Data.Order.DESCENDING),
            new Data(1000, 1000, Data.Order.DESCENDING),
            new Data(10000, 10000, Data.Order.DESCENDING),
            new Data(100000, 100000, Data.Order.DESCENDING),
            new Data(1000000, 1000000, Data.Order.DESCENDING)
    };
    final static Data[] equalData = {
            new Data(100, 1, Data.Order.RANDOM),
            new Data(1000, 1, Data.Order.RANDOM),
            new Data(10000, 1, Data.Order.RANDOM),
            new Data(100000, 1, Data.Order.RANDOM),
            new Data(1000000, 1, Data.Order.RANDOM)
    };



    public static long timeQuicksort(Data data, Stopwatch clock, IntSorter sorter) {
        long[] times = new long[10];
        // Warmup run
        for (int i = 0; i < 5; i++) {
            {
                sorter.sort(data.get());
            }
        }

        // Real run
        for (int i = 0; i < 10; i++) {
            clock.reset().start();
            sorter.sort(data.get());
            times[i] = clock.stop().nanoseconds();
        }
        // Get average
        double avg = Arrays.stream(times).average().orElseThrow();
        // Remove anomalies
        long[] withoutAnomalies = Arrays.stream(times)
                .filter(x -> !(x > avg * 1.5))
                .toArray();
        // Return new average
        return (long) Arrays.stream(withoutAnomalies).average().orElseThrow();
    }

    public static void checker(Stopwatch clock, Data[] data) {
        long[] fixedPivotTimes = new long[5];
        long[] fixedPivotInsertionTimes = new long[5];
        long[] randomPivotTimes = new long[5];
        long[] randomPivotInsertionTimes = new long[5];
        long[] javaSortTimes = new long[5];

        for (int i = 0; i < data.length; i++) {

            fixedPivotTimes[i] = timeQuicksort(data[i], clock, new QuicksortFixedPivot());
            fixedPivotInsertionTimes[i] = timeQuicksort(data[i], clock, new QuicksortFixedPivotInsertion());
            randomPivotTimes[i] = timeQuicksort(data[i], clock, new QuicksortRandomPivot());
            randomPivotInsertionTimes[i] = timeQuicksort(data[i], clock, new QuicksortRandomPivotInsertion());
            javaSortTimes[i] = timeQuicksort(data[i], clock, v -> Arrays.sort(v));
        }

        System.out.println("Fixed Pivot Times:                  " + Arrays.toString(fixedPivotTimes));
        System.out.println("Fixed Pivot With Insertion Times:   " + Arrays.toString(fixedPivotInsertionTimes));
        System.out.println("Random Pivot Times:                 " + Arrays.toString(randomPivotTimes));
        System.out.println("Random Pivot With Insertion Times:  " + Arrays.toString(randomPivotInsertionTimes));
        System.out.println("Java sort                           " + Arrays.toString(javaSortTimes));
    }


    public static void main(String[] args) {
        final Stopwatch clock = new Stopwatch();

        System.out.println("Random Data:");
        checker(clock, randomData);
        System.out.println("\nSorted Data:");
        checker(clock, sortedData);
        System.out.println("\nReversed Data:");
        checker(clock, reversedData);
        System.out.println("\nEqual Data:");
        checker(clock, equalData);


        timeQuicksort(randomData[2], clock, new InsertionSort());
        System.out.println("\nInsertion sort:");
        long[] randomTimeInsertion = new long[5];
        long[] sortedTimeInsertion = new long[5];
        long[] reversedTimeInsertion = new long[5];
        long[] equalTimeInsertion = new long[5];
        for (int i = 0; i < 4; i++) {
            randomTimeInsertion[i] = timeQuicksort(randomData[i], clock, new InsertionSort());
        }
        System.out.println("Random Data:    " + Arrays.toString(randomTimeInsertion));
        for (int i = 0; i < 5; i++) {
            sortedTimeInsertion[i] = timeQuicksort(sortedData[i], clock, new InsertionSort());
        }
        System.out.println("Sorted Data:    " + Arrays.toString(sortedTimeInsertion));
        for (int i = 0; i < 4; i++) {
            reversedTimeInsertion[i] = timeQuicksort(reversedData[i], clock, new InsertionSort());
        }
        System.out.println("Reversed Data:  " + Arrays.toString(reversedTimeInsertion));
        for (int i = 0; i < 5; i++) {
            equalTimeInsertion[i] = timeQuicksort(equalData[i], clock, new InsertionSort());
        }
        System.out.println("Equal Data:     " + Arrays.toString(equalTimeInsertion));


    }
}


