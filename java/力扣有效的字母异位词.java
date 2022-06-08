import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class 力扣有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        //哈希表或者list，两次遍历
        if(s.length() != t.length()){
            return false;
        }else if(s.equals("") && t.equals("")){
            return true;
        }
        Map<String, Integer> occur1 = new HashMap<String, Integer>();
        Map<String, Integer> occur2 = new HashMap<String, Integer>();
        for(int i = 0; i < s.length(); i++){
            String temp = String.valueOf(s.charAt(i));
            occur1.put(temp, occur1.get(temp) == null? 0:occur1.get(temp)+1);
        }
        for(int i = 0; i < s.length(); i++){
            String temp = String.valueOf(t.charAt(i));
            occur2.put(temp, occur2.get(temp) == null? 0:occur2.get(temp)+1);
        }
        for(int i = 0; i < s.length(); i++){
            String temp = String.valueOf(s.charAt(i));
            if(occur1.get(temp) != occur2.get(temp)){
                return false;
            }
        }
        return true;
    }
}
