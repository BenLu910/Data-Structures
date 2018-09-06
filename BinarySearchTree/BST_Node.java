package BST_A2;


public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;
	BST_Node parent;
	BST_Node(String data){ 
		this.data=data; }

	// --- used for testing  ----------------------------------------------
	//
	// leave these 3 methods in, as is

	public String getData(){ 
		return data; }
	public BST_Node getLeft(){ 
		return left; }
	public BST_Node getRight(){ 
		return right; }

	// --- end used for testing -------------------------------------------


	// --- fill in these methods ------------------------------------------
	//
	// at the moment, they are stubs returning false 
	// or some appropriate "fake" value
	//
	// you make them work properly
	// add the meat of correct implementation logic to them

	// you MAY change the signatures if you wish...
	// make the take more or different parameters
	// have them return different types
	//
	// you may use recursive or iterative implementations



	public boolean containsNode(String s){ 
		
		if(s.compareTo(data) < 0){
			if(left !=null){
			return (left.containsNode(s));
			}
			return false;
		}else if(s.compareTo(data) > 0){
			if(right !=null){
				return (right.containsNode(s));
				}
			return false;

		}else if(s.compareTo(data) == 0){
			
			return true; //if compareTO returned 0 it's a match
		}else{
			return false;
		}
		//If there is no match return false

	}

	public boolean insertNode(String s){ 

		if(s.compareTo(data) < 0 && getLeft() == null){
			//Create new node if the left node is empty
			left = new BST_Node(s);
			left.parent = this;
		}else if(s.compareTo(data) > 0 && getRight() == null){
			//Create new node if the right node is empty
			right = new BST_Node(s);
			right.parent = this;
		}else if(s.compareTo(data) < 0){
			//If the string to insert is less than the data in the node given, try to insert in the left node
			left.insertNode(s);
		}else if(s.compareTo(data) > 0){
			//If the string to insert is more than the data in the node given, try to insert in the right node
			right.insertNode(s);

		}
		return false;

	}

	public boolean removeNode(String s, BST_Node parent){ 
		
		if (s.compareTo(data) > 0) {
			
			if (right == null) {
				return false;
			} else {
				return right.removeNode(s, this);
			}
			
		} else if (s.compareTo(data) < 0) {
			
			if (left == null) {
				return false;
			} else {
				return left.removeNode(s, this);
			}		
		} else {
			
			if (left != null && right != null) {
				//Two Children
				this.data = right.findMin().data;
				right.removeNode(this.data, this);
				
				//One child cases
			} else if (parent.left == this) {	
				if (left != null) {
					parent.left = left;
					return true;
				} else {
					parent.left = right;
					return true;
				}
			} else if (parent.right == this) {
				if (left != null) {
					parent.right = left;
					return true;
				} else {
					parent.right = right;
					return true;
				}			
			}
		}	
		return true;
		
	}





	public BST_Node findMin(){ 
		if(getLeft() == null){
			return this;
		}else{
			left.findMin();	
		}
		return left;

	}

	public BST_Node findMax(){ 
		if(getRight() == null){
			return this;
		}else{
			right.findMax();	
		}
		return right; }

	public int getHeight(){ 
		int height =0;
		if(this.left == null && this.right == null){
			height = 1 + Math.max(-1, -1);
		}else if(this.left == null){
			height = 1 + Math.max(-1, this.right.getHeight());
		}else if(this.right == null){
			height = 1 + Math.max(this.left.getHeight(), -1);
		}else{
			height = 1 + Math.max(this.left.getHeight(), this.right.getHeight());
		}

		return height; }



	// --- end fill in these methods --------------------------------------


	// --------------------------------------------------------------------
	// you may add any other methods you want to get the job done
	// --------------------------------------------------------------------

	public String toString(){
		return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
				+",Right: "+((this.right!=null)?right.data:"null");
	}

	//	public BST_Node findParent(String s){
	//		
	//		if(s.compareTo(data) < 0){
	//			parent = this;
	//			left.containsNode(s);
	//
	//		}else if(s.compareTo(data) > 0){
	//			parent = this;
	//			right.containsNode(s);
	//
	//		}else if(s.compareTo(data) == 0){
	//
	//			return parent; //if compareTO returned 0 it's a match
	//		}
	//		return parent;
	//	}

}

