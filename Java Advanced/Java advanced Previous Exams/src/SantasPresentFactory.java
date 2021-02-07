import java.util.*;

public class SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<Integer> materialsBox = new ArrayDeque<>();
        Deque<Integer> magicBox = new ArrayDeque<>();

        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        for (int number : numbers) {
            materialsBox.push(number);
        }

        numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        for (int number : numbers) {
            magicBox.offer(number);
        }
        int bicycle = 0;
        int teddyBears = 0;
        int woodenTrains = 0;
        int dolls = 0;

        while (materialsBox.size() > 0 && magicBox.size() > 0) {

            int material = materialsBox.pop();
            int magic = magicBox.poll();
            int result = material * magic;

            if (result == 400) {
                bicycle++;
            } else if (result == 300) {
                teddyBears++;
            } else if (result == 250) {
                woodenTrains++;
            } else if (result == 150) {
                dolls++;
            } else {
                if (result < 0) {
                    materialsBox.push(material + magic);
                } else if (material == 0 || magic == 0) {
                    if (material == 0) {
                        magicBox.push(magic);
                    } else {
                        materialsBox.push(material);
                    }
                } else {
                    materialsBox.push(material + 15);
                }
            }
        }
        if ((dolls > 0 && woodenTrains > 0) || (teddyBears > 0 && bicycle > 0)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (materialsBox.size() > 0) {
            System.out.print("Materials left: ");
            List<String> temp = new ArrayList<>();
            while (materialsBox.size() > 0) {
                temp.add("" + materialsBox.poll());
            }
            System.out.println(String.join(", ", temp));
        }

        if (magicBox.size() > 0) {
            System.out.print("Magic left: ");
            List<String> temp = new ArrayList<>();
            while (magicBox.size() > 0) {
                temp.add("" + magicBox.poll());
            }
            System.out.println(String.join(", ", temp));
        }

        if (bicycle > 0) {
            System.out.println("Bicycle: " + bicycle);
        }
        if (dolls > 0) {
            System.out.println("Doll: " + dolls);
        }
        if (teddyBears > 0) {
            System.out.println("Teddy bear: " + teddyBears);
        }
        if (woodenTrains > 0) {
            System.out.println("Wooden train: " + woodenTrains);
        }
    }
}
