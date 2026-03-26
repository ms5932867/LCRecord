/**
 * 128. Longest Consecutive Sequence
 * Given an array of integers nums, return the length of the longest consecutive sequence of elements that can be formed.

A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element. The elements do not have to be consecutive in the original array.

You must write an algorithm that runs in O(n) time.

Example 1:

Input: nums = [2,20,4,10,3,4,5]

Output: 4
Explanation: The longest consecutive sequence is [2, 3, 4, 5].

Example 2:

Input: nums = [0,3,2,5,4,6,1,1]

Output: 7
 * 
 */
class Solution {
    public int longestConsecutive(int[] nums) {
      Set<Integer> numsSet = new HashSet<>();
      for (int n : nums) {
        numsSet.add(n);
      }
      int res = 0;
      for (int n: nums) {
        if (!numsSet.contains(n - 1)) {
            int start = n;
            while (numsSet.contains(n)) {
                n++;
            }
            res = Math.max(n -start, res);
        }
      }  
      return res;
    }
}

/*
对于一个数 num：

如果 set 里 有 num - 1
说明它不是连续序列开头
跳过
如果 set 里 没有 num - 1
说明它是起点
就一直查 num + 1, num + 2, num + 3...
Time Complexity: O(n)
Space Complexity: O(n)  
*/

/**
 * Java 有两种数组：

类型	示例
基本类型数组	int[]
对象数组	Integer[]

Arrays.asList() 只能正确处理对象数组

✔️ 如果你是这样写，就没问题：
Integer[] nums = {1,2,3};
Set<Integer> set = new HashSet<>(Arrays.asList(nums));
🧠 一句话记忆（面试用）

👉 Arrays.asList() 不支持 primitive array（如 int[]）自动拆箱
 */