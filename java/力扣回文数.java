public class 力扣回文数 {
    public boolean isPalindrome(int x) {
        if(x <= 0){
            return false;
        }
        int temp = x;
        int reverseNum = 0;
        while(temp != 0){
            int add = temp % 10;
            reverseNum = reverseNum * 10 + add;
            temp = temp / 10;
        }
        return reverseNum == x;
    }
}
