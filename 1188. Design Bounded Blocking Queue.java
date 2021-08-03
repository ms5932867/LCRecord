class BoundedBlockingQueue {
    Queue<Integer> q;
    int capacity;
    Semaphore available;
    Semaphore filled;
    public BoundedBlockingQueue(int capacity) {
        q = new ConcurrentLinkedQueue<>();
        this.capacity = capacity;
        available =  new Semaphore(capacity);
        filled = new Semaphore(0);
    }
    
    public void enqueue(int element) throws InterruptedException {
        available.aqcuire();
        q.offer(element);
        filled.release();
    }
    
    public int dequeue() throws InterruptedException {
        filled.acquire();
        int i = q.poll();
        available.release();
        return i;
    }
    
    public int size() {
        return q.size();
    }
}
