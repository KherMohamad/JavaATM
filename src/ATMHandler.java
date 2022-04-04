import java.util.HashMap;
import java.util.LinkedHashMap;

public class ATMHandler {
    private ATM atm;
    private static CashOutputter co = new CashOutputter();

    public ATMHandler(ATM atm) {
        this.atm = atm;
    }


    public void handle(int value, String userName) {
        LinkedHashMap<Integer, Integer> billsReturned = atm.calculateSplit(value);
        try {
            co.printBills(billsReturned, value, userName);
            if (value > 200) {
                co.sendBigWithdrawalNotification(userName);
            }
            if (QuantityChecker.checkLevel1Shortage(atm)) {
                co.sendLevel1ShortageNotification();
            }
            if (QuantityChecker.checkLevel2Shortage(atm)) {
                co.sendLevel2ShortageNotification();
            }
            if (QuantityChecker.checkLevel3Shortage(atm)) {
                co.sendLevel3ShortageNotification();
            }
        } catch (InsufficientDepositException ide) {
            System.err.println("Error: "+ ide.getMessage());
        }
    }
}
