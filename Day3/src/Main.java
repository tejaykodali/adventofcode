import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String basePath = new File("").getAbsolutePath();
        String fileName = basePath.concat("\\Day3\\pattern.txt");
        ArrayList<String> pattern = readPattern(fileName);
        int trees = treesEncountered(pattern);
        System.out.println("Trees encountered: " + trees);
    }

    public static ArrayList<String> readPattern(String fileName) {
        ArrayList<String> pattern = new ArrayList<>();

        try(Scanner scanner = new Scanner(Paths.get(fileName))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                if (!row.isEmpty()) {
                    pattern.add(row);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + e.getCause());
        }

        return pattern;
    }

    public static int treesEncountered(ArrayList<String> pattern) {
        int stringLength = pattern.get(0).length();
        int trees = 0;
        for (int i = 1; i < pattern.size(); i++) {
            int index = i * 3;
            if (index >= stringLength) {
                index = index % stringLength;
            }
            System.out.println(index);
            if (pattern.get(i).charAt(index) == '#') {
                trees += 1;
            }
        }
        return trees;
    }
}
