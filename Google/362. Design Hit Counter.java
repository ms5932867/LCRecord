class HitCounter {
    Queue<Integer> record;
    /** Initialize your data structure here. */
    public HitCounter() {
        record = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        record.offer(timestamp);
        cleanUp(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        cleanUp(timestamp);
        return record.size();
    }
    private void cleanUp(int timestamp) {
        while (!record.isEmpty() && record.peek() <= timestamp - 300) {
            record.poll();
        } 
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */