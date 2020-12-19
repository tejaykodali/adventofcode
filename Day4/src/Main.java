import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String basePath = new File("").getAbsolutePath();
        String fileName = basePath.concat("\\Day4\\data.txt");
        ArrayList<Passport> passports = readFile(fileName);
        int count1 = 0;
        int count2 = 0;
        for (Passport passport : passports) {
            System.out.println(passport);
            if (passport.isValidPart1()) {
                count1 ++;
                if (passport.isValidPart2()) {
                    count2 ++;
                }
            }
        }
        System.out.println("Number of valid passports (Part 1): " + count1);
        System.out.println("Number of valid passports (Part 2): " + count2);
    }

    public static ArrayList<Passport> readFile(String fileName) {
        ArrayList<String> passportData = new ArrayList<>();
        ArrayList<Passport> passports = new ArrayList<>();

        try(Scanner scanner = new Scanner(Paths.get(fileName))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                if (!scanner.hasNextLine()) {
                    passportData.add(row);
                    passports.add(parsePassportData(passportData));
                    passportData.clear();
                } else {
                    if (row.isEmpty()) {
                        passports.add(parsePassportData(passportData));
                        passportData.clear();
                    } else {
                        passportData.add(row);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + e.getCause());
        }

        return passports;
    }

    public static Passport parsePassportData(ArrayList<String> passportData) {
        HashMap<String, String> attributes = new HashMap<String, String>();
        for (String row : passportData) {
            String[] parts = row.split(" ");
            for (String part : parts) {
                String[] subPart = part.split(":");
                attributes.put(subPart[0], subPart[1]);
            }
        }
        return new Passport(attributes);
    }

}
