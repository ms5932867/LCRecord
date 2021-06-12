class Solution {
    /**   n
     * w     e
     *    s
     */   
    public boolean isRobotBounded(String instructions) {
        int[] moveX = new int[]{0, 1,0, -1};
        int[] moveY = new int[]{1,0, -1, 0};
        int dir = 0;
        int x = 0;
        int y = 0;
        for (char c: instructions.toCharArray()) {
            switch (c) {
                case 'L':
                    dir--;
                    dir = (dir + 4) % 4;
                    break;
                case 'R':
                    dir++;
                    dir = (dir + 4) % 4;
                    break;
                case 'G':
                    x += moveX[dir];
                    y += moveY[dir]; 
                    break;
            }
        } 
        // System.out.println(x + " " + y + " " + dir);
        return (x == 0 && y == 0) || dir > 0;
    }
}
/**
 * On an infinite plane, a robot initially stands at (0, 0) 
 * and faces north. The robot can receive one of three instructions:
 * "G": go straight 1 unit;
 * "L": turn 90 degrees to the left;
 * "R": turn 90 degrees to the right.
 * https://www.cnblogs.com/grandyang/p/14451061.html
 * 若执行过一遍所有指令之后机器人还在原点上，则一定是在一个圆圈路径上（即便是机器人可能就没移动过，一个点也可以看作是圆圈路径）。
 * 若机器人偏离了起始位置，只要看此时机器人的朝向，只要不是向北，则其最终一定会回到起点，
 * 别问博主怎么证明，博主也不知道，大家可以多带几个例子试一下。
 * 知道了最终状态和循环路径的关系，现在就是如何执行这些指令了
 * 
 * https://blog.csdn.net/fuxuemingzhu/article/details/92128721
 * 我们一定知道，这个题不能用暴力解法。机器人的路径最终被圆包括的充分条件是机器在一些指令之后回到原点。
 * 由于指令是循环的，题目只给出了部分指令。那么对于该部分指令的要求是，机器人回到了原点或者不再原点且不面向北。
 回到原点很好理解，那么不再原点且不面向北是什么意思呢？

如果题目中的指令结束之后，机器人不在原点，那么说明它相对原点移动了一个向量v。
机器人在指令结束后的位置成为了新的原点，题目说机器人的初始状态时是面向北的，
那么如果在新的原点上仍然面向北，那么一定还会继续向第一次一样相对新的原点移动相同的向量v，
此时机器人距原点的向量是2v。

那么为什么不面向北就一定能回到原点呢？
这是由于在新的原点新的方向上再次接受相同指令后，机器人移动新向量的长度为|向量v|、方向和v成90度或者180度；
多次指令的结果叠加就会抵消第一次移动的v。
————————————————
版权声明：本文为CSDN博主「负雪明烛」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/fuxuemingzhu/article/details/92128721
 */