import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.LocalDate;


public class Cashier {

    UI ui = new UI();
    FileHandling fileHandling;
    ArrayList<Subscription> finances;

    public Cashier (FileHandling fileHandling, ArrayList<Subscription> finances){
        this.fileHandling = fileHandling;
        this.finances = finances;

    }

    public void initSubscription(){
        finances = fileHandling.loadSubscriptionsFromFile();
    }


    public void createSubscription(Swimmer swimmer){
        Subscription subscription = new Subscription(swimmer.getFirstName(), swimmer.getLastName(),
                swimmer.getYearOfBirth(), swimmer.getEmail(), swimmer.isActive(), swimmer.isPaid(),
                calculateSubscriptionPrice(swimmer));

        ui.printSubscriptionPrice(subscription.getPrice());

        if (swimmer.isPaid()) {
            ui.printConfirmationForPayment();
        }
        addSubscriptionToFinancesArray(subscription);
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

    public void addSubscriptionToFinancesArray(Subscription subscription){
        finances.add(subscription);
    }


    public void showFinances() {
        for (int i = 0; i < finances.size(); i++) {
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + (i + 1) + ConsoleColors.WHITE_BOLD_BRIGHT +  ". Name: " +
                    finances.get(i).getFirstName() + " " + finances.get(i).getLastName() + " Age: " +
                    (LocalDateTime.now().getYear() - finances.get(i).getYearOfBirth()) + " Email: " +
                    finances.get(i).getEmail() + " Is active: " + finances.get(i).isActive() + " Has paid: " +
                    finances.get(i).isPaid() + "Price: " + finances.get(i).getPrice() + ConsoleColors.RESET);
        }
    }


    public void showMembersInArrears(){
        System.out.println(ConsoleColors.BLUE_BRIGHT + "Below is a list of members in arrears." + ConsoleColors.RESET);
        printMembersInArrears();

    }

    public void processPayment() {
        ui.printConfirmationForPayment();
        //metode der bruger setter
    }

    public void printMembersInArrears() {
        for (int i = 0; i < finances.size(); i++) {
            if (!finances.get(i).isPaid()){
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + (i+1) + ConsoleColors.WHITE_BOLD_BRIGHT +
                    ". " + "Name: " + finances.get(i).getFirstName() + " " + finances.get(i).getLastName() +
                    " Age: " + (LocalDateTime.now().getYear() - finances.get(i).getYearOfBirth()) +
                    " Email: " + finances.get(i).getEmail() + " Is active: " + finances.get(i).isActive() +
                    " Has paid: " + finances.get(i).isPaid() + "Price: " +
                    finances.get(i).getPrice() + ConsoleColors.RESET);
        }
        }
    }
}