class RLEIterator {
    int index;
    int[] encoding;
    public RLEIterator(int[] encoding) {
        index = 0;
        this.encoding = encoding;
    }
    
    public int next(int n) {
        while (index < encoding.length && n > encoding[index]) {
            n -= encoding[index];
            index += 2;
            
        }
        if (index >= encoding.length) {
            return -1;
        }
        encoding[index] -= n;
        return encoding[index + 1]; 
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */