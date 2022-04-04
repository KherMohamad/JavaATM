import java.util.HashMap;
import java.util.LinkedHashMap;

public class CashOutputter {
    public void printBills(LinkedHashMap<Integer, Integer> billsReturned, Integer value, String userName) throws InsufficientDepositException{
        if (billsReturned == null) {
            throw new InsufficientDepositException("ATM machine has insufficient funds deposited to return that value");
        } else {
            System.out.print("User " + userName + " withdrew " + value + " as: ");
            for (Integer bill : billsReturned.keySet()) {
                Integer nrOfBills = billsReturned.get(bill);
                while (nrOfBills > 0) {
                    System.out.println(bill);
                    nrOfBills--;
                }
            }
        }
    }
    public void sendLevel1ShortageNotification() {
        System.out.println("To: ATMAdmin@gmail.com");
        System.out.println("Notice: 100 bill has a quantity shortage");
        System.out.println("Level: warning");
    }
    public void sendLevel2ShortageNotification() {
        System.out.println("To: 0730301212");
        System.out.println("Notice: 100 bill has a quantity shortage");
        System.out.println("Level: crtitical");
    }
    public void sendLevel3ShortageNotification() {
        System.out.println("To: ATMAdmin@gmail.com");
        System.out.println("Notice: 50 bill has a quantity shortage");
        System.out.println("Level: warning");
    }
    public void sendBigWithdrawalNotification(String user) {
        System.out.println("To: " + user + " @gmail.com");
        System.out.println("Notice: You've made a large sum withdrawal. Please access your account to confirm that was you");
    }

}
