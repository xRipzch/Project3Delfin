package delfinen;

import delfinen.filehandling.FHFinance;

import java.time.LocalDate;
import java.util.ArrayList;

public class CashierController {

    private FHFinance fhFinance = new FHFinance();
    private ArrayList<Subscription> subscriptions = fhFinance.loadSubscriptionsFromFile();
    private UI ui = new UI();


    public void createSubscription(Swimmer swimmer){
        Subscription subscription = new Subscription(swimmer.getFirstName(), swimmer.getLastName(),
                swimmer.getEmail(), swimmer.isActive(), swimmer.isPaid(),
                calculateSubscriptionPrice(swimmer));
        printSubscriptionPrice(subscription);
        addSubscriptionToFinancesArray(subscription);
        fhFinance.saveInFinancesFile(subscriptions);
    }

    public void printSubscriptionPrice(Subscription subscription){
        ui.printSubscriptionPrice(subscription.getPrice());
    }

    public void addSubscriptionToFinancesArray(Subscription subscription){
        subscriptions.add(subscription);
    }


    //Calculate the price of the subscription based on age.
    public int calculateSubscriptionPrice(Swimmer swimmer) {
        int currentYear = LocalDate.now().getYear();
        int age = currentYear - swimmer.getYearOfBirth();
        int subscriptionPrice = 0;

        if (swimmer.isActive()) {
            if (age < 18) {
                subscriptionPrice = 1000;
            } else if (age >= 18 && age < 60) {
                subscriptionPrice = 1600;
            } else if (age >= 60) {
                subscriptionPrice = 1200;
            }
        } else {
            subscriptionPrice = 500; // passive subscription
        }
        return subscriptionPrice;
    }

    public void displayFinances(){
        fhFinance.loadSubscriptionsFromFile();
        printFinances();
    }


    public void printMembersInArrears() {
        System.out.println(ConsoleColors.BLUE_BRIGHT + "Below is a list of members in arrears." + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "\n       NAME                             EMAIL" +
                "                                PRICE           MEMBER    ARREARS");
        for (int i = 0; i < subscriptions.size(); i++) {
            if (!subscriptions.get(i).isPaid()){
                System.out.printf("%s %-4s %s %-28s %s | %s %-35s %s %-5d %s %s | %s %-5s %s | %s %-6s %s | %s%n",
                        ConsoleColors.PURPLE_BOLD_BRIGHT, (i + 1) + ".", ConsoleColors.CYAN_BOLD_BRIGHT,
                        subscriptions.get(i).getFirstName() + " " + subscriptions.get(i).getLastName(),
                        ConsoleColors.PURPLE_BOLD_BRIGHT, ConsoleColors.YELLOW_BOLD_BRIGHT, subscriptions.get(i).getEmail(),
                        ConsoleColors.GREEN_BOLD_BRIGHT, subscriptions.get(i).getPrice(), "DKK,-",
                        ConsoleColors.PURPLE_BOLD_BRIGHT, ConsoleColors.CYAN_BOLD_BRIGHT, subscriptions.get(i).isActive(),
                        ConsoleColors.PURPLE_BOLD_BRIGHT, ConsoleColors.CYAN_BOLD_BRIGHT, subscriptions.get(i).isPaid(),
                        ConsoleColors.PURPLE_BOLD_BRIGHT, ConsoleColors.RESET);
            }
        }
        System.out.println();
    }

    public void printFinances() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "\n       NAME                             EMAIL" +
                "                                PRICE           MEMBER    ARREARS");
        for (int i = 0; i < subscriptions.size(); i++) {
            System.out.printf("%s %-4s %s %-28s %s | %s %-35s %s %-5d %s %s %s %s %-5s %s %s %s %-6s %s | %s%n",
                    ConsoleColors.PURPLE_BOLD_BRIGHT, (i + 1) + ".", ConsoleColors.CYAN_BOLD_BRIGHT,
                    subscriptions.get(i).getFirstName() + " " + subscriptions.get(i).getLastName(),
                    ConsoleColors.PURPLE_BOLD_BRIGHT, ConsoleColors.YELLOW_BOLD_BRIGHT, subscriptions.get(i).getEmail(),
                    ConsoleColors.GREEN_BOLD_BRIGHT, subscriptions.get(i).getPrice(), "DKK,-",
                    ConsoleColors.PURPLE_BOLD_BRIGHT, "|", ConsoleColors.CYAN_BOLD_BRIGHT, subscriptions.get(i).isActive(),
                    ConsoleColors.PURPLE_BOLD_BRIGHT, "|", ConsoleColors.CYAN_BOLD_BRIGHT, subscriptions.get(i).isPaid(),
                    ConsoleColors.PURPLE_BOLD_BRIGHT, ConsoleColors.RESET);
        }
        System.out.println();
    }


// TODO DENNE METODE SKAL IKKE STÅ HER
    public void processPayment() {
        printMembersInArrears();
        int chosenMember = ui.chooseMember();
        subscriptions.get(chosenMember).setIsPaid(true);
        ui.printConfirmationForPayment();
    }

}
