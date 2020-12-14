public class Password {

    private int lowerLimit;
    private int upperLimit;
    private char letter;
    private String password;

    public Password(int lowerLimit, int upperLimit, char letter, String password) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.letter = letter;
        this.password = password;
    }

    public int getCount() {
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == letter) {
                count += 1;
            }
        }
        return count;
    }

    public boolean isValid1() {
        int count = getCount();
        return lowerLimit <= count & count <= upperLimit;
    }

    public boolean isValid2() {
        int lowerIndex = lowerLimit - 1;
        int upperIndex = upperLimit - 1;
        int count = 0;
        if (password.charAt(lowerIndex) == letter) {
            count += 1;
        }
        if (password.charAt(upperIndex) == letter) {
            count += 1;
        }
        return count == 1;
    }
}
