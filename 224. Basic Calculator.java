class Solution {
    // + -  ()
    int index = 0;
    public int calculate(String s) {
        s = "(" + s + ")";
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                sb.append(c);
            } 
        }
        s = sb.toString();
        System.out.println("s = " + s);
        // s = (1-(2+3))
        return calculatorHelper(s);   
    }

    // calcule the result inside each ()
    // index is the index of left (
    // when the helper function return, it needs to return two numbers: the res of current () and which index of the string the level ends
    // here i return the current result and use a global index
    private int calculatorHelper(String s) {
        char preOp = '+';
        int curRes = 0;
        index++;
        for (; index < s.length(); index++) {
            if (Character.isDigit(s.charAt(index))) {
                int curVal = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    curVal = curVal * 10 + (s.charAt(index) - '0');
                    index++;
                }
                if (preOp == '+') {
                    curRes += curVal;
                }
                else if (preOp == '-') {
                    curRes -= curVal;
                }
                index--;
            }
            else {
                if (s.charAt(index) == '+' || s.charAt(index) == '-') {
                    preOp = s.charAt(index);
                }
                else if (s.charAt(index) == ')') {
                    return curRes;
                }
                else if (s.charAt(index) == '(') {
                    if (preOp == '+') {
                        curRes += calculatorHelper(s);
                    }
                    else {
                        curRes -= calculatorHelper(s);
                    }
                    
                }
            }
        }
        return curRes;   
    }
}