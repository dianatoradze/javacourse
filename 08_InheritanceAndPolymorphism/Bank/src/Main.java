import accounts.Account;

public class Main {
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
