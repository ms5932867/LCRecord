// Given a non-negative integer x, compute and return the square root of x.
// Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int s = 1;
        int e = x /2;
        while (s + 1 < e) {
            int m = s  + (e - s) / 2;
            double powM = Math.pow(m, 2);
            //System.out.println(s + " " + e + " " + m + " " + powM);
            if (powM == (long)x) {
                
                return m;
            } else if (powM < (long)x) {
                s = m;
            } else {
                e = m;
            }
        }

        //System.out.println(" final " + s + " " + e );
        if (Math.pow(e, 2) <= (long)x ) {
            return e;
        }
        return s;
    }
}

// the if after while loop in binary search
// (long) convert type
//int	4 bytes	Stores whole numbers from -2,147,483,648 to 2,147,483,647
//long	8 bytes	Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
//float	4 bytes	Stores fractional numbers. Sufficient for storing 6 to 7 decimal digits
//double	8 bytes	Stores fractional numbers. Sufficient for storing 15 decimal digits