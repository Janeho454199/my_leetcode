import java.util.ArrayList;
import java.util.List;

public class 力扣较大分组的位置 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        if(s.length() < 3){
            return result;
        }
        char[] sc = s.toCharArray();
        int count = 1;
        for (int i = 0; i < sc.length - 1; i++){
            List<Integer> temp = new ArrayList<>();
            int cur = i;
            int next = i+1;
            while(sc[cur] == sc[next]){
                count++;
                next++;
                if(next >= sc.length){
                    break;
                }
            }
            if(count >= 3){
                temp.add(cur);
                temp.add(next - 1);
                i = next - 1;
                result.add(temp);
            }
            count = 1;
        }
        return result;
    }
}
