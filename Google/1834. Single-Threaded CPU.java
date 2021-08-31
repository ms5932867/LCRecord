import java.util.PriorityQueue;

//TODO must do it again!!!
// think about idle time, need to change the time manually
class Solution {
    public class Task {
        int idx;
        int enqueueTime;
        int processTime;
        Task(int idx, int enqueueTime, int processTime) {
            this.idx = idx;
            this.enqueueTime = enqueueTime;
            this.processTime = processTime;
        }
    }
    public class TaskPriorityQueueComparator implements Comparator<Task>{
        public int compare(Task t1, Task t2) {
            if (t1.processTime == t2.processTime) {
                return t1.idx - t2.idx;
            } 
            return t1.processTime - t2.processTime;           
        }
    }
    public int[] getOrder(int[][] tasks) {
        int index = 0;
        List<Task> taskList = buildTaskList(tasks);

        int idxRes = 0;
        int[] res = new int[tasks.length];
        
        int time = taskList.get(index).enqueueTime;

        PriorityQueue<Task> taskPq = new PriorityQueue<>(10, new TaskPriorityQueueComparator());

        
        while (!taskPq.isEmpty() || index < taskList.size()) {
            while (index < taskList.size() && time >= taskList.get(index).enqueueTime) {
                taskPq.offer(taskList.get(index));
                index++;
            }


            if (taskPq.isEmpty()) {
                time = taskList.get(index).enqueueTime;
            } else {
                Task cur = taskPq.poll();
                res[idxRes] = cur.idx;
                idxRes++;
                time += cur.processTime;
            }
        }
        return res;
        
    }
    private List<Task> buildTaskList(int[][] tasks) {
        List<Task> taskList = new ArrayList<>();
        for (int i = 0; i < tasks.length; i++) {
            taskList.add(new Task(i, tasks[i][0], tasks[i][1]));
        }
        Collections.sort(taskList, (t1, t2) -> Integer.compare(t1.enqueueTime, t2. enqueueTime));
        return taskList;

    }
}