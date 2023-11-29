import java.lang.reflect.Member;
import java.util.ArrayList;

public class Delfinen {
    private static ArrayList<ProSwimmer> proSwimmers = new ArrayList<ProSwimmer>();
    private static ArrayList<Swimmer> regularSwimmers = new ArrayList<Swimmer>();
    private static ArrayList<Subscription> finances = new ArrayList<>();

    static FileHandling fileHandling = new FileHandling(proSwimmers, regularSwimmers, finances);
    static Cashier cashier = new Cashier(fileHandling, finances);
    static Chairman chairman = new Chairman(fileHandling, cashier, proSwimmers, regularSwimmers);
    static MenuMaker menuMaker = new MenuMaker(chairman, cashier);
    static Landing landing = new Landing();



    public static void main(String[] args) {
        new Delfinen().run();
    }

    private void run() {
        chairman.initProMember();
        chairman.initRegularMember();
        cashier.initSubscription();
        landing.intro1();
        menuMaker.executeMenu();
        fileHandling.writeToProSwimmersFile();
        fileHandling.writeToRegularSwimmersFile();
        fileHandling.writeToFinancesFile();
    }
}
