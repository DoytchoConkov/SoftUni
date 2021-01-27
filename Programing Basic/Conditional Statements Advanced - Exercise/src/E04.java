import java.util.Scanner;

public class E04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String flowerType = scan.nextLine();
        int count = Integer.parseInt(scan.nextLine());
        int budjet = Integer.parseInt(scan.nextLine());
        double price = 0;
        double discont = 1;

        switch (flowerType) {
            case "Roses":
                price = count * 5;
                if (count > 80) {
                    discont = 0.9;
                }
                break;
            case "Dahlias":
                price = count * 3.8;
                if (count > 90) {
                    discont = 0.85;
                }
                break;
            case "Tulips":
                price = count * 2.8;
                if (count > 80) {
                    discont = 0.85;
                }
                break;
            case "Narcissus":
                price = count * 3;
                if (count < 120) {
                    discont = 1.15;
                }
                break;
            case "Gladiolus":
                price = count * 2.5;
                if (count < 80) {
                    discont = 1.2;
                }
                break;
        }
        //⦁	Ако Нели купи повече от 80 Рози - 10% отстъпка от крайната цена
        //⦁	Ако Нели купи повече от 90  Далии - 15% отстъпка от крайната цена
        //⦁	Ако Нели купи повече от 80 Лалета - 15% отстъпка от крайната цена
        //⦁	Ако Нели купи по-малко от 120 Нарциса - цената се оскъпява с 15%
        //⦁	Ако Нели Купи по-малко от 80 Гладиоли - цената се оскъпява с 20%
        price = price * discont;

//⦁	Ако бюджета им е достатъчен - "Hey, you have a great garden with {броя цвета} {вид цветя} and {останалата сума} leva left."
//⦁	Ако бюджета им е НЕ достатъчен - "Not enough money, you need {нужната сума} leva more."
        if (price <= budjet) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", count, flowerType, budjet - price);
        } else {
            System.out.printf("Not enough money, you need %.2f leva more.", price - budjet);
        }
    }
}
