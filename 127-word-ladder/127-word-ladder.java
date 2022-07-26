class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        
        int[] distances = new int[wordList.size()];
        
        return shortestDistance(wordList, distances, endWord);
    }
    
    private int shortestDistance(List<String> wordList, int[] distances, String endWord){
        final int INF = Integer.MAX_VALUE;
        Arrays.fill(distances, INF);
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(wordList.size() - 1);
        distances[wordList.size() - 1] = 1;
        
        while( !queue.isEmpty() ){
            int node = queue.poll();
            String currentWord = wordList.get(node);
            for(int i = 0; i < wordList.size() - 1; i++){
                String neighborWord = wordList.get(i);
                if( distances[i] == INF && oneTransformationAway(neighborWord, currentWord)){
                    distances[i] = distances[node] + 1;
                    if( neighborWord.equals(endWord) )
                        return distances[i];
                    queue.add(i);
                }
            }
        }
          return 0;
    }
    
    private boolean oneTransformationAway(String word1, String word2){
        int transformations = 0;
        for(int i = 0; i < word1.length(); i++){
            if( word1.charAt(i) != word2.charAt(i) )
                transformations++;
        }
        
        return (transformations == 1);
    }
}