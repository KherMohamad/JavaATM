import java.util.*;

public class ATM {
    private LinkedHashMap<Integer, Integer> atmBalance;
    private List<Integer> billsAvailable;
    private HashMap<Integer, Integer> capacity;
    public ATM() {
        atmBalance = new LinkedHashMap<>();
        atmBalance.put(1, 100);
        atmBalance.put(5, 100);
        atmBalance.put(10, 100);
        atmBalance.put(50, 50);
        atmBalance.put(100, 50);
        billsAvailable = Arrays.asList(100, 50, 10, 5, 1);
        capacity = new HashMap<>(atmBalance);
    }
    public LinkedHashMap<Integer, Integer> calculateSplit(int value) {
        LinkedHashMap<Integer, Integer> billsReturned = new LinkedHashMap<>();
        int billIndex = getNextBillInStock(0);
        if (billIndex == -1) {
            return null;
        }
        int billValue = billsAvailable.get(billIndex);
        int valueLeft = value;
        while(valueLeft > 0) {
            if (billValue <= valueLeft) {
               if (billsReturned.containsKey(billValue)) {
                   billsReturned.put(billValue, billsReturned.get(billValue) + 1);
               } else {
                   billsReturned.put(billValue, 1);
               }
                valueLeft -= billValue;

                atmBalance.put(billValue, atmBalance.get(billValue) - 1);
                if (valueLeft == 0) {
                    break;
                }
                if (atmBalance.get(billValue) == 0) {
                    billIndex = getNextBillInStock(billIndex + 1);
                    if (billIndex == -1 && valueLeft > 0) {
                        return null;
                    }
                    billValue = billsAvailable.get(billIndex);
                }
            } else {
                billIndex = getNextBillInStock(billIndex + 1);
                if (billIndex == -1 && valueLeft > 0) {
                    return null;
                }
                billValue = billsAvailable.get(billIndex);
            }

        }
        return billsReturned;
    }
    public double getStock(int bill) {
        double percentage = atmBalance.get(bill);
        return percentage / capacity.get(bill);
    }
    public int getNextBillInStock(int billIndex) {
        while(billIndex < billsAvailable.size() && (atmBalance.get(billsAvailable.get(billIndex)) == 0)) {
            billIndex++;
        }
        if (billIndex >= billsAvailable.size()) {
            return -1;
        }
        return billIndex;


    }

}
