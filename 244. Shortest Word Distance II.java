import java.util.Map;
class WordDistance {
    String[] wordsDict;
    Map<String, List<Integer>> dict;
    public WordDistance(String[] wordsDict) {
        this.wordsDict = wordsDict;
        dict = buildMap();
    }
    
    private Map<String, List<Integer>> buildMap() {
        Map<String, List<Integer>> dict = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            String s =  wordsDict[i];
            dict.putIfAbsent(s, new ArrayList<>());
            dict.get(s).add(i);
        }
        return dict;
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = dict.get(word1);
        List<Integer> l2 = dict.get(word2);
        int i = 0;
        int j = 0;
        int dif = Math.abs(l1.get(i) - l2.get(j));
        while(i < l1.size() && j < l2.size()) {
            dif = Math.min(dif,Math.abs(l1.get(i) - l2.get(j)) );
            if (l1.get(i) < l2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return dif;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */