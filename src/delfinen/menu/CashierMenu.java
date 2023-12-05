package delfinen.menu;

import delfinen.model.Cashier;
import delfinen.misc.ConsoleColors;

import java.util.Scanner;

public class CashierMenu {

    Menu cashierMenu = new Menu("Cashier Menu:", pointsCashierMenu());
    MainMenu mainMenu = new MainMenu();
    private Cashier cashier = new Cashier();
    private Scanner scanner = new Scanner(System.in);
    private int userChoice = -1;

    public void chooseFromCashierMenu() {
        cashierMenu.printMenu();
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 0 -> mainMenu.exitProgram();
            case 1 -> cashier.displayFinance();
            case 2 -> cashier.displayMembersInArrears();
            case 3 -> cashier.recievePayment();
            case 9 -> mainMenu.chooseFromMainMenu();
        }
    }

    private String[] pointsMainMenu() {
        return new String[]{ConsoleColors.PURPLE_BOLD_BRIGHT + "1." + ConsoleColors.BLUE_BOLD + " Chairman menu.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "2." + ConsoleColors.BLUE_BOLD + " Coach menu.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "3." + ConsoleColors.BLUE_BOLD + " Cashier menu.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "0." + ConsoleColors.BLUE_BOLD + " Exit program" + ConsoleColors.RESET};
    }

    public String[] pointsCashierMenu() {
        return new String[]{ConsoleColors.PURPLE_BOLD_BRIGHT + "1." + ConsoleColors.BLUE_BOLD + " View finances.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "2." + ConsoleColors.BLUE_BOLD + " Show members in arrears.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "3." + ConsoleColors.BLUE_BOLD + " Receive payment from member.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "9." + ConsoleColors.BLUE_BOLD + " Main Menu.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "0." + ConsoleColors.BLUE_BOLD + " Exit program" + ConsoleColors.RESET};
    }
}
