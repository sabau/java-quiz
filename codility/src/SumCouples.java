/**
 * Created by web on 1/10/17.
 */
public class SumCouples {
	public static int countSumOfTwoRepresentations2(int n, int l, int r) {
		if (2*l > n) return 0;
		if (2*r < n) return 0;
		l = Math.max(l, n-r);
		return n / 2 - l + 1;
	}
}
