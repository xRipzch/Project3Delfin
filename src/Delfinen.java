import java.util.ArrayList;

public class Delfinen {
    private static ArrayList<ProSwimmer> proSwimmers = new ArrayList<ProSwimmer>();
    private static ArrayList<Swimmer> regularSwimmers = new ArrayList<Swimmer>();

    static FileHandling fileHandling = new FileHandling(proSwimmers, regularSwimmers);
    static Chairman chairman = new Chairman(fileHandling, proSwimmers, regularSwimmers);
    static MenuMaker menuMaker = new MenuMaker(chairman);

    static Landing landing = new Landing();



    public static void main(String[] args) {
        new Delfinen().run();
    }

    private void run() {
        chairman.initProMember();
        chairman.initRegularMember();
        landing.intro1();
        menuMaker.executeMenu();
        fileHandling.writeToProSwimmersFile(proSwimmers);
        fileHandling.writeToRegularSwimmersFile(regularSwimmers);
    }
}
