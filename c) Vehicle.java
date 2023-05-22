import java.util.ArrayList;
import java.util.List;

// Vehicle.java
public abstract class Vehicle {
    protected Person[][] personsOnBoard;
    protected int numberOfRows;
    protected int[] numSeatsPerRow;

    public Vehicle(int numRows, int[] numSeatsPerRow) {
        this.numberOfRows = numRows;
        this.numSeatsPerRow = numSeatsPerRow;
        personsOnBoard = new Person[numberOfRows][];
        for (int i = 0; i < numberOfRows; i++) {
            personsOnBoard[i] = new Person[numSeatsPerRow[i]];
        }
    }

    public Vehicle(int numRows, int numSeatsPerRow) {
        this.numberOfRows = numRows;
        this.numSeatsPerRow = new int[numberOfRows];
        personsOnBoard = new Person[numberOfRows][];
        for (int i = 0; i < numberOfRows; i++) {
            this.numSeatsPerRow[i] = numSeatsPerRow;
            personsOnBoard[i] = new Person[numSeatsPerRow];
        }
    }

    public Vehicle(Person driver, int[] numSeatsPerRow) throws InvalidDriverException {
        this(numSeatsPerRow.length, numSeatsPerRow);
        if (driver.hasDriverLicense()) {
            personsOnBoard[0][0] = driver;
        } else {
            throw new InvalidDriverException("Driver does not have a license");
        }
    }

    public abstract boolean loadPassenger(Person p);

    public abstract int loadPassengers(Person[] peeps);

    public void setDriver(Person p) throws InvalidDriverException {
        if (p.hasDriverLicense()) {
            personsOnBoard[0][0] = p;
        } else {
            throw new InvalidDriverException("Driver does not have a license");
        }
    }

    // Add the remaining methods from the requirements
}
// Bus.java
public class Bus extends Vehicle {
    public Bus(int numRows, int numSeatsPerRow) {
        super(numRows, numSeatsPerRow);
    }

    public Bus(int[] numSeatsPerRow) {
        super(numSeatsPerRow.length, numSeatsPerRow);
    }

    public Bus(Person driver, int[] numSeatsPerRow) throws InvalidDriverException {
        super(driver, numSeatsPerRow);
    }

    @Override
    public boolean loadPassenger(Person p) {
        for (int row = 0; row <; row++) {
            for (int col = 0; col <SeatsPerRow[row]; col++) {
                if (personsOnBoard[row][col] == null) {
                    if (row == 0 && (p.getAge() <5 || p.getHeight() <36)) {
                        continue;
                    }
                    personsOnBoard[row][col] = p;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int loadPassengers(Person[] peeps) {
        int loadedPassengers = 0;
        for (Person p : peeps) {
            if (loadPassenger(p)) {
                loadedPassengers++;
            } else {
                break;
            }
        }
        return loadedPassengers;
    }

    // Add the main method and test the code
}
