import java.util.Scanner;

public class main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choose;
        boolean exit = false;

        showMenu();

        while (true) {
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    DictionaryManagement.insertFromFile();
                    break;
                case 2:
                    DictionaryManagement.insertFromCommandline();
                    break;
                case 3:
                    DictionaryCommandline.showAllWords();
                    break;
                case 4:
                    DictionaryManagement.dictionaryLookup();
                    break;
                case 5:
                    DictionaryCommandline.dictionarySearcher();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Goodbye!");
                    break;
            }
            if (exit) break;
            System.out.println("\n");
            showMenu();
        }
    }

    public static void showMenu() {
        System.out.println("===== SHOW MENU =====");
        System.out.println("1. Insert from File");
        System.out.println("2. Insert from Command Line");
        System.out.println("3. Show all words");
        System.out.println("4. Look up");
        System.out.println("5. Search");
        System.out.println("0. exit");
        System.out.println("=====================");
        System.out.print("Please choose: ");
    }
}
