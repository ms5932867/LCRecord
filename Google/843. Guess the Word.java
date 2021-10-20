/**
 * 1. every round use ONE randome number
 * 2. How to tranverse list/set... and update it? replace with a new one.
 */
 
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {

        List<String> words = new ArrayList<>(Arrays.asList(wordlist));

        int match = -1;
        while (match < 6) {
            int index = (int)(Math.random() * (double)words.size());
            String cur = words.get(index);
            match = master.guess(cur);
            // System.out.println(cur + " " + match);
            if (match == 6) {
                return;
            }
            List<String> nextRoundWords = new ArrayList<>();
            for (String next : words) {
                if (!next.equals(cur) && compareWord(next, cur) == match) {
                    nextRoundWords.add(next);
                }  
            }
            words = nextRoundWords;

           
        }
    }
    private int compareWord(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }
}