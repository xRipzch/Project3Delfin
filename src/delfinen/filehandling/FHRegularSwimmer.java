package delfinen.filehandling;

import delfinen.misc.ConsoleColors;
import delfinen.model.Swimmer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FHRegularSwimmer {


    static final java.io.File regularSwimmersFile = new java.io.File("src\\delfinen\\files\\regular_swimmers.csv");
    private ArrayList<Swimmer> regularSwimmers = new ArrayList<>();



    public void saveInRegularSwimmersFile(ArrayList<Swimmer> newRegularSwimmers) {
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream(regularSwimmersFile));

            for (int i = 0; i < newRegularSwimmers.size(); i++) {
                ps.println(newRegularSwimmers.
                        get(i).getFirstName() + "," + newRegularSwimmers.
                        get(i).getLastName() + "," + newRegularSwimmers.
                        get(i).getYearOfBirth() + "," + newRegularSwimmers.
                        get(i).getEmail() + "," + newRegularSwimmers.
                        get(i).getAddress() + "," + newRegularSwimmers.
                        get(i).isActive() + "," + newRegularSwimmers.
                        get(i).isPaid());
            }
        } catch (FileNotFoundException e) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "File not found." + ConsoleColors.RESET);

        } catch (Exception e) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Error occurred." + ConsoleColors.RESET);
        }
        ps.close();
    }


    public ArrayList<Swimmer> loadRegularMembersFromFile() {
        String memberFirstName;
        String memberLastName;
        int memberYearOfBirth;
        String memberEmail;
        String memberAddress;
        boolean isActive;
        boolean isPaid;

        Scanner fileScanner;
        String line;
        String[] parts;
        try {
            fileScanner = new Scanner(regularSwimmersFile);
            regularSwimmers.clear();
            while (fileScanner.hasNextLine()) {
                line = fileScanner.nextLine();

                parts = line.split(",");
                memberFirstName = parts[0];
                memberLastName = parts[1];
                memberYearOfBirth = Integer.parseInt(parts[2]);
                memberEmail = parts[3];
                memberAddress = parts[4];
                isActive = Boolean.parseBoolean(parts[5]);
                isPaid = Boolean.parseBoolean(parts[6]);

                Swimmer swimmer = new Swimmer(memberFirstName, memberLastName, memberYearOfBirth,
                        memberEmail, memberAddress, isActive, isPaid);
                regularSwimmers.add(swimmer);

            }
            return getRegularSwimmers();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
            // TODO FJERN ALT THROW I HELE PROGRAMEMT
        }
    }
    public ArrayList<Swimmer> getRegularSwimmers() {
        return new ArrayList<>(regularSwimmers);
    }
}
