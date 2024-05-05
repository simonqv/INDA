If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)


### Exercise 1
| Size / complexity |     log n     |       n       |    n log n    |  n<sup>2</sup>   |  n<sup>3</sup>   |   2<sup>n</sup>  |      n!          |
|-------------------|---------------|---------------|---------------|------------------|------------------|------------------|------------------|
| 1                 | 0             | 1             | 0             | 1                | 1                | 2                | 1                |
| 10                | 3.322         | 10            | 33.219        | 100              | 1000             | 1024             | 3.6e6            |
| 100               | 6.644         | 100           | 664.38        | 10000            | 1e6              | 1e30             | 9e157            |
| 1000              | 9.966         | 1000          | 9966          | 1e6              | 1e9              | 1e301            | 4e2567           |
| 10000             | 13.288        | 10000         | 132877        | 1e8              | 1e12             | 2e3010           | 2.8e35659        |
| 100000            | 16.610        | 100000        | 1.66e6        | 1e10             | 1e15             | 1e30103          | 2.8e456573       |
| 1000000           | 19.932        | 1000000       | 2e7           | 1e12             | 1e18             | 1e301030         | 8e5565708        |

### Exercise 2
| T(n)          | 1 second | 1 minute |  1 hour  |  1 day   |  1 year  |
| --------------|----------|----------|----------|----------|----------|
| log n         | &#x221e; | &#x221e; | &#x221e; | &#x221e; | &#x221e; |
| n             | 1e9      | 6e10     | 3.6e12   | 8.64e13  | 3.1536e16|
| n log n       | 3.96e7   | 1.9e9    | 9.8e10   | 2e12     | 6.4e14   |
| n<sup>2</sup> | 3e4      | 2.4e5    | 1.8e6    | 9e6      | 1.8e8    |
| n<sup>3</sup> | 1000     | 3915     | 15326    | 44208    | 315938   |
| 2<sup>n</sup> | 29.8     | 35.8     | 41       | 46.3     | 54.8     |
| n!            | 12.2901  | 13.86    | 15       | 16.5031  | 18.5437  |

### Exercise 3
**Arrange the functions in the following list in ascending order based on their
rate of growth.** 

f4(n) = n + 100

f3(n) = n log n

f1(n) = n<sup>1.5</sup>

f5(n) = 2<sup>n</sup>

f2(n) = 10<sup>n</sup>

**Which of the following statements are true? Justify your answer.**

**TRUE**

n (n + 1) / 2 = O(n<sup>3</sup>)
after n=1, n<sup>3</sup> will always form the upper bound. 

n (n + 1) / 2 = O(n<sup>2</sup>)
after n=1, n<sup>2</sup> will always form the upper bound.

n (n + 1) / 2 = Ω(n)
after n=1, n will always be the lower bound. 


**FALSE**

n (n + 1) / 2 = Θ(n<sup>3</sup>)
the growth rate of n<sup>3</sup> is faster than n (n + 1) / 2, thus it can't form both lower and upper bound. 

### Exercise 4

Algorithm Loop1(n):
   a = 0
   for i = 1 to n
      a += i

just one for-loop, with 1 cost n times so O(n)


Algorithm Loop2(n):
   b = 1
   for i = 1 to 4n
      b++

4O(n) but the coefficient doesn't matter, so the answer is O(n) again


Algorithm Loop3(n):
   c = 1
   for i = 1 to n^2
      c--

The loop now goes n^2 times, so n^2 becomes dominant, thus the answer is O(n^2)

Algorithm Loop4(n):
   d = 5
   for i = 1 to 3n
      for j = 1 to i
         d = d + j
         
first for-loop costs 1 n times, and the inner loop loops for every n. So the answer is O(n^2)

Algorithm Loop5(n):
   e = 5
   for i = 1 to n^2
      for j = 1 to i
         e = e + j
         
First loop n^2 times, and then n^4 for the inner one. So O(n^4)

### Exercise 5
Explain why (n+1)<sup>3</sup> is O(n<sup>3</sup>). Use the following
definition: f(n) is O(g(n)) if there exists positive constants c and
n<sub>0</sub> such that f(n) &le; c &times; g(n) for all n &ge; n<sub>0</sub>.


At first glance it looks like (n+1)<sup>3</sup> should form the upper bound. But they share the same growth rate. 
However, we know that f(n) is O(g(n)) if we can find c and n<sub>0</sub> such that f(n) &le; c &times; g(n) for all n &ge; n<sub>0</sub>.

In this case we could for example set c to 10 then f(n) &le; 10 &times; g(n) for all n &ge; 0.886
In a graph you can no easily see that O(n<sup>3</sup>) forms the upper bound!

### Exercise 6.1
```python
Reverse (A):
    # Input: an array A storing n elements.
    # Output: the same array with the elements in reversed order.
    for i = 1 to n-1
       x = A[i]
       for j = i down to 1
           A[j] = A[j-1]
       A[0] = x
```

The basic operation is the most frequently used operation. 
In this case that is the inner for-loop check. 

The inner for-loop creates a quadratic term which dominates for large n, making the time complexity quadratic.

### Exercise 6.2
See Reverse.java och ReverseTest.java

### Exercise 7

- if the list already is sorted, selection sort still needs to go through the entire list for every element 
and perform no swaps. 
Insertion sort on the other hand only checks every element once (the one next to the active element), and will not 
perform any swaps. So insertion sort will make fewer comparisons than selection sort.

- because data is often in a somewhat sorted form, insertion sort would be preferred! If you know the data will **not**
be sorted or somewhat sorted, it doesn't matter as much. If the list is reversed, insertion sort will do a lot more swaps 
than selection sort. However insertion sort is still the preferred one, like said above.

