import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class Solution {
	public static String strength(String a, int i, int j){
		if (a.charAt(i) == '0') return "0"; //If first child has value 0 in the group, strength of group is zero
		return a.substring(i,j);
	}

	public void twotwo(){
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		in.nextLine();
		String line;
		int count = 0;
		Trie trie = new Trie();
		for (int i = 0; i <= 800; i++){
			Double d = Math.pow(2,i);
			trie.add(""+ d.intValue());
		}


		for (int i = 0; i < N; i++){
			line = in.nextLine();
			for (int a = 0; a < line.length(); a++ ){
				for (int b = a+1; b < line.length(); b++ ){
					if(trie.contains(strength(line, a, b)))
						count++;
				}
			}
			System.out.println(count);
			count = 0;
		}

	}

	public static boolean powerOfTwo(String x){
		int value = 0, reminder = 0, result = 0;
		String next = "";

		while (x.length() > 1){
			for (int i = 0; i < x.length(); i++){
				value = reminder * 10 + Character.getNumericValue( x.charAt(i) );
				result += value / 2;
				reminder = value % 2;
				if (i != 0 || result != 0) next += result;
			}

		}
		return true;
		//return (x != 0) && ((x & (x - 1)) == 0);
	}

	public int equilibrium(int[] A) {
		if (A.length == 0) return -1;
				// write your code in Java SE 8

		BigInteger left = BigInteger.valueOf(0), right = BigInteger.valueOf(0);

		for (int i = 1; i < A.length; i++){
			right = right.add(BigInteger.valueOf(A[i]));
		}

		for (int i = 0; i < A.length; i++){
			if (right.equals(left)) return i;
			if (i < A.length - 1 ) right = right.subtract(BigInteger.valueOf(A[i+1]));
			else right = BigInteger.valueOf(0);
			left = left.add(BigInteger.valueOf(A[i]));
		}

		return -1;
	}

	public int binaryGap(int N) {
		// write your code in Java SE 8
		String binary = Integer.toBinaryString(N);
		binary = binary.replaceAll("(0+)$", "");
		String[] strings = binary.split("1+");
		int max = 0;
		for( String string : strings){
			if (string.length() > max) max = string.length();
		}

		return max;
	}

	public int[] cyclicRotation(int[] A, int k) {
		// write your code in Java SE 8
		k = k % A.length;
		int tmp;
		int[]
				end = Arrays.copyOfRange(A, 0, k),
				start = Arrays.copyOfRange(A, k+1, A.length)
		;
		for (int i = 0; i < A.length; i++){
			tmp = A[i];
			A[i] = A[(i+k)%A.length];
		}

		return null;
	}

	public int disjoint(int[] A, int[] B) {
		// write your code in Java SE 8
		/**
		 *  we can sort the two series and remain into O(nlog(n)) with space complexity O(log(n))
		 *  as Arrays.sort is a quicksort we can use it
		 *  then we compare item by item if A[i] <= B[i] and B[i] >= A[i+1] if so,
		 * 	we include them in our current pairwise disjoint interval,
		 * 	if not we close our current set and open a new one.
		 *
		 * 	Given the assumptions we may say that at every point A[i] < B[i] is true.
		 * */


		if (A.length == 0) return 0;
		Arrays.sort(A);
		Arrays.sort(B);

		int disjointSetsCounter = 1;
		for (int i = 0; i < A.length - 1; i++){
			if (B[i] < A[i+1]) disjointSetsCounter++;
		}

		return disjointSetsCounter;
	}




	private Node head;
//	private int size;
	private Stack<Node> transactionHeads;


	private static class Node {
		private int value;
		private Node next;
	}

	public Solution() {
		transactionHeads = new Stack<>();
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
