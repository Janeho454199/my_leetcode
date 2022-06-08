/*
符合下列属性的数组 arr 称为 山峰数组（山脉数组） ：

arr.length >= 3
存在 i（0 < i< arr.length - 1）使得：
arr[0] < arr[1] < ... arr[i-1] < arr[i]
arr[i] > arr[i+1] > ... > arr[arr.length - 1]
给定由整数组成的山峰数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i ，即山峰顶部。
 */

public class 剑指OfferII069山峰数组的顶部 {
    public static int peakIndexInMountainArray(int[] arr) {
        // 只有一个顶峰，且顶峰不会是头尾，那么就好处理了
        // 顶峰的条件必然是arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]
        // 当前是单调递增的时候，证明顶峰在右边，当前是单调递减的时候，证明顶峰在左边
        int left = 1;
        int right = arr.length - 2;
        while(left <= right) {
            int mid = (right + left) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
                // 单调递增，顶峰在右
            } else if(arr[mid] < arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                left = mid + 1;
                // 单调递减，顶峰在左
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] a = {3,4,5,1};
        peakIndexInMountainArray(a);
    }
}
