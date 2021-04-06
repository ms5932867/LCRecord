class TweetCounts {
    Map<String, List<Integer>> map;
    Map<String, Integer> freqTime;
    public TweetCounts() {
        map =  new HashMap<>();
        freqTime = buildFreqTimeMap();
    }
    
    public void recordTweet(String tweetName, int time) {
        map.putIfAbsent(tweetName, new ArrayList<>());
        map.get(tweetName).add(time);
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int time = freqTime.get(freq);
        List<Integer> records = map.get(tweetName);
        Collections.sort(records);
        List<Integer> res = new ArrayList<>();
        for (int n = 0; n <= (endTime - startTime) / time; n++) {
            res.add(0);
        }

        int cntDelta = 0;
        for (int i = 0; i < records.size() && records.get(i) <= endTime; i++) {
            // System.out.println("i=" + i + " records.get(i)=" +records.get(i));
            if (records.get(i) < startTime) {
                continue;
            }
            if (records.get(i) >= startTime + time * cntDelta && records.get(i) < startTime + time * (cntDelta + 1)) {
                
                res.set(cntDelta,  res.get(cntDelta) + 1);
                // System.out.println(" startTime=" +startTime + " endTime="+ endTime);
                // System.out.println("i=" + i + " records.get(i)=" +records.get(i) + " cntDelta=" +cntDelta + " res.get(cntDelta)=" + res.get(cntDelta));
            }
            else  {
                cntDelta++;
                // System.out.println(" !!!cntDelta=" +cntDelta);
                i--;
            }
        }
     
        
        return res;

    }
    private Map<String, Integer> buildFreqTimeMap() {
        Map<String, Integer> freqTime = new HashMap<>();
        freqTime.put("minute", 60);
        freqTime.put("hour", 60 * 60);
        freqTime.put("day", 60 * 60 * 24);
        return freqTime;
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */