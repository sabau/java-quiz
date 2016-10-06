import java.util.Scanner;

public class BubbleSort {
	int[] a;
	int n;
	int totalNumberOfSwaps;

	public BubbleSort(int[] arr){
		a = arr;
		n = arr.length;
		totalNumberOfSwaps = 0;
	}

	public void sort(){
		for (int i = 0; i < n; i++) {
			// Track number of elements swapped during a single array traversal
			int numberOfSwaps = 0;

			for (int j = 0; j < n - 1; j++) {
				// Swap adjacent elements if they are in decreasing order
				if (a[j] > a[j + 1]) {
					swap(j, j + 1);
					numberOfSwaps++;
				}
			}
			totalNumberOfSwaps += numberOfSwaps;
			// If no elements were swapped during a traversal, array is sorted
			if (numberOfSwaps == 0) {

				break;
			}
		}
	}

	private void swap(int i, int j){
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	private void print(){
		System.out.format("Array is sorted in %d swaps.\n", totalNumberOfSwaps);
		System.out.format("First Element: %d\n", a[0]);
		System.out.format("Last Element: %d\n", a[a.length-1]);
	}

	public static<E> void printArray(E[] a){
		for (E el : a){
			System.out.println(el);
		}

	}

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++){
			a[i] = in.nextInt();
		}
		BubbleSort b = new BubbleSort(a);
		b.sort();
		b.print();
	}
}