import java.util.Arrays;

public class 力扣476数组的补数 {
    public static int findComplement(int num) {
        // 思路 转二进制，转字符串，转补数，转整数
        char[] strNum = Integer.toBinaryString(num).toString().toCharArray();
        for (int i = 0; i < strNum.length; i++) {
            if (strNum[i] == '1') {
                strNum[i] = '0';
            } else if (strNum[i] == '0') {
                strNum[i] = '1';
            }
        }
        int start = 0;
        if(strNum[0] == '0') {
            for (int j = 0; j < strNum.length; j++) {
                if (strNum[j] != '0') {
                    start = j;
                    break;
                }
            }
        }
        strNum = Arrays.copyOfRange(strNum, start, strNum.length);
        String result = String.valueOf(strNum);
        return Integer.parseInt(result, 2);
    }

    public static void main(String[] args) {
        int a = findComplement(5);
    }
}
