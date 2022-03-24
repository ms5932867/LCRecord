class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i-- ) {
            if (split[i].equals("")) {
                continue;
            }
            sb.append(split[i] + " ");
        }
        return sb.substring(0, sb.length() - 1).toString();
    }
}

// 	split string with multiple  " ", will get "" or length == 0
// public static void main(String []args){
//     System.out.println("Hello World");
//     String s = "a  b c    d";
//     String[] splitted = s.split(" ");
//     for (int i = splitted.length - 1; i>= 0; i--) {
//         String word = splitted[i];
//         System.out.println(i + "---" + word + "---");
        
//     }
//  }

// $javac HelloWorld.java
// $java -Xmx128M -Xms16M HelloWorld
// Hello World
// 7---d---
// 6------
// 5------
// 4------
// 3---c---
// 2---b---
// 1------
// 0---a---