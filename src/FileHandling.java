import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;


public class FileHandling {

    static final File financesFile = new File("src\\finances.csv");
    static final File proSwimmersFile = new File("src\\pro_swimmer.csv");
    static final File regularSwimmersFile = new File("src\\regular_swimmers.csv");
    static final File competitionFile = new File("competition.csv");

    private ArrayList<ProSwimmer> proSwimmers;
    private ArrayList<Swimmer> regularSwimmers;
    private ArrayList<Subscription> finances;
    String memberFirstName;
    String memberLastName;
    int memberYearOfBirth;
    String memberEmail;
    String memberAddress;
    boolean isActive;
    boolean isPaid;
    int subscriptionPrice;
    SwimDiscipline swimDisciplin;





    public FileHandling(ArrayList<ProSwimmer> proSwimmers, ArrayList<Swimmer> regularSwimmers,
                        ArrayList<Subscription> finances) {
        this.proSwimmers = proSwimmers;
        this.regularSwimmers = regularSwimmers;
        this.finances = finances;
    }

    public void writeToRegularSwimmersFile() {
        PrintStream ps=null;
        try {
            ps = new PrintStream(new FileOutputStream(regularSwimmersFile), true);

            for (int i = 0; i < regularSwimmers.size(); i++) {
                ps.println ( regularSwimmers.
                        get(i).getFirstName() + "," + regularSwimmers.
                        get(i).getLastName() + "," + regularSwimmers.
                        get(i).getYearOfBirth() + "," + regularSwimmers.
                        get(i).getEmail() + "," + regularSwimmers.
                        get(i).getAddress() + "," + regularSwimmers.
                        get(i).isActive() + "," + regularSwimmers.
                        get(i).isPaid());
            }
        } catch (FileNotFoundException e) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "File not found." + ConsoleColors.RESET);

        } catch (Exception e) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Error occurred." + ConsoleColors.RESET);
        }
        ps.close();
    }
    
    public void writeToProSwimmersFile() {
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream(proSwimmersFile), true);

            for (int i = 0; i < proSwimmers.size(); i++) {
                ps.println(proSwimmers.get(i).getFirstName() + "," +
                        proSwimmers.get(i).getLastName() + "," +
                        proSwimmers.get(i).getYearOfBirth() + "," +
                        proSwimmers.get(i).getEmail() + "," +
                        proSwimmers.get(i).getAddress() + "," +
                        proSwimmers.get(i).isActive() + "," +
                        proSwimmers.get(i).isPaid() +"," +
                        proSwimmers.get(i).getSwimDisciplin());
            }

        } catch (FileNotFoundException e) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "File not found" + ConsoleColors.RESET);
        } catch (Exception e){
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Error occurred." + ConsoleColors.RESET);
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
            memberAddress = parts[4];
            isActive = Boolean.parseBoolean(parts[5]);
            isPaid = Boolean.parseBoolean(parts[6]);

            Swimmer swimmer = new Swimmer(memberFirstName,memberLastName,memberYearOfBirth,
                    memberEmail,memberAddress,isActive, isPaid);
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
                memberAddress = parts[4];
                isActive = Boolean.parseBoolean(parts[5]);
                isPaid = Boolean.parseBoolean(parts[6]);

                try {
                    swimDisciplin = SwimDiscipline.valueOf(parts[7]);
                } catch (IllegalArgumentException e) {
                    System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + parts[7] +
                            ConsoleColors.RED_BOLD_BRIGHT + " is an invalid swim discipline" + ConsoleColors.RESET);
                }


                ProSwimmer proSwimmer = new ProSwimmer(memberFirstName,memberLastName,memberYearOfBirth,
                        memberEmail,memberAddress,isActive, isPaid, swimDisciplin);
                proSwimmers.add(proSwimmer);

            } return  proSwimmers;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Subscription> loadSubscriptionsFromFile(){
        Scanner fileScanner;
        String line;
        String[] parts;
    try{
        fileScanner = new Scanner(financesFile);

        while(fileScanner.hasNextLine()){
            line = fileScanner.nextLine();
            parts = line.split(",");
            memberFirstName = parts[0];
            memberLastName = parts[1];
            memberYearOfBirth = Integer.parseInt(parts[2]);
            memberEmail = parts[3];
            isActive = Boolean.parseBoolean(parts[4]);
            isPaid = Boolean.parseBoolean(parts[5]);
            subscriptionPrice = Integer.parseInt(parts[6]);

        } return finances;
    }catch (FileNotFoundException e) {
        throw new RuntimeException(e);
        //System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "File not found." + ConsoleColors.RESET);
    //} catch (Exception e){
        //throw new RuntimeException(e);
        //System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Error occurred." + ConsoleColors.RESET);
        // HVAD ER BEDST throw new eller catch Exception?
    }

    }

    public void printFinancesArrayList ()  {
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

    public void writeToFinancesFile(){
        PrintStream ps = null;
                try{
                    ps = new PrintStream(new FileOutputStream(financesFile), true);
                    for (int i = 0; i < finances.size(); i++) {
                        ps.println(finances.get(i).getFirstName() + "," + finances.get(i).getLastName() + "," +
                                finances.get(i).getYearOfBirth() + "," + finances.get(i).getEmail() + "," +
                                finances.get(i).isActive() + "," + finances.get(i).isPaid() + "," +
                                finances.get(i).getPrice());
                    }
                    for (int i = 0; i < proSwimmers.size(); i++) {
                        ps.println(proSwimmers.get(i).getFirstName());

                    }
                    ps.close();
    }catch (FileNotFoundException e){
        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "File not found." + ConsoleColors.RESET);
                }
}
}
