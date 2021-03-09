class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[2];
        int prev = 0;
        int sum = 0;
        int expectSum = (1 + nums.length)  * nums.length /2;
        
        for (int n : nums) {
            
            if (n == prev) {
                res[0] = n;

            }
            sum += n;
            prev = n;
            
        }
        // System.out.println(expectSum + " " + sum);
        res[1] = res[0] + expectSum - sum;
        return res;
    }
}

// there's a better way to do