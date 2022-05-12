// Solution 1: 
/**
 * https://www.cnblogs.com/grandyang/p/7519466.html
 * 由于数组是有序的，所以最后返回的k个元素也一定是有序的，那么其实就是返回了原数组的一个长度为k的子数组，
 * 转化一下，实际上相当于在长度为n的数组中去掉 n-k 个数字，而且去掉的顺序肯定是从两头开始去，
 * 因为距离x最远的数字肯定在首尾出现。
 * 那么问题就变的明朗了，每次比较首尾两个数字跟x的距离，将距离大的那个数字删除，直到剩余的数组长度为k为止
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - 1;
        while (r - l + 1 > k) {
            if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                r--;
            } else {
                l++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = findClosestToX(arr, x);
        List<Integer> res = new ArrayList<>();
        
        int left = index;
        int right = index + 1;
        
        while (left >= 0 || right < arr.length) {
            
            if (left < 0 || (right < arr.length && Math.abs(arr[right] - x) < Math.abs(arr[left] - x))) {
                res.add(arr[right]);
                right++;
            } else {
                res.add(arr[left]);
                left--;
            }
            if (res.size() ==k) {
                break;
            }
        }
        Collections.sort(res);
        return res;


    }
    private int findClosestToX(int[] arr, int x) {
        int s = 0;
        int e = arr.length - 1;
        while (s + 1 < e) {
            int m = s + (e - s) / 2;
            if (arr[m] == x) {
                return m;
            } else if (arr[m] > x) {
                e = m;
            } else {
                s = m;
            }
        }
        if (Math.abs(arr[s] - x) <= Math.abs(arr[e] - x)) {
            return s;
        }
        return e;
    }
}