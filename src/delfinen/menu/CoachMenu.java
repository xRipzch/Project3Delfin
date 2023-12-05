package delfinen.menu;

import delfinen.model.Coach;
import delfinen.misc.ConsoleColors;

import java.util.Scanner;

public class CoachMenu {
    Coach coach = new Coach("First");
    Menu coachMenu = new Menu("Coach menu", pointsCoachMenu());
    Menu topFiveMenu = new Menu("Top five menu", pointsTopFiveMenu());
    MainMenu mainMenu = new MainMenu();
    private Scanner scanner = new Scanner(System.in);
    private int userChoice = -1;


    public void juniorMenu (){
        topFiveMenu.printMenu();
         userChoice = scanner.nextInt();
         switch (userChoice) {
             case  1-> coach.printBestFiveJuniorSwimmersBreaststroke();
             case 2 -> coach.printBestFiveJuniorSwimmersBackstroke();
             case 3 -> coach.printBestFiveJuniorSwimmersButterfly();
             case 4 -> coach.printBestFiveJuniorSwimmersInCrawl();
             case 5 -> coach.printBestFiveJuniorSwimmersMedley();
             case 9 -> mainMenu.chooseFromMainMenu();
         }
    }

    public void seniorMenu (){
        topFiveMenu.printMenu();
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1-> coach.printBestFiveSeniorSwimmersBreaststroke();
            case 2-> coach.printBestFiveSeniorSwimmersBackstroke();
            case 3-> coach.printBestFiveSeniorSwimmersButterfly();
            case 4-> coach.printBestFiveSeniorSwimmersInCrawl();
            case 5-> coach.printBestFiveSeniorSwimmersMedley();
            case 9-> mainMenu.chooseFromMainMenu();
        }
    }
    public void chooseFromCoachMenu() {
        coach.SetTrainingResultsHigh();
        coach.addToArrayByAge();
        coachMenu.printMenu();
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 0 -> mainMenu.exitProgram();
            case 1 -> {
                coach.addTrainingsResultToSwimmer();
                // debugger msg System.out.println(proSwimmer.getTrainingResults());
            }
            //case 2 -> competitionMenu();
            case 3 -> juniorMenu();
            case 4 -> seniorMenu();
            case 9 -> mainMenu.chooseFromMainMenu();
        }
    }

        private String[] pointsCoachMenu () {
            return new String[]{ConsoleColors.PURPLE_BOLD_BRIGHT + "1." + ConsoleColors.BLUE_BOLD +" Add time to swimmer." +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + "[" + ConsoleColors.CYAN_BOLD_BRIGHT + "Training" + ConsoleColors.PURPLE_BOLD_BRIGHT + "]",
                    "2" + ConsoleColors.BLUE_BOLD + " Competition PLACEHOLDER // TODO" + ConsoleColors.PURPLE_BOLD_BRIGHT +
                            "[" + ConsoleColors.CYAN_BOLD_BRIGHT + "Competition" + ConsoleColors.PURPLE_BOLD_BRIGHT + "]",
                    ConsoleColors.PURPLE_BOLD_BRIGHT + "3." + ConsoleColors.BLUE_BOLD + " View top 5 for different disciplines for Juniors",
                    ConsoleColors.PURPLE_BOLD_BRIGHT + "4." + ConsoleColors.BLUE_BOLD + " View top 5 for different disciplines for Seniors.",
                    ConsoleColors.PURPLE_BOLD_BRIGHT + "9." + ConsoleColors.BLUE_BOLD + " Main Menu.",
                    ConsoleColors.PURPLE_BOLD_BRIGHT + "0." + ConsoleColors.BLUE_BOLD + " Exit program" + ConsoleColors.RESET};
        }
        private  String[] pointsTopFiveMenu(){
            return new String[]{ConsoleColors.PURPLE_BOLD_BRIGHT + "1." + ConsoleColors.BLUE_BOLD + " Show top 5 breaststroke." + ConsoleColors.PURPLE_BOLD_BRIGHT + "[" + ConsoleColors.CYAN_BOLD_BRIGHT + "Training" + ConsoleColors.PURPLE_BOLD_BRIGHT + "]",
                    ConsoleColors.PURPLE_BOLD_BRIGHT + "2." + ConsoleColors.BLUE_BOLD + " Show top 5 backstroke" + ConsoleColors.PURPLE_BOLD_BRIGHT + "[" + ConsoleColors.CYAN_BOLD_BRIGHT + "Competition" + ConsoleColors.PURPLE_BOLD_BRIGHT + "]",
                    ConsoleColors.PURPLE_BOLD_BRIGHT + "3." + ConsoleColors.BLUE_BOLD + " Show top 5 butterfly.",
                    ConsoleColors.PURPLE_BOLD_BRIGHT + "4." + ConsoleColors.BLUE_BOLD + " Show top 5 crawl.",
                    ConsoleColors.PURPLE_BOLD_BRIGHT + "5." + ConsoleColors.BLUE_BOLD + " Show top 5 medley.",
                    ConsoleColors.PURPLE_BOLD_BRIGHT + "9." + ConsoleColors.BLUE_BOLD + " Main Menu." + ConsoleColors.RESET};
        }
    }


