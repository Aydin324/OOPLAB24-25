package week4.task3and4;

public class Teacher extends Person {
    private int salary;

    public Teacher(String name, String address, int age, String country, int salary){
        super(name, address, age, country);
        this.salary = salary;
    }

    @Override
    public String toString(){
        return getName() + "\n\t" + getAddress() +"\n\tage "+ getAge() + "\n\tcountry "+ getCountry() + "\n\tsalary " + salary + " euros/month";
    }
}
