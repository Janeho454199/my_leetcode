public class 力扣278第一个错误版本 {

    public static boolean isBadVersion(int n) {
        boolean[] arr = {false, false, false, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true, true, true};
        return arr[n];
    }

    public static int firstBadVersion(int n) {
        if (n == 1 && isBadVersion(n)) {
            return 1;
        }
        int start = 0;
        n = n - 1;
        while (start < n) {
            int mid = start + (n - start) / 2;
            if (isBadVersion(mid) && mid != 0 && !isBadVersion(mid - 1)) {
                return mid + 1;
            } else if (!isBadVersion(mid) && mid != 0 && !isBadVersion(mid - 1)) {
                start = mid + 1;
            } else {
                n = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a = 20;
        int target = firstBadVersion(a);
    }
}
