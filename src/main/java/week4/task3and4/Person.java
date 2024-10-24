package week4.task3and4;

public class Person {
    private String name;
    private String address;
    private int age;
    private String country;

    public Person(String name, String address, int age, String country) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.country = country;
    }

    public String toString(){
        return name + "\n\t" + address + "\n\t" + age + "\n\t" + country;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
