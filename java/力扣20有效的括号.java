import java.util.Stack;

public class 力扣20有效的括号 {
    public boolean isValid(String s) {
        if(s.length() == 0 || s.length() == 1){
            return false;
        }
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                stk.push('}');
            } else if (s.charAt(i) == '[') {
                stk.push(']');
            } else if (s.charAt(i) == '(') {
                stk.push(')');
            } else if (!stk.isEmpty()) {
                char temp = stk.pop();
                if (temp != s.charAt(i)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stk.isEmpty();
    }
}
