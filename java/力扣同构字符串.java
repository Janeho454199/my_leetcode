import java.util.HashMap;
import java.util.Map;

public class 力扣同构字符串 {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> occur = new HashMap<>();
        HashMap<Character, Character> occur1 = new HashMap<>();
        if(s.length() == 0){
            return true;
        }
        for(int i = 0; i < s.length(); i++){
            if(occur.containsKey(s.charAt(i)) && occur.get(s.charAt(i)) != t.charAt(i) || occur1.containsKey(t.charAt(i)) && occur1.get(t.charAt(i)) != s.charAt(i)){
                return false;
            }
            occur.put(s.charAt(i),t.charAt(i));
            occur1.put(t.charAt(i),s.charAt(i));
        }
        return true;
    }
}
