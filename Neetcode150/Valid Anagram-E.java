class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        } 
        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();
        Arrays.sort(sSort);
        Arrays.sort(tSort);
        //WRONG!!! return sSort.equals(tSort); //WRONG!!!
        return Arrays.equals(sSort, tSort);
    }
}
/**
🧠 Java equals / hashCode / Arrays 总结（强化版）
1. equals 的本质（核心）
Object.equals() 默认实现：
→ 比较地址（this == obj）

👉 结论：

如果类没有 override equals() → equals 就是在比地址

2. 哪些类是“比内容”的？

这些类已经重写 equals：

String → 比内容
Integer / Double → 比数值
List → 元素 + 顺序
Set → 元素（无序）
Map → key-value

👉 这些可以直接用 .equals()

3. 最大坑：数组
char[] a = {'a','b'};
char[] b = {'a','b'};

a.equals(b); // ❌ false（比地址）

✅ 正确写法：

Arrays.equals(a, b);      // 一维
Arrays.deepEquals(a, b);  // 多维
4. 自定义类（默认也是坑）
class Person {
    String name;
}
new Person("Tom").equals(new Person("Tom")); // ❌ false

✅ 正确写法：

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Person)) return false;
    Person p = (Person) o;
    return Objects.equals(this.name, p.name);
}

@Override
public int hashCode() {
    return Objects.hash(name);
}
5. StringBuilder / StringBuffer（隐藏坑）
StringBuilder a = new StringBuilder("abc");
StringBuilder b = new StringBuilder("abc");

a.equals(b); // ❌ false

👉 原因：没有重写 equals（还是比地址）

✅ 正确写法：

a.toString().equals(b.toString());

👉 或（更推荐）：

Objects.equals(a.toString(), b.toString());
6. 特殊坑
BigDecimal
new BigDecimal("1.0").equals(new BigDecimal("1")); // ❌ false

✅ 正确写法：

a.compareTo(b) == 0
Double / Float（浮点数）
Double a = 0.0;
Double b = -0.0;

a.equals(b); // ❌ false

👉 问题：

精度误差
特殊值（NaN / -0.0）

✅ 正确写法（数值比较）：

Math.abs(a - b) < 1e-9

👉 或（更严谨）：

Double.compare(a, b) == 0
7. HashSet / HashMap 原理（重点）

查找流程：

hashCode() → 找 bucket
equals() → 在 bucket 里比较
❌ 为什么只写 equals 不够？
set.add(new Person("Tom"));
set.contains(new Person("Tom")); // ❌ 可能 false

👉 原因：

equals = true
hashCode 不同
→ 去不同 bucket
→ 找不到
✅ 正确写法（必须同时写）
@Override
public boolean equals(Object o) { ... }

@Override
public int hashCode() {
    return Objects.hash(field);
}
8. Arrays vs equals（回到题目）
sSort.equals(tSort);        // ❌ 比地址
Arrays.equals(sSort,tSort); // ✅ 比内容
🔥 最重要的三句话（一定要记住）

👉 equals 默认是比地址，除非被重写

👉 数组永远不要用 equals，比的是地址

👉 hashCode 决定去哪找，equals 决定是不是它

🎯 刷题触发记忆

看到这些情况要警觉：

array + equals
自定义 class + HashSet / Map
StringBuilder 比较

👉 立刻问自己：

“是不是在比地址？”
“要不要用 Arrays.equals / toString / override hashCode？”
*/


/*
char array as hashmap to count
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
            cnt[t.charAt(i) - 'a']--;
        }
        for (int c : cnt) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
