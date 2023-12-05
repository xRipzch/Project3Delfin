package delfinen.model;

import delfinen.controller.CoachController;
import delfinen.menu.CoachMenu;
import delfinen.misc.ConsoleColors;
import delfinen.misc.ProSwimmerComparator;
import delfinen.viewer.UI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Coach {
    private String name;
    private ArrayList<ProSwimmer> Juniors = new ArrayList<>();
    private ArrayList<ProSwimmer> Seniors = new ArrayList<>();


    CoachController coachController = new CoachController();

    public Coach(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void SetTrainingResultsHigh() {
        if (coachController != null && coachController.getProSwimmers() != null) {
            for (int i = 0; i < coachController.getProSwimmers().size(); i++) {
                coachController.getProSwimmers().get(i).addTrainingResult(coachController.getProSwimmers().get(i).getSwimDisciplin(), 100);
            }
        }
    }

    // TODO Skal muligvis skrives om - Venter på test.
    public void addTrainingsResultToSwimmer() {
        UI ui = new UI();
        String swimmerName = ui.askForName();
        for (int i = 0; i < coachController.getProSwimmers().size(); i++) {
            ProSwimmer currentSwimmer = coachController.getProSwimmers().get(i);

            if (currentSwimmer.getFirstName().equals(swimmerName)) {
                currentSwimmer.addTrainingResult(currentSwimmer.getSwimDisciplin(), ui.askForTime());
                System.out.println(currentSwimmer.getTrainingResults());
            }
        }
    }

    public void addToArrayByAge() {

        for (int i = 0; i < coachController.getProSwimmers().size(); i++) {
            int yearOfBirth = coachController.getProSwimmers().get(i).getYearOfBirth();
            if ((LocalDate.now().getYear() - yearOfBirth) < 18) {
                Juniors.add(coachController.getProSwimmers().get(i));
            } else if ((LocalDate.now().getYear() - yearOfBirth) >= 18) {
                Seniors.add(coachController.getProSwimmers().get(i));
            }
        }

    }


    public void printBestFiveJuniorSwimmersInCrawl() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT + "junior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT + "crawl" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);
        Collections.sort(Juniors, new ProSwimmerComparator("Crawl"));
        for (int i = 0; i < Math.min(5, Juniors.size()); i++) {
            System.out.println(Juniors.get(i).getQuickestTime("Crawl"));

        }
    }

    public void printBestFiveSeniorSwimmersInCrawl() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT + "senior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT + "crawl" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);
        Collections.sort(Seniors, new ProSwimmerComparator("Crawl"));
        for (int i = 0; i < Math.min(5, Seniors.size()); i++) {
            System.out.println(Seniors.get(i).getTrainingResults());
        }
    }

    public void printBestFiveJuniorSwimmersBackstroke() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT + "junior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT + "backstroke" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);
        Collections.sort(Juniors, new ProSwimmerComparator("Backstroke"));
        for (int i = 0; i < Math.min(5, Juniors.size()); i++) {
            System.out.println(Juniors.get(i).getQuickestTime("Backstroke"));
        }
    }

    public void printBestFiveSeniorSwimmersBackstroke() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT + "senior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT + "backstroke" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);
        Collections.sort(Seniors, new ProSwimmerComparator("Backstroke"));
        for (int i = 0; i < Math.min(5, Seniors.size()); i++) {
            System.out.println(Seniors.get(i).getQuickestTime("Backstroke"));
        }
    }

    public void printBestFiveJuniorSwimmersBreaststroke() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT + "junior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT + "breaststroke" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);
        Collections.sort(Juniors, new ProSwimmerComparator("Breaststroke"));
        for (int i = 0; i < Math.min(5, Juniors.size()); i++) {
            System.out.println(Juniors.get(i).getQuickestTime("Breaststroke"));
        }
    }

    public void printBestFiveSeniorSwimmersBreaststroke() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT + "senior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT + "breaststroke" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);
        Collections.sort(Seniors, new ProSwimmerComparator("Breaststroke"));
        for (int i = 0; i < Math.min(5, Seniors.size()); i++) {
            System.out.println(Seniors.get(i).getQuickestTime("Breaststroke"));
        }
    }

    public void printBestFiveJuniorSwimmersButterfly() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT + "junior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT + "butterfly" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);
        Collections.sort(Juniors, new ProSwimmerComparator("Butterfly"));
        for (int i = 0; i < Math.min(5, Juniors.size()); i++) {
            System.out.println(Juniors.get(i).getQuickestTime("Butterfly"));
        }
    }

    public void printBestFiveSeniorSwimmersButterfly() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT + "senior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT + "butterfly" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);
        Collections.sort(Seniors, new ProSwimmerComparator("Butterfly"));
        for (int i = 0; i < Math.min(5, Seniors.size()); i++) {
            System.out.println(Seniors.get(i).getQuickestTime("Butterfly"));
        }
    }

    public void printBestFiveJuniorSwimmersMedley() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT + "junior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT + "medley" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);
        Collections.sort(Juniors, new ProSwimmerComparator("Medley"));
        for (int i = 0; i < Math.min(5, Juniors.size()); i++) {
            System.out.println(Juniors.get(i).getQuickestTime("Medley"));
        }
    }

    public void printBestFiveSeniorSwimmersMedley() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT + "senior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT + "medley" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);
        Collections.sort(Seniors, new ProSwimmerComparator("Medley"));
        for (int i = 0; i < Math.min(5, Seniors.size()); i++) {
            System.out.println(Seniors.get(i).getQuickestTime("Medley"));
        }
    }
}

