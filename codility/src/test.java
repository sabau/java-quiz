import java.util.Scanner;

public class test {
	public test(){}

	public static void main(String[] args){
		test t = new test();

		Solution s = new Solution();
//		int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//		int rotate = -64;
//		//System.out.println(s.equilibrium(arr));
//		//System.out.println(s.binaryGap(51712));
//		System.out.println(Arrays.toString(a));
//		System.out.println("rot " + rotate);
//		System.out.println(Arrays.toString(s.cyclicRotation(a,rotate)));
		Scanner in = new Scanner(System.in);
//		String S = in.next();
//		try {
//			System.out.format("%d", Integer.parseInt(S));
//		}catch (NumberFormatException e){
//			System.out.println("Bad String");
//		}
		Calculator c = new Calculator();
		int T=in.nextInt();
		while(T-->0)
		{
			int n = in.nextInt();
			int p = in.nextInt();
			Calculator myCalculator = new Calculator();
			try
			{
				int ans=myCalculator.power(n,p);
				System.out.println(ans);

			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

//		int[]
//				a = {-1000000000, -1000000000, 1000000000, 5, -5, -1000000000},
//				b = {-999999998, -999999999, 1000000000, 6, 4, 0};
////				a = {},
////				b = {};
////				a = {1, 12, 42, 70, 36, -4, 43, 15},
////				b = {5, 15, 44, 72, 36, 2, 69, 24};
//		System.out.println(s.disjoint(a,b));

//		example1();
//		example2();
	}

	public static void example1() {
		Stack sol = new Stack();
		sol.push(5);
		sol.push(2);                    // stack: [5,2]
		assert sol.top() == 2;
		sol.pop();                      // stack: [5]
		assert sol.top() == 5;

		Stack sol2 = new Stack();
		assert sol2.top() == 0;         // top of an empty stack is 0
		sol2.pop();                     // pop should do nothing
	}

	public static void example2() {
		Stack sol = new Stack();
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


