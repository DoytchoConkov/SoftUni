import java.util.*;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Integer> male = new ArrayDeque<>();
        Deque<Integer> female = new ArrayDeque<>();
        boolean flag = true;

        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        for (int number : numbers) {
            if (number != 0 && flag) {
                if (number % 25 == 0) {
                    flag = false;
                } else {
                    male.push(number);
                    flag = true;
                }
            }
        }

        flag = true;
        numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        for (int number : numbers) {
            if (number != 0 && flag) {
                if (number % 25 == 0) {
                    flag = false;
                } else {
                    female.offer(number);
                    flag = true;
                }
            }
        }

        int matches = 0;

        while (male.size() > 0 && female.size() > 0) {
            int currentMale = male.pop();
            int currentFemale = female.poll();


            while (currentMale % 25 == 0) {
                if (male.size() == 0) {
                    currentMale = 0;
                    break;
                }
                currentMale = male.pop();
            }

            while (currentFemale % 25 == 0) {
                if (female.size() == 0) {
                    currentFemale = 0;
                    break;
                }
                currentFemale = female.poll();
            }

            if (currentFemale == currentMale) {
                matches++;
            } else {
                if (currentMale - 2 > 0) {
                    male.push(currentMale - 2);
                }
            }
        }

        System.out.printf("Matches: %d%n", matches);

        if (male.size() == 0) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            List<String> temp = new ArrayList<>();
            while (male.size() > 0) {
                temp.add("" + male.pop());
            }
            System.out.println(String.join(", ", temp));
        }

        if (female.size() == 0) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            List<String> temp = new ArrayList<>();
            while (female.size() > 0) {
                temp.add("" + female.poll());
            }
            System.out.println(String.join(", ", temp));
        }
    }
}
