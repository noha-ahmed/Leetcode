class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagrams = new HashMap<>();
        for(String str: strs){
            String sortedStr = sort(str);
            List<String> words = anagrams.getOrDefault(sortedStr, new LinkedList<>());
            words.add(str);
            anagrams.put(sortedStr, words);
        }
        
        List<List<String>> sol = new LinkedList<>();
        for(List<String> anagramGroup : anagrams.values())
            sol.add(anagramGroup);
        return sol;
    }
    
    private String sort(String str){
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}