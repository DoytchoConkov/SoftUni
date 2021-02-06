import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list1 = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        List<String> list2 = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        List<String> resultList = new ArrayList<>();
        if (list1.size() < list2.size()) {
            {
                int i = 0;
                while (i < list1.size()) {
                    resultList.add(list1.get(i));
                    resultList.add(list2.get(i));
                    i++;
                }
            }
            for (int i = list1.size(); i < list2.size(); i++) {
                resultList.add(list2.get(i));
            }
        } else {
            for (int i = 0; i < list2.size(); i++) {
                resultList.add(list1.get(i));
                resultList.add(list2.get(i));
            }
            for (int i = list2.size(); i < list1.size(); i++) {
                resultList.add(list1.get(i));
            }
        }
        System.out.println(resultList.toString().replaceAll("[\\[\\],]", ""));
    }
}
