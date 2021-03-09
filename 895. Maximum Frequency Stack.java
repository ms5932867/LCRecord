//LC 895. Maximum Frequency Stack
class FreqStack {
    Map<Integer, Integer> numAndCnt;
    Map<Integer, Stack<Integer>> cntAndNum;
    int maxCnt = 0;
    public FreqStack() {
        numAndCnt = new HashMap<>();
        cntAndNum = new HashMap<>();
    }
    
    public void push(int x) {
        numAndCnt.putIfAbsent(x, 0);
        numAndCnt.put(x, numAndCnt.get(x) + 1);
        int xCnt = numAndCnt.get(x);
        maxCnt = Math.max(xCnt, maxCnt);
        cntAndNum.putIfAbsent(xCnt, new Stack<>());
        cntAndNum.get(xCnt).push(x);
        
    }

    
    public int pop() {
        int ans = cntAndNum.get(maxCnt).pop();
        if (cntAndNum.get(maxCnt).isEmpty()) {
            cntAndNum.remove(maxCnt);
            maxCnt--;
        }
        numAndCnt.put(ans, numAndCnt.get(ans) - 1);
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */