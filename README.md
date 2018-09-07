# Data-Structures
Fundamental data structures implemented using Java.

   * [Data Structures](#Data-Structures)
       * [Linked List](#linked-list)
       * [Binary Search Tree](#binary-search-tree)
       * [Minimum Binary Heap](#minimum-binary-heap)
       * [Splay Trees](#splay-trees)
       * [DiGraph](#digraph)
       * [Dijkstra's Algorithm](#dijkstras-algorithim)
       
## Linked List
I built a general List ADT (LIST) using linked cells in Java. This means I did not use arrays to contain the elements stored in the List. It also means I did not use any of the code from the Java Collections library to create the implementation. 



My implementation always has at least one node (cell) in it. This is a special "header" node cell is called a sentinel:
![Sentinel](https://i.imgur.com/4fvPv5I.png)

I used a single sentinel node as both a header (points to the first cell in the list) and as a trailer (last cell in the list points to the sentinel). When a brand new list is created and there are no elements stored, there still is the one sentinel node in the list structure. It is accessed by the "sentinel" field in the list object. The data value in the sentinel node doesn't matter, as it is not a data node. It serves as an item that will always be there so there are fewer null pointers in the list structure. It makes checking for end-of-list a bit easier, and it helps eliminate a lot of null pointer errors. In essence an empty list is not a "null", but a single cell with no next and no prev cells. We will (better) detect empty list by checking the size method for 0.  

### Functions:
#### Clear
   * In: nothing
   * Return: void
   * Effect: list is left with size 0, no elements in it, consists of just the original root Node
#### Size
   * In: nothing
   * Return: number of elements stored in the list
   * Effect: no change to list state
#### IsEmpty
   * In: nothing
   * Return: boolean, true if the list has no elements in it, true is size is 0
   * Effect: no change to list state
#### Insert
   * In: a double (the data element), and an int (position index)
   * Return: boolean, return true if insert is successful, false otherwise
   * Effect: the list state will be altered so that the element is located at the specified index; the list has size bigger by one; all elements that were at the specified index or after have been moved down one slot
   * Error: if index is beyond list size range return false valid inserts take place either at a location where a list element already exists, or at the location that is one beyond the last element
#### Remove
   * In: an int (the index of the element to take out of the list)
   * Return: boolean.. return true if the remove is successful, false otherwise
   * Effect: list state is altered in that the Node at the specified index is decoupled list size decreases by one errors: what if specified index is not in the list? return false
#### Get
   * In: an int, the index of the element item to return
   * Return: double, the element stored at index, or Double.NaN
   * Effect: no change in state of the list
   * Error: what if index is not in the list? return Double.NaN

## Binary Search Tree

### insert:
   * in: a string (the element to be stored into the tree)
   * return: boolean, return true if insert is successful, false otherwise
   * effect: if the string is already in the tree, then there is no change to the tree state, and return false if the string is not already in the tree, then a new tree cell/node is created, the string put into it as data, the new node is linked into the tree at the proper place; size is incremented by 1, and return a true
   
### remove:
   * in: a string (the element to be taken out of the tree)
   * return: boolean, return true if the remove is successful, false otherwise this means return false if the tree size is 0
   * effect: if the element being looked for is in the tree, unlink the node containing it and return true (success); size decreases by one if the element being looked for is not in the tree, return false and make no change to the tree state
   
### contains:
   * n: a string (the element to be seaarched for)
   * return: boolean, return true if the string being looked for is in the tree; return false otherwise this means return false if tree size is 0
   * effect: no change to the state of the tree

### findMin:
   * in: none
   * return: string, the element value from the tree that is smallest
   * effect: no tree state change
   * error: is tree size is 0, return null


### findMax:
   * in: none
   * return: string, the element value from the tree that is largest
   * effect: no tree state change
   * error: is tree size is 0, return null

### size:
   * in: nothing
   * return: number of elements stored in the tree
   * effect: no change to tree state

### empty:
   * in: nothing
   * return: boolean, true if the tree has no elements in it, true if size is 0 return false otherwise
   * effect: no change to tree state

### height:
   * in: none
   * return: integer, the length of the longest path in the tree from root to a leaf
   * effect: no change in tree state
   * error: return -1 is tree is empty (size is 0, root is null)

### getRoot:
   * in: none
   * return: a tree cell/node, the one that is the root of the entire tree means return a null if the tree is empty
   * effect: no change to tree state

## Minimum Binary Heap

## Splay Trees

## DiGraph

## Dijkstras Algorithim

