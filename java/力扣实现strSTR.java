import java.util.ArrayList;
import java.util.List;

public class 力扣实现strSTR {
    public int strStr(String haystack, String needle) {
        //排除
        if(haystack.length() == 0 && needle.length() == 0){
            return 0;
        }
        if(haystack.length() == 0){
            return -1;
        }
        if(needle.length() == 0){
            return 0;
        }
        if(needle.length() > haystack.length()){
            return -1;
        }

        //将字符串转换为char数组
        char[] fir = new char[haystack.length()];
        fir = haystack.toCharArray();
        char[] sec = new char[needle.length()];
        sec = needle.toCharArray();

        int l = 0;
        int r = 0;
        for(int i = 0; i < haystack.length(); i++){
            if(fir[i] == sec[l] && needle.length() == 1){
                return i;
            }
            if(fir[i] == sec[l] && haystack.length() - i >= needle.length()){
                r = i + 1;
                l++;
                while (l <= needle.length()){
                    if(l == needle.length()){
                        return i;
                    }
                    if(fir[r] == sec[l]){
                        l++;
                        r++;
                    } else {
                        l = 0;
                        break;
                    }
                }
            }
        }
        return -1;
    }
}
