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