public abstract class Client {
    protected double amount;

    public Client(double amount) {
        this.amount = amount;
        double amountToPut = 0;
        double amountToTake = 0;
    }

    protected Client() {
    }

    public double getAmount() {
        return amount;
    }

    public void put(double amountToPut) {
        if (amountToPut < 0) {
            System.out.println("Отрицательная сумма пополнения");
        } else {
            amount += amountToPut;
        }
    }

    public void take(double amountToTake) {
        if (amount < 0) {
            System.out.println("Отрицательная сумма");
        } else if (amount < amountToTake) {
            System.out.println("Недостаточно средств");
        } else {
            amount -= amountToTake;
        }
    }

    public void print() {
        System.out.println("Информация об аккаунте");
        System.out.println("Баланс:" + getAmount());
        System.out.print("Условия снятия");
        System.out.println("ИП-1% комиссия, если сумма <1000р, если >1000р комиссия 0.5%" +
                "Юр.лица комиссия 1%");
        System.out.print("Условия пополнения");
        System.out.print("Снятие суммы больше баланса невозможно");
    }

}
