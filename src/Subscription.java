import java.time.LocalDate;

public class Subscription {
    UI ui = new UI();





    //Calculate the price of the subscription based on age.
    public void calculateSubscriptionPrice(Swimmer swimmer) {
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

        System.out.println(ConsoleColors.GREEN_BRIGHT + "You're subscription fee is:  " +
                ConsoleColors.GREEN_BOLD + subscriptionPrice + " DKK,-" + ConsoleColors.RESET);
    }


    public void processPayment(Swimmer swimmer) {
        ui.printConfirmationForPayment();
        //metode der bruger setter
    }
}
