import java.util.ArrayList;

public class SubArraysGivenSum {

	private static boolean dp[][];

	private static Boolean subArrayExistsWithSumRecursive(int[] arr, int size, int sum) {
		if (sum == 0)
			return true;
		if (size == 0 && sum != 0)
			return false;
		if (arr[size - 1] > sum)
			return subArrayExistsWithSumRecursive(arr, size - 1, sum);
		return subArrayExistsWithSumRecursive(arr, size - 1, sum)
				|| subArrayExistsWithSumRecursive(arr, size - 1, sum - arr[size - 1]);
	}

	private static Boolean subArrayExistsWithSum(int arr[], int size, int sum) {
		dp = new boolean[size + 1][sum + 1];
		for (int i = 0; i <= size; ++i) {
			dp[i][0] = true;
		}
		for (int i = 1; i <= sum; ++i) {
			dp[0][i] = false;
		}
		for (int i = 1; i <= size; ++i) {
			for (int j = 1; j <= sum; ++j) {
				if (j < arr[i - 1])
					dp[i][j] = dp[i - 1][j];
				if (j >= arr[i - 1])
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
			}
		}
		return dp[size][sum];
	}

	private static void printSubsets(int arr[], int i, int sum, ArrayList<Integer> p) {
		if (i == 1 && sum != 0 && dp[1][sum]) {
			p.add(arr[i-1]);
			System.out.println(p);
			p.clear();
			return;
		}
		if (sum == 0 && i == 1) {
			System.out.println(p);
			p.clear();
			return;
		}
		if (dp[i][sum]) {
			ArrayList<Integer> b = new ArrayList<Integer>();
			b.addAll(p);
			printSubsets(arr, i - 1, sum, b);
		}
		if (sum >= arr[i-1] && dp[i][sum - arr[i-1]]) {
			p.add(arr[i-1]);
			printSubsets(arr, i - 1, sum - arr[i-1], p);
		}
	}

	public static void main(String[] args) {
		int superSet[] = { 1, 3, 5, 7, 9 };
		int sum = 9;
		String outputDP = subArrayExistsWithSum(superSet, superSet.length, sum) ? "EXISTS" : "DOES NOT EXIST";
		String outputRecursive = subArrayExistsWithSumRecursive(superSet, superSet.length, sum) ? "EXISTS"
				: "DOES NOT EXIST";
		System.out.println("DP SOLUTION");
		System.out.println("Subset with the given array and sum " + outputDP);
		System.out.println("RECURSIVE SOLUTION");
		System.out.println("Subset with the given array and sum " + outputRecursive);
		if (subArrayExistsWithSum(superSet, superSet.length, sum)) {
			ArrayList<Integer> p = new ArrayList<Integer>();
			System.out.println("Possible subsets are : ");
			printSubsets(superSet, superSet.length, sum, p);

		}

	}

}
