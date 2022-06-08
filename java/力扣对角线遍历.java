import java.util.ArrayList;

public class 力扣对角线遍历 {
    public int[] findDiagonalOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        //排除
        if (n == 0){
            return new int[0];
        }
        int j = 0;
        int k = 0;
        int asIndex = 0;
        int[] arr = new int[n*m];

        for (int i = 0; i < n + m - 1; i++){
            if(i % 2 == 0){
                while(j >= 0 && k < m){
                    arr[asIndex] = matrix[j][k];
                }
            }
        }
        return arr;
    }
}
