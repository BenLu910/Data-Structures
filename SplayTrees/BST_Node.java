package SPLT_A4;

public class BST_Node {

	String data;
	BST_Node left;
	BST_Node right;
	BST_Node par; 
	boolean justMade; //could be helpful if you change some of the return types on your BST_Node insert.
					  //I personally use it to indicate to my SPLT insert whether or not we increment size.

	BST_Node(String data){ 
		this.data=data;
		this.justMade=true;
	}

	public String getData(){ return data; }
	public BST_Node getLeft(){ return left; }
	public BST_Node getRight(){ return right; }

	public BST_Node containsNode(String s){ 
		if(data.equals(s)) {
			splay(this);
			return this;
		}
		if(data.compareTo(s)<0){
			if(right == null && par != null) {
				splay(this);
				return this;
			}
			if(right == null && par == null) {
				return this;
			}
			return right.containsNode(s);
		}
		
		if(data.compareTo(s)>0){
			if(left == null && par != null) {
				splay(this);
				return this;
			}
			if (left == null && par == null) {
				return this;
			}
			return left.containsNode(s);
		}

		
		return null;
	}

	public BST_Node insertNode(String s){
		
		if(data.compareTo(s)<0){
			if(right==null){
				right=new BST_Node(s);
				right.par = this;
				BST_Node temp = right;
				splay(right);
				return temp;
			}
			return right.insertNode(s);
		}
		if(data.compareTo(s)>0){
			if(left==null){
				left=new BST_Node(s);
				left.par = this;
				BST_Node temp = left;
				splay(left);
				return temp;
			}
			return left.insertNode(s);
		}
		justMade = false;
		splay(this);
		return this;
	}

	public void removeNode(String s){}

	public BST_Node findMin(){
		if(left!=null)return left.findMin();
		splay(this);
		return this;
	}

	public BST_Node findMax(){
		if(right!=null)return right.findMax();
		splay(this);
		return this;
	}

	public int getHeight(){
		int l=0;
		int r=0;
		if(left!=null)l+=left.getHeight()+1;
		if(right!=null)r+=right.getHeight()+1;
		return Integer.max(l, r);
	}

	private void splay(BST_Node x) { 

		while(x.par != null) { 

			if(x.par.par == null) { 
				if (x == x.par.right) 
					zigR(x);
				else 
					zigL(x); 
			} else if (x.par.par.right != null && 
					x == x.par.par.right.right) {
				zigZigR(x);
			} else if (x.par.par.left != null && 
					x == x.par.par.left.left) {
				zigZigL(x);
			} else if (x.par.par.right != null &&
					x == x.par.par.right.left) {
				zigZagR(x);
			} else if (x.par.par.left != null && 
					x == x.par.par.left.right) {
				zigZagL(x);
			}
		}
	}


	/* Rotate Left Methods */
	private void zigR(BST_Node x) { 	
		BST_Node l = x.left; 
		x.left = x.par; 
		x.left.par = x;
		x.par = null;
		x.left.right = l;
		if (l != null) {
			l.par = x.left;
		}
	}
	
	private void zigZigR(BST_Node x) {
		BST_Node l = x.left;
		BST_Node lpar = x.par.left;
		BST_Node ggpar = x.par.par.par;
		if (ggpar != null) {

			if (x.par.par.par.right != null &&
					x.par.par.par.right.right.right == x)
				ggpar.right = x;
			else
				ggpar.left = x;
		}
		x.left = x.par;
		x.left.left = x.par.par;
		x.left.left.par = x.left;
		x.left.par = x;
		x.par = ggpar;
		x.left.right = l;
		x.left.left.right = lpar;
		if (l != null)
			l.par = x.left;
		if (lpar != null)
			lpar.par = x.left.left;
	}
	
	private void zigZagR(BST_Node x) {
		BST_Node l = x.left;
		BST_Node r = x.right;
		BST_Node ggpar = x.par.par.par;
		if (ggpar != null) {
			if(x.par.par.par.right != null && 
					x.par.par.par.right.right.left == x)
				ggpar.right = x;
			else
				ggpar.left = x;
		}
		x.right = x.par;
		x.left = x.par.par;
		x.right.par = x;
		x.left.par = x;
		x.par = ggpar;
		x.right.left = r;
		x.left.right = l;
		if (l != null)
			l.par = x.left;
		if (r != null)
			r.par = x.right;
		
	}
	

	/* Rotate Right Methods */
	public void zigL(BST_Node x) {
		BST_Node r = x.right;
		x.right = x.par;
		x.right.par = x;
		x.par = null;
		x.right.left = r;
		if (r != null) 
			r.par = x.right;
	}
	
	private void zigZigL(BST_Node x) {
		BST_Node r = x.right;
		BST_Node rpar = x.par.right;
		BST_Node ggpar = x.par.par.par;
		if (ggpar != null) {
			if (x.par.par.par.left != null && 
					x.par.par.par.left.left.left == x)
				ggpar.left = x;
			else
				ggpar.right = x;
		}
		x.right = x.par;
		x.right.right = x.par.par;
		x.right.right.par = x.right;
		x.right.par = x;
		x.par = ggpar;
		x.right.left = r;
		x.right.right.left = rpar;
		if (r != null)
			r.par = x.right;
		if (rpar != null)
			rpar.par = x.right.right;
	}

	private void zigZagL(BST_Node x) {
		BST_Node l = x.left;
		BST_Node r = x.right;
		BST_Node ggpar = x.par.par.par;
		if (ggpar != null) {
			if(x.par.par.par.left != null && 
					x.par.par.par.left.left.right == x) 
				ggpar.left = x;
			else 
				ggpar.right = x;
		}
		x.left = x.par;
		x.right = x.par.par;
		x.left.par = x;
		x.right.par = x;
		x.par = ggpar;
		x.left.right = l;
		x.right.left = r;
		if (r != null)
			r.par = x.right;
		if (l != null)
			l.par = x.left;
	}

}