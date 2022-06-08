import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 力扣每日温度 {
//    public int[] dailyTemperatures(int[] T) {
//        Stack<Integer> stack = new Stack();
//        int[] result = new int[T.length];
//        for(int i = 0; i < T.length; i++){
//            stack.push(T[i]);
//            int temp = stack.peek();
//            for(int j = i + 1; j < T.length; j++){
//                if(T[j] <= temp){
//                    stack.push(T[j]);
//                }else if(T[j] > temp){
//                    result[i] = stack.size();
//                    stack.clear();
//                    break;
//                }
//            }
//            if(!stack.isEmpty()){
//                result[i] = 0;
//            }
//        }
//        return result;
//    }
    public int[] dailyTemperatures(int[] T) {
    int length = T.length;
    int[] ans = new int[length];
    Deque<Integer> stack = new LinkedList<Integer>();
    for (int i = 0; i < length; i++) {
        int temperature = T[i];
        while (!stack.isEmpty() && temperature > T[stack.peek()]) {
            int prevIndex = stack.pop();
            ans[prevIndex] = i - prevIndex;
        }
        stack.push(i);
    }
    return ans;
    }
}
