class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int l = 0;
        HashMap<Character, Integer> lastIndexMap = new HashMap<>(128);
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int lastIndex = lastIndexMap.getOrDefault(c, -1);
            if( lastIndex >= l )
                l = lastIndex + 1;
             lastIndexMap.put(c, i);
             maxLen = Math.max(maxLen, i - l + 1);
        }
        return maxLen;
    }
}