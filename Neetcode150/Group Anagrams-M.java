/*
Time complexity:  O(m∗n) 
Space complexity: O(m) extra space. O(m∗n) space for the output list.
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s: strs) {
            int[] cnt = new int[26];
            for (char c: s.toCharArray()) {
                cnt[c -'a'] ++;
            }
            String key = Arrays.toString(cnt);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
}



/**
Time complexity: O(m∗nlogn) 
Space complexity:  O(m∗n)
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s: strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedS = new String(charArray);
            res.putIfAbsent(sortedS, new ArrayList<>());
            res.get(sortedS).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
/*
List extends Collection（接口继承）
ArrayList implements List（类实现接口）

🔍 代码层面的体现（最关键）
接口继承（interface → interface）
interface List<E> extends Collection<E>

👉 含义：

List 拥有 Collection 的所有方法 + 自己的方法
类实现接口（class → interface）
class ArrayList<E> implements List<E>

👉 含义：

ArrayList 必须实现 List（以及 Collection）所有方法
🔥 类型关系（非常重要）
ArrayList 是 List
List 是 Collection

👉 所以：

List<Integer> list = new ArrayList<>();        // ✅
Collection<Integer> c = new ArrayList<>();     // ✅

🚨 但反过来不行：

Collection<Integer> c = new ArrayList<>();
List<Integer> list = c; // ❌
🎯 为什么要这样设计？
接口（Collection / List） → 定义“能做什么”
实现类（ArrayList） → 决定“怎么做”

👉 好处：

可以随时换实现（ArrayList / LinkedList）
代码更灵活
*/

/*
char[] arr = s.toCharArray();
String s = new String(arr);

String[] arr = list.toArray(new String[0]);
List<String> list = Arrays.asList(arr);

int x = c - 'a';     // char → int
char c = (char)(x + 'a'); // int → char

*/
