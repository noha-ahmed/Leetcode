class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        HashMap<String, Integer> map = new HashMap<>(words.length);
        int maxLength = 1;
        map.put(words[0], 1);
        for(int i = 1; i < words.length; i++){
            String word = words[i];
            StringBuilder strBuilder = new StringBuilder(word);
            int length = 1;
            for(int j = 0; j < word.length(); j++){
                strBuilder.deleteCharAt(j);
                length = Math.max(length, map.getOrDefault(strBuilder.toString(), 0) + 1);
                strBuilder.insert(j, word.charAt(j));
            }
            map.put(word, length);
            maxLength = Math.max(length, maxLength);
            
        }
        return maxLength;
    }
}