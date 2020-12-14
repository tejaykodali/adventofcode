import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
//        From the list of numbers in file, find the two that sum up to 2020
//        and calculate their product



//            Collections.sort(even);
//            Collections.sort(odd);

        String basePath = new File("").getAbsolutePath();
        String fileName = basePath.concat("\\Day1\\numbers.txt");
        ArrayList<ArrayList<Integer>> inputs = readNumbers(fileName);
        ArrayList<Integer> even = inputs.get(0);
        ArrayList<Integer> odd = inputs.get(1);
        part1(inputs);
        part2(even, odd);
    }

    public static ArrayList<ArrayList<Integer>> readNumbers(String fileName) {
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();

        try(Scanner scanner = new Scanner(Paths.get(fileName))) {
            System.out.println("opened file");
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int number = scanner.nextInt();
                    if (number % 2 == 0) {
                        even.add(number);
                    } else {
                        odd.add(number);
                    }

                } else {
                    scanner.next();
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + e.getCause());
        }
        return new ArrayList<>(Arrays.asList(even, odd));
    }

    public static void part1(ArrayList<ArrayList<Integer>> inputs) {
        inputs.forEach( (x) -> {
            for (int num : x) {
                int otherNum = 2020 - num;
                if (x.contains(otherNum)) {
                    System.out.println("Pair found: " + num + " " + otherNum);
                    System.out.println("Product: " + num * otherNum);
                    break;
                }  //                    System.out.println("Doesn't contain " + otherNum);
            }
        });
    }

    public static void part2(ArrayList<Integer> even, ArrayList<Integer> odd) {
        new ArrayList<>(Arrays.asList(even, odd)).forEach( (x) -> {
            for (int i = 0; i < x.size(); i++) {
                for (int j = 0; j < x.size(); j++) {
                    int otherNum = 2020 - (x.get(i) + x.get(j));
                    if (even.contains(otherNum)) {
                        System.out.println("Triplet fount: " + x.get(i) + " " + x.get(j) + " " + otherNum);
                        System.out.println("Product: " + x.get(i) * x.get(j) * otherNum);
                        break;
                    }
                }
            }
        });

    }
}
