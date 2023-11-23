import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandling {
    private ArrayList<Object> allMembers;
    String memberFirstName;
    String memberLastName;
    int memberYearOfBirth;
    String memberEmail;
    String memberAdress;
    boolean isActive;
    boolean hasPaid;


    Scanner in = new Scanner(System.in);

    final File financeFile = new File("src\\finances.csv");
    final File allMembersFile = new File("all_members.csv");
    final File proSwimmersFile = new File("src\\pro_swimmers.csv");
    final File regularSwimmersFile = new File("src\\regular_swimmers.csv");
    final File competitionFile = new File("src\\competition.csv");

    public FileHandling() {
        this.allMembers = new ArrayList<>();
    }


    public void writeAllMembersToFile(ArrayList<Member> allMembers) {

        PrintStream ps;
        try {
            ps = new PrintStream(allMembersFile);

            for (int i = 0; i < allMembers.size(); i++) {
                ps.println(allMembers.
                        get(i).getFirstName() + "," + allMembers.
                        get(i).getLastName() + "," + allMembers.
                        get(i).getYearOfBirth() + "," + allMembers.
                        get(i).getEmail() + "," + allMembers.
                        get(i).getAdress() + "," + allMembers.
                        get(i).isActive() + "," + allMembers.
                        get(i).getHasPaid());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");

        } catch (Exception e) {
            System.out.println("Error occured.");
        }
    }

    public void loadAllMembersFromFile() {
        Scanner lineScanner;
        String line;
        String[] parts;
        allMembers.clear();
        lineScanner = new Scanner(System.in);
        while (lineScanner.hasNextLine()) {
            line = lineScanner.nextLine();

            parts = line.split(",");
            memberFirstName = parts[0];
            memberLastName = parts[1];
            memberYearOfBirth = Integer.parseInt(parts[2]);
            memberEmail = parts[3];
            memberAdress = parts[4];
            isActive = Boolean.parseBoolean(parts[5]);
            hasPaid = Boolean.parseBoolean(parts[6]);
            Member member = new Member(memberFirstName, memberLastName, memberYearOfBirth, memberEmail, memberAdress, isActive, hasPaid);
            allMembers.add(member);
        }
    }


    public ArrayList<Member> initFromFile() {
        ArrayList<Member> allMembers = new ArrayList<>();

        Member member = new Member(
                memberFirstName, memberLastName, memberYearOfBirth,
                memberEmail, memberAdress, isActive, hasPaid
        );
        allMembers.add(member);

        return allMembers;
    }
}

   /* public Aftale opretAftaleFraString(String linje) {
        DateTimeFormatter datoFormaterer = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter tidsFormaterer = DateTimeFormatter.ofPattern("HH:mm");
        String[] dele;
        dele = linje.split(", ");
        int kundeTlfNr = Integer.parseInt(dele[3]); //
        Kunde kunde = new Kunde(dele[2], kundeTlfNr);

        int pris = Integer.parseInt(dele[4]);
        LocalDate dato = LocalDate.parse(dele[0], datoFormaterer);
        LocalTime tidspunkt = LocalTime.parse(dele[1], tidsFormaterer);
        String betaling = dele[5];
        return new Aftale(dato, tidspunkt, kunde, pris, betaling);




    public void printFinancesFile {
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
 */