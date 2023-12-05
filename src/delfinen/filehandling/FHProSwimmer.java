package delfinen.filehandling;

import delfinen.misc.ConsoleColors;
import delfinen.model.ProSwimmer;
import delfinen.misc.SwimDiscipline;
import delfinen.model.Coach;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FHProSwimmer {


    private static ArrayList<ProSwimmer> proSwimmers = new ArrayList<>();
    static final java.io.File proSwimmersFile = new java.io.File("src\\delfinen\\files\\pro_swimmers.csv");

    public void saveInProSwimmersFile(ArrayList<ProSwimmer> newProSwimmers) {
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream(proSwimmersFile));

            for (int i = 0; i < newProSwimmers.size(); i++) {
                ps.println(newProSwimmers.get(i).getFirstName() + "," +
                        newProSwimmers.get(i).getLastName() + "," +
                        newProSwimmers.get(i).getYearOfBirth() + "," +
                        newProSwimmers.get(i).getEmail() + "," +
                        newProSwimmers.get(i).getAddress() + "," +
                        newProSwimmers.get(i).isActive() + "," +
                        newProSwimmers.get(i).isPaid() + "," +
                        newProSwimmers.get(i).getSwimDisciplin() + "," +
                        newProSwimmers.get(i).getCoachName());
            }
        } catch (FileNotFoundException e) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "File not found" + ConsoleColors.RESET);
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Error occurred." + ConsoleColors.RESET);
        }
    }

    public ArrayList<ProSwimmer> loadFileProSwimmers() {
        String memberFirstName;
        String memberLastName;
        int memberYearOfBirth;
        String memberEmail;
        String memberAddress;
        boolean isActive;
        boolean isPaid;
        SwimDiscipline swimDisciplin;
        Coach coach;
        Scanner fileScanner;
        String line;
        String[] parts;
        try {
            fileScanner = new Scanner(proSwimmersFile);
            proSwimmers.clear();
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
                swimDisciplin = SwimDiscipline.valueOf(parts[7]);


                ProSwimmer proSwimmer = new ProSwimmer(memberFirstName, memberLastName, memberYearOfBirth,
                        memberEmail, memberAddress, isActive, isPaid, swimDisciplin);
                proSwimmers.add(proSwimmer);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return getProMembers();
    }

    public ArrayList<ProSwimmer> getProMembers() {
        return new ArrayList<>(proSwimmers);
    }
}