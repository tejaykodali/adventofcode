import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String basePath = new File("").getAbsolutePath();
        String fileName = basePath.concat("\\Day3\\pattern.txt");
        ArrayList<String> pattern = readPattern(fileName);
        part1(pattern);
        part2(pattern);
    }

    public static void part1(ArrayList<String> pattern) {
        int trees = treesEncountered(pattern, 3, 1);
        System.out.println("Part 1: " + trees);
    }

    public static void part2(ArrayList<String> pattern) {
        int trees1 = treesEncountered(pattern, 1, 1);
        int trees2 = treesEncountered(pattern, 3, 1);
        int trees3 = treesEncountered(pattern, 5, 1);
        int trees4 = treesEncountered(pattern, 7, 1);
        int trees5 = treesEncountered(pattern, 1, 2);
        System.out.println(trees1);
        System.out.println(trees2);
        System.out.println(trees3);
        System.out.println(trees4);
        System.out.println("Part 2: " + trees1 * trees2 * trees3 * trees4 * trees5);
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

    public static int treesEncountered(ArrayList<String> pattern, int h, int v) {
        int stringLength = pattern.get(0).length();
        int trees = 0;
        int index = 0;
        for (int i = v; i < pattern.size(); i += v) {
            index += h;
            if (index >= stringLength) {
                index = index % stringLength;
            }
//            System.out.println(index);
            if (pattern.get(i).charAt(index) == '#') {
                trees += 1;
            }
        }
        return trees;
    }
}
