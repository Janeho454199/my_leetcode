public class 力扣旋转矩阵 {
    public void rotate(int[][] matrix) {
    int n = matrix.length;
    int[][] newMatrix = new int[n][matrix[0].length];
    int k = n - 1;
    int j = 0;
    int l = 0;
    for(int i = 0; i < n * n; i++){
        newMatrix[i % n][k] = matrix[j][l];
        l++;
        if(l == n){
            j++;
            k--;
            l = 0;
        }
    }
    for(int i = 0; i < matrix.length; i++){
        System.arraycopy(newMatrix[i], 0, matrix[i], 0, newMatrix[i].length);
    }
    }
}
