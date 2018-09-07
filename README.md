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

### Functions:

#### Insert:
   * In: a string (the element to be stored into the tree)
   * Return: boolean, return true if insert is successful, false otherwise
   * Effect: if the string is already in the tree, then there is no change to the tree state, and return false if the string is not already in the tree, then a new tree cell/node is created, the string put into it as data, the new node is linked into the tree at the proper place; size is incremented by 1, and return a true
   
#### Remove:
   * In: a string (the element to be taken out of the tree)
   * Return: boolean, return true if the remove is successful, false otherwise this means return false if the tree size is 0
   * Effect: if the element being looked for is in the tree, unlink the node containing it and return true (success); size decreases by one if the element being looked for is not in the tree, return false and make no change to the tree state
   
#### Contains:
   * N: a string (the element to be seaarched for)
   * Return: boolean, return true if the string being looked for is in the tree; return false otherwise this means return false if tree size is 0
   * Effect: no change to the state of the tree

#### FindMin:
   * In: none
   * Return: string, the element value from the tree that is smallest
   * Effect: no tree state change
   * Error: is tree size is 0, return null
   
#### FindMax:
   * In: none
   * Return: string, the element value from the tree that is largest
   * Effect: no tree state change
   * Error: is tree size is 0, return null

#### Size:
   * In: nothing
   * Return: number of elements stored in the tree
   * Effect: no change to tree state

#### Empty:
   * In: nothing
   * Return: boolean, true if the tree has no elements in it, true if size is 0 return false otherwise
   * Effect: no change to tree state

#### Height:
   * In: none
   * Return: integer, the length of the longest path in the tree from root to a leaf
   * Effect: no change in tree state
   * Error: return -1 is tree is empty (size is 0, root is null)

#### GetRoot:
   * In: none
   * Return: a tree cell/node, the one that is the root of the entire tree means return a null if the tree is empty
   * Effect: no change to tree state

## Minimum Binary Heap

### Functions

#### Insert
   * In: an EntryPair object, containing the priority and string, assume no duplicate priorities will be inserted 
   * Return: void
   
#### DelMin
   * In: nothing
   * Return: void
   
#### GetMin
   * In: nothing
   * Return: an element (an EntryPair object)
#### Size
   * In: nothing
   * Return: integer 0 or greater
#### Build
   * In: array of elements that need to be in the heap
   * Return: void (assume for a build that the bheap will start empty)

## Splay Trees

### Functions:

#### Insert:
   * In: a string (the element to be stored into the tree)
   * Return: void, if you need to update size when delegating, consider using a boolean as I mention in BST_Node
   * Effect: if the string is already in the tree, then there is no change to the tree state (save for splaying), and return if the string is not already in the tree, then a new tree cell/node is created, the string put into it as data, the new node is linked into the tree at the proper place; size is incremented by 1, and return

#### Remove:
   * In: a string (the element to be taken out of the tree)
   * Return: void
   * Effect: see description on "when to splay"
   
#### Contains:
   * In: a string (the element to be searched for)
   * Return: boolean, return true if the string being looked for is in the tree; return false otherwise this means return false if tree size is 0
   * Effect: no change to the state of the tree (save for splaying found node or what would be its parent)

#### FindMin:
   * In: none
   * Return: string, the element value from the tree that is smallest
   * Effect: no tree state change (save for splaying)
   * Error: is tree size is 0, return null
   
#### FindMax:
   * In: none
   * Return: string, the element value from the tree that is largest
   * Effect: no tree state change (save for splaying)
   * Error: is tree size is 0, return null

#### Size:
   * In: nothing
   * Return: number of elements stored in the tree
   * Effect: no change to tree state

#### Empty:
   * In: nothing
   * Return: boolean, true if the tree has no elements in it, true if size is 0 return false otherwise
   * Effect: no change to tree state

#### Height:
   * In: none
   * Return: integer, the length of the longest path in the tree from root to a leaf
   * Effect: no change in tree state
   * Error: return -1 is tree is empty (size is 0, root is null)

#### GetRoot:
   * In: none
   * Return: a tree cell/node, the one that is the root of the entire tree means return a null if the tree is empty
   * Effect: no change to tree state

## DiGraph

### Functions:

#### AddNode
   * In: unique id number of the node (0 or greater) string for name you might want to generate the unique number automatically but this operation allows you to specify any integer both id number and label must be unique
   * Return: boolean
     returns false if node number is not unique, or less than 0
     returns false if label is not unique (or is null)
     returns true if node is successfully added 

#### AddEdge
   * In: unique id number for the new edge, label of source node, label of destination node, weight for new edge (use 1 by default) label for the new edge (allow null)
   * Return: boolean
     returns false if edge number is not unique or less than 0
     returns false if source node is not in graph
     returns false if destination node is not in graph
     returns false is there already is an edge between these 2 nodes
     returns true if edge is successfully added 
            
#### DelNode
   * In: string label for the node to remove
   * Out: boolean
          return false if the node does not exist
          return true if the node is found and successfully removed
          
#### DelEdge
   * In: string label for source node
         string label for destination node
   * Out: boolean
          return false if the edge does not exist
          return true if the edge is found and successfully removed
          
#### NumNodes
   * In: nothing
   * Return: integer 0 or greater
             reports how many nodes are in the graph
             
#### NumEdges
   * In: nothing
   * Return: integer 0 or greater
             reports how many edges are in the graph
             
#### TopoSort:
   * In: nothing
   * Return: array of node labels (strings)
             if there is no topo sort (a cycle) return null for the array
             if there is a topo sort, return an array containing the node 
             labels in order

## Dijkstras Algorithim

### Functions:

#### AddNode
   * In: unique id number of the node (0 or greater)
         string for name you might want to generate the unique number automatically but this operation allows you to specify any integer both id number and label must be unique
   * Return: boolean
             returns false if node number is not unique, or less than 0
             returns false if label is not unique (or is null)
             returns true if node is successfully added 
#### AddEdge
   * In: unique id number for the new edge, label of source node, label of destination node, weight for new edge (use 1 by default) label for the new edge (allow null)
   * Return: boolean
             returns false if edge number is not unique or less than 0
             returns false if source node is not in graph
             returns false if destination node is not in graph
             returns false is there already is an edge between these 2 nodes
             returns true if edge is successfully added 
            
#### DelNode
   * In: string label for the node to remove
   * Out: boolean
          return false if the node does not exist
          return true if the node is found and successfully removed
     
#### DelEdge
   * In: string label for source node
         string label for destination node
   * Out: boolean
          return false if the edge does not exist
          return true if the edge is found and successfully removed
          
#### NumNodes
   * In: nothing
   * Return: integer 0 or greater, reports how many nodes are in the graph
   
#### NumEdges
   * In: nothing
   * Return: integer 0 or greater, reports how many edges are in the graph
   
#### TopoSort:
   * In: nothing
   * Return: array of node labels (strings)
             if there is no topo sort (a cycle) return null for the array
             if there is a topo sort, return an array containing the node
             labels in order              
#### ShortestPath:
   * In: string label for start vertex
   * Return: array of ShortestPathInfo objects (ShortestPathInfo)
             length of this array should be numNodes (as you will put in all shortest paths including from source to itself)
             See ShortestPathInfo class for what each field of this object should contain
