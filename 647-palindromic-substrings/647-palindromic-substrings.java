class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            count+= countSubstringsFromCenter(s, i);
        }
        return count;
    }
    
    public int countSubstringsFromCenter(String s, int center){
        int count = 1;
        count+= expandAndCountSubstringFromCenter(s, center - 1, center + 1);
        count+= expandAndCountSubstringFromCenter(s, center - 1, center);
        return count;
    }
    
    public int expandAndCountSubstringFromCenter(String s, int l, int r){
        int count = 0;
        while( l >= 0 && r < s.length() ){
            if(s.charAt(l--) != s.charAt(r++) )
                break;
            count++;
        }
        return count;
    }
}