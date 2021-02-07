import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split((", "))).map(Integer::parseInt).forEach(tasks::push);
        ArrayDeque<Integer> threads = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        int maxTask = Integer.parseInt(scan.nextLine());

//        while (!cpu.isEmpty() && !threads .isEmpty()) {
//            int first = cpu.pop();
//            int second = threads .poll();
//            System.out.println(first + " " + second);
//        }

        while (!tasks.isEmpty() && !threads.isEmpty()) {
            int task = tasks.peek();
            int thread = threads.peek();
            if(task==maxTask){
                System.out.println(String.format("Thread with value %d killed task %d", thread,task));
                break;
            }
            if (thread >= task) {
                tasks.pop();
                threads.poll();
            } else if (thread < task) {
                threads.poll();
            }
            if(tasks.isEmpty() ||threads.isEmpty()){
                System.out.println(String.format("Thread with value %d killed task %d", thread,task));
            }
        }
if(!threads.isEmpty()){
    threads.forEach(e-> System.out.print(e+" "));
}
    }
}
