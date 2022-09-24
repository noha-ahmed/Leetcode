class Solution {
    public int concatenatedBinary(int n) {
        long result=1;
        int length=0;
        for(int i=2;i<=n;i++) {
            // length of number in binary form
            length=((int)(Math.log(i)/Math.log(2)))+1;
            result=((result<<length)+i)%1000000007;
        }
        return (int)result;
    }
}