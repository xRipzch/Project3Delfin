public class Menu {
    private String menuHeader;
    private String[] menuPoint;

    public Menu(String menuHeader, String[] menuPoint) {
        this.menuHeader = menuHeader;
        this.menuPoint = menuPoint;
    }
    public void printMenu() {
        String printString = menuHeader + "\n";
        for (int i = 0; i < menuPoint.length; i++) printString += menuPoint[i] + "\n";
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "\n" +
                printString + ConsoleColors.RESET);
    }
}
