class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int a = asteroids[i];
            if (a > 0 || (a < 0 && stk.isEmpty()) || (a < 0 && !stk.isEmpty() && stk.peek() < 0)) {
                stk.push(a);
            } else { // a < 0 and stk.peek() > 0 
                int last = stk.peek();
                if (Math.abs(a) == last) {
                    stk.pop();
                } else if (Math.abs(a) > last) {
                    stk.pop();
                    i--;// we need to compare the current a again so i--
                } 
                // if if (Math.abs(a) < last) do nothing
            }
        }
        int[] res = new int[stk.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stk.pop();
        }
        return res;
    }
}