package week4.task1;

public class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String toString(){
        return name + "\n\t" + address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
