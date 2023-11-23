public class Delfinen {
    MenuMaker menuMaker = new MenuMaker();
    public static void main(String[] args) {
        new Delfinen().run();
    }

    private void run() {
        menuMaker.executeMenu();
    }
}
