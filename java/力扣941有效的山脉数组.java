public class 力扣941有效的山脉数组 {
    public boolean validMountainArray(int[] A) {
        if(A.length < 3 || A[0] > A[1]){
            return false;
        }
        int flag = 0;
        for(int i = 0; i < A.length - 1; i++){
            if((A[i] < A[i + 1]) && flag == 0){
                continue;
            }else if(A[i] > A[i + 1]){
                flag = 1;
                continue;
            }else{
                return false;
            }
        }
        if(flag != 0){
            return true;
        }else{
            return false;
        }
    }
}
