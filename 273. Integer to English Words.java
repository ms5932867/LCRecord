class Solution {
    private final String[] under20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tens  = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    private final int BILLION = 1000000000,
                MILLION = 1000000,
                THOUSAND = 1000;

    StringBuilder sb = new StringBuilder();

    public String numberToWords(int num) {
        // num >= 0, upper limit is lager than 2 billion
        if (num == 0) {
            return "Zero";
        }
        helper(num);
        return sb.toString();
        
    }
    private void helper(int num) {
        if (num == 0) {
            return;
        }
        else if (num < 20) {
            sb.append(under20[num]);
        }
        else if (num < 100) {
            int tensDgt = num / 10;
            sb.append(tens[tensDgt]);
            num %= 10;
            appendSpaceIfHasRemaining(num);
            helper(num);
        }
        else if (num < THOUSAND) {
            int hundredDgt = num / 100;
            sb.append(under20[hundredDgt] + " Hundred");
            num %= 100;
            appendSpaceIfHasRemaining(num);
            helper(num);
            
        }
        else if (num < MILLION) {
            helper(num / THOUSAND);
            sb.append(" Thousand");
            num %= THOUSAND;
            appendSpaceIfHasRemaining(num);
            helper(num);
            
        }
        else if (num < BILLION ) {
            helper(num / MILLION);
            sb.append(" Million");
            num %= MILLION;
            appendSpaceIfHasRemaining(num);
            helper(num);
            
        }
        else if (num >= BILLION) {
            helper(num / BILLION);
            sb.append(" Billion");
            num %= BILLION;
            appendSpaceIfHasRemaining(num);
            helper(num);
            
        }
    } 
    private void appendSpaceIfHasRemaining(int num) {
        if (num > 0) sb.append(" ");
    }
    
}