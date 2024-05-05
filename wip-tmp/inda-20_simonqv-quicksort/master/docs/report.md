# A Study of Quicksort

Simon Larspers Qvist
INDA Group limpor
Year 2021

## Characteristics and Complexity

The Quicksort algorithm was discovered in 1960 by Tony Hoare. Quicksort is a "divide and conquer" algorithm, 
which means that it continuously divides the problem into smaller problems. 
In the average case the time complexity is O(n log n), and in the worst case 
it is O(n^2). It is also space efficient because it sorts the list in place, i.e. it does not copy the array while sorting it.

## Variations of Quicksort

There are multiple ways to implement the quicksort algorithm. Four different versions have been
implemented here: two with a fixed pivot and two with a random pivot, both of them with variations where it cuts off to 
insertion sort in the end. The fixed pivot is selected to the middle element of the array. All the variations have been 
implemented with a dual pivot, a middle ground where elements that equals the pivot are placed. 

```
// Create random index for the pivot
int pivotInd = rand.nextInt((hi - lo) + 1) + lo;
```
> The way the random pivot is chosen.
```
// Selects middle elem as pivot
final int pivot = v[(lo + hi) / 2];
```
> The way the fixed pivot is chosen.
```
// if the list is shorter than k, cut off to insertion sort
if (v.length < k) {
new InsertionSort().sort(v);
```
> When to cut off to insertion sort.

#####Fixed Pivot
First selects the middle element as the pivot. After that it continues with the partition 
using the array, first element, last element and the pivot. The partition sorts the array, so 
the elements smaller than the pivot is to the left, the ones larger than the pivot to the right, 
and the ones equal the pivot in the "middle" (with the pivot). This then returns the lower and upper 
index of the "middle" part. Then the procedure repeats with the lower and upper part, where the 
new lower part is from the previous low to the lower part of the "middle" and vice versa.

#####Fixed Pivot Insertion
The same base as Fixed Pivot, see above, only difference is that it cuts off to insertion sort when the 
array or sub-array is too small. 

#####Random Pivot
The only difference from Fixed Pivot is that the pivot is randomized, see how in the code snippet above. 

#####Random Pivot Insertion
Again, the only differance is that the Random Pivot cuts off to insertion sort when the array is too small. 

#####Choosing cut-off
According to [this page](https://yourbasic.org/golang/quicksort-optimizations/) the cut-off usually works best at 
a length between 10 and 100. I tested some values to cut off at (10, 20, 50 and 100) but did not se a noteworthy
differance between them. The cut off at 10 seemed the best, it was slightly faster than the other ones. 


## Methodology

For the testing I wanted to make sure the order was correct after sorting, for both even and odd length arrays. 
I also tested that nothing happens if the array is empty and that an array with one kind of element, such as 
an array of only 1s, stays the same. I also tested a list with only one element, to check that it also stayed the same. 
Lastly a large array was tested, to see that it works. 

When testing the ordering of random, sorted and reversed list I didn't mind the size of the array, so I choose 
2000 and 2001 to get both even and odd length. For the list filled with the same element I choose a bigger list 
due to the fact that I had some problems with StackOverFlow with lists of equal elements. For the large array 
the size was 10000000 with some duplication allowed. 

Firstly I set up the data: evenRandom, oddRandom, evenAscending, oddAscending, evenDescending, 
oddDescending, oneElem, sameElem, empty, veryLarge. For each of the methods testing different things
I used the .get() method to create an array from the data. For the ones testing order, I copied the array 
and used my implementations of quicksort and javas sort, and compared the two to see if they were equal.

Example:
```
@Test
     public void quicksortMultipleRandomElementArrayGivesCorrectOrdering() {
         // Arrange
         int[] actualEven = evenRandom.get();
         int[] expectedEven = actualEven.clone();
         int[] actualOdd = oddRandom.get();
         int[] expectedOdd = actualOdd.clone();
         // Act
         getIntSorter().sort(actualEven);
         Arrays.sort(expectedEven);
         getIntSorter().sort(actualOdd);
         Arrays.sort(expectedOdd);
         // Assert
         assertThat(actualEven, equalTo(expectedEven));
         assertThat(actualOdd, equalTo(expectedOdd));
     }
```
> Here I test arrays of random elements with even and odd length.


After these, tests just measuring how long things take were made. Some warm up runs were executed to 
prevent JVM warm up anomalies. Then sorting was executed multiple times on each sort, and an average was calculated. 
If one run diverged too much from the average it was removed, and a new average was calculated. This average was then returned 
and used in the data for comparison. 

## Results

Below are tables with data from the timing tests. Below the tables are charts with visualisation of the data.

| Test 1: Random Data | nano seconds  | nano seconds| nano seconds          | nano seconds | nano seconds           | nano seconds  |
| ------------------  | ------------- | ----------- | --------------------- | ------------ | ---------------------- | ------------- |
| Problem Size        | InsertionSort | Fixed Pivot | Fixed Pivot Insertion | Random Pivot | Random Pivot Insertion | Arrays.sort † |
| 100                 | 2911          | 2405        | 2109                  | 8899         | 9055                   | 2687          |
| 1000                | 245273        | 63245       | 63053                 | 107000       | 134717                 | 71272         |
| 10000               | 22701286      | 1154166     | 1103623               | 1301983      | 1335044                | 607327        |
| 100000              | 2274339139    | 12648027    | 12938399              | 15190963     | 15350500               | 7350197       |
| 1000000             | -             | 148053341   | 153023744             | 175993800    | 178598181              | 89001765      |

| Test 2: Sorted Data | nano seconds  | nano seconds| nano seconds          | nano seconds | nano seconds           | nano seconds  |
| ------------------  | ------------- | ----------- | --------------------- | ------------ | ---------------------- | ------------- |
| Problem Size        | InsertionSort | Fixed Pivot | Fixed Pivot Insertion | Random Pivot | Random Pivot Insertion | Arrays.sort † |
| 100                 | 350          | 2643        | 2929                  | 8128        | 8111                  | 366          |
| 1000                | 4331          | 26448       | 24998                 | 79132       | 80485                 | 924          |
| 10000               | 41321         | 450809      | 437448                | 901098      | 906022                | 8927        |
| 100000              | 304977        | 5189120     | 5488782               | 10672167     | 10274501               | 93587        |
| 1000000             | 3136509       | 62834100    | 63677728              | 114870647    | 114726375              | 1894417       |

| Test 3: Reversed Data| nano seconds | nano seconds| nano seconds          | nano seconds | nano seconds           | nano seconds  |
| ------------------  | ------------- | ----------- | --------------------- | ------------ | ---------------------- | ------------- |
| Problem Size        | InsertionSort | Fixed Pivot | Fixed Pivot Insertion | Random Pivot | Random Pivot Insertion | Arrays.sort † |
| 100                 | 5507          | 2837        | 2626                  | 10499        | 10895                  | 495          |
| 1000                | 474774        | 45916       | 28428                 | 81281       | 80870                 | 1485         |
| 10000               | 45072716      | 418828      | 437209                | 893674      | 891236                | 14279        |
| 100000              | 4512663236    | 5163484     | 5439374               | 10674628     | 10070113               | 147358        |
| 1000000             | -             | 62746063    | 70243753              | 115625471    | 113824550              | 2582284       |

| Test 4: Equal Data  | nano seconds  | nano seconds| nano seconds          | nano seconds | nano seconds           | nano seconds  |
| ------------------  | ------------- | ----------- | --------------------- | ------------ | ---------------------- | ------------- |
| Problem Size        | InsertionSort | Fixed Pivot | Fixed Pivot Insertion | Random Pivot | Random Pivot Insertion | Arrays.sort † |
| 100                 | 304           | 299        | 308                  | 392        | 409                  | 181           |
| 1000                | 2595          | 2208       | 2198                 | 2433        | 2293                  | 989          |
| 10000               | 20973         | 21332      | 19185                | 19633       | 19670                | 8916          |
| 100000              | 216004        | 200758     | 216997               | 195641     | 195482               | 90136        |
| 1000000             | 3010288       | 2812148    | 2971146              | 2819213    | 3004379              | 1852687       |


------
#####Sorting Random Data 
![RandomData](Images/SortingRandom.png)

#####Sorting Sorted Data
![SortedData](Images/SortingSorted.png)

#####Sorting Reversed Data
![ReversedData](Images/SortingReversed.png)

#####Sorting Equal Data
![EqualData](Images/SortingEqual.png)

#####Sorting With Insertion Sort
Insertion sort was very slow for the bigger arrays, they would completely 
dominate the charts, and two of them took too long to sort. Because of this they have 
been given their own charts, one zoomed-out showing everything, and one zoomed-in so 
the smaller pillars are visible. 

![InsertionSortZoomOut](Images/InsertionSortZoomOut.png)
> Zoomed out
![InsertionSortZoomIn](Images/InsertionSortZoomIn.png)
> Zoomed in


## Discussion

I was at first surprised that the fixed pivot seems to outperform the random pivot! I 
suspect it is because of the fixed pivot being in the middle, thus getting a boost when 
the array already is sorted, or reversed. It is also probably benefiting more from the dual pivot 
implemented this week. However, when the arrays consist of only equal elements they perform pretty 
similar. I am also a little surprised at how much faster the Arrays.sort is, compared to 
my implementations, for reversed and sorted data, however as the instructions in the README file says, 
it is heavily optimized.

I also thought that cutting off to insertion sort would improve the sort, but that does not seem to be the 
case for some reason, and I don't know why. I might be my implementation of insertion sort that could be improved.

The fixed pivot version seems like the best one! It is always the fastest one, only ever matched by the 
random pivot when all elements are equal. However, the Arrays.sort is a lot faster when the arrays already are  
sorted, ascending or descending order. The insertion sort is very bad when the array is in reversed order, 
and pretty bad when the array is random. It is great when the array is sorted to begin with though.
