package delfinen.menu;

import delfinen.manager.CoachManager;
import delfinen.misc.ConsoleColors;
import delfinen.model.Coach;

import java.util.ArrayList;
import java.util.Scanner;

public class CoachMenu {


    Menu coachMenu = new Menu("Coach menu", pointsCoachMenu()); //hvorfor bliver den her ikke brugt
    Menu juniorAndSeniorMenu = new Menu("Choose action", pointsJuniorAndSeniorMenu());
    Menu chooseSwimDisciplineMenu = new Menu("Choose swim discipline", pointsSwimDisciplineMenu());
    Menu specificPrintDisciplineMenu = new Menu("Choose action", pointsSpecificDisciplineMenu());


    CoachManager coachManager = new CoachManager();
    ArrayList<Coach> coaches = coachManager.getCoaches();
    MainMenu mainMenu = new MainMenu();

    private Scanner scanner = new Scanner(System.in);
    private int userChoice = -1;


    public void chooseSwimDiscipline() {
        chooseSwimDisciplineMenu.printMenu();
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 0 -> mainMenu.exitProgram();
            case 1 -> chooseSpecificDisciplineMenu(0);
            case 2 -> chooseSpecificDisciplineMenu(1);
            case 3 -> chooseSpecificDisciplineMenu(2);
            case 4 -> chooseSpecificDisciplineMenu(3);
            case 5 -> chooseSpecificDisciplineMenu(4);
            case 9 -> mainMenu.executeMainMenu(0);
        }
    }

    public void chooseSpecificDisciplineMenu(int choice) {
        specificPrintDisciplineMenu.printMenu();
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 0 -> mainMenu.exitProgram();
            case 1 -> juniorMenu(choice);
            case 2 -> seniorMenu(choice);
            case 9 -> mainMenu.executeMainMenu(0);
        }
    }


    public void juniorMenu(int choice) {
        juniorAndSeniorMenu.printMenu();
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 0 -> mainMenu.exitProgram();
            case 1 -> coaches.get(choice).printBestFiveJuniorSwimmers();
            case 2 -> coaches.get(choice).printBestFiveJuniorCompSwimmers();
            case 3 -> coaches.get(choice).selectTrainingJunior();
            case 4 -> coaches.get(choice).selectCompJunior();
            case 9 -> mainMenu.executeMainMenu(0);
        }
    }

    public void seniorMenu(int choice) {
        juniorAndSeniorMenu.printMenu();
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 0 -> mainMenu.exitProgram();
            case 1 -> coaches.get(choice).printBestFiveSeniorSwimmers();
            case 2 -> coaches.get(choice).printBestFiveSeniorCompSwimmers();
            case 3 -> coaches.get(choice).selectTrainingSenior();
            case 4 -> coaches.get(choice).selectCompSenior();
            case 9 -> mainMenu.executeMainMenu(0);
        }
    }


    private String[] pointsSwimDisciplineMenu() {
        return new String[]{ConsoleColors.PURPLE_BOLD_BRIGHT + "1." + ConsoleColors.CYAN_BOLD_BRIGHT + " Backstroke.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "2." + ConsoleColors.CYAN_BOLD_BRIGHT + " Breaststroke.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "3." + ConsoleColors.CYAN_BOLD_BRIGHT + " Butterfly.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "4." + ConsoleColors.CYAN_BOLD_BRIGHT + " Crawl.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "5." + ConsoleColors.CYAN_BOLD_BRIGHT + " Medley.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "9." + ConsoleColors.BLUE_BOLD + " Main Menu.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "0." + ConsoleColors.BLUE_BOLD + " Exit program" + ConsoleColors.RESET};
    }


    private String[] pointsSpecificDisciplineMenu() {
        return new String[]{ConsoleColors.PURPLE_BOLD_BRIGHT + "1." + ConsoleColors.BLUE_BOLD + " View junior swimmers.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "2." + ConsoleColors.BLUE_BOLD + " View senior swimmer.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "9." + ConsoleColors.BLUE_BOLD + " Main Menu.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "0." + ConsoleColors.BLUE_BOLD + " Exit program" + ConsoleColors.RESET};

    }

    private String[] pointsCoachMenu() {
        return new String[]{ConsoleColors.PURPLE_BOLD_BRIGHT + "1." + ConsoleColors.BLUE_BOLD + " Add time to swimmer." +
                ConsoleColors.PURPLE_BOLD_BRIGHT + "[" + ConsoleColors.CYAN_BOLD_BRIGHT + "Training" + ConsoleColors.PURPLE_BOLD_BRIGHT + "]",
                "2" + ConsoleColors.BLUE_BOLD + " Competition PLACEHOLDER // TODO" + ConsoleColors.PURPLE_BOLD_BRIGHT +
                        "[" + ConsoleColors.CYAN_BOLD_BRIGHT + "Competition" + ConsoleColors.PURPLE_BOLD_BRIGHT + "]",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "3." + ConsoleColors.BLUE_BOLD + " View top 5 for different disciplines for Juniors",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "4." + ConsoleColors.BLUE_BOLD + " View top 5 for different disciplines for Seniors.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "9." + ConsoleColors.BLUE_BOLD + " Main Menu.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "0." + ConsoleColors.BLUE_BOLD + " Exit program" + ConsoleColors.RESET};
    }

    private String[] pointsJuniorAndSeniorMenu() {
        return new String[]{ConsoleColors.PURPLE_BOLD_BRIGHT + "1." + ConsoleColors.BLUE_BOLD + " Show top 5 swimmers." +
                ConsoleColors.PURPLE_BOLD_BRIGHT + "[" + ConsoleColors.CYAN_BOLD_BRIGHT + "Training" + ConsoleColors.PURPLE_BOLD_BRIGHT + "]",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "2." + ConsoleColors.BLUE_BOLD + " Show top 5 swimmers." +
                        ConsoleColors.PURPLE_BOLD_BRIGHT + "[" + ConsoleColors.CYAN_BOLD_BRIGHT + "Competition" + ConsoleColors.PURPLE_BOLD_BRIGHT + "]",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "3." + ConsoleColors.BLUE_BOLD + " Note time for swimmer." +
                        ConsoleColors.PURPLE_BOLD_BRIGHT + "[" + ConsoleColors.CYAN_BOLD_BRIGHT + "Training" + ConsoleColors.PURPLE_BOLD_BRIGHT + "]",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "4." + ConsoleColors.BLUE_BOLD + " Note time for swimmer." +
                        ConsoleColors.PURPLE_BOLD_BRIGHT + "[" + ConsoleColors.CYAN_BOLD_BRIGHT + "Competition" + ConsoleColors.PURPLE_BOLD_BRIGHT + "]",

                ConsoleColors.PURPLE_BOLD_BRIGHT + "9." + ConsoleColors.BLUE_BOLD + " Main Menu.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "0." + ConsoleColors.BLUE_BOLD + " Exit program" + ConsoleColors.RESET};
    }
}


