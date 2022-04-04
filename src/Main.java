import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        ATM myAtm = new ATM();
        ATMHandler handler = new ATMHandler(myAtm);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter userName:");
        try {
            String userName = br.readLine();
            while (true) {
                System.out.println("enter value you want to retreive");
                String inputVal = br.readLine();
                if (inputVal.equals("exit")) {
                    break;
                }
                if (Utils.isInteger(inputVal) == false) {
                    System.out.println("Please provide a valid value");
                    continue;
                }
                int value = Integer.parseInt(inputVal);
                handler.handle(value, userName);
            }
        } catch (IOException ioException) {
            System.out.println(ioException);
        }
    }
}
