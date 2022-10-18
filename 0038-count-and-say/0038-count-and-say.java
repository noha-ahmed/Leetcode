class Solution {
    public String countAndSay(int n) {
        if( n == 1 )
            return "1";
        String prevDigitString = countAndSay(n - 1);
        return say(prevDigitString);
    }
    
    private String say(String digitString){
        StringBuilder strBuilder = new StringBuilder(2*digitString.length());
        char currentDigit = digitString.charAt(0);
        int count = 0;
        for(char d : digitString.toCharArray()){
            if(currentDigit == d)
                count++;
            else{
                strBuilder.append(count);
                strBuilder.append(currentDigit);
                currentDigit = d; count = 1;
            }
        }
        strBuilder.append(count);
        strBuilder.append(currentDigit);
        return strBuilder.toString();
    }
}