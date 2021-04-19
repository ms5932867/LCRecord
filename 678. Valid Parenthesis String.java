class Solution {
    public boolean checkValidString(String s) {
        int low = 0; // lowest possible difference between left - right
        int high  = 0; // highest possible difference between left - right
        for (char c: s.toCharArray()) {
            switch (c) {
                case '(':
                    low++;
                    high++;
                    break;
                case ')':
                    low--;
                    high--;
                    break;
                case '*':
                    low--;
                    high++;
                    break;
            } 
            System.out.println(c + " " + low + " " + high);  
            if (high < 0) {
                return false;
            }
            //https://leetcode.com/problems/valid-parenthesis-string/discuss/302732/C%2B%2B-O(S)-Time-O(1)-Space-One-Pass-with-Explanation
            if (low < 0) {
                low = 0;
            } 
            
        }
        return low == 0;
                
    }
}


// @Aristo_ The way I think about it is, imagine this question without the *, where you just have "(" and ")", then you would be right, the difference can be negative, and in that case, the whole sequence becomes invalid.

// Now add the * into the question, as long as maxDiff >= 0, whenever minDiff becomes negative, it means you made a choice about "*" and it made the sequence invalid, and you need to eliminate that sequence, because you don't want to build the subsequent solution on top of an invalid solution to a subproblem.