class Solution {
    public class Item {
        int idx;
        String src;
        String tgt;
        Item (int idx, String src, String tgt) {
            this.idx = idx;
            this.src = src;
            this.tgt = tgt;
        }
    }

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        List<Item> items = buildItems(indices, sources, targets);
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (index >= items.size() || i < items.get(index).idx) {
                sb.append(s.charAt(i));
            } else if (i == items.get(index).idx) {
                if (!s.substring(i, items.get(index).src.length() + i).equals(items.get(index).src)) {
                    sb.append(s.charAt(i));
                    
                } else {
                    sb.append(items.get(index).tgt);
                    i += (items.get(index).src.length() - 1);
                }
                index++;

            }
            System.out.println( "i=" + i + " index=" + index + " sb=" + sb.toString());
        }  
        return sb.toString();              
        
    }
    private List<Item> buildItems(int[] indices, String[] sources, String[] targets) {
        List<Item> items = new ArrayList<>();
        for (int index = 0; index < indices.length; index++) {
            items.add(new Item(indices[index], sources[index], targets[index]));
        }
        Collections.sort(items, (i1, i2) -> (i1.idx - i2.idx));
        return items;
    }
}