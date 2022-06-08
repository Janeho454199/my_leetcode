import java.util.HashMap;
import java.util.Map;

public class 力扣771宝石与石头 {
    public int numJewelsInStones(String J, String S) {
        Map<Character, Integer> map = new HashMap<>();
        int num = 0;
        char[] l = J.toCharArray();
        char[] r = S.toCharArray();
        for(int i = 0; i < l.length; i++){
            map.put(l[i], 0);
        }
        for(int j = 0; j < r.length; j++){
            if(map.containsKey(r[j])){
                map.put(r[j], map.get(r[j]) + 1);
                num += 1;
            }
        }
        return num;
    }
}
