/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
 */
package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {

	Node sentinel; //this will be the entry point to your linked list (the head)
	int numElts;
	Node curr;


	public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
		sentinel=new Node(0); //Note that the root's data is not a true part of your data set!
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
	}

	//implement all methods in interface, and include the getRoot method we made for testing purposes. Feel free to implement private helper methods!

	public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
		return sentinel;
	}

	@Override
	public boolean insert(double elt, int index) {
		if(index < 0 || index > size()){
			return false;
		}
		//curr is the node at the given index that we will be inserting a new node
		Node curr = sentinel;
		
		for (int i=0;i<=size(); i++){
			//Iterate through the list until i = the index specified in the insert function call
			curr = curr.next;
			
			if(i == index){
				//Once at the correct index of curr, create a new node with the specified value
				Node newNode = new Node(elt);
				
				//Now make the node before curr point to curr as it's .next field
				curr.prev.next = newNode;
				
				//Also make curr's prev node now point to the newNode's prev node
				newNode.prev = curr.prev;
				
				//Now make the previous node of curr newNode
				curr.prev = newNode;
				
				//Lastly make the .next field of newNode a pointer to curr  
				newNode.next = curr;
			}
		}
		numElts++;
		return true;
	}

	@Override
	public boolean remove(int index) {
		if (index < 0 || index > size()-1){
			return false;
		}
		get(index);
		curr.next.prev = curr.prev;
		curr.prev.next = curr.next;
		numElts--;
		return true;
	}

	@Override
	public double get(int index) {

		if (index < 0 || index > size()-1){
			return Double.NaN;
		}
		curr=sentinel;
		for(int i = 0; i<= index;i++){
			curr=curr.next;
		}

		return curr.getData();
	}

	@Override
	public int size() {
		return numElts;
	}

	@Override
	public boolean isEmpty() {
		return (size()==0);
	}

	@Override
	public void clear() {
		sentinel.prev= sentinel;
		sentinel.next = sentinel;
		numElts=0;

	}
}