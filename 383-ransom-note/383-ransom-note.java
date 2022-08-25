class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] lettersFreq = new int[26];
        for(char c : magazine.toCharArray())
            lettersFreq[c - 'a']++;
        
        for(char c : ransomNote.toCharArray()){
            if(lettersFreq[c - 'a'] == 0)
                return false;
            lettersFreq[c - 'a']--;
        }
        
        return true;
    }
}