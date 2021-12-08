import java.util.Map;
        // Follow up: What if only one of the vectors is sparse?
        // interate on the map with smaller size!!!
        class SparseVector {
            Map<Integer, Integer> map;
            SparseVector(int[] nums) {
                map = new HashMap<>();
                for(int i = 0; i < nums.length; i++) {
                    if (nums[i] != 0) {
                        map.put(i, nums[i]);
                    }
                }
            }
            
            // Return the dotProduct of two sparse vectors
            public int dotProduct(SparseVector vec) {
                
                if (map.size() < vec.map.size()) {
                    return getSum(map, vec.map);
                }
                return getSum(vec.map, map);
            }
            
            private int getSum(Map<Integer, Integer> m1, Map<Integer, Integer> m2) {
                int sum = 0;
                for (int index : m1.keySet()) {
                    if (m2.containsKey(index)) {
                        sum += m2.get(index) * m1.get(index);
                    }
                }
                return sum;
            }
        }
        
        // Your SparseVector object will be instantiated and called as such:
        // SparseVector v1 = new SparseVector(nums1);
        // SparseVector v2 = new SparseVector(nums2);
        // int ans = v1.dotProduct(v2);