package accounts;

public class CheckingAccount extends ModelOfAccounts{


    public CheckingAccount(int numberOfAccount, String name, String cpf) {
        super(numberOfAccount, name, cpf);
    }

    @Override
    public void withdraw(double value) {
        try {
            if (value > checkBalance()) {
                throw new RuntimeException("The withdrawal amount cannot be greater than your balance.");
            }
            if (value <= 0) {
                throw new RuntimeException("The withdrawal amount cannot be less than or equal to 0.");
            }
            deposit(-value);
        } catch (RuntimeException exception) {
            System.out.println("System: " + exception.getMessage());
        }
    }
}
