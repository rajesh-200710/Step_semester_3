package week_10_problems.class_problems;

import java.util.*;

abstract class Account {
    protected String id;
    protected int balance;

    public Account(String id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public abstract String withdraw(int amount);
}

class SavingsAccount extends Account {
    public SavingsAccount(String id, int balance) {
        super(id, balance);
    }

    @Override
    public String withdraw(int amount) {
        if (balance - amount < 1000) {
            return id + " rejected: minimum balance 1000";
        }
        balance -= amount;
        return id + " balance " + balance;
    }
}

class CurrentAccount extends Account {
    public CurrentAccount(String id, int balance) {
        super(id, balance);
    }

    @Override
    public String withdraw(int amount) {
        if (balance - amount < -5000) {
            return id + " rejected: overdraft limit 5000";
        }
        balance -= amount;
        return id + " balance " + balance;
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Account> accounts = new HashMap<>();

        while (sc.hasNext()) {
            String command = sc.next();
            if (command.equals("Savings")) {
                String id = sc.next();
                int initialBalance = sc.nextInt();
                accounts.put(id, new SavingsAccount(id, initialBalance));
            } else if (command.equals("Current")) {
                String id = sc.next();
                int initialBalance = sc.nextInt();
                accounts.put(id, new CurrentAccount(id, initialBalance));
            } else if (command.equals("WITHDRAW")) {
                String id = sc.next();
                int amount = sc.nextInt();
                if (!accounts.containsKey(id)) {
                    System.out.println("Account not found");
                } else {
                    System.out.println(accounts.get(id).withdraw(amount));
                }
            }
        }
        sc.close();
    }
}