// the minium sum of (length - k) cards from the array
//Keep a window of size n - k over the array. The answer is max(answer, total_pts - sumOfCurrentWindow)
// sliding window check LC 76
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int length = cardPoints.length;
       //1. get sum
        int sum = 0;
        for (int c : cardPoints) {
            sum += c;
        }
        // System.out.println("sum = " + sum);
        if (length <= k) {
            return sum;
        }
        // 2. get length - k  sum
        
        int left = 0;
        int partSum = 0;
        int res = Integer.MIN_VALUE;
        for (int right = 0; right < length; right++) {
                if (right - left + 1 <= length - k) {
                    partSum += cardPoints[right];   
                    // System.out.println("if left = " + left + " right = " + right + " partSum=" + partSum);
                }
                if (right - left + 1 == length - k) {

                    res = Math.max(res, sum - partSum);
                    // System.out.println("while res = " + res);
                    partSum -= cardPoints[left];
                    left++;
                    // System.out.println("while left = " + left + " right = " + right + " partSum=" + partSum);
                }
        }
        return res;
    }
}