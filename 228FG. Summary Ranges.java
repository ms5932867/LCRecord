// corner cases, first index or last index is their own group
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int s = nums[0];
        int last = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == last + 1) {
                last++;
            } else {
                if (s == last) {
                    res.add(String.valueOf(s));
                } else {
                    res.add(s + "->" + last);  
                }
                s = nums[i];
                last = nums[i];
            }
        }
        if (s == last) {
            res.add(String.valueOf(s));
        } else {
            res.add(s + "->" + last);
        }
        return res;
    }
}