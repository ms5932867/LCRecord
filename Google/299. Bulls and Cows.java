import java.util.Map;
class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> secretRemain = new HashMap<>();
        Map<Character, Integer> guessRemain = new HashMap<>();
        // find bulls
        int bulls = 0;
        for (int i = 0; i < secret.length(); i++) {
            char sc = secret.charAt(i);
            char gc = guess.charAt(i);
            if (sc == gc) {
                bulls++;
                continue;
            }
            secretRemain.putIfAbsent(sc, 0);
            secretRemain.put(sc, secretRemain.get(sc) + 1);
            guessRemain.putIfAbsent(gc, 0);
            guessRemain.put(gc, guessRemain.get(gc) + 1);
        }
        int cows = 0;
        for (Character sc : secretRemain.keySet()) {
            if (guessRemain.containsKey(sc)) {
                cows += Math.min(guessRemain.get(sc),secretRemain.get(sc));
            }
        }
        return bulls + "A" + cows + "B";
    }
}