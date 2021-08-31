/** 
 * https://www.geeksforgeeks.org/priorityqueue-remove-method-in-java/
 * PriorityQueue remove() 
 * Syntax of remove method:  
 * Priority_Queue.remove(Object O)
 * Parameters: The parameter O is of the type of PriorityQueue and specifies the element to be removed from the PriorityQueue.
 * Return Value: This method returns True if the specified element is present in the Queue else it returns False.
 * 
 * https://leetcode.com/problems/hand-of-straights/discuss/1182982/Java-Clean-O(N-logN)-PriorityQueue-TreeMap-Solution
 *
 * for (int num : hand) {
            numToCnt.put(num, numToCnt.getOrDefault(num, 0) + 1);
        }
 *  */


// PriorityQueue
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : hand) {
            pq.offer(n);
        }
        while (!pq.isEmpty()) {
            int start = pq.peek();
            int num = start;
            while (num <= start + groupSize - 1) {
                if (!pq.remove(num)) {
                    return false;
                }
                num++;
            }
        }
        return pq.isEmpty();

    }
}
//TreeMap
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        TreeMap<Integer, Integer> numToCnt = new TreeMap<>();
        for (int num : hand) {
            numToCnt.put(num, numToCnt.getOrDefault(num, 0) + 1);
        }
        while (numToCnt.size() > 0) {
            int start = numToCnt.firstKey();
            for (int next = start; next <= start + groupSize - 1; next++) {
                if (!numToCnt.containsKey(next)) {
                    return false;
                }
                numToCnt.put(next, numToCnt.get(next) - 1);
                if (numToCnt.get(next) == 0) {
                    numToCnt.remove(next);
                }
            }
        }
        return true;
    }
}