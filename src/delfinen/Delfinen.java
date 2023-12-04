package delfinen;

import java.util.ArrayList;

public class Delfinen {

    private static ArrayList<Coach> coaches = new ArrayList<>();

    static MenuMaker menuMaker = new MenuMaker();
    static Landing landing = new Landing();




    public static void main(String[] args) {
        new Delfinen().run();
    }

    private void run() {
//        menuMaker.loadFileProSwimmers();
        //menuMaker.loadFileRegularMembers();
        //menuMaker.loadFileSubscription();
        //regularSwimmers = fileHandling.loadRegularMembersFromFile();
        //finances = fileHandling.loadSubscriptionsFromFile();

        landing.intro1();
        menuMaker.executeMenu();

        //fileHandling.saveInRegularSwimmersFile();
        //fileHandling.saveInFinancesFile();
    }
}
