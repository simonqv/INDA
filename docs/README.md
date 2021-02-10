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