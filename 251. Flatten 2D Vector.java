//["Vector2D","hasNext"]
// [[[[]]],[]]
class Vector2D {
    Stack<int[]> aryStk = new Stack<>();
    Stack<Integer> intStk = new Stack<>();

    private void buildAryStk(int[][] v) {
        for (int i = v.length - 1; i >= 0; i--) {
            aryStk.push(v[i]);
        }
    }

    private void buildIntStk(int[] ary) {
        for (int i = ary.length - 1; i >= 0; i--) {
            intStk.push(ary[i]);
        }
    }

    public Vector2D(int[][] v) {
        buildAryStk(v);
        
    }
    
    public int next() {
        if (!hasNext()) {
            return -1;
        }
        return intStk.pop();
    }
    
    public boolean hasNext() {
        while (intStk.isEmpty() && !aryStk.isEmpty()) {
            buildIntStk(aryStk.pop());
        }
        return !intStk.isEmpty();

    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */