import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 力扣杨辉三角2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        // 排除
        if (rowIndex == 0) {
            for(int i = 0; i < rowIndex + 1; i++){
                result.add(1);
            }
            return result;
        }
        for(int i = 0; i < rowIndex + 1; i++){
            result.add(1);
        }
        for(int i = 2; i < rowIndex + 1; i++){
            for(int j = i - 1; j > 0; j--){
                result.set(j,result.get(j - 1) + result.get(j));
            }
        }
        return result;
    }
}
