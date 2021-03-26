class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < words.length; ) {
            int end = findLastIndexForLine(i, words, maxWidth);
            if (end != words.length - 1) {
                res.add(buildLine(i, end, words, maxWidth));
            }else  {
                res.add(buildLastLine(i, end, words, maxWidth));
            }
            i = end + 1;
        }
        return res;
    }

    private int findLastIndexForLine(int start, String[] words, int maxWidth) {
        int end = start;
        int cntCurLength = 0;
        while (end < words.length) {
            cntCurLength += words[end].length();
            if (cntCurLength == maxWidth) {
                return end;
            } else if (cntCurLength > maxWidth) {
                return end - 1;
            } 
            cntCurLength++;//at least one space between two words
            end++;
        }
        return end - 1;
    }

    private String buildLine(int start, int end, String[] words, int maxWidth) {
        int cntWord = end - start + 1;
        int cntCurLength = 0;
        for (int i = start; i <= end; i++) {
            cntCurLength+= words[i].length();
        }

        StringBuilder line = new StringBuilder();
        if (cntWord == 1) { // if only one word treat as lastLine
            return buildLastLine(start, end, words, maxWidth);
        }
        if ((maxWidth - cntCurLength) % (cntWord - 1) == 0) { // can be evenly ditributed
            int evenSpace = (maxWidth - cntCurLength) / (cntWord - 1);
            for (int i = start; i < end; i++) {
                line.append(words[i]);
                for (int j = 0; j < evenSpace; j++) {
                    line.append(" ");
                }
            }
            
        } else {// can not be evenly ditributed
            int remain = (maxWidth - cntCurLength) % (cntWord - 1);
            int evenSpace = (maxWidth - cntCurLength) / (cntWord - 1);
            for (int i = start; i < end; i++) {
                line.append(words[i]);
                for (int j = 0; j < evenSpace; j++) {
                    line.append(" ");
                }
                if (remain > 0) {
                    line.append(" ");
                    remain--;
                }
            }

        }
        line.append(words[end]);
        return line.toString();
    }

    private String buildLastLine(int start, int end, String[] words, int maxWidth) {
        StringBuilder line = new StringBuilder();
        for (int i = start; i <= end; i++) {
            line.append(words[i]);
            line.append(" ");
        }
        line.deleteCharAt(line.length() - 1);
        while (maxWidth - line.length() > 0) {
            line.append(" ");
        }
        return line.toString();
    }
}