package accounts;
public class Account {
    double amount;
    double balance;
    int account;

    public double getAmount() {
        return amount;
    }

    public int getAccount() {
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

        public static void main(String[] args) {
            Account bill = new Account(1001);
            bill.deposit(200);
            bill.withdrawal(50);
            System.out.println("Итоговый баланс: " + bill.getBalance());
            Account billSend = new Account(1002);
            billSend.deposit(75.50);
            billSend.withdrawal(20.00);
            System.out.println("Итоговый баланс: " + billSend.getBalance());
            System.out.println("Перевод средств " + bill.send(bill, 100));
        }
  }


