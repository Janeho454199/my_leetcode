import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 力扣数组的度 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        if(n == 1){
            return 1;
        }
        if(n == 2){
            if(nums[0] == nums[1]){
                return 2;
            }else{
                return 1;
            }
        }
        int maxNum = 0;
        int tempLength = 0;
        int minLength = Integer.MAX_VALUE;
        int flag = 0;
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
                //找到度
                if(map.get(nums[i]).size() == tempLength){
                    tempLength = map.get(nums[i]).size();
                    //记录此时的元素
                    maxNum = nums[i];
                    //获取第一次出现和最后一次出现的位置并计算其长度
                    int maxLength = map.get(maxNum).size();
                    int length = map.get(maxNum).get(maxLength - 1) - map.get(maxNum).get(0) + 1;
                    //找最短
                    if(length < minLength){
                        minLength = length;
                    }
                    flag = 1;
                }else if(map.get(nums[i]).size() > tempLength){
                    tempLength = map.get(nums[i]).size();
                    //记录此时的元素
                    maxNum = nums[i];
                    //获取第一次出现和最后一次出现的位置并计算其长度
                    int maxLength = map.get(maxNum).size();
                    int length = map.get(maxNum).get(maxLength - 1) - map.get(maxNum).get(0) + 1;
                    //找最短
                    minLength = length;
                    flag = 1;
                }
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(nums[i], temp);
                if(map.get(nums[i]).size() > tempLength){
                    tempLength = map.get(nums[i]).size();
                    maxNum = nums[i];
                }
            }
        }
        if(flag == 0){
            return 1;
        }else{
            return minLength;
        }
    }
}
