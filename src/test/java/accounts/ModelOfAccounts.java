package accounts;

import java.util.Random;

public abstract class ModelOfAccounts {

    private final String name;
    private final int numberOfAccount;
    private double balance;
    private String cpf;
    private String type;
    private double coin;

    public ModelOfAccounts(int numberOfAccount, String name, String cpf) {
        this.numberOfAccount = numberOfAccount;
        this.name = name;
        this.cpf = cpf;
        balance = 0;
        coin = 0;
        Random rand = new Random();
        deposit(rand.nextDouble(1000.00));
    }

    public abstract void withdraw(double value);
    public void deposit (double value){
        try {
            if (value < 0) {
                coin += value;
                balance -= value;
            } else if (coin < value) {
                throw  new RuntimeException("You don't have any coins for this transaction.");
            } else if (value <= 0) {
                throw new RuntimeException("The withdrawal amount cannot be less than or equal to 0.");
            } else if (value > 0) {
                coin -= value;
                balance += value;
            }
        } catch (RuntimeException exception) {
            System.out.println("System: " + exception.getMessage());
        }
    }
    public double checkBalance() {
        return balance;
    }
    public double checkCoin() {
        return coin;
    }
    public void transfer(ModelOfAccounts targetAccount, double value) {
        try {
            if (this.balance >= value) {
                this.balance -= value;
                targetAccount.balance += value;
            } else if (value <= 0) {
                throw new RuntimeException("The withdrawal amount cannot be less than or equal to 0.");
            }
        } catch (RuntimeException exception) {
            System.out.println("System: " + exception.getMessage());
        }
    }
}