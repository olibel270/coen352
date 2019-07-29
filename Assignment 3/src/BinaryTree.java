
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
		//root = insertHelp()
	}
	
	public int remove(int content) {
		//findHelp then removeHelp if found
	}
	
	public int find(int content) {
		//findHelp
	}
	
	public int size() {
		return nodeCount;
	}
}
