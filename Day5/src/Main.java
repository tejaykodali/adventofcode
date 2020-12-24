import java.io.File;
import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String basePath = new File("").getAbsolutePath();
        String fileName = basePath.concat("\\Day5\\data.txt");

        ArrayList<Seat> seats = readSeats(fileName);
        ArrayList<Integer> seatIDs = new ArrayList<>();
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();
        for (Seat seat : seats) {
//            System.out.println(seat);
            seatIDs.add(seat.getSeatID());
            rows.add(seat.getRow());
            cols.add(seat.getCol());
        }

//        Part 1
        int maxSeatID = Collections.max(seatIDs);
        int minSeatID = Collections.min(seatIDs);
        System.out.println("Max seat ID: " + maxSeatID);

//        Part 2
        int minRow = Collections.min(rows);
        int maxRow = Collections.max(rows);
        int minCol = Collections.min(cols);
        int maxCol = Collections.max(cols);
//        ArrayList<Integer> possibleSeatIDs = new ArrayList<>();

        for (int i = minRow; i <= maxRow; i++) {
            for (int j = minCol; j <= maxCol; j++) {
                int currentSeatID = i * 8 + j;
                if (!seatIDs.contains(currentSeatID) &&
                        currentSeatID > minSeatID &&
                        currentSeatID < maxSeatID) {
                    System.out.println("Missing seat: " + currentSeatID);
                }
            }
        }
    }

    public static ArrayList<Seat> readSeats(String fileName) {
        ArrayList<Seat> seats = new ArrayList<>();

        try(Scanner scanner = new Scanner(Paths.get(fileName))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                if (!row.isEmpty()) {
                    seats.add(new Seat(row));
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + e.getCause());
        }

        return seats;
    }
}
