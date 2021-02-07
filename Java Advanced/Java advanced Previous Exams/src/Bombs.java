import java.util.*;

public class Bombs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<Integer> bombEffects = new ArrayDeque<>();
        Deque<Integer> bombCasing = new ArrayDeque<>();

        int[] numbers = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        for (int number : numbers) {
            bombEffects.offer(number);
        }

        numbers = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        for (int number : numbers) {
            bombCasing.push(number);
        }

        int daturaBombs = 0;
        int cherryBombs = 0;
        int smokeDecoyBombs = 0;

        while (bombEffects.size() > 0 && bombCasing.size() > 0) {
            if (daturaBombs >= 3 && cherryBombs >= 3 && smokeDecoyBombs >= 3) {
                break;
            }
            int currentEffects = bombEffects.poll();
            int currentCasing = bombCasing.pop();
            int sum = currentEffects + currentCasing;
            if (sum == 120) {
                smokeDecoyBombs++;
            } else if (sum == 60) {
                cherryBombs++;
            } else if (sum == 40) {
                daturaBombs++;
            } else {
                while (true) {
                    currentCasing -= 5;
                    sum = currentEffects + currentCasing;
                    if (sum == 120) {
                        smokeDecoyBombs++;
                        break;
                    } else if (sum == 60) {
                        cherryBombs++;
                        break;
                    } else if (sum == 40) {
                        daturaBombs++;
                        break;
                    }
                }
            }
        }
        if (daturaBombs >= 3 && cherryBombs >= 3 && smokeDecoyBombs >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (bombEffects.size() == 0) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            List<String> temp = new ArrayList<>();
            while (bombEffects.size() > 0) {
                temp.add("" + bombEffects.pop());
            }
            System.out.println(String.join(", ", temp));
        }

        if (bombCasing.size() == 0) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            List<String> temp = new ArrayList<>();
            while (bombCasing.size() > 0) {
                temp.add("" + bombCasing.poll());
            }
            System.out.println(String.join(", ", temp));
        }

        System.out.printf("Cherry Bombs: %d%n", cherryBombs);
        System.out.printf("Datura Bombs: %d%n", daturaBombs);
        System.out.printf("Smoke Decoy Bombs: %d%n", smokeDecoyBombs);
    }
}
