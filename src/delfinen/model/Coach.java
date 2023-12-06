package delfinen.model;

import delfinen.misc.ConsoleColors;
import delfinen.misc.ProSwimmerComparator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Coach {


    private String name;
    private ArrayList<ProSwimmer> specificProSwimmers = new ArrayList<>();
    private ArrayList<ProSwimmer> juniors = new ArrayList<>();
    private ArrayList<ProSwimmer> seniors = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);


    public Coach(String name, ArrayList<ProSwimmer> proSwimmers) {
        this.name = name;
        this.specificProSwimmers = proSwimmers;
    }

    public void addCompetitionResult(ProSwimmer proSwimmer) {
        System.out.println(ConsoleColors.BLUE_BRIGHT + "Enter name of competition:" + ConsoleColors.RESET);
        String compName = scanner.nextLine();

        System.out.println(ConsoleColors.BLUE_BRIGHT + "Please input a time in seconds." +
                ConsoleColors.PURPLE_BOLD_BRIGHT + "[" + ConsoleColors.CYAN_BOLD_BRIGHT + "SS.SS" +
                ConsoleColors.PURPLE_BOLD_BRIGHT + "]");
        double time = scanner.nextDouble();
        scanner.nextLine(); // scanner bug
        System.out.println(ConsoleColors.BLUE_BRIGHT + "Enter placement:" + ConsoleColors.RESET);
        int placement = scanner.nextInt();
        scanner.nextLine(); // scanner bug
        LocalDate date = LocalDate.now();
        ResultCompetition resultCompetition = new ResultCompetition(time, date, proSwimmer.getSwimDisciplin(), compName, placement);
        proSwimmer.addCompResultToArray(resultCompetition);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Member results added!" + ConsoleColors.RESET);
        System.out.println(proSwimmer.getTrainingResults());
    }

    public void addTrainingResult(ProSwimmer proswimmer) {
        System.out.println(ConsoleColors.BLUE_BRIGHT + "Please input a time in seconds." +
                ConsoleColors.PURPLE_BOLD_BRIGHT + "[" + ConsoleColors.CYAN_BOLD_BRIGHT + "SS.SS" +
                ConsoleColors.PURPLE_BOLD_BRIGHT + "]");
        double time = scanner.nextDouble();
        LocalDate date = LocalDate.now();
        ResultTraining resultTraining = new ResultTraining(time, date, proswimmer.getSwimDisciplin());
        proswimmer.addResultToArray(resultTraining);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Member results added!" + ConsoleColors.RESET);
        System.out.println(proswimmer.getTrainingResults());
    }

    public void selectTrainingJunior() {
        sortByAge();
        int index = 0;
        System.out.println(ConsoleColors.BLUE_BRIGHT + "Choose the number of the swimmer to add results:" + ConsoleColors.RESET);
//        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "    NAME         TRAINING TIME           COMPETITION TIME ");
        for (int i = 0; i < juniors.size(); i++) {
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + (i + 1 + "." + ConsoleColors.RESET) + " "
                    + ConsoleColors.CYAN_BOLD_BRIGHT + juniors.get(i).getFirstName() + " "
                    + juniors.get(i).getLastName() + juniors.get(i).getTrainingResults());

        }
        index = scanner.nextInt() - 1;
        scanner.nextLine();
        addTrainingResult(juniors.get(index));
    }


    public void selectTrainingSenior() {
        sortByAge();
        int index = 0;
        System.out.println(ConsoleColors.BLUE_BRIGHT + "Choose the number of the swimmer to add results:" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "    NAME         TRAINING TIME           COMPETITION TIME ");
        for (int i = 0; i < seniors.size(); i++) {
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + (i + 1 + "." + ConsoleColors.RESET) + " "
                    + ConsoleColors.CYAN_BOLD_BRIGHT + seniors.get(i).getFirstName() + " "
                    + seniors.get(i).getLastName() + seniors.get(i).getTrainingResults());

        }
        index = scanner.nextInt() - 1;
        scanner.nextLine();
        addTrainingResult(seniors.get(index));
    }
    public void selectCompJunior() {
        sortByAge();
        int index = 0;
        System.out.println(ConsoleColors.BLUE_BRIGHT + "Choose the number of the swimmer to add results:" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "    NAME         TRAINING TIME           COMPETITION TIME ");
        for (int i = 0; i < juniors.size(); i++) {
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + (i + 1 + "." + ConsoleColors.RESET) + " "
                    + ConsoleColors.CYAN_BOLD_BRIGHT + juniors.get(i).getFirstName() + " "
                    + juniors.get(i).getLastName() + juniors.get(i).getCompetitionResult());

        }
        index = scanner.nextInt() - 1;
        scanner.nextLine();
        addCompetitionResult(juniors.get(index));
    }


    public void selectCompSenior() {
        sortByAge();
        int index = 0;
        System.out.println(ConsoleColors.BLUE_BRIGHT + "Choose the number of the swimmer to add results:" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "   NAME                                      TRAINING TIME           COMPETITION TIME ");
        for (int i = 0; i < seniors.size(); i++) {
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + (i + 1 + "." + ConsoleColors.RESET) + " "
                    + ConsoleColors.CYAN_BOLD_BRIGHT + seniors.get(i).getFirstName() + " "
                    + seniors.get(i).getLastName() + seniors.get(i).getCompetitionResult());

        }
        index = scanner.nextInt() - 1;
        scanner.nextLine();
        addCompetitionResult(seniors.get(index));
    }

    public void sortByAge() {
        // Clear juniors and seniors lists before populating them
        juniors.clear();
        seniors.clear();

        for (int i = 0; i < specificProSwimmers.size(); i++) {
            if (LocalDate.now().getYear() - specificProSwimmers.get(i).getYearOfBirth() < 18) {
                juniors.add(specificProSwimmers.get(i));
            } else {
                seniors.add(specificProSwimmers.get(i));
            }
        }
    }


    public void printBestFiveJuniorSwimmers() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT +
                "junior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT +
                "crawl" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);
        Collections.sort(juniors, new ProSwimmerComparator(juniors.get(0).getSwimDisciplin()));
        for (int i = 0; i < Math.min(5, juniors.size()); i++) {
            System.out.println(juniors.get(i).getTrainingResults()); // TODO FARVER
        }
    }

    public void printBestFiveSeniorSwimmers() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT +
                "senior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT +
                "crawl" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);
        Collections.sort(seniors, new ProSwimmerComparator(seniors.get(0).getSwimDisciplin()));
        for (int i = 0; i < Math.min(5, seniors.size()); i++) {
            System.out.println(ConsoleColors.BLUE_BOLD + seniors.get(i).getTrainingResults()); // TODO FARVER
        }
    }
    public void printBestFiveJuniorCompSwimmers() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT +
                "junior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT +
                "crawl" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);
        Collections.sort(juniors, new ProSwimmerComparator(juniors.get(0).getSwimDisciplin()));
        for (int i = 0; i < Math.min(5, juniors.size()); i++) {
            System.out.println(juniors.get(i).getCompetitionResult()); // TODO FARVER
        }
    }

    public void printBestFiveSeniorCompSwimmers() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT +
                "senior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT +
                "crawl" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);
        Collections.sort(seniors, new ProSwimmerComparator(seniors.get(0).getSwimDisciplin()));
        for (int i = 0; i < Math.min(5, seniors.size()); i++) {
            System.out.println(ConsoleColors.BLUE_BOLD + seniors.get(i).getCompetitionResult()); // TODO FARVER
        }
    }
}
