class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        int MOD = 1_000_000_007;
        long[] dp = new long[arr.length];
        Arrays.fill(dp , 1);
        Map<Integer, Integer> map =  new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j  = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j])) {
                    dp[i] += dp[j] * (dp[map.get(arr[i] / arr[j])]) % MOD;
                }
            }
        }
        long res = 0;
        for (int i = 0; i < dp.length; i++) {
            // System.out.println(dp[i]);
            res += dp[i];
        }

        return (int)(res % MOD);
    }
}