public class 力扣38外观数列 {
    public static String countAndSay(int n) {
        String result = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int left = 0;
            int right = 0;
            while (left < result.length()) {
                while (right < result.length() && result.charAt(right) == result.charAt(left)) {
                    right++;
                }
                sb.append(Integer.toString(right - left)).append(result.charAt(left));
                left = right;
            }
            result = sb.toString();
        }
        return result;
    }

    public static String countAndSay2(int n) {
        if (n <= 0) {
            return "";
        }
        if (n == 1) {
            return "1";
        }
        String[] dp = new String[n + 1];
        dp[1] = "1";
        dp[2] = "11";
        for (int i = 3; i <= n; i++) {
            dp[i] = describe(dp[i - 1]);
        }
        return dp[n];
    }
    //从第三个开始分别描述前一个数
    private static String describe(String pre) {
        StringBuilder ans = new StringBuilder();
        int len = pre.length();
        //num = 第n项，count = 出现次数
        int num = pre.charAt(0) - '0';
        int count = 1;
        for (int i = 1; i < len; i++) {
            //如果相等则count++
            if (pre.charAt(i) == pre.charAt(i - 1)) {
                count++;
                //否则将统计次数和元素添加
            } else {
                ans.append(count);
                ans.append(num);
                num = pre.charAt(i) - '0';
                count = 1;
            }
            if (i == len - 1) {
                ans.append(count);
                ans.append(num);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        int a = 5;
        countAndSay2(a);
    }
}
