
public class BstNode {
	private int content;
	private BstNode left;
	private BstNode right;
	
	BstNode(){
		this.left = this.right = null;
	}
	
	BstNode(int content){
		this.left = null;
		this.right = null;
		this.content = content;
	}
	
	BstNode(int content, BstNode left, BstNode right){
		this.left = left;
		this.right = right;
		this.content = content;
	}
	
	public void setContent(int content) {
		this.content = content;
	}
	
	public int getContent() {
		return this.content;
	}
	
	public void setLeft(BstNode left) {
		this.left = left;
	}
	
	public BstNode getLeft() {
		return this.left;
	}
	
	public void setRight(BstNode right) {
		this.right = right;
	}
	
	public BstNode getRight() {
		return this.right;
	}
	
	public boolean isLeaf() {
		return (left == null) && (right == null);
	}
}
