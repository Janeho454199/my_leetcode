public class 力扣最长湍流子数组 {
    public int maxTurbulenceSize(int[] arr) {
        //dp[][],0=up,1=down
        int n = arr.length;
        int[][] dp = new int[n][2];
        int max_length = 1;
        dp[0][0] = dp[0][1] = 1;
        for(int i = 1; i < n; i++){
            if(arr[i] > arr[i - 1]){
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = 1;
                max_length = Math.max(max_length, dp[i][0]);
            }else if(arr[i] < arr[i - 1]){
                dp[i][1] = dp[i - 1][0] + 1;
                dp[i][0] = 1;
                max_length = Math.max(max_length, dp[i][1]);
            }else{
                dp[i][0] = 1;
                dp[i][1] = 1;
            }
        }
        return max_length;
    }
}
