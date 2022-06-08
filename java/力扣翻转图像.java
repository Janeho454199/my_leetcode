public class 力扣翻转图像 {
    public int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        //双指针
        //头和尾做对比，当不相等的时候可不做任何变化
        //当相等的时候都变为0或者1
        for(int i = 0; i < n; i++){
            int right = m - 1;
            for(int j = right,left = 0; left <= j; j--,left++){
                if(A[i][j] == A[i][left]){
                    //^=：两个二进制的对应位相同，结果为0，否则结果为1。
                    A[i][j] = A[i][left] ^= 1;
                }
            }
        }
        return A;
    }
}
