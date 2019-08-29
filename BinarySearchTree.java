package HW5;


public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>
{
	
	private BinaryNode<AnyType> root;
	
	//Construct the tree.
	public BinarySearchTree( )
	{
		root = null;	
	}
	private static class BinaryNode<AnyType>{
		// Constructors
	     BinaryNode( AnyType theElement )
	     {
	         this( theElement, null, null );
	     }

	     BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt )
	     {
	         element  = theElement;
	         left     = lt;
	         right    = rt;
	     }

	     AnyType element;            // The data in the node
	     BinaryNode<AnyType> left;   // Left child
	     BinaryNode<AnyType> right;  // Right child
	}
	
	public int height() {
		return heightHelper(root);

	}
	
	private int heightHelper(BinaryNode<AnyType> tree) {
		if(tree != null) {
			return 1+ Math.max(heightHelper(tree.left), heightHelper(tree.right));
		}
		return 0;
	}
	
	private boolean passedTest(BinaryNode<AnyType> tree) {
		int heightLeft = this.heightHelper(tree.left);
		int heightRight = this.heightHelper(tree.right);
		
		if((heightLeft - heightRight) > 1) {
			return false;
		}
		return true;
	}
	
	private boolean passed = true;
	
	private boolean allPassed() {
		this.allPassedHelper(root);
		boolean temp = passed;
		passed = true;
		return temp;
		
	}
	
	private void allPassedHelper(BinaryNode<AnyType> tree) {
		if(!this.passedTest(tree)) {
			passed = false;
		}
		if(passed && tree.left != null) {
			this.allPassedHelper(tree.left);
		}
		if(passed && tree.right != null) {
			this.allPassedHelper(tree.right);
		}
	}
	
	public void printInOrder() {
		this.printInOrderHelper(root);
	}
	
	private void printInOrderHelper(BinaryNode<AnyType> tree) {
		if(tree != null) {
			this.printInOrderHelper(tree.left);
			System.out.print(tree + ", ");
			this.printInOrderHelper(tree.right);
		}
	}
	
	private String PostOrder;
	
	public String PostOrder() {
		this.PostOrderHelper(root);
		String temp = PostOrder;
		PostOrder = "";
		return temp;
	}
	
	private void PostOrderHelper(BinaryNode<AnyType> tree) {
		if(tree != null) {
			this.PostOrderHelper(tree.left);
			this.PostOrderHelper(tree.right);
			PostOrder += tree + ", ";
		}
	}
	
	private int numNodes;
	
	public int numberOfNodes() {
		this.numberOfNodesHelper(root);
		int temp = numNodes;
		numNodes = 0;
		return temp;
	}
	
	private void numberOfNodesHelper(BinaryNode<AnyType> tree) {
		if(tree == null) {
			
		}
		else if(tree.right == null && tree.left == null) {
			numNodes += 1;
		}
		else {
			this.numberOfNodesHelper(tree.left);
			this.numberOfNodesHelper(tree.right);
		}
	}
}
