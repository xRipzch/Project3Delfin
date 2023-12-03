import java.lang.reflect.Member;
import java.util.ArrayList;

public class Delfinen {
    private static ArrayList<ProSwimmer> proSwimmers = new ArrayList<ProSwimmer>();
    private static ArrayList<Swimmer> regularSwimmers = new ArrayList<Swimmer>();
    private static ArrayList<Subscription> finances = new ArrayList<>();
    private static ArrayList<Coach> coaches = new ArrayList<>();

    static FileHandling fileHandling = new FileHandling(proSwimmers, regularSwimmers, finances);
    static Cashier cashier = new Cashier(fileHandling, finances);
    static Chairman chairman = new Chairman(fileHandling, cashier);
    static Coach coach = new Coach("OttoTheFlotto", 1, chairman);
    static MenuMaker menuMaker = new MenuMaker(chairman, cashier, coach);
    static Landing landing = new Landing();




    public static void main(String[] args) {
        new Delfinen().run();
    }

    private void run() {
        proSwimmers = fileHandling.loadProMembersFromFile();
        regularSwimmers = fileHandling.loadRegularMembersFromFile();
        finances = fileHandling.loadSubscriptionsFromFile();

        chairman.displayProMember();
        chairman.displayRegularMember();
        cashier.printMembersInArrears();
        cashier.showFinances();

        landing.intro1();
        menuMaker.executeMenu();

        fileHandling.writeToProSwimmersFile();
        fileHandling.writeToRegularSwimmersFile();
        fileHandling.writeToFinancesFile();
    }
}
