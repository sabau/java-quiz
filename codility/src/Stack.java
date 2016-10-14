/**
 * Created by web on 10/14/16.
 */
public class Stack {
	private Node head;
	//	private int size;
	private java.util.Stack<Node> transactionHeads;


	private static class Node {
		private int value;
		private Node next;

	}

	public Stack() {
		transactionHeads = new java.util.Stack<>();
		head = null;
//		size = 0;
	}
	public boolean isEmpty() {
		return head == null;
	}

//	public int getSize() {
//		return size;
//	}
//
//	private int increaseSize() {
//		return size;
//	}
//
//	private boolean decreaseSize() {
//		if (size == 0) return false;
//		size--;
//		return true;
//	}

	public void push(int value) {
		Node currentHead = head;
		head = new Node();
		head.value = value;
		head.next = currentHead;
//		increaseSize();
	}

	public int top() {
		if(isEmpty()) return 0;
		return head.value;
	}

	public void pop() {
		if (!isEmpty()){
			head = head.next;
//			decreaseSize();
		}
	}

	public void begin() {
		/**
		 * I have not clear how the commit should work in case of nested transactions.
		 * I.E. EmptyStack:
		 * push 0
		 * begin, push 5, push 6, push 7,
		 *   begin, push 8, commit,
		 * rollback
		 * pop will return 8 or 0?
		 * I will assume 0, so nested commit will apply to the context where the transaction started,
		 * if the surrounding context have a rollback, then also his childs operations will be gone.
		 */
		transactionHeads.push(head);

	}

	public boolean rollback() {
		if (transactionHeads.isEmpty()) return false;
		//we may also implement via try/catch ArrayIndexOutOfBoundsException
		// but is seems more expensive to force our Stack to throw exceptions
		head = transactionHeads.pop();
		return true;
	}

	public boolean commit() {
		if (transactionHeads.isEmpty()) return false;
		transactionHeads.pop();
		return true;
	}
}
