class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagrams = new HashMap<>();
        for(String str: strs){
            String hash = hash(str);
            List<String> words = anagrams.getOrDefault(hash, new LinkedList<>());
            words.add(str);
            anagrams.put(hash, words);
        }
        
        List<List<String>> sol = new LinkedList<>();
        sol.addAll(anagrams.values());
        return sol;
    }
    
    private String hash(String str){
        char[] freq = new char[26];
        for(int c : str.toCharArray())
            freq[c - 'a']++;
        return new String(freq);
    }
}