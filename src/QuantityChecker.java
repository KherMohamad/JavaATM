public class QuantityChecker {
    public static boolean checkLevel1Shortage(ATM atm) {
        return atm.getStock(100) < 0.2;
    }
    public static boolean checkLevel2Shortage(ATM atm) {
        return atm.getStock(100) < 0.1;
    }
    public static boolean checkLevel3Shortage(ATM atm) {
        return atm.getStock(50) < 0.15;
    }
}
