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



## Minimum Binary Heap

## Splay Trees

## DiGraph

## Dijkstras Algorithim

