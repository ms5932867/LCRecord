import java.util.Map;
class StockPrice {
    Map<Integer, Integer> records;// timeStamp: price
    int lastTime;
    TreeMap<Integer, Integer> orderedRecords;// price and how many times the price is there
    public StockPrice() {
        records =  new HashMap<>();
        lastTime = 0;
        orderedRecords = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        lastTime = Math.max(lastTime, timestamp);
        if (records.containsKey(timestamp)) {
            int oldPrice = records.get(timestamp);
            orderedRecords.put(oldPrice,  orderedRecords.get(oldPrice) - 1);
            if (orderedRecords.get(oldPrice) == 0) {
               orderedRecords.remove(oldPrice); 
            }  
        } 
        orderedRecords.putIfAbsent(price, 0);
        orderedRecords.put(price, orderedRecords.get(price) + 1);
        
        records.put(timestamp, price);
    }
    
 
    
    
    public int current() {
        return records.get(lastTime);
    }
    
    public int maximum() {
        return orderedRecords.lastKey();
    }
    
    public int minimum() {
        return orderedRecords.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */