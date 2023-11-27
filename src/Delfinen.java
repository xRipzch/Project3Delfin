import java.util.ArrayList;

public class Delfinen {
    MenuMaker menuMaker = new MenuMaker();
    FileHandling fileHandling = new FileHandling();
    public static void main(String[] args) {
        new Delfinen().run();
    }

    private void run() {
     //   fileHandling.loadAllMembersFromFile();
        menuMaker.executeMenu();
    }
}
