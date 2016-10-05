class Calculator implements AdvancedArithmetic{
	Calculator(){}

	public int power(int n, int p) throws Exception {
		if (n < 0 || p < 0) throw new Exception("n and p should be non-negative");
		return (new Double(Math.pow(n,p))).intValue();
	}

	public int divisorSum(int n) {
		if (n == 0) return 0;
		int count = n;
		for (int i = Math.round(n/2); i > 0; i--){
			if (n % i == 0) count+=i;
		}
		return count;
	}
}