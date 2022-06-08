import java.util.HashMap;
import java.util.Map;

public class 力扣单词规律 {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        String[] arr = str.split(" ");
        //如果二者长度都不等，那么根本无法匹配 直接返回false
        if(pattern.length() != arr.length)
            return false;
        for(int i = 0; i < pattern.length(); i++){
            if(!map.containsKey(pattern.charAt(i))){
                if(map.containsValue(arr[i]))
                    return false;
                map.put(pattern.charAt(i), arr[i]);
            }
            else{
                if(!map.get(pattern.charAt(i)).equals(arr[i]))
                    return false;
            }
        }
        return true;
    }
}
