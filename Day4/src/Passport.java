import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Passport {

    private HashMap<String, String> attributes;


    public Passport(HashMap<String, String> attributes) {
        this.attributes = attributes;
    }

    public boolean isValidPart1() {
        ArrayList<String> requiredAttributes = new ArrayList<>(Arrays.asList("byr",
                "iyr", "eyr", "hgt", "hcl", "ecl", "pid"));
        return attributes.keySet().containsAll(requiredAttributes);
    }

    public boolean isValidPart2() {
        boolean isValidByr = isValidYear("byr", 1920, 2002);

        boolean isValidIyr = isValidYear("iyr", 2010, 2020);

        boolean isValidEyr = isValidYear("eyr", 2020, 2030);

        return isValidPart1() & isValidByr & isValidIyr & isValidEyr &
                isValidHgt() & isValidHcl() & isValidEcl() & isValidPid();
    }

    private boolean isValidYear(String key, int lowerLimit, int upperLimit) {
        String stringYr = attributes.get(key);
        if (stringYr == null) {
            return false;
        }
        if (!stringYr.matches("\\d+")) {
            return false;
        }
        int yr = Integer.parseInt(stringYr);
        return (yr >= lowerLimit) & (yr <= upperLimit);
    }

    private boolean isValidHgt() {
        String hgt = attributes.get("hgt");
        if (hgt == null) {
            return false;
        }
        String unit = hgt.substring(Math.max(hgt.length() - 2, 0));
        ArrayList<String> validUnits = new ArrayList<>(Arrays.asList("cm", "in"));
        if (!validUnits.contains(unit)) {
            return false;
        }
        int hgtNumber = Integer.parseInt(hgt.substring(0, hgt.length() - 2));
        if (unit.equals("cm")) {
            return (hgtNumber >= 150) & (hgtNumber <= 193);
        } else {
            return (hgtNumber >= 59) & (hgtNumber <= 76);
        }
    }

    private boolean isValidHcl() {
        String hcl = attributes.get("hcl");
        if (hcl == null) {
            return false;
        }
        if (hcl.charAt(0) != '#') {
            return false;
        }
        String remainingChars = hcl.substring(1);
        ArrayList<Character> validChars = new ArrayList<>(Arrays.asList('a', 'b',
                'c', 'd', 'e', 'f', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
        boolean areCharsValid = true;
        for (int i = 0; i < remainingChars.length(); i++) {
            if (!validChars.contains(remainingChars.charAt(i))) {
                areCharsValid = false;
                break;
            }
        }
        return remainingChars.length() == 6 & areCharsValid;
    }

    private boolean isValidEcl() {
        String ecl = attributes.get("ecl");
        if (ecl == null) {
            return false;
        }
        ArrayList<String> validEcls = new ArrayList<>(Arrays.asList("amb", "blu",
                "brn", "gry", "grn", "hzl", "oth"));
        return validEcls.contains(ecl);
    }

    private boolean isValidPid() {
        String pid = attributes.get("pid");
        if (pid == null) {
            return false;
        }
        if (pid.length() != 9) {
            return false;
        }
        ArrayList<Character> validDigits = new ArrayList<>(Arrays.asList('0', '1',
                '2', '3', '4', '5', '6', '7', '8', '9'));
        boolean areDigitsValid = true;
        for (int i = 0; i < pid.length(); i++) {
            if (!validDigits.contains(pid.charAt(i))) {
                areDigitsValid = false;
                break;
            }
        }
        return areDigitsValid;
    }

    public String toString() {
        String out = "";
        for (String key : attributes.keySet()) {
            out += key + ":" + attributes.get(key) + " ";
        }
        return out;
    }
}
