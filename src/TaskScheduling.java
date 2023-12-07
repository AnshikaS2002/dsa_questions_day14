import java.util.Arrays;
import java.util.Scanner;

public class TaskScheduling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of tasks: ");
        int n = scanner.nextInt();

        int[] deadlines = new int[n];
        int[] durations = new int[n];

        System.out.println("Enter task deadlines and durations:");
        for (int i = 0; i < n; i++) {
            deadlines[i] = scanner.nextInt();
            durations[i] = scanner.nextInt();
        }

        Task[] tasks = new Task[n];
        for (int i = 0; i < n; i++) {
            tasks[i] = new Task(deadlines[i], durations[i]);
        }
        Arrays.sort(tasks);

        int completionTime = 0;
        for (int i = 0; i < n; i++) {
            completionTime += tasks[i].duration;
            int overshoot = Math.max(0, completionTime - tasks[i].deadline);
            System.out.println("Task " + (i + 1) + ": " + overshoot + " minutes");
        }
    }

    static class Task implements Comparable<Task> {
        int deadline;
        int duration;

        public Task(int deadline, int duration) {
            this.deadline = deadline;
            this.duration = duration;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.deadline, other.deadline);
        }
    }
}
