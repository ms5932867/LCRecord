class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        
        if (n < 0) {
            return  1.0 / helper(x, n * (-1));
            //只能乘以一次-1， 如果把这里移到helper 会overflow，因为-2147483648 to 2147483647， -2147483648* -1 = -2147483648
            //另一种办法是把n写成long
        }

        return helper(x, n);
        

    }
    private double helper(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = helper(x, n/2);
        if (n % 2 == 0) {
            
            return half * half;
        } 
        return half * half * x;
    }
}
