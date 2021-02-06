import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] numbersInText = scan.nextLine().split(" ");
        Integer[] numbers = new Integer[numbersInText.length];

        for (int i = 0; i < numbersInText.length; i++) {
            numbers[i] = Integer.parseInt(numbersInText[i]);
        }

        String[] comand = scan.nextLine().split(" ");

        while (!"end".equals(comand[0])) {
            switch (comand[0]) {
                case "exchange":
                    if (Integer.parseInt(comand[1]) >= 0 && Integer.parseInt(comand[1]) < numbers.length) {
                        exchange(numbers, Integer.parseInt(comand[1]));
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "max":
                    if ("even".equals(comand[1])) {
                        maxEven(numbers);
                    } else {
                        maxOdd(numbers);
                    }
                    break;
                case "min":
                    if ("even".equals(comand[1])) {
                        minEven(numbers);
                    } else {
                        minOdd(numbers);
                    }
                    break;
                case "first":
                    if ("even".equals(comand[2])) {
                        if (Integer.parseInt(comand[1]) >= 1 && Integer.parseInt(comand[1]) <= numbers.length) {
                            firstEven(numbers, Integer.parseInt(comand[1]));
                        } else {
                            System.out.println("Invalid count");
                        }
                    } else {
                        if (Integer.parseInt(comand[1]) >= 1 && Integer.parseInt(comand[1]) <= numbers.length) {
                            firstOdd(numbers, Integer.parseInt(comand[1]));
                        } else {
                            System.out.println("Invalid count");
                        }
                    }
                    break;
                case "last":
                    if ("even".equals(comand[2])) {
                        if (Integer.parseInt(comand[1]) >= 1 && Integer.parseInt(comand[1]) <= numbers.length) {
                            lastEven(numbers, Integer.parseInt(comand[1]));
                        } else {
                            System.out.println("Invalid count");
                        }
                    } else {
                        if (Integer.parseInt(comand[1]) >= 1 && Integer.parseInt(comand[1]) <= numbers.length) {
                            lastOdd(numbers, Integer.parseInt(comand[1]));
                        } else {
                            System.out.println("Invalid count");
                        }
                    }
                    break;
            }

            comand = scan.nextLine().split(" ");
        }

        printArray1(numbers);
    }

    private static void lastOdd(Integer[] numbers, int lng) {
        int cnt = 0;
        Integer[] newNum = new Integer[lng];

        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] % 2 != 0) {
                newNum[lng - cnt - 1] = numbers[i];
                cnt++;
                if (cnt >= lng) {
                    break;
                }
            }
        }

        printArray1(reverseArray(newNum));
    }

    private static Integer[] reverseArray(Integer[] newNum) {
        boolean flag = false;

        for (int i = 0; i < newNum.length; i++) {
            if (newNum[i] != null) {
                flag = true;
            }
        }
        if (flag) {
            while (newNum[0] == null) {
                for (int i = 0; i < newNum.length - 1; i++) {
                    newNum[i] = newNum[i + 1];
                }
                newNum[newNum.length - 1] = null;
            }
        }

        return newNum;
    }

    private static void lastEven(Integer[] numbers, int lng) {
        int cnt = 0;
        Integer[] newNum = new Integer[lng];

        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] % 2 == 0) {
                newNum[lng - cnt - 1] = numbers[i];
                cnt++;
                if (cnt >= lng) {
                    break;
                }
            }
        }
        printArray1(reverseArray(newNum));
    }

    private static void firstOdd(Integer[] numbers, int lng) {
        int cnt = 0;
        Integer[] newNum = new Integer[lng];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                newNum[cnt] = numbers[i];
                cnt++;
                if (cnt >= lng) {
                    break;
                }
            }
        }
        printArray1(newNum);
    }

    private static void firstEven(Integer[] numbers, int lng) {
        int cnt = 0;
        Integer[] newNum = new Integer[lng];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                newNum[cnt] = numbers[i];
                cnt++;
                if (cnt >= lng) {
                    break;
                }
            }
        }
        printArray1(newNum);
    }

    private static void minOdd(Integer[] numbers) {
        int index = 0;
        int minTemp = Integer.MAX_VALUE;
        boolean flag = false;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                if (numbers[i] <= minTemp) {
                    flag = true;
                    minTemp = numbers[i];
                    index = i;
                }
            }
        }

        if (flag) {
            System.out.println(index);
        } else {
            System.out.println("No matches");
        }

    }


    private static void minEven(Integer[] numbers) {
        int index = 0;
        int minTemp = Integer.MAX_VALUE;
        boolean flag = false;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                if (numbers[i] <= minTemp) {
                    flag = true;
                    minTemp = numbers[i];
                    index = i;
                }
            }
        }

        if (flag) {
            System.out.println(index);
        } else {
            System.out.println("No matches");
        }
    }

    private static void maxOdd(Integer[] numbers) {
        int index = 0;
        int maxTemp = Integer.MIN_VALUE;
        boolean flag = false;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                if (numbers[i] >= maxTemp) {
                    flag = true;
                    maxTemp = numbers[i];
                    index = i;
                }
            }
        }

        if (flag) {
            System.out.println(index);
        } else {
            System.out.println("No matches");
        }
    }

    private static void maxEven(Integer[] numbers) {
        int index = 0;
        int maxTemp = Integer.MIN_VALUE;
        boolean flag = false;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                if (numbers[i] >= maxTemp) {
                    flag = true;
                    maxTemp = numbers[i];
                    index = i;
                }
            }
        }

        if (flag) {
            System.out.println(index);
        } else {
            System.out.println("No matches");
        }
    }

    private static void exchange(Integer[] num, int n) {
        for (int i = 0; i <= n % num.length; i++) {
            int temp = num[0];
            for (int j = 0; j < num.length - 1; j++) {
                num[j] = num[j + 1];
            }
            num[num.length - 1] = temp;
        }
    }

    private static void printArray1(Integer[] num) {
        System.out.print("[");
        for (int i = 0; i < num.length; i++) {
            if (num[i] != null) {
                if (i == 0) {
                    System.out.print(num[i]);
                } else {
                    System.out.print(", " + num[i]);
                }
            }
        }
        System.out.println("]");
    }
}
