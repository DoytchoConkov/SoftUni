import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] bestDNA = new int[n];
        int sequenceIndex = 0;
        int maxLenght = 0;
        int maxLeft = 0;
        int maxSum = 0;
        int[] dna = new int[n];
        int bestSequenceIndex = 0;
        String input = scan.nextLine();
        while (!"Clone them!".equals(input)) {
            sequenceIndex++;
            int k = 0;
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '0') {
                    dna[k] = 0;
                    k++;
                }
                if (input.charAt(j) == '1') {
                    dna[k] = 1;
                    k++;
                }
            }
            int cnt = 0;
            boolean flag = false;
            int posision = 0;
            int currentleft = 0;
            int currentLenght = 0;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (dna[i] == 1) {
                    cnt++;
                    sum++;
                    if (!flag) {
                        posision = i;
                        flag = true;
                    }
                } else {
                    flag = false;
                    cnt = 0;
                }
                if (cnt > currentLenght) {
                    currentLenght = cnt;
                    currentleft = posision;
                }
            }
            if (maxLenght < currentLenght) {
                maxLenght = currentLenght;
                maxLeft = currentleft;
                bestSequenceIndex = sequenceIndex;
                maxSum = sum;
                for (int i = 0; i < n; i++) {
                    bestDNA[i] = dna[i];
                }
            } else if (maxLenght == currentLenght && maxLeft > currentleft) {
                maxLeft = currentleft;
                bestSequenceIndex = sequenceIndex;
                maxSum = sum;
                for (int i = 0; i < n; i++) {
                    bestDNA[i] = dna[i];
                }
            } else if (maxLenght == currentLenght && maxLeft == currentleft && sum > maxSum) {
                maxLeft = currentleft;
                bestSequenceIndex = sequenceIndex;
                for (int i = 0; i < n; i++) {
                    bestDNA[i] = dna[i];
                }
            }
            if (sequenceIndex==1) {
                maxLenght = currentLenght;
                maxLeft = currentleft;
                bestSequenceIndex = sequenceIndex;
                maxSum = sum;
                for (int i = 0; i < n; i++) {
                    bestDNA[i] = dna[i];
                }
            }
            input = scan.nextLine();
        }
        String result = "";
        for (int number : bestDNA) {
            result = result + number + " ";

        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSequenceIndex, maxSum);
        System.out.println(result);
    }
}
