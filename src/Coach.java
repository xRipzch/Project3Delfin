import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Coach implements Comparator {

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

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    public class coaching {

        public void displauMenu() {
            System.out.println("1. Add time to swimmer [Training]");
            System.out.println("2. Add time to swimmer [Competition]");
            System.out.println("3. See top 5 for different disciplines..");
            System.out.println("4. See top 5 options for all swimmers in Delfinen");
        }

        public void displayBestFive() {
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "1. " + ConsoleColors.RESET + "Show best 5 senior swimmers in Crawl");
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "2. " + ConsoleColors.RESET + "Show best 5 senior swimmers in Backstroke");
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "3. " + ConsoleColors.RESET + "Show best 5 senior swimmers in Breaststroke");
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "4. " + ConsoleColors.RESET + "Show best 5 senior swimmers in Butterfly");
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "5. " + ConsoleColors.RESET + "Show best 5 senior swimmers in Medley");

            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "7. " + ConsoleColors.RESET + "Show best 5 junior swimmers in Crawl");
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "8. " + ConsoleColors.RESET + "Show best 5 junior swimmers in Backstroke");
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "9. " + ConsoleColors.RESET + "Show best 5 junior swimmers in Breaststroke");
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "10. " + ConsoleColors.RESET + "Show best 5 junior swimmers in Butterfly");
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "11. " + ConsoleColors.RESET + "Show best 5 junior swimmers in Medley");

        }

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
    }
}