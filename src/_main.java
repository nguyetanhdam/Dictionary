public class _main {
    public static void main(String[] args) {
        int choose;
        boolean exit = false;

        showMenu();

        while (true) {
            choose = Validation.inputIntLimit(0, 8);
            switch (choose) {
                case 1:
                    DictionaryManagement.insertFromFile();
                    System.out.print("Insert from file successful!");
                    break;
                case 2:
                    DictionaryManagement.insertFromCommandline();
                    System.out.print("Insert from Command Line successful!");
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
                case 6:
                    DictionaryManagement.editDictionary();
                    break;
                case 7:
                    DictionaryManagement.removeWordInDictionary();
                    break;
                case 8:
                    DictionaryManagement.dictionaryExportToFile();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Goodbye!");
                    break;
            }
            if (exit) break;
            System.out.println("\n\n");
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
        System.out.println("6. Edit dictionary");
        System.out.println("7. Remove one word in dictionary");
        System.out.println("8. Export this dictionary to file");
        System.out.println("0. Exit");
        System.out.println("=====================");
        System.out.print("Please choose: ");
    }
}
