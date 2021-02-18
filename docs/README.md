| Operation (BST)     | Time Complexity (worst case)    |
| ------------------- | ------------------------------- |
| search              | O(n)    (O(log n))                    |
| insert              | O(n)    (O(log n))                    |
| size                | O(1)                            |
| height              | O(n)                            |
| leaves              | O(n)                            |
| toString            | O(n)                            |

* **search:** O(n) because of the binary nature. If it's a pathological tree the entire tree needs to be traversed. If it's a perfect tree, it's O(log n).
* **insert:** Exactly the same reasoning here. 
* **size:** O(1) constant. The size of the tree is saved to a variable. The variable is returned, which is constant.
* **height:** O(n) You might have to traverse the entire tree.
* **leaves:** O(n) Same here.
* **toString:** O(n) You need to traverse the entire tree to save every element to create a String of the elements.