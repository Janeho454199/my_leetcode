import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class 力扣575分糖果 {
//    输入: candies = [1,1,2,2,3,3]
//    输出: 3
//    解析: 一共有三种种类的糖果，每一种都有两个。
//    最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
    public int distributeCandies(int[] candyType) {
        if (candyType.length == 2) {
            return 1;
        }
        Set<Integer> sis = new HashSet<>();
        for (int candy:candyType) {
            sis.add(candy);
        }
        if (sis.size() >= candyType.length/2) {
            return candyType.length/2;
        } else {
            return sis.size();
        }
    }
}
