import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String basePath = new File("").getAbsolutePath();
        String fileName = basePath.concat("\\Day2\\passwords.txt");
        ArrayList<Password> passwords = readPasswords(fileName);
        int count1 = 0;
        int count2 = 0;
        for (Password password : passwords) {
            if (password.isValid1()) {
                count1 += 1;
            }
            if (password.isValid2()) {
                count2 += 1;
            }
        }
        System.out.println("Valid passwords part 1: " + count1);
        System.out.println("Valid passwords part 2: " + count2);
    }

    public static ArrayList<Password> readPasswords(String fileName) {
        ArrayList<Password> data = new ArrayList<>();

        try(Scanner scanner = new Scanner(Paths.get(fileName))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                if (!row.isEmpty()) {
                    String[] parts = row.split(" ");
                    String[] limits = parts[0].split("-");
                    int lowerLimit = Integer.parseInt(limits[0]);
                    int upperLimit = Integer.parseInt(limits[1]);
                    char letter = parts[1].charAt(0);
                    String passwordText = parts[2];
                    data.add(new Password(lowerLimit, upperLimit, letter, passwordText));
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + e.getCause());
        }
        return data;
    }
}
