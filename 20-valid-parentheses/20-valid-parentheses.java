class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if( isOpenBracket(c) )
               stack.push(c);
            else if ( stack.isEmpty() || !isMatching(stack.pop(), c) )
                return false;
        }
        return stack.isEmpty();
        
    }
    
    private boolean isOpenBracket(char c){
        return c == '(' || c == '{' || c == '[';
    }
    
    private boolean isMatching(char o, char c){
        return (o == '(' && c == ')') ||
            (o == '{' && c == '}') ||
            (o == '[' && c == ']');
    }
}