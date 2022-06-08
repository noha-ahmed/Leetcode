class Solution {
    public int removePalindromeSub(String s) {
        if( isPalindrome(s) ) return 1;
        return 2;
    }
    
    public boolean isPalindrome(String s){
        for(int i = 0; i < s.length()/2 ;i++)
            if( s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        return true;
    }
}