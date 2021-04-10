// https://www.youtube.com/watch?v=Oi68_8xkxI4
// 主函数 start t1 -》 子函数start  t2 -》 子函数end  t3 -》 主函数end t4
// 注意什么时候把t1 更新成 t3 + 1
//

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<String> stk = new Stack<>();
        int[] res = new int[n];
        for (String log : logs) {
            if (stk.isEmpty()) {
                stk.push(log);
                continue;
            } 
            if (isStart(log)) {
                String lastLog = stk.peek();
                res[getId(lastLog)] += getTime(log) - getTime(lastLog);
                stk.push(log);
            }
            else {
                String startLog = stk.pop();
                int id = getId(log);
                res[id] += (getTime(log) - getTime(startLog) + 1);
                if (!stk.isEmpty()) {
                    String lastLog = stk.pop();
                    String updatedLastLog = updateTime(lastLog, getTime(log));
                    stk.push(updatedLastLog);
                }

            }
        }
        return res;

    }
    private int getId(String s) {
        return Integer.valueOf(s.split(":")[0]);
    }
    private boolean isStart(String s) {
        return s.split(":")[1].equals("start");
    }
    private int getTime(String s) {
        return Integer.valueOf(s.split(":")[2]);
    }
    private String updateTime(String s, int time) {
        StringBuilder sb = new StringBuilder();
        String[] splitS = s.split(":");
        for (int i = 0; i <= 1; i++) {
            sb.append(splitS[i]);
            sb.append(":");
        }
        sb.append(Integer.toString(time + 1));
        return sb.toString();
    }
}