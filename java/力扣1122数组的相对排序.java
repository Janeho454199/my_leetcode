import java.lang.reflect.Array;
import java.util.*;

public class 力扣1122数组的相对排序 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //利用哈希表
        Map<Integer, Integer> HM = new HashMap<Integer, Integer>();
        Map<Integer, Integer> HM1 = new HashMap<Integer, Integer>();
        for(int i:arr1){
            boolean flag = HM.containsKey(i);
            HM.put(i, flag == true? HM.get(i)+1:1);
        }
        for(int i:arr2){
            HM1.put(i, 1);
        }
        int[] result = new int[arr1.length];
        List<Integer> e = new LinkedList<>();
        int j = 0;
        //把额外的数组排好序拿出来
        Arrays.sort(arr1);
        for(int i = 0; i < arr1.length; i++){
            if(HM1.get(arr1[i]) == null){
                e.add(arr1[i]);
                HM.remove(arr1[i]);
            }
        }
        for(int i = 0; i < arr2.length; i++){
            for(int k = 0; k < HM.get(arr2[i]); k++){
                result[j] = arr2[i];
                j++;
            }
        }
        for(int i = 0; i < e.size(); i++){
            result[j] = e.get(i);
            j++;
        }
        return result;
    }
}
