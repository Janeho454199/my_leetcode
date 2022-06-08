public class 力扣双周赛第一题矩阵对角线元素的和 {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        int k = 0;
        for(int i = 0; i < n; i++){
            sum += mat[i][i];
        }
        for(int j = n - 1; j >= 0; j--){
            if(n % 2 != 0 && j == (n-1)/2 + 1 - 1){
                k++;
                continue;
            }else{
                sum += mat[j][k];
                k++;
            }
        }
        return sum;
    }
}
