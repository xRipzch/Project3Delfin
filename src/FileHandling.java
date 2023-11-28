import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class FileHandling {

    private ArrayList<ProSwimmer> proSwimmers;
    private ArrayList<Swimmer> regularSwimmers;
    String memberFirstName;
    String memberLastName;
    int memberYearOfBirth;
    String memberEmail;
    String memberAdress;
    boolean isActive;
    boolean isPaid;
    SwimDisciplin swimDisciplin;

    Scanner in = new Scanner(System.in);

    static final File financeFile = new File("src\\finances.csv");
    static final File proSwimmersFile = new File("src\\pro_swimmer.csv");
    static final File regularSwimmersFile = new File("src\\regular_swimmers.csv");
    static final File competitionFile = new File("competition.csv");

    public FileHandling(ArrayList<ProSwimmer> proSwimmers, ArrayList<Swimmer> regularSwimmers) {
        this.proSwimmers = proSwimmers;
        this.regularSwimmers = regularSwimmers;
    }


    public void writeToRegularSwimmersFile(ArrayList<Swimmer> regularSwimmers) {
        PrintStream ps=null;
        try {
            ps = new PrintStream(new FileOutputStream(regularSwimmersFile), true);

            for (int i = 0; i < regularSwimmers.size(); i++) {
                ps.println ( regularSwimmers.
                        get(i).getFirstName() + "," + regularSwimmers.
                        get(i).getLastName() + "," + regularSwimmers.
                        get(i).getYearOfBirth() + "," + regularSwimmers.
                        get(i).getEmail() + "," + regularSwimmers.
                        get(i).getAdress() + "," + regularSwimmers.
                        get(i).isActive() + "," + regularSwimmers.
                        get(i).getIsPaid());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");

        } catch (Exception e) {
            System.out.println("Error occured.");
        }
        ps.close();
    }
    
    public void writeToProSwimmersFile(ArrayList<ProSwimmer> proSwimmers) {
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream(proSwimmersFile), true);

            for (int i = 0; i < proSwimmers.size(); i++) {
                ps.println(proSwimmers.get(i).getFirstName() + "," +
                        proSwimmers.get(i).getLastName() + "," +
                        proSwimmers.get(i).getYearOfBirth() + "," +
                        proSwimmers.get(i).getEmail() + "," +
                        proSwimmers.get(i).getAdress() + "," +
                        proSwimmers.get(i).isActive() + "," +
                        proSwimmers.get(i).getIsPaid() +"," +
                        proSwimmers.get(i).getSwimDisciplin());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (Exception e){
            System.out.println("Error occured.");
        }
    }

   public ArrayList<Swimmer> loadRegularMembersFromFile() {
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
            memberAdress = parts[4];
            isActive = Boolean.parseBoolean(parts[5]);
            isPaid = Boolean.parseBoolean(parts[6]);

            Swimmer swimmer = new Swimmer(memberFirstName,memberLastName,memberYearOfBirth,
                    memberEmail,memberAdress,isActive, isPaid);
            regularSwimmers.add(swimmer);

        } return  regularSwimmers;
       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       }
    }
    public ArrayList<ProSwimmer> loadProMembersFromFile() {
        Scanner fileScanner;
        String line;
        String[] parts;
        try {
            fileScanner = new Scanner(proSwimmersFile);
          
            while (fileScanner.hasNextLine()) {
                line = fileScanner.nextLine();

                parts = line.split(",");
                memberFirstName = parts[0];
                memberLastName = parts[1];
                memberYearOfBirth = Integer.parseInt(parts[2]);
                memberEmail = parts[3];
                memberAdress = parts[4];
                isActive = Boolean.parseBoolean(parts[5]);
                isPaid = Boolean.parseBoolean(parts[6]);
                swimDisciplin = SwimDisciplin.valueOf(parts[7]);


                ProSwimmer proSwimmer = new ProSwimmer(memberFirstName,memberLastName,memberYearOfBirth,
                        memberEmail,memberAdress,isActive, isPaid, swimDisciplin);
                proSwimmers.add(proSwimmer);

            } return  proSwimmers;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void printFinancesFile ()  {
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(financeFile);
            while (fileScanner.hasNextLine()) {
                String fileText = fileScanner.nextLine();
                System.out.println(fileText);
            }
        } catch (FileNotFoundException e) {
          System.out.println("File not found.");
          throw new RuntimeException(e); // HVAD ER BEDST throw new eller catch Exception?
        }
        fileScanner.close();
    }
}
