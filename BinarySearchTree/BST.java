package BST_A2;
public class BST implements BST_Interface {
	public BST_Node root;
	int size;
	int height;

	public BST(){ size=0; root=null; }

	@Override
	//used for testing, please leave as is
	public BST_Node getRoot(){ 
		return root; }

	@Override
	public boolean insert(String s) {
		//If there is nothing in the tree just create a node
		if(root == null){
			root = new BST_Node(s);
			size++;
			return true;
		}else if(root != null){
			root.insertNode(s);
			size++;
			return true;
		}
		return false;

	}

	@Override
	public boolean remove(String s) {
		if (this.empty()) {
			return false;
		}
		if(s.equals(root.data)) {
			BST_Node newRoot = new BST_Node(s);
			newRoot.left = root;
			boolean result = root.removeNode(s, newRoot);
			root = newRoot.left;
			size--;
			return result;
			
		}
		if (root.removeNode(s, null)) {
			size--;
		}
		return root.removeNode(s, null);
	}

	@Override
	public String findMin() {
		if(size == 0){
			return null;
		}else{
			return root.findMin().getData();
		}
	}

	@Override
	public String findMax() {
		if(size == 0){
			return null;
		}else{
			return root.findMax().getData();
		}
	}

	@Override
	public boolean empty() {
		if(size ==0 && root==null){
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(String s) {
		if(root == null){
			return false;
		}else{
			return root.containsNode(s);
		}

	}

	@Override
	public int size() {
		if(root == null){
			return 0;
		}

		return size;
	}

	@Override
	public int height() {
		if(root == null){
			return -1;
		}
		return root.getHeight();
	}

}
