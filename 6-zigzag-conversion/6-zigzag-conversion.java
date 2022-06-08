class Solution {
    public String convert(String s, int numRows) {
        if( s.length() <= numRows || numRows == 1) return s;
         int row = 1;
            int n = numRows;
            StringBuilder strBuilder = new StringBuilder(s.length());
            for (; row <= n; row++) {
                int i = row - 1;
                boolean flag = true;
                strBuilder.append(s.charAt(i));
                while (i <= s.length()){
                    if (row != n && flag) {
                        i = i + (2 * (n - row - 1) + 1) + 1;
                        if( i < s.length() ){
                            strBuilder.append(s.charAt(i));
                        }
                        else break;
                    } else if (row != 1 && !flag) {
                        i = i + (2 * (row - 2) + 1) + 1;
                        if( i < s.length() ){
                            strBuilder.append(s.charAt(i));
                        }
                        else break;
                    }
                    
                    flag = !flag;
                }
                System.out.println(strBuilder.toString());
            }
            return strBuilder.toString();
        
    }
}