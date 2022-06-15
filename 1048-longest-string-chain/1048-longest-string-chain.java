class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        HashMap<String, Integer> map = new HashMap<>();
        int maxLength = 1;
        map.put(words[0], 1);
        for(int i = 1; i < words.length; i++){
            String word = words[i];
            int length = 1;
            for(int j = 0; j < word.length(); j++){
                length = Math.max(length, map.getOrDefault(removeCharAt(word, j), 0) + 1);
            }
            map.put(word, length);
            maxLength = Math.max(length, maxLength);
            
        }
        return maxLength;
    }
    
     public String removeCharAt(String str, int index) {
        return str.substring(0,index) + str.substring(index + 1, str.length());

    }
}