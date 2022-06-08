import java.util.Arrays;

public class 力扣可获得的最大点数 {
    public int maxScore(int[] cardPoints, int k) {
        //滑动窗口
        int n = cardPoints.length;
        if(n == 0){
            return 0;
        }
        int left = 0;
        int right = n - k;
        //计算当前滑动窗口的值
        int temp_sum = 0;
        for (int i = 0; i < right; i++) {
            temp_sum += cardPoints[i];
        }
        //求出滑动窗口的最小值
        int min_sum = temp_sum;
        while(right < n){
            temp_sum = temp_sum - cardPoints[left] + cardPoints[right];
            min_sum = Math.min(temp_sum, min_sum);
            left++;
            right++;
        }
        return Arrays.stream(cardPoints).sum() - min_sum;
    }
}
