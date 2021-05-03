public class IndividualBusinessman extends Client {

    public IndividualBusinessman() {
        this.amount = amount;
    }

    public void take(double amountToTake) {
        super.take(amountToTake);
    }

    @Override
    public void put(double amountToPut) {

        if (amountToPut < 1000) {
            amount -= amountToPut * 0.01;
        } else {
            amount -= amountToPut * 0.005;
        }
        super.put(amountToPut);
    }

    public void print() {
        System.out.println("Информация об аккаунте");
        System.out.println("Условия пополнения: Снятие суммы больше баланса невозможно");
        System.out.println("Баланс:" + getAmount());
        System.out.println("ИП-1% комиссия, если сумма <1000р, если >1000р комиссия 0.5%");

    }
}
