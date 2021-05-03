public class LegalPerson extends Client {

    public LegalPerson() {
        this.amount = amount;
    }

    @Override
    public void put(double amountToPut) {
        super.put(amountToPut);
    }

    @Override
    public void take(double amountToTake) {
        if (amountToTake < amount) {
            amount -= amountToTake * 0.01;
        }
        super.take(amountToTake);
    }

    public void print() {
        System.out.println("Информация об аккаунте");
        System.out.println("Условия пополнения: Снятие суммы больше баланса невозможно");
        System.out.println("Баланс:" + getAmount());
        System.out.print("Условия снятия: Юр.лица комиссия 1%");

    }

}
