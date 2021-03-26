class Solution {
    int index = 0;
    public int calculate(String s) {
        s = "(" + s + ")";
        //System.out.println("s = " + s);
        // s = (1-(2+3))
        return calculatorHelper(s);   
    }

    // calcule the result inside each ()
    // index is the index of left (
    // preOperator is the operator brefore left (
    private int calculatorHelper(String s) {
        char preOp = '+';
        int curRes = 0;
        index++;
        for (; index < s.length(); index++) {
            if (s.charAt(index) == ' ') {
                continue;
            }
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