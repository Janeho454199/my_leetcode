import java.util.Arrays;


public class sortASCI {
    public String sort(String s){
        char[] result = s.toCharArray();
        int[] ASCI = new int[result.length];
        for(int i = 0; i < result.length; i++){
            ASCI[i] = result[i];
        }
        Arrays.sort(ASCI);
        for(int i = 0; i < result.length; i++){
            ASCI[i] += 3;
            result[i] = (char)ASCI[i];
        }
        return result.toString();
    }
}
