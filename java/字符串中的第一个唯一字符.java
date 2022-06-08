import java.util.HashMap;
import java.util.Map;

public class 字符串中的第一个唯一字符 {
    public int firstUniqChar(String s) {
        char[] sarray = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < sarray.length; i++){
            if(map.containsKey(sarray[i])){
                map.put(sarray[i], map.get(sarray[i]+1));
            }else{
                map.put(sarray[i], 1);
            }
        }
        for(int i = 0; i < sarray.length; i++){
            if(map.get(sarray[i]) == 1){
                return i;
            }
        }
        return 0;
    }

    public int firstUniqChar2(String s) {
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar3(String s) {
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        int n = s.length();
        // 第一次遍历，存在重复的赋值为-1，否则赋为当前位置
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (position.containsKey(ch)) {
                position.put(ch, -1);
            } else {
                position.put(ch, i);
            }
        }
        int first = n;
        // 第二次遍历，找到第一个value不为-1的值既为第一个唯一字符
        for (Map.Entry<Character, Integer> entry : position.entrySet()) {
            int pos = entry.getValue();
            if (pos != -1 && pos < first) {
                first = pos;
            }
        }
        if (first == n) {
            first = -1;
        }
        return first;
    }
}
