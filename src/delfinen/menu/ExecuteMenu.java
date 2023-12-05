package delfinen.menu;

import delfinen.misc.ConsoleColors;


public class ExecuteMenu {

    MainMenu mainMenu = new MainMenu();
    ChairmanMenu chairmanMenu = new ChairmanMenu();
    CashierMenu cashierMenu = new CashierMenu();
    CoachMenu coachMenu = new CoachMenu();
    int chooseStaffMember;



    public void executeMenu() {
        chooseStaffMember =mainMenu.chooseFromMainMenu();

        do {
            switch (chooseStaffMember) {
                case 0 -> exitProgram();
                case 1 -> chairmanMenu.chooseFromChairmanMenu();
                case 2 -> coachMenu.chooseFromCoachMenu();
                case 3 -> cashierMenu.chooseFromCashierMenu();
                default ->
                        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid choice. Try again." + ConsoleColors.RESET);
            }
        } while (chooseStaffMember != 0);
    }

    public int exitProgram() {
        return chooseStaffMember = 0;
    }

}
