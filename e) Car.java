import java.util.Arrays;

public class Car extends Vehicle implements Comparable<Car>, Announcements {
    private int numDoors;
    private int numWindows;

    public Car(int numDoors, int numWindows) {
        super(2, new int[]{2});
        this.numDoors = numDoors;
        this.numWindows = numWindows;
    }

    public Car(int numDoors, int numWindows, int numSeatsPerRow) {
        super(2, new int[]{numSeatsPerRow});
        this.numDoors = numDoors;
        this.numWindows = numWindows;
    }

    public Car(int numDoors, int numWindows, int[] numSeatsPerRow) {
        super(numSeatsPerRow);
        this.numDoors = numDoors;
        this.numWindows = numWindows;
    }

    public Car(int numDoors, int numWindows, Person driver, int[] numSeatsPerRow) throws InvalidDriverException {
        super(driver, numSeatsPerRow);
        this.numDoors = numDoors;
        this.numWindows = numWindows;
    }

    public boolean canOpenDoor(Person p) {
        for (int row = 0; row <; row++) {
            if (p.getAge() > 5 && (personsOnBoard[row][0] == p || personsOnBoard[row][numSeatsPerRow[row] - 1] == p)) {
                if (row <Doors / 2 || row >= numRows - numDoors / 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canOpenWindow(Person p) {
        for (int row = 0; row < numRows; row++) {
            if (p.getAge() > 2 && (personsOnBoard[row][0] == p || personsOnBoard[row][numSeatsPerRow[row] - 1] == p)) {
                if (row <Windows / 2 || row >= numRows - numWindows / 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public int getNumWindows() {
        return numWindows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return super.equals(o) &&
                numDoors == car.numDoors &&
                numWindows == car.numWindows;
    }

    @Override
    public String toString() {
        String seatsPerRowString = Arrays.toString(numSeatsPerRow);
        String peopleOnBoardString = getNamesOfPeopleOnBoard();
        return String.format("Car: number of doors= %02d | number of windows = %02d | number of rows= %02d | seats per row= %s | names of people on board= %s\n",
                numDoors, numWindows, numRows, seatsPerRowString, peopleOnBoardString);
    }

    @Override
    public int compareTo(Car c) {
        int totalSeats = getNumberOfSeats();
        int otherTotalSeats = c.getNumberOfSeats();
        if (totalSeats < otherTotalSeats) {
            return -1;
        } else (totalSeats > otherTotalSeats) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String departure() {
        return "All Aboard\n";
    }

    @Override
    public String arrival() {
        return "Everyone Out\n";
    }

    @Override
    public String doNotDisturbTheDriver() {
        return "No Backseat Driving\n";
    }
}
