public class Bicycle extends Vehicle implements Comparable<Bicycle> {
    private double weight;

    public Bicycle() {
        super(1, new int[] {1});
        weight = 0.0;
    }

    public Bicycle(Person driver) throws InvalidDriverException {
        super(1, new int[] {1}, driver);
        weight 0.0;
    }

    public Bicycle(Person driver, double weight) throws InvalidDriverException {
        super(1, new int[] {1}, driver);
        if (weight <0) {
            this.weight = 0.0;
        } else {
            this.weight = weight;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Bicycle) {
            Bicycle b = (Bicycle) o;
            return Math.abs(this.weight - b.getWeight()) <= 0.5;
        }
        return false;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double w) {
        if (w >= 0) {
            weight = w;
        } else {
            weight = 0.0;
        }
    }

    @Override
    public void setDriver(Person p) throws InvalidDriverException {
        if (p.getAge() >= 3) {
            super.setDriver(p);
        } else {
            throw new InvalidDriverException("Driver must be at least 3 years old.");
        }
    }

    @Override
    public String toString() {
        return "Bicycle [ rider= " + getDriver().getName() + " | weight= " + weight + " ]";
    }

    @Override
    public int compareTo(Bicycle b) {
        if (Math.abs(this.weight - b.getWeight()) > 0.5) {
            return Double.compare(this.weight, b.getWeight());
        }
        return 0;
    }

    @Override
    public String departure() {
        return "Pedaling away...\n";
    }

    @Override
    public String arrival() {
        return "Arrived at destination!\n";
    }

    @Override
    public String doNotDisturbTheDriver() {
        return "Don't Disturb the Cyclist\n";
    }
}
