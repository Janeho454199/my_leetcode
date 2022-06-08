import java.util.ArrayList;

public class 力扣205周赛替换所有的问号 {
    public String modifyString(String s) {
        //排除
        if (s.length() == 0){
            String temp = "";
            return temp;
        }
        if (s.length() == 1){
            if(s.charAt(0) == '?'){
                String temp = "a";
                return temp;
            }else {
                return s;
            }
        }
        StringBuilder str = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (str.charAt(i) == '?') {
                if (i == 0) {
                    for (int j = 0; j < 24; j++) {
                        if (str.charAt(i + 1) != j+97) {
                            char temp = (char) (j + 97);
                            str.setCharAt(i, temp);
                            break;
                        }
                    }
                } else if (i == s.length() - 1) {
                    for (int j = 0; j < 24; j++) {
                        if (str.charAt(i - 1) != j+97) {
                            char temp = (char) (j + 97);
                            str.setCharAt(i, temp);
                            break;
                        }
                    }
                } else {
                    for (int j = 0; j < 24; j++) {
                        if (str.charAt(i + 1) != j + 97 && str.charAt(i - 1) != j + 97) {
                            char temp = (char) (j + 97);
                            str.setCharAt(i, temp);
                            break;
                        }
                    }
                }
            }
        }
        return str.toString();
    }
}
