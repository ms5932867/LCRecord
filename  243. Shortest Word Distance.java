//One pass is better
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int i1 = -1;
        int i2 = -1;
        int dif = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                i1 = i;
            }
            if (wordsDict[i].equals(word2)) {
                i2 = i;
            }
            if (i1 != -1 && i2 != -1) {
                dif = Math.min(dif, Math.abs(i1 -i2));
            }

        }
        return dif;
    }
}

// class Solution {
//     public int shortestDistance(String[] wordsDict, String word1, String word2) {
//         Map<String, List<Integer>> dict = new HashMap<>();
//         for (int i = 0; i < wordsDict.length; i++) {
//             String s =  wordsDict[i];
//             dict.putIfAbsent(s, new ArrayList<>());
//             dict.get(s).add(i);
//         }
//         List<Integer> l1 = dict.get(word1);
//         List<Integer> l2 = dict.get(word2);
//         int i = 0;
//         int j = 0;
//         int dif = Math.abs(l1.get(i) - l2.get(j));
//         while(i < l1.size() && j < l2.size()) {
//             dif = Math.min(dif,Math.abs(l1.get(i) - l2.get(j)) );
//             if (l1.get(i) < l2.get(j)) {
//                 i++;
//             } else {
//                 j++;
//             }
//         }
//         return dif;
//     }
// }


