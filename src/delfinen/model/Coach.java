package delfinen.model;

import delfinen.filehandling.FHProSwimmer;
import delfinen.misc.ConsoleColors;
import delfinen.misc.ProSwimmerComparator;
import delfinen.misc.SwimDiscipline;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Coach {

    private Scanner scanner = new Scanner(System.in);
    private FHProSwimmer fhProSwimmer = new FHProSwimmer();
    private ArrayList<ProSwimmer> proSwimmers = fhProSwimmer.loadFileProSwimmers();
    private ArrayList<ProSwimmer> specificProSwimmers = new ArrayList<>();
    private ArrayList<Coach> coaches = new ArrayList<>();
    private ArrayList<ProSwimmer> juniors = new ArrayList<>();
    private ArrayList<ProSwimmer> seniors = new ArrayList<>();


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

    public Coach createBackstrokeCoach() {
        Coach coachBackstroke = new Coach();
        ArrayList<ProSwimmer> backStrokeSwimmers = new ArrayList<>();
        for (int i = 0; i < proSwimmers.size(); i++) {
            if (proSwimmers.get(i).getSwimDisciplin() == SwimDiscipline.BACKSTROKE) {
                backStrokeSwimmers.add(proSwimmers.get(i));
            }
        }
        coachBackstroke.setSpecificProSwimmers(backStrokeSwimmers);
        return coachBackstroke;
    }

    public Coach createBreaststrokeCoach() {
        Coach coachBreaststroke = new Coach();
        ArrayList<ProSwimmer> breastStrokeSwimmers = new ArrayList<>();
        for (int i = 0; i < proSwimmers.size(); i++) {
            if (proSwimmers.get(i).getSwimDisciplin() == SwimDiscipline.BREASTSTROKE) {
                    breastStrokeSwimmers.add(proSwimmers.get(i));
            }
        }
        coachBreaststroke.setSpecificProSwimmers(breastStrokeSwimmers);
        return coachBreaststroke;
    }

    public Coach createButterflyCoach() {
        Coach coachButterfly = new Coach();
        ArrayList<ProSwimmer> butterflySwimmers = new ArrayList<>();
        for (int i = 0; i < proSwimmers.size(); i++) {
            if (proSwimmers.get(i).getSwimDisciplin() == SwimDiscipline.BUTTERFLY) {
                butterflySwimmers.add(proSwimmers.get(i));
            }
        }
        coachButterfly.setSpecificProSwimmers(butterflySwimmers);
        return coachButterfly;

    }

    public Coach createCrawlCoach() {
        Coach coachCrawl = new Coach();
        ArrayList<ProSwimmer> crawlSwimmers = new ArrayList<>();
        for (int i = 0; i < proSwimmers.size(); i++) {
            if (proSwimmers.get(i).getSwimDisciplin() == SwimDiscipline.CRAWL) {
                crawlSwimmers.add(proSwimmers.get(i));
            }
        }
        coachCrawl.setSpecificProSwimmers(crawlSwimmers);
        return coachCrawl;
    }

    public Coach createMedleyCoach() {
        Coach coachMedley = new Coach();
        ArrayList<ProSwimmer> medleySwimmers = new ArrayList<>();
        for (int i = 0; i < proSwimmers.size(); i++) {
            if (proSwimmers.get(i).getSwimDisciplin() == SwimDiscipline.MEDLEY) {
                medleySwimmers.add(proSwimmers.get(i));
            }
        }
        coachMedley.setSpecificProSwimmers(medleySwimmers);
        return coachMedley;
    }

    public void addCoachesToArray() {
        coaches.add(createBackstrokeCoach());
        coaches.add(createBreaststrokeCoach());
        coaches.add(createButterflyCoach());
        coaches.add(createCrawlCoach());
        coaches.add(createMedleyCoach());
    }

    public ArrayList<Coach> getCoaches() {
        addCoachesToArray();
        return coaches;
    }

    public void setSpecificProSwimmers(ArrayList<ProSwimmer> specificProSwimmers) {
        this.specificProSwimmers = specificProSwimmers;
    }
}
