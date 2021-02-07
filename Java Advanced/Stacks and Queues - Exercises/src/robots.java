import java.util.*;

public class robots {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] robots = input.split(";");
        Map<String, Integer> robotsTime = new LinkedHashMap<>();
        Map<Integer, String> robotsNames = new LinkedHashMap<>();
        int cnt = 0;
        for (String robot : robots) {
            String[] tokens = robot.split("-");
            robotsTime.put(tokens[0], Integer.parseInt(tokens[1]));
            robotsNames.put(cnt, tokens[0]);
            cnt++;
        }

        int[] time = Arrays.stream(scan.nextLine().split(":")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int totalTimeInSeconds = time[0] * 3600 + time[1] * 60 + time[2];
        ArrayDeque<String> products = new ArrayDeque<>();
        String product = scan.nextLine();

        while (!product.equals("End")) {
            products.offer(product);
            product = scan.nextLine();
        }

        int[] timeWork = new int[robotsTime.size()];

        while (!products.isEmpty()) {
            totalTimeInSeconds++;
            for (int i = 0; i < timeWork.length; i++) {
                if (timeWork[i] > 0) {
                    timeWork[i]--;
                }
            }
            boolean isThereFree=false;
            for (int i = 0; i < timeWork.length; i++) {
                if (timeWork[i] == 0) {
                    isThereFree=true;
                    String robotName = robotsNames.get(i);
                    Integer robotDelay = robotsTime.get(robotName);
                    int currentHour = totalTimeInSeconds / 3600%24;
                    int currentMinutes = totalTimeInSeconds % 3600 / 60;
                    int currentSeconds = totalTimeInSeconds % 60;
                    timeWork[i] = robotDelay;
                    System.out.printf("%S - %s [%02d:%02d:%02d]\n", robotName, products.poll(), currentHour, currentMinutes, currentSeconds);
                    break;
                }
            }
            if (!isThereFree){
                products.offer(products.poll());
            }
        }
    }
}
