public class 力扣尽可能使字符串相等 {
    public int equalSubstring(String s, String t, int maxCost) {
        //滑动窗口
        int n = s.length();
        int[] costs = new int[n];
        for(int i = 0; i < n; i++){
            costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        //[1,1,1,2]
        int left = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += costs[i];
            if(sum > maxCost){
                sum = sum - costs[left];
                left+=1;
            }
        }
        return n - left;
    }
}
