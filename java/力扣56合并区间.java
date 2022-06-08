import java.util.Arrays;
import java.util.Stack;

public class 力扣56合并区间 {
    public int[][] merge(int[][] intervals) {
        //排除
        if(intervals.length == 1 || intervals.length == 0){
            return intervals;
        }
        //将区间排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        //创建一个栈存储区间信息
        Stack<Integer> target = new Stack<>();
        //把第一个区间放到栈中
        target.push(intervals[0][0]);
        target.push(intervals[0][1]);
        //一个区间一个区间的比较
        for(int i=1; i < intervals.length; i++){
            if(target.peek() >= intervals[i][0]){
                if(target.peek() <= intervals[i][1]){
                    target.pop();
                    target.push(intervals[i][1]);
                }
            }else {
                target.push(intervals[i][0]);
                target.push(intervals[i][1]);
            }
        }
        int[][] newIntervalsLength = new int[target.size()/2][2];
        for(int j = newIntervalsLength.length-1; j>=0; j--){
            newIntervalsLength[j][1] = target.pop();
            newIntervalsLength[j][0] = target.pop();
        }
        return newIntervalsLength;
    }
}
