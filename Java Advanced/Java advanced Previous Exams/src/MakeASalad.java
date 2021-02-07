import java.util.*;

public class MakeASalad {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<String> vegetables = new ArrayDeque<>();
        Deque<Integer> calories = new ArrayDeque<>();

        String[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .toArray(String[]::new);
        for (String number : numbers) {
            vegetables.offer(number);
        }

        int[] calors = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        for (int number : calors) {
            calories.push(number);
        }

        List<Integer> salads = new ArrayList<>();

        while (vegetables.size() > 0 && calories.size() > 0) {
            int calorie = calories.peek();

            while (calorie > 0) {
                if (vegetables.size() <= 0) {
                    break;
                }
                String vegeteble = vegetables.poll();
                int pointToremove = 0;
                switch (vegeteble) {
                    case "tomato":
                        pointToremove = 80;
                        break;
                    case "carrot":
                        pointToremove = 136;
                        break;
                    case "lettuce":
                        pointToremove = 109;
                        break;
                    case "potato":
                        pointToremove = 215;
                        break;
                }

                calorie -= pointToremove;
            }
            salads.add(calories.pop());
        }
        salads.forEach(e -> System.out.print(e + " "));
        System.out.println();
        if (vegetables.size() > 0) {
            vegetables.forEach(e -> System.out.print(e + " "));
        } else {
            calories.forEach(e -> System.out.print(e + " "));
        }
    }
}
