//Numbers can be regarded as the product of their factors.
// For example, 8 = 2 x 2 x 2 = 2 x 4.
// Given an integer n, return all possible combinations of its factors. You may return the answer in any order.
// Note that the factors should be in the range [2, n - 1].
// Input: n = 32
// Output: [[2,16],[4,8],[2,2,8],[2,4,4],[2,2,2,4],[2,2,2,2,2]]
// 1. 为什么需要start？为了去重
// 2. 边界条件i * i <= n   (!!!)
// 3. 什么时候加结果以及加哪两种结果
// input 16
// --------------helper 16 2
// --------------helper 8 2
// --------------helper 4 2
// --------------helper 2 2
// --------------helper 1 2
// 2 2 2 2 
// --------------helper 1 4
// 2 2 4 
// --------------helper 1 8
// 2 8 
// --------------helper 4 4
// --------------helper 1 4
// 4 4 
// tree:              16
//               2          4
//             2   8      4  
//           2   4
//         2
// each path from up to bottom is a result




class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> getFactors(int n) {
       if (n == 1) {
           return res;
       } 
       List<Integer> curRes = new ArrayList<>();
       System.out.println("--------------helper" + " "+ n + " " + 2);
       helper(curRes, n, 2);
       return res;
    }
    private void helper(List<Integer> curRes, int n, int start) {
        if (n == 1) {
            for (int i : curRes) {
                System.out.print(i + " ");
            }
            System.out.println("");
            res.add(new ArrayList<>(curRes));
            return;
        }
        for (int i = start; i * i <= n; i++) {
            if (n % i == 0) {
                curRes.add(i);
                System.out.println("--------------helper" + " "+ n / i + " " + i);
                helper(curRes, n / i, i);
                //curRes.remove(curRes.size() - 1);

                //curRes.add(i);
                curRes.add(n / i);
                System.out.println("--------------helper" + " "+ 1 + " " + n/i);
                helper(curRes, 1, n / i);
                curRes.remove(curRes.size() - 1);
                curRes.remove(curRes.size() - 1);

            }
        }
    }
}