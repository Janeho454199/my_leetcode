public class 力扣零矩阵 {
    public void setZeroes(int[][] matrix) {
        int j = 0;
        int k = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            System.arraycopy(matrix[i], 0, newMatrix[i], 0, matrix[i].length);
        }
        for(int i = 0; i < n*m; i++){
            if(matrix[j][k] == 0){
                for(int l = 0;l < matrix[j].length; l++){
                    newMatrix[j][l] = 0;
                }
                for(int l = 0;l < matrix.length; l++){
                    newMatrix[l][k] = 0;
                }
            }
            k++;
            if(k == m){
                k = 0;
                j++;
            }
            if(j == n){
                j = 0;
            }
        }
        for(int i = 0; i < matrix.length; i++){
            System.arraycopy(newMatrix[i], 0, matrix[i], 0, newMatrix[i].length);
        }
    }
    public void setZeroes2(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean row0_flag = false;
        boolean col0_flag = false;
        // 第一行是否有零
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                row0_flag = true;
                break;
            }
        }
        // 第一列是否有零
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                col0_flag = true;
                break;
            }
        }
        // 把第一行第一列作为标志位
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 置0
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row0_flag) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0_flag) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}