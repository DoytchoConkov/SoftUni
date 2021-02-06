import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> racers = Arrays.stream(scan.nextLine().split(", "))
                .collect(Collectors.toList());
        Pattern patternName = Pattern.compile("[A-Z]|[a-z]");
        Pattern patternDistance = Pattern.compile("[0-9]");
        Map<String, Integer> mapRacers = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!"end of race".equals(input)) {
            StringBuilder name = new StringBuilder();
            int distance = 0;
            Matcher matcherName = patternName.matcher(input);
            Matcher matcherDistance = patternDistance.matcher(input);
            while (matcherName.find()) {
                name.append(matcherName.group(0));
            }
            while (matcherDistance.find()) {
                distance += Integer.parseInt(matcherDistance.group(0));
            }
            if (racers.contains(String.valueOf(name))) {
                mapRacers.putIfAbsent(String.valueOf(name), 0);
                mapRacers.put(String.valueOf(name), mapRacers.get(String.valueOf(name)) + distance);
            }
            input = scan.nextLine();
        }
        int i = 1;
        List<Map.Entry<String, Integer>> toSort = new ArrayList<>();
        for (Map.Entry<String, Integer> r : mapRacers
                .entrySet()) {
            toSort.add(r);
        }
        toSort.sort((r1, r2) -> r2.getValue().compareTo(r1.getValue()));
        long limit = 3;
        for (Map.Entry<String, Integer> r : toSort) {
            if (limit-- == 0) break;
            switch (i) {
                case 1:
                    System.out.printf("1st place: %s%n", r.getKey());
                    break;
                case 2:
                    System.out.printf("2nd place: %s%n", r.getKey());
                    break;
                case 3:
                    System.out.printf("3rd place: %s%n", r.getKey());
                    break;
            }
            i++;
        }
    }
}
