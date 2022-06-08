import java.util.ArrayList;
import java.util.List;

public class 力扣计数质数 {
    public int countPrimes(int n) {
        List<Integer> list = new ArrayList<Integer>();
        if(n == 2 || n == 1 || n == 0){
            return list.size();
        }
        for (int i = 2; i <= n; i++) {
            //去除偶数部分
            if (i % 2 == 0 && i != 2) {
                continue;
            }
            boolean flag = true;
            for (int j = 2; j <= i; j++) {
                if(!flag){
                    break;
                }
                if (i % j == 0) {
                    flag = false;
                }
            }
            if (flag) {
                list.add(i);
            }
        }
        return list.size();
    }
}
