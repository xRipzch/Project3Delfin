import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class Coach implements Comparator {

    public Coach(String name, int coachId) {
        this.name = name;
        this.coachId = coachId;
    }

    ProSwimmer proSwimmer = new ProSwimmer("first", "last", 1999, "email", "address", true, true, SwimDiscipline.CRAWL);
    private String name;
    private int coachId;
    private ArrayList<ProSwimmer> crawlSenior = new ArrayList<>();
    private ArrayList<ProSwimmer> backstrokeSenior = new ArrayList<>();
    private ArrayList<ProSwimmer> breaststrokeSenior = new ArrayList<>();
    private ArrayList<ProSwimmer> butterflySenior = new ArrayList<>();
    private ArrayList<ProSwimmer> medleySenior = new ArrayList<>();
    private ArrayList<ProSwimmer> crawlJunior = new ArrayList<>();
    private ArrayList<ProSwimmer> backstrokeJunior = new ArrayList<>();
    private ArrayList<ProSwimmer> breaststrokeJunior = new ArrayList<>();
    private ArrayList<ProSwimmer> butterflyJunior = new ArrayList<>();
    private ArrayList<ProSwimmer> medleyJunior = new ArrayList<>();


    public void addSeniorSwimmerToArrayList() {
        if (proSwimmer.getSwimDisciplin() == SwimDiscipline.CRAWL) {
            crawlSenior.add(proSwimmer);
        } else if (proSwimmer.getSwimDisciplin() == SwimDiscipline.BACKSTROKE) {
            backstrokeSenior.add(proSwimmer);
        } else if (proSwimmer.getSwimDisciplin() == SwimDiscipline.BREASTSTROKE) {
            breaststrokeSenior.add(proSwimmer);
        } else if (proSwimmer.getSwimDisciplin() == SwimDiscipline.BUTTERFLY) {
            butterflySenior.add(proSwimmer);
        } else if (proSwimmer.getSwimDisciplin() == SwimDiscipline.MEDLEY) {
            medleySenior.add(proSwimmer);
        }
    }

    public void addJuniorSwimmerToArrayList() {
        if (proSwimmer.getSwimDisciplin() == SwimDiscipline.CRAWL) {
            crawlJunior.add(proSwimmer);
        } else if (proSwimmer.getSwimDisciplin() == SwimDiscipline.BACKSTROKE) {
            backstrokeJunior.add(proSwimmer);
        } else if (proSwimmer.getSwimDisciplin() == SwimDiscipline.BREASTSTROKE) {
            breaststrokeJunior.add(proSwimmer);
        } else if (proSwimmer.getSwimDisciplin() == SwimDiscipline.BUTTERFLY) {
            butterflyJunior.add(proSwimmer);
        } else if (proSwimmer.getSwimDisciplin() == SwimDiscipline.MEDLEY) {
            medleyJunior.add(proSwimmer);
        }
    }


    public void printBestFiveJuniorSwimmersInCrawl() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT +
                "junior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT
                + "crawl" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);
        for (int i = 0; i < 5; i++) {
            System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + crawlJunior.get(i).getQuickestTime() + ConsoleColors.RESET);

        }

    }

    public void printBestFiveInDelfinen() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT +
                "swimmers" + ConsoleColors.PURPLE_BOLD_BRIGHT + " in Delfinen " + ConsoleColors.RESET);
        for (int i = 0; i < 5; i++) {
//            System.out.println(CONSOLECOLORS.YELLOWallProSwimmersDelfinen.get(i).getQuickestTime());
        }
    }

    public void printBestFiveSeniorSwimmersInCrawl() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT +
                "senior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT
                + "crawl" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);

        for (int i = 0; i < 5; i++) {
            System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + crawlSenior.get(i).getQuickestTime() + ConsoleColors.RESET);
        }
    }

    public void printBestFiveJuniorSwimmersBackstroke() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT +
                "junior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT
                + "backstroke" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);

        for (int i = 0; i < 5; i++) {
            System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + backstrokeJunior.get(i).getQuickestTime() + ConsoleColors.RESET);
        }
    }

    public void printBestFiveSeniorSwimmersBackstroke() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT +
                "senior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT
                + "backstroke" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);

        for (int i = 0; i < 5; i++) {
            System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + backstrokeSenior.get(i).getQuickestTime() + ConsoleColors.RESET);

        }
    }

    public void printBestFiveJuniorSwimmersBreaststroke() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT +
                "junior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT
                + "breaststroke" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);

        for (int i = 0; i < 5; i++) {
            System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + breaststrokeJunior.get(i).getQuickestTime() + ConsoleColors.RESET);
        }
    }

    public void printBestFiveSeniorSwimmersBreaststroke() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT +
                "senior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT
                + "breaststroke" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);

        for (int i = 0; i < 5; i++) {
            System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + breaststrokeSenior.get(i).getQuickestTime() + ConsoleColors.RESET);
        }
    }

    public void printBestFiveJuniorSwimmersButterfly() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT +
                "junior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT
                + "butterfly" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);

        for (int i = 0; i < 5; i++) {
            System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + butterflyJunior.get(i).getQuickestTime() + ConsoleColors.RESET);
        }
    }

    public void printBestFiveSeniorSwimmersButterfly() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT +
                "senior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT +
                "butterfly" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);

        for (int i = 0; i < 5; i++) {
            System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + butterflySenior.get(i).getQuickestTime() + ConsoleColors.RESET);
        }
    }

    public void printBestFiveJuniorSwimmersMedley() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT +
                "junior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT +
                "medley" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);

        for (int i = 0; i < 5; i++) {
            System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + medleyJunior.get(i).getQuickestTime() + ConsoleColors.RESET);
        }
    }

    public void printBestFiveSeniorSwimmersMedley() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Quickest 5 " + ConsoleColors.CYAN_BOLD_BRIGHT +
                "senior" + ConsoleColors.PURPLE_BOLD_BRIGHT + " swimmers in the " + ConsoleColors.CYAN_BOLD_BRIGHT
                + "medley" + ConsoleColors.PURPLE_BOLD_BRIGHT + " discipline:" + ConsoleColors.RESET);

        for (int i = 0; i < 5; i++) {
            System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + medleySenior.get(i).getQuickestTime() + ConsoleColors.RESET);
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

}

