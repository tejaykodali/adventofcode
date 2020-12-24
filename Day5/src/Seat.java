public class Seat {

    private String seat;

    public Seat(String seat) {
        this.seat = seat;
    }

    public int getSeatID() {
        return getRow() * 8 + getCol();
    }

    public int getRow() {
        String string = seat.substring(0, 7);
        return getNumericValue(string, 'F', 'B');
    }

    public int getCol() {
        String string = seat.substring(seat.length() - 3);
        return getNumericValue(string, 'L', 'R');
    }

    private int getNumericValue(String string, char char1, char char2) {
        int l = string.length();
        int lowerLimit = 1;
        int upperLimit = (int) Math.pow(2, l);


        for (int i = 0; i < l; i ++) {
            double mid = (upperLimit + lowerLimit) / 2.0;
            if (string.charAt(i) == char1) {
                upperLimit = (int) Math.floor(mid);
            } else {
                lowerLimit = (int) Math.round(mid);
            }
        }

        if (string.charAt(l - 1) == char1) {
            return upperLimit - 1;
        } else {
            return lowerLimit - 1;
        }
    }

    public String toString() {

        int row = getRow();
        int col = getCol();
        return seat + ": row " + row + ", column " + col + ", seat ID " + getSeatID() + ".";
    }
}
