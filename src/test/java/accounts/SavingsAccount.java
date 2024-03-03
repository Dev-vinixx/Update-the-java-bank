package accounts;

public class SavingsAccount extends ModelOfAccounts{


    public SavingsAccount(int numberOfAccount, String name, String cpf) {
        super(numberOfAccount, name, cpf);
    }


    @Override
    public void withdraw(double value) {
        try {
            if ((value * 1.05) > checkBalance()) {
                throw new RuntimeException("You can't withdraw your balance doesn't incur the 5% fee.");
            } if (value <= 0) {
                throw new RuntimeException("The withdrawal amount cannot be less than or equal to 0.");
            }
            deposit( (value * 1.05));
        } catch (RuntimeException exception) {
            System.out.println("System: " + exception.getMessage());
        }
    }

}

