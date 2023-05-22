public class Person {
    private String name;
    private boolean hasDriverLicense;
    private int age;
    private int height;

    public Person(String name, boolean hasDriverLicense, int age, int height) {
        this.name = name;
        this.hasDriverLicense = hasDriverLicense;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public boolean hasDriverLicense() {
        return hasDriverLicense;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public Person clone() {
        return new Person(name, hasDriverLicense, age, height);
    }

    public boolean equals(Object o) {
        if (!(o instanceof Person)) {
            return false;
        }
        Person p = (Person) o;
        return name.equals(p.name)
                && hasDriverLicense == p.hasLicense
                && age == p.age
                && height == p.height;
    }

    public String toString() {
        return String.format("Person [name=%10s | age=%02d | height=%02d | has license/%s license]", 
            name, age, height, hasDriverLicense ? "has" : "no");
    }
}
