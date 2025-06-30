class Solution {
    public int rob(int[] nums) {

        // 각 집의 금액을 나타내는 int[] nums

        // 같은 날 밤 인접한 두 집에 침입이 발생하면 자동으로 경찰에 신고된다
        // 오늘 밤 훔칠 수 있는 최대 금액을 return

        int n = nums.length;
        int[] dp = new int[n + 1]; //내가 턴 집
        Arrays.fill(dp, -1);

        dp[0] = 0;
        dp[1] = nums[0]; //1번집 턴 금액


        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], nums[i-1] + dp[i-2]);
        }
        return dp[n];
    }
}