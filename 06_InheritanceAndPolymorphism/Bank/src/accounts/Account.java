package accounts;
public class Account {
    protected double amount;
     protected double balance;
     protected int account;

    public double getAmount() {
        return amount;
    }

    protected int getAccount() {
        return account;
    }

    public Account(int accountNum) {
        account = accountNum;
    }
  public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {

        balance += amount;
        System.out.println("Пополнение со счета " + account);
        System.out.println("Сумма пополнения: " + amount);
        System.out.println("Новый баланс: " + balance);
        System.out.println();
    }

    public boolean withdrawal(double amount) {

        boolean result = false;
        System.out.println("Снятие средств со счета " + account);
        System.out.println("Сумма снятия: " + amount);
        if (amount > balance)
            System.out.println("Недостаточно средств");
        else {
            balance -= amount;
            System.out.println("Новый баланс: " + balance);
            result = true;
        }
        System.out.println();
        return result;
    }

    public boolean send(Account receiver, double amount) {
       boolean sendAmount= this.withdrawal(amount);
    if (sendAmount) {
        receiver.deposit(amount);
    }

    this.withdrawal(amount);

        return sendAmount;
    }
  }


