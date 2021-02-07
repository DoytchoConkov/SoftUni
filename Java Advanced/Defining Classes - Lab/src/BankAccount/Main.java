package BankAccount;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<Integer, BankAccount> accounts = new LinkedHashMap<>();
        while (!input.equals("End")) {
            String[] token = input.split("\\s+");
            if (token[0].equals("Create")) {
                BankAccount acount = new BankAccount();
                accounts.put(acount.getId(), acount);
                System.out.printf("Account ID%d created\n", acount.getId());
            } else if (token[0].equals("Deposit")) {
                int currentId = Integer.parseInt(token[1]);
                double currentDeposit = Integer.parseInt(token[2]);
                if (accounts.containsKey(currentId)) {
                    accounts.get(currentId).deposit(currentDeposit);
                    System.out.printf("Deposited %f to ID%d\n", currentDeposit, currentId);
                } else {
                    System.out.println("Account does not exist");
                }
            } else if (token[0].equals("GetInterest")) {
                int currentId = Integer.parseInt(token[1]);
                int years = Integer.parseInt(token[2]);
                if (accounts.containsKey(currentId)) {
                    System.out.printf("%.2f\n", accounts.get(currentId).getInterest(years));
                } else {
                    System.out.println("Account does not exist");
                }
            } else if (token[0].equals("SetInterest")) {
                BankAccount.setInterestRate(Double.parseDouble(token[1]));
            }
            input = scan.nextLine();
        }
    }
}
