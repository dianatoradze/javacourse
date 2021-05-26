package accounts;

import java.time.LocalDate;
import java.util.Date;

public class DepositAccount extends Account {


    private LocalDate datePayment;

    public DepositAccount(int accountNum, Date setLocalDate) {
        super(accountNum);

    }
    public boolean withdrawal (double amount) {

        return super.withdrawal (amount + 0.01);
    }
    public void SaverAccount (int accountNum) {


        if (datePayment.isBefore(datePayment.plusMonths(1))) {
            System.out.println ("Штраф за снятие: " + 0.01);
        }
    }
   public LocalDate getDatePayment (){

        LocalDate date  = LocalDate.of(2020, 11, 30);
        System.out.println("Дата внесения последнего платежа" + date);

       return datePayment;
   }

}
