import java.util.Map;

public class 力扣爱生气的书店老板 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int leftSum = 0;
        int rightSum = 0;
        int midSum = 0;;
        int left = 1;
        int right = X;
        //计算窗口内的值
        for(int i = 0; i < X; i++){
            midSum += customers[i];
        }
        //计算滑动窗口右边的值
        for(int i = X; i < n; i++){
            if(grumpy[i] == 0){
                rightSum += customers[i];
            }
        }
        int Sum = leftSum + midSum + rightSum;
        int maxSum = Sum;
        while (right < n){
            if(grumpy[left - 1] == 0){
                leftSum += customers[left - 1];
            }
            if(grumpy[right] == 0){
                rightSum -= customers[right];
            }
            midSum = midSum - customers[left - 1] + customers[right];
            Sum = leftSum + rightSum + midSum;
            maxSum = Math.max(Sum, maxSum);
            left++;
            right++;
        }
        return maxSum;
    }
}
