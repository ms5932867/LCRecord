class LogSystem {
    TreeMap<String, Set<Integer>> logs;// timestamp : list of id
    Map<String, Integer> granularityConverter;
    public LogSystem() {
        logs = new TreeMap<>();
        buildGranularityConverter();
    }
    
    public void put(int id, String timestamp) {
        logs.putIfAbsent(timestamp, new HashSet<>());
        logs.get(timestamp).add(id);
    }
    // Timestamp is a string that has the following 
    // format: Year:Month:Day:Hour:Minute:Second, 
    // for example, 2017:01:01:23:59:59
    
    public List<Integer> retrieve(String start, String end, String granularity) {

        String min = startConverter(start, granularityConverter.get(granularity));
        String max = endConverter(end, granularityConverter.get(granularity));
        //TreeMap.subMap(fromKey, inclusive, toKey, inclusive)
        Set<Integer> set = new HashSet<>();
        for(Map.Entry<String, Set<Integer>> entry: logs.subMap(min, true, max, true).entrySet()) {
            set.addAll(entry.getValue());
        }
        return new ArrayList<>(set);
    }

    private String startConverter(String start, int index) {
        String[] splitted = start.split(":");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splitted.length; i++) {
            if (i <= index) {
                sb.append(splitted[i]);
            } else {
                sb.append("00");
            }
            sb.append(":");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String endConverter(String end, int index) {
        String[] maxVal = new String[]{"", "12", "31", "23", "59", "59"};
        String[] splitted = end.split(":");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splitted.length; i++) {
            if (i <= index) {
                sb.append(splitted[i]);
            } else {
                sb.append(maxVal[i]);
            }
            sb.append(":");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }


    private void buildGranularityConverter() {
        granularityConverter = new HashMap<>();
        granularityConverter.put("Year", 0);
        granularityConverter.put("Month", 1);
        granularityConverter.put("Day", 2);
        granularityConverter.put("Hour", 3);
        granularityConverter.put("Minute", 4);
        granularityConverter.put("Second", 5);
    }


}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(start,end,granularity);
 */