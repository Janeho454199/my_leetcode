import java.math.BigInteger;

public class 力扣加一 {
    public int[] plusOne(int[] digits) {
        int temp = 0;
        for(int i = 0; i < digits.length; i++){
            temp += Math.pow(10, digits.length - 1 - i) * digits[i];
        }
        temp = temp + 1;
        int n = String.valueOf(temp).length();
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            int j = new Double(Math.pow(10, result.length - 1 - i)).intValue();
            result[i] = (temp / j) % 10;
        }
        return result;
    }
}
