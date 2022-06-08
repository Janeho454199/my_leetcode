public class 力扣搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        // 第一次二分
        int left = 0;
        int right = (n - 1)/2;
        int mid = right/2;
        while(left < right){
            int temp = matrix[mid][0];
            if(target == matrix[mid][0]){
                return true;
            }else if(matrix[mid][0] > target){
                right = mid;
            }else{
                left = mid;
            }
            mid = (right - left)/2;
        }
        return false;
    }
}
