class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        char[] arr = s.toLowerCase().toCharArray();
        while(l < r){
            if(!Character.isLetterOrDigit(arr[l])) l++;
            else if(!Character.isLetterOrDigit(arr[r])) r--;
            else if(arr[l] != arr[r]) return false;
            else{
                l++;
                r--;
            }
        }
        return true;
    }
}