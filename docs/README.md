### Task 2

| Operation         | Sorted Array | Unsorted Singly Linked List | Hashtable (average) | Hashtable (worst) |
| :-----------------| :------------| :---------------------------| :-------------------| :-----------------|
| Search for key X  |  O(log n)    |              O(n)           |     O(1)            |     O(n)          |
| Insert X at start |  O(n)        |              O(1)           |     O(1)            |     O(n)          |
| Remove X from end |  O(1)        |              O(1)           |     O(1)            |     O(n)          |

- Sorted Array: 
    * Search for key X: because it is sorted Binary search can be used, and binary search is O(log n), which is fast but not constant.
    * Insert X at start: linear O(n), because everything needs to be copied over to a new array and shifted one step.
    * Remove X from the end: constant O(1), because of random access because it's the last element nothing needs to be shifted.
- Unsorted Singly Linked List
    * Search for key X: As said in the instructions, if the element is the last one we would need to go through every element to find it. 
    * Insert X at start: Constant O(1), there is a pointer to the first element, so instant access and then replace it.
    * Remove X from the end: Same thinking here, instant access because of the pointer to the last element.
- Hashtable (average): 
    * Search for key X: constant O(1), everything has a key which points directly to it. 
    * Insert X at start: inserting anything anywhere in the Hashtable should be constant in the average case. If the key is free the element will be added to that spot. 
    * Remove X from the end: constant O(1), instant access with the pointer and then simply remove the element.
- Hashtable (worst): 
    * Search for key X: O(n) linear. If multiple elements share the same hash they would end up in the same spot, then a i.e. a LinkedListed could be used, and you might have to travers that list.
    * Insert X at start: O(n) linear. If the element got the same hash as another one it would be needed to insert it into some kind of list, or look for an open spot in the hashtable, which in the worst case would be linear (what if the first open spot is the last, or what if there are no open spots?)
    * Remove X from the end: O(n) linear. Same thinking here. If multiple elements have the same hash that place needs to be searched for the removal to happen.
    
    
### Task 3
1. The default capacity is set to 10.
2. Line 219. The if-statement determines if the array needs to grow, if it needs to grow it calls grow(minCapacity); 
3. The shift operator (>>). It takes the old capacity and adds (oldCapacity >> 1) to it to determine the new size. If I
   interpret it correctly that would mean if oldCapacity = 10 then the newCapacity would become 10 + (10 >> 1) = 15. 
   The line in question is 240.
4. It increases by 1.5. So newCapacity = 1.5 * oldCapacity.
5. 10 * 1.5 * 1.5 = 22.5 = 22. The size would be 22.
6. **Best case:** would be constant O(1), because the internal array does not need to grow. 
   
   **Worst case:** would be linear O(n), because every element needs to be copied over to a bigger array.
   
   **Average case:** With a bigger ArrayList the need to copy will become less and less frequent. 
   Cost of add = 1 + 1 + 1 ... = 23
   Cost of create a new array and copy = 1 + 10 + 15 + 22 = 47
   Total cost = 71
   
   n = 23
   71/23 = 3 Cost per operation.
   
   3n   =>   O(3n) = O(n) 
   n add takes O(n)
   The amortized time becomes O(n)/n = O(1)

   
    
    
   
   
   