import java.time.LocalDate;

public class Subscription {
    UI ui = new UI();

    public int getSubscriptionPrice(Member member) {
        calculateSubscriptionPrice(member);
        return subscriptionPrice;
    }

    public int subscriptionPrice = 0;

    //Calculate the price of the subscription based on age.
    public int calculateSubscriptionPrice(Member member) {
        int currentYear = LocalDate.now().getYear();
        int age = currentYear - member.getYearOfBirth();

        if (member.isActive()) {
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

        System.out.println("You're subscription fee is:  " + subscriptionPrice + "$$$.");
    }


    public void processPayment(Member member) {
        ui.printConfirmationForPayment();
        //metode der bruger setter
    }
}
