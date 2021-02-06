import java.util.Arrays;
import java.util.Scanner;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers1 = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int[] numbers2 = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        Integer[] arr = new Integer[numbers1.length + numbers2.length - 2];
        int cnt = 0;
        int minNumber = 0;
        int maxNumber = 0;
        if (numbers1.length>numbers2.length) {
            for (int i = 0; i < numbers2.length; i++) {
                arr[cnt] = numbers1[i];
                arr[cnt + 1] = numbers2[numbers2.length - 1 - i];
                cnt = cnt + 2;
            }

            if (numbers1[numbers1.length - 1] < numbers1[numbers1.length - 2]) {
                minNumber = numbers1[numbers1.length - 1];
                maxNumber = numbers1[numbers1.length - 2];
            } else {
                minNumber = numbers1[numbers1.length - 2];
                maxNumber = numbers1[numbers1.length - 1];
            }
        }else {

            for (int i = 0; i < numbers1.length; i++) {
                arr[cnt] = numbers1[i];
                arr[cnt + 1] = numbers2[numbers2.length - 1 - i];
                cnt = cnt + 2;
            }

            if (numbers2[0] < numbers2[1]) {
                minNumber = numbers2[0];
                maxNumber = numbers2[1];
            } else {
                minNumber = numbers2[1];
                maxNumber = numbers2[0];
            }

        }
        int counter = 0;
        for (int number : arr) {
            if (number > minNumber && number < maxNumber) {
                counter++;
            }
        }
        int[] result = new int[counter];
        int index = 0;
        for (int number : arr) {
            if (number > minNumber && number < maxNumber) {
                result[index] = number;
                index++;
            }
        }
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < result.length - 1; i++) {
                if (result[i] > result[i + 1]) {
                    int tmp = result[i];
                    result[i] = result[i + 1];
                    result[i + 1] = tmp;
                    flag = true;
                }
            }
        }
        for (int n : result) {
            System.out.print(n + " ");
        }
    }
}
