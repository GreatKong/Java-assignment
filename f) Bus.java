public class Bus extends Car {
    public Bus(int[] numSeatsPerRow) {
        super(2, (numSeatsPerRow.length * 2) - 1, getSeatsPerRow(numSeatsPerRow));
    }

    public Bus(Person driver, int[] numSeatsPerRow) throws InvalidDriverException {
        super(2, (numSeatsPerRow.length * 2) - 1, driver, getSeatsPerRow(numSeatsPer));
    }

    private static int[] getSeatsPerRow(int[] numSeatsPerRow) {
        int[] seatsPerRow = new int[numSeatsPerRow.length];
        seatsPerRow[0] = 1;
        for (int i = 1; i <SeatsPerRow.length; i++) {
            seatsPerRow[i] = numSeatsPerRow[i];
        }
        return seatsPerRow;
    }

    @Override
    public boolean canOpenDoor(Person p) {
        if (p == getDriver()) {
            return true;
        } else {
            int lastPopulatedRow = getLastPopulatedRow();
            if (lastPopulatedRow != -1 && p.getAge() > 5 && p.getHeight() > 40 && personsOnBoard[lastPopulatedRow][0] == p) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canOpenWindow(Person p) {
        if (super.canOpenWindow(p) && p.getAge() > 5) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Bus is an extension of " + super.toString();
    }

    @Override
    public String departure() {
        return "All Aboard the Bus\n";
    }

    @Override
    public String arrival() {
        return "End of the Bus Line\n";
    }

    @Override
    public String doNotDisturbTheDriver() {
        return "Don't Disturb the Bus Driver\n";
    }
}
