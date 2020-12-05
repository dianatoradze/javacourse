package accounts;

public class CreditCardAccount extends accounts.Account {
    public CreditCardAccount(int account, double amount, double balance) {
        super(account);
    }
    private CreditCardAccount overdraft;

    public CreditCardAccount(int accountNum,
                            CreditCardAccount protection) {

        super (accountNum);
        overdraft = protection;
    }

    public boolean withdrawal (double amount) {

        boolean result = false;

        if (! super.withdrawal (amount)) {
            System.out.println ("Включен овердрафт");
            if (! overdraft.withdrawal (amount - balance)) {
                System.out.println("Средств овердрафта недосточно");
            }

            else {
                balance = 0;
                balance += balance * 0.01;
                System.out.println ("Процент добавлен к счету " + account);
                System.out.println ("Новый баланс счета " +
                        account + ": " + balance);
                result = true;
            }
        }
        System.out.println ();
        return result;
    }
}
