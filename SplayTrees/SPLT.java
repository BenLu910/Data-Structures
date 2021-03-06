package SPLT_A4;

public class SPLT implements SPLT_Interface{
	private BST_Node root;
	private int size;

	public SPLT() {
		this.size = 0;
		root = null;
	} 

	public BST_Node getRoot() { //please keep this in here! I need your root node to test your tree!
		return root;
	}

	@Override
	public void insert(String s) {
		if (empty()) {
			root = new BST_Node(s);
			size += 1;
		} else {
			root = root.insertNode(s);
			if(root.justMade)
				size++;
		}
	}

	@Override
	public void remove(String s) { 
		if (contains(s)) {
			if (root.data.equals(s) && size == 1) {
				root = null;
				size -= 1;
			} else {
				BST_Node rightRoot = root.right;

				
				if (root.right != null)
					root.right.par = null; 

				if (root.left != null)
					root.left.par = null; 
				
				if (root.left != null) {
					root = root.left.findMax();
					root.right = rightRoot;
					if (rightRoot != null) {
						rightRoot.par = root;
					}
				} else { 
					root = rightRoot;
				}
				size -= 1;
			}
		}
	}

	@Override
	public String findMin() {		
		if (empty()) {
			return null;
		} else {
			root = root.findMin();
			return root.findMin().data;
		}
	}

	@Override
	public String findMax() {		
		if (empty()) {
			return null;
		} else {
			root = root.findMax();
			return root.findMax().data;
		}
	}

	@Override
	public boolean empty() {	
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean contains(String s) {
		if (empty()) {
			return false;
		}
		root = root.containsNode(s);
		if (root.data == s) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {		
		return size;
	}

	@Override
	public int height() {		
		if (empty()) {
			return -1;
		} else {
			return root.getHeight();
		}
	}

}