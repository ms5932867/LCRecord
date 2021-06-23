// https://leetcode.com/problems/bulb-switcher/discuss/1161362/Java-Code-with-Explanation
/**
 * Notice that the number of times each bulb is toggled is equal to the number of its factors.
Also notice that if we toggle a bulb even number of times, it goes back to its original OFF state.

Since every number,except perfect squares, has an even number of factors, 
the number of bulbs in the ON state after n toggles will be equal to the number of perfect squares <= n.
 */
class Solution {   
    public int bulbSwitch(int n) {
        return  (int)Math.sqrt(n);
    }
}