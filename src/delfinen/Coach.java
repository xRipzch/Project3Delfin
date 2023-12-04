package delfinen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Coach implements Comparator {
    Cashier cashier;
    Chairman chairman;

    public Coach(String name, int coachId) {
        this.name = name;
        this.coachId = coachId;
    }

    ProSwimmer proSwimmer = new ProSwimmer("first", "last", 1999, "email", "address", true, true, SwimDiscipline.CRAWL);
    private String name;
    private int coachId;

    private ArrayList<ProSwimmer> crawlJunior = new ArrayList<>();
    private ArrayList<ProSwimmer> crawlSenior = new ArrayList<>();

    private ArrayList<ProSwimmer> backstrokeJunior = new ArrayList<>();
    private ArrayList<ProSwimmer> backstrokeSenior = new ArrayList<>();

    private ArrayList<ProSwimmer> breaststrokeJunior = new ArrayList<>();
    private ArrayList<ProSwimmer> breaststrokeSenior = new ArrayList<>();

    private ArrayList<ProSwimmer> butterflyJunior = new ArrayList<>();
    private ArrayList<ProSwimmer> butterflySenior = new ArrayList<>();

    private ArrayList<ProSwimmer> medleyJunior = new ArrayList<>();
    private ArrayList<ProSwimmer> medleySenior = new ArrayList<>();

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }


    public void addSeniorSwimmerToArrayList() {
        if (proSwimmer.getSwimDisciplin() == SwimDiscipline.CRAWL && proSwimmer.getYearOfBirth() >= LocalDate.now().getYear() - 18) {
            crawlSenior.add(proSwimmer);
        } else if (proSwimmer.getSwimDisciplin() == SwimDiscipline.BACKSTROKE && proSwimmer.getYearOfBirth() >= LocalDate.now().getYear() - 18) {
            backstrokeSenior.add(proSwimmer);
        } else if (proSwimmer.getSwimDisciplin() == SwimDiscipline.BREASTSTROKE && proSwimmer.getYearOfBirth() >= LocalDate.now().getYear() - 18) {
            breaststrokeSenior.add(proSwimmer);
        } else if (proSwimmer.getSwimDisciplin() == SwimDiscipline.BUTTERFLY && proSwimmer.getYearOfBirth() >= LocalDate.now().getYear() - 18) {
            butterflySenior.add(proSwimmer);
        } else if (proSwimmer.getSwimDisciplin() == SwimDiscipline.MEDLEY && proSwimmer.getYearOfBirth() >= LocalDate.now().getYear() - 18) {
            medleySenior.add(proSwimmer);
        }
    }
/*
    public void addJuniorSwimmerToArrayList() {
        if (proSwimmer.getSwimDisciplin() == SwimDiscipline.CRAWL) {
            crawlJunior.add(proSwimmer);
        } else if (proSwimmer.getSwimDisciplin() == SwimDiscipline.BACKSTROKE&& proSwimmer.getYearOfBirth() <= LocalDate.now().getYear() - 18) {
            backstrokeJunior.add(proSwimmer);
        } else if (proSwimmer.getSwimDisciplin() == SwimDiscipline.BREASTSTROKE && proSwimmer.getYearOfBirth() <= LocalDate.now().getYear() - 18) {
            breaststrokeJunior.add(proSwimmer);
        } else if (proSwimmer.getSwimDisciplin() == SwimDiscipline.BUTTERFLY && proSwimmer.getYearOfBirth() <= LocalDate.now().getYear() - 18) {
            butterflyJunior.add(proSwimmer);
        } else if (proSwimmer.getSwimDisciplin() == SwimDiscipline.MEDLEY && proSwimmer.getYearOfBirth() <= LocalDate.now().getYear() - 18) {
            medleyJunior.add(proSwimmer);
        }
    }
    public void searchProSwimmerByName() {
        UI ui = new UI();
        for (int i = 0; i < chairman.getProMembers().size(); i++) {
            if (chairman.getProMembers().get(i).getFirstName().equals(ui.askForName())) {
                chairman.getProMembers().get(i).addTrainingResult(chairman.getProMembers().get(i).getSwimDisciplin(), ui.askForTime());
            }

        }
    }


    public void printBestFiveJuniorSwimmersInCrawl() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT + "junior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT + "crawl" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);
        for (int i = 0; i < 5; i++) {
            System.out.println(crawlJunior.get(i).getQuickestTime());

        }

    }

    public void printBestFiveInDelfinen() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT + "swimmers" + ConsoleColors.PURPLE_BOLD_BRIGHT + " in Delfinen " + ConsoleColors.RESET);
        for (int i = 0; i < 5; i++) {
            //        System.out.println(allProSwimmersDelfinen.get(i).getQuickestTime());
        }
    }

    public void printBestFiveSeniorSwimmersInCrawl() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT + "senior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT + "crawl" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);

        for (int i = 0; i < 5; i++) {
            System.out.println(crawlSenior.get(i).getQuickestTime());
        }
    }

    public void printBestFiveJuniorSwimmersBackstroke() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT + "junior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT + "backstroke" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);

        for (int i = 0; i < 5; i++) {
            System.out.println(backstrokeJunior.get(i).getQuickestTime());
        }
    }

    public void printBestFiveSeniorSwimmersBackstroke() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT + "senior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT + "backstroke" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);

        for (int i = 0; i < 5; i++) {
            System.out.println(backstrokeSenior.get(i).getQuickestTime());

        }
    }

    public void printBestFiveJuniorSwimmersBreaststroke() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT + "junior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT + "breaststroke" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);

        for (int i = 0; i < 5; i++) {
            System.out.println(breaststrokeJunior.get(i).getQuickestTime());
        }
    }

    public void printBestFiveSeniorSwimmersBreaststroke() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT + "senior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT + "breaststroke" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);

        for (int i = 0; i < 5; i++) {
            System.out.println(breaststrokeSenior.get(i).getQuickestTime());
        }
    }

    public void printBestFiveJuniorSwimmersButterfly() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT + "junior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT + "butterfly" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);

        for (int i = 0; i < 5; i++) {
            System.out.println(butterflyJunior.get(i).getQuickestTime());
        }
    }

    public void printBestFiveSeniorSwimmersButterfly() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT + "senior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT + "butterfly" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);

        for (int i = 0; i < 5; i++) {
            System.out.println(butterflySenior.get(i).getQuickestTime());
        }
    }

    public void printBestFiveJuniorSwimmersMedley() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT + "junior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT + "medley" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);

        for (int i = 0; i < 5; i++) {
            System.out.println(medleyJunior.get(i).getQuickestTime());
        }
    }

    public void printBestFiveSeniorSwimmersMedley() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT + "senior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT + "medley" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);

        for (int i = 0; i < 5; i++) {
            System.out.println(medleySenior.get(i).getQuickestTime());
        }
    }


    public void sortArraylistByTime(ArrayList<ProSwimmer> proSwimmers) {
        Collections.sort(proSwimmers, Comparator.comparing(ProSwimmer::getQuickestTime));

    }

    public void sortAllArrayLists() {
        sortArraylistByTime(crawlSenior);
        sortArraylistByTime(backstrokeSenior);
        sortArraylistByTime(breaststrokeSenior);
        sortArraylistByTime(butterflySenior);
        sortArraylistByTime(medleySenior);
    }



    public void sortByAge() { //Ikke sikkert den her metode skal bruges.
        ArrayList<Swimmer> juniorSwimmers = new ArrayList<>();
        ArrayList<Swimmer> seniorSwimmers = new ArrayList<>();
        ArrayList<Swimmer> membersAbove60 = new ArrayList<>();
        if (!fileHandling.getProSwimmers().isEmpty()) {
            for (ProSwimmer proSwimmer : fileHandling.getProSwimmers()) {
                if (proSwimmer.getYearOfBirth() < 18) {
                    juniorSwimmers.add(proSwimmer);
                } else if (proSwimmer.getYearOfBirth() >= 18 && proSwimmer.getYearOfBirth() < 60) {
                    seniorSwimmers.add(proSwimmer);
                } else if (proSwimmer.getYearOfBirth() >= 60) {
                    membersAbove60.add(proSwimmer);
                }
            }
            if (!fileHandling.getRegularSwimmers().isEmpty()) {
                for (Swimmer Swimmer : fileHandling.getRegularSwimmers()) {
                    if (Swimmer.getYearOfBirth() < 18) {
                        juniorSwimmers.add(Swimmer);
                    } else if (Swimmer.getYearOfBirth() >= 18 && Swimmer.getYearOfBirth() < 60) {
                        seniorSwimmers.add(Swimmer);
                    } else if (Swimmer.getYearOfBirth() >= 60) {
                        membersAbove60.add(Swimmer);
                    }
                }
            }
        }
    }*/
}

