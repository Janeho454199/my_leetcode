import java.util.ArrayList;
import java.util.List;

public class 力扣杨辉三角 {
    public List<Integer> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        // 排除
        if (numRows == 0) {
            List<Integer> row = new ArrayList<>();
            return row;
        }
        // 先将第一行放进去
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);
            // 第一个元素总是1
            row.add(1);
            // 除了第一个元素，每个元素等于上一行元素的同位元素和前一位元素
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            // 最后一个元素也总是1
            row.add(1);
            // 将整行加入
            triangle.add(row);
        }
        return triangle.get(numRows - 1);
    }
}
