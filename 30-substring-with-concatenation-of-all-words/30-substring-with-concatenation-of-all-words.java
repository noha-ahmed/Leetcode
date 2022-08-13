class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> wordsMap = new HashMap<>();
        
        for(String word : words)
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        
        List<Integer> sol = new LinkedList<>();
        HashMap<String, Integer> wordsFound = new HashMap<>(); 
        
        int wordSize = words[0].length(), wordsNum = words.length,
        foundWordsNum = 0, startIndx = 0;
        
        for(int i = 0; i < s.length() - wordSize + 1;){
            String word = s.substring(i, i + wordSize);
            int wordOccurence = wordsMap.getOrDefault(word, 0);
            int wordLeft = wordOccurence - wordsFound.getOrDefault(word, 0);
            
            if( wordLeft == 0 ){   
                wordsFound.clear(); foundWordsNum = 0;
                startIndx+=1 ; i = startIndx;
            }
            else{
                foundWordsNum++;
                wordsFound.put(word, wordsFound.getOrDefault(word, 0) + 1);
                i+= wordSize;
                
               if( foundWordsNum == wordsNum){
                   sol.add(startIndx);
                   wordsFound.clear();  foundWordsNum = 0;
                   startIndx+=1; i = startIndx;
               }
            }
        }
        
        return sol;
    }
}