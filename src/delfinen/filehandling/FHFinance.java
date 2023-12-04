package delfinen.filehandling;

import delfinen.ConsoleColors;
import delfinen.Subscription;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FHFinance {


    static final java.io.File financesFile = new java.io.File("src\\delfinen\\files\\finances.csv");
    private ArrayList<Subscription> subscriptions = new ArrayList<>();


    public void saveInFinancesFile(ArrayList<Subscription>  newSubscriptions) {
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream(financesFile));
            for (int i = 0; i < newSubscriptions.size(); i++) {
                ps.println(newSubscriptions.get(i).getFirstName() + "," + newSubscriptions.get(i).getLastName() + "," +
                        newSubscriptions.get(i).getEmail() + "," +
                        newSubscriptions.get(i).isActive() + "," + newSubscriptions.get(i).isPaid() + "," +
                        newSubscriptions.get(i).getPrice());
            }
            ps.close();
        } catch (FileNotFoundException e) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "File not found." + ConsoleColors.RESET);
        }
    }


    public ArrayList<Subscription> loadSubscriptionsFromFile() {
        String memberFirstName;
        String memberLastName;
        String memberEmail;
        boolean isActive;
        boolean isPaid;
        int subscriptionPrice;
        Scanner fileScanner;
        String line;
        String[] parts;
        try {
            fileScanner = new Scanner(financesFile);
            while (fileScanner.hasNextLine()) {
                line = fileScanner.nextLine();
                parts = line.split(",");
                memberFirstName = parts[0];
                memberLastName = parts[1];
                memberEmail = parts[2];
                isActive = Boolean.parseBoolean(parts[3]);
                isPaid = Boolean.parseBoolean(parts[4]);
                subscriptionPrice = Integer.parseInt(parts[5]);

                Subscription subscription = new Subscription(memberFirstName, memberLastName, memberEmail,
                        isActive, isPaid, subscriptionPrice);
                subscriptions.add(subscription);
            }

        } catch (FileNotFoundException e) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "File not found." + ConsoleColors.RESET);
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Error occurred." + ConsoleColors.RESET);

        }
        return getSubscriptions();
    }

    public ArrayList<Subscription> getSubscriptions() {
        return new ArrayList<>(subscriptions);
    }

    public void printFinancesArrayList() {
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(financesFile);
            while (fileScanner.hasNextLine()) {
                String fileText = fileScanner.nextLine();
                System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + fileText + " " + ConsoleColors.RESET);
            }
        } catch (FileNotFoundException e) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "File not found." + ConsoleColors.RESET);
            throw new RuntimeException(e);
        }
        fileScanner.close();
    }

}

