class WordFilter {
    
    TrieNode rootP, rootS;
    HashMap<String, Integer> wordsIndexMap;

    public WordFilter(String[] words) {
        wordsIndexMap = new HashMap<>();
        rootP = new TrieNode();
        rootS = new TrieNode();
        for(int i = 0; i < words.length; i++){
            wordsIndexMap.put(words[i], i);
            insert(words[i]);
        }
        
    }
    
    private void insert(String word){
        TrieNode nodeP = rootP, nodeS = rootS;
        char[] charArr = word.toCharArray();
        for(int i = 0; i < charArr.length; i++){
            char c = charArr[i];
            if( ! nodeP.children.containsKey(c) )
                nodeP.children.put(c, new TrieNode());
            nodeP = nodeP.children.get(c);
            nodeP.words.add(word);
            
            c = charArr[charArr.length - i - 1];
            if( ! nodeS.children.containsKey(c) )
                nodeS.children.put(c, new TrieNode());
            nodeS = nodeS.children.get(c);
            nodeS.words.add(word);
            
        }
    }
    
    public int f(String prefix, String suffix) { 
        TrieNode node = rootP;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            node = node.children.getOrDefault(c, null);
            if(node == null)
                return -1;
            
        }
        Set<String> words1 = node.words;
        
        node = rootS;
        for(int i = suffix.length() - 1; i >= 0; i--){
            char c = suffix.charAt(i);
            node = node.children.getOrDefault(c, null);
            if(node == null)
                return -1;
            
        }
        Set<String> words2 = node.words;
      
        
        // String commonWord = "";
        // for(String word : words1){
        //     if(words2.contains(word)){
        //         if( commonWord.length() < word.length() )
        //             commonWord = word;
        //     }
        // }
        //  return wordsIndexMap.getOrDefault(commonWord, -1);
        
        int index = -1;
        for (String word: words1) 
            if (words2.contains(word))
                 index = Math.max(index, wordsIndexMap.get(word));
        
        return index;
       
    }
    
    
    class TrieNode{
        Map<Character, TrieNode> children;
        Set<String> words;
        public TrieNode(){
            children = new HashMap<>();
            words = new HashSet<>();
        }
        
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */