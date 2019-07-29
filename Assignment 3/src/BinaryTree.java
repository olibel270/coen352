
public class BinaryTree {
	private BstNode root;
	private int nodeCount;
	
	BinaryTree(){
		root = null;
		nodeCount = 0;
	}
	
	public void clear() {
		root = null;
		nodeCount = 0;
	}
	
	public void insert(int content) {
		this.root = insertHelp(this.root, content);
		this.nodeCount++;
	}
	
	public BstNode remove(int content) {
		BstNode temp = findHelp(this.root, content);
		if (temp!=null) {
			this.root = removeHelp(this.root, content);
			this.nodeCount--;
		}
		return temp;
	}
	
	public BstNode find(int content) {
		return findHelp(this.root, content);
	}
	
	public int size() {
		return this.nodeCount;
	}
	
	private BstNode insertHelp(BstNode root, int content) {
		if (root==null)
			return new BstNode(content);
		if (content < root.getContent())
			root.setLeft(insertHelp(root.getLeft(), content));
		else
			root.setRight(insertHelp(root.getRight(), content));
		return root;
	}
	
	private BstNode removeHelp(BstNode root, int content) {
		if(root==null)
			return null;
		if(content < root.getContent())
			root.setLeft(removeHelp(root.getLeft(), content));
		else if (content > root.getContent())
			root.setRight(removeHelp(root.getRight(), content));
		else {
			if (root.getLeft()==null)
				return root.getRight();
			else if (root.getRight()==null)
				return root.getLeft();
			else {
				BstNode temp = getMin(root.getRight());
				root.setContent(temp.getContent());
				root.setRight(deleteMin(root.getRight()));
			}
		}
		return root;
	}
	
	private BstNode deleteMin(BstNode root) {
		if (root.getLeft()==null)
			return root.getRight();
		root.setLeft(deleteMin(root.getLeft()));
		return root;
	}
	
	private BstNode getMin(BstNode root) {
		if (root.getLeft()==null)
			return root;
		return getMin(root.getLeft());
	}
	
	private BstNode findHelp(BstNode root, int content) {
		if (root==null)
			return null;
		if (content < root.getContent())
			return findHelp(root.getLeft(),content);
		else if (root.getContent()==content)
			return root;
		else return findHelp(root.getRight(),content);
			
	}
}
