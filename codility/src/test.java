public class test {
	public test(){}

	public static void main(String[] args){
		test t = new test();

		Solution s = new Solution();
		//int[] a = {0, -2147483648, -2147483648};
		//System.out.println(s.equilibrium(arr));
		//System.out.println(s.binaryGap(51712));


//		int[]
//				a = {-1000000000, -1000000000, 1000000000, 5, -5, -1000000000},
//				b = {-999999998, -999999999, 1000000000, 6, 4, 0};
////				a = {},
////				b = {};
////				a = {1, 12, 42, 70, 36, -4, 43, 15},
////				b = {5, 15, 44, 72, 36, 2, 69, 24};
//		System.out.println(s.disjoint(a,b));

		example1();
		example2();
	}

	public static void example1() {
		Solution sol = new Solution();
		sol.push(5);
		sol.push(2);                    // stack: [5,2]
		assert sol.top() == 2;
		sol.pop();                      // stack: [5]
		assert sol.top() == 5;

		Solution sol2 = new Solution();
		assert sol2.top() == 0;         // top of an empty stack is 0
		sol2.pop();                     // pop should do nothing
	}

	public static void example2() {
		Solution sol = new Solution();
		sol.push(4);
		sol.begin();                    // start transaction 1
		sol.push(7);                    // stack: [4,7]
		sol.begin();                    // start transaction 2
		sol.push(2);                    // stack: [4,7,2]
		assert sol.rollback() == true;  // rollback transaction 2
		assert sol.top() == 7;          // stack: [4,7]
		sol.begin();                    // start transaction 3
		sol.push(10);                   // stack: [4,7,10]
		assert sol.commit() == true;    // transaction 3 is committed
		assert sol.top() == 10;
		assert sol.rollback() == true;  // rollback transaction 1
		assert sol.top() == 4;          // stack: [4]
		assert sol.commit() == false;   // there is no open transaction
	}
}


