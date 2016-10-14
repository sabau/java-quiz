import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BST {

	static void levelOrder(Node root){
		//Write your code here
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while(!q.isEmpty()) {
			Node el = q.remove();
			System.out.format("%d ", el.data);
			if (el.left != null) q.add(el.left);
			if (el.right != null) q.add(el.right);
		}
	}

	//BST height
	public static int getHeight(Node root){
		//Write your code here
		if (root == null || (root.left == null && root.right == null)) return 0;
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

	public static Node insert(Node root,int data){
		if(root==null){
			return new Node(data);
		}
		else{
			Node cur;
			if(data<=root.data){
				cur=insert(root.left,data);
				root.left=cur;
			}
			else{
				cur=insert(root.right,data);
				root.right=cur;
			}
			return root;
		}
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		Node root=null;
		while(T-->0){
			int data=sc.nextInt();
			root=insert(root,data);
		}
		levelOrder(root);
	}
}
