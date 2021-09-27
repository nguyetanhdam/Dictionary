import java.util.Scanner;

public class Validation {

    private static final Scanner SC = new Scanner(System.in);

    //check user input number in limit
    public static int inputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(SC.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input an integer between " + min + " and " + max + ".");
                System.out.print("Enter again: ");
            }
        }
    }
}
