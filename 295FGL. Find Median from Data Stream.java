// Solution 1: from LC sulotion
/**
A max-heap to store the smaller half of the input numbers
A min-heap to store the larger half of the input numbers
-> balancing the two heaps!

*/
class MedianFinder {

    
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(10, Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        
        if (minHeap.size() < maxHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }        
    }
    
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
            
        } 
        return minHeap.peek();
    }
}

// Solution 2: by me
class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(10, Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        minHeap.offer(num);
        if (minHeap.size() - maxHeap.size() == 2) {
            maxHeap.offer(minHeap.poll());
        } 
        if (minHeap.size() > 0 &&  maxHeap.size() > 0) {
            int min = Math.min(minHeap.peek(), maxHeap.peek());
            int max = Math.max(minHeap.peek(), maxHeap.peek());
            minHeap.poll();
            maxHeap.poll();
            minHeap.offer(max);
            maxHeap.offer(min);
        }

        
    }
    
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
            
        } 
        return minHeap.peek();
    }
}

