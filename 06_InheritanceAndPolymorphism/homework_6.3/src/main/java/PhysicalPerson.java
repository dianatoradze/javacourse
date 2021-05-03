public class PhysicalPerson extends Client {

    public PhysicalPerson() {
        this.amount = amount;
    }

    public void put(double amountToPut) {
        super.put(amountToPut);
    }

    public void take(double amountToTake) {
        super.take(amountToTake);
    }

    public void print() {
        System.out.println("Условия пополнения: Снятие суммы больше баланса невозможно");
        System.out.println("Информация об аккаунте");
        System.out.println("Баланс:" + getAmount());

    }
}
