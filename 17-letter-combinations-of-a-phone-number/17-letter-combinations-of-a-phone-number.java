class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        int n = digits.length();
        HashMap<Character, char[]> dic = constructDic();
        
        List<String> sol = new ArrayList<String>((int)Math.pow(3, n));
        explore(0, new StringBuilder(n), digits, sol, dic);
        return sol;                              
    }
    
    private HashMap<Character, char[]> constructDic(){
        HashMap<Character, char[]> dic = new HashMap<>();
        dic.put('2', new char[]{'a', 'b', 'c'});
        dic.put('3', new char[]{'d', 'e', 'f'});
        dic.put('4', new char[]{'g', 'h', 'i'});
        dic.put('5', new char[]{'j', 'k', 'l'});
        dic.put('6', new char[]{'m', 'n', 'o'});
        dic.put('7', new char[]{'p', 'q', 'r', 's'});
        dic.put('8', new char[]{'t', 'u', 'v'});
        dic.put('9', new char[]{'w','x', 'y', 'z'});
        return dic;
        
    }
    
    private void explore(int index, StringBuilder prefix, String digits, List<String> sol, HashMap<Character, char[]> dic){
        if(index == digits.length()){
            sol.add(prefix.toString());
            return;
        }
        
       
        int lastIndex = prefix.length();
        char[] charArr = dic.get(digits.charAt(index));
        for(char c : charArr){
            prefix.append(c);
            explore(index + 1, prefix, digits, sol, dic);    
            prefix.deleteCharAt(lastIndex);
        }
            
    }
}