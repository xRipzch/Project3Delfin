import java.util.concurrent.TimeUnit;

public class Landing {

    public void intro1() {
        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT);
        System.out.println();
        System.out.println();
        System.out.println("                      Delfinen Swimclub!                      ");
        System.out.println("                         Please hold.                        ");
        System.out.println();
        sleep();
        System.out.println("                                  __");
        System.out.println("                               _.-~  )");
        System.out.println("                    _..--~~~~,'   ,-/     _");
        sleep();
        System.out.println("                 .-'. . . .'   ,-','    ,' )");
        System.out.println("               ,'. . . _   ,--~,-'__..-'  ,'");
        System.out.println("             ,'. . .  (@)' ---~~~~      ,'");
        sleep();
        System.out.println("           //. . . . '~~             ,-'");
        System.out.println("          //. . . . .             ,-'");
        System.out.println("          ; . . . .  - .        ,'");
        sleep();
        System.out.println("         : . . . .       _     /");
        System.out.println("        . . . . .          `- .:");
        System.out.println("       . . . ./  - .          )");
        System.out.println("      .  . . |  _____..---.._/ _____");
        System.out.println("~---~~~~----~~~~             ~~");
        System.out.println(ConsoleColors.RESET);
        sleep();
    }


    public void sleep() {
        try {
            TimeUnit.MILLISECONDS.sleep(350);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

