class Solution {
    private static final int MOD = 1_000_000_007;

    public int distinctSubseqII(String s) {
        long[] dp = new long[26];
        long total = 0;

        for(int c:s.toCharArray()){
            int idx = c - 'a';
            long newCount = (total + 1) % MOD;
            total = (total - dp[idx] + newCount + MOD) % MOD;
            dp[idx] = newCount;
        }
        return (int) total;
    }
}