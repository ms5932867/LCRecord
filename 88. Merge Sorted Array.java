class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1;
        int i2 = n - 1;
        int index = m + n - 1;
        while (index >= 0) {
            if (i2 < 0 || (i1 >= 0 && i2 >= 0 && nums1[i1] > nums2[i2])) {
                nums1[index] = nums1[i1];
                i1--;
            } else {
                nums1[index] = nums2[i2];
                i2--;
            }
            index--;
        }
        // while (i1 >= 0) {
        //     nums1[index] = nums1[i1];
        //     i1--;
        //     index--;
        // }

        // while (i2 >= 0 ) {
        //     nums1[index] = nums2[i2];
        //     i2--;
        //     index--;
        // }
    }
}