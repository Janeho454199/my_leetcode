public class 力扣922按奇偶排序数组 {
    public int[] sortArrayByParityII(int[] A) {
        int[] a = new int[A.length/2];
        int[] b = new int[A.length/2];
        int j = 0;
        int k = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] % 2 != 0){
                a[j] = A[i];
                j++;
            }else{
                b[k] = A[i];
                k++;
            }
        }
        j = 0;
        k = 0;
        int[] result = new int[A.length];
        for(int i = 0; i < result.length; i++){
            if(i % 2 == 0){
                result[i] = b[j];
                j++;
            }else{
                result[i] = a[k];
                k++;
            }
        }
        return result;
    }
}
