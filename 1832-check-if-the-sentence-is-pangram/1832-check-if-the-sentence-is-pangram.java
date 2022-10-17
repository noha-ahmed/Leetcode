class Solution {
    public boolean checkIfPangram(String sentence) {
        int bitMask = 0;
        for(char c : sentence.toCharArray()){
            bitMask |= (0b1 << (c - 'a'));
            if(bitMask == 0x3ffffff)
                return true;
        }
        return false;
    }
}