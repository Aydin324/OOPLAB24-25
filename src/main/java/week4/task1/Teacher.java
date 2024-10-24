package week4.task1;

public class Teacher extends Person{
    private int salary;

    public Teacher(String name, String address, int salary){
        super(name, address);
        this.salary = salary;
    }

    @Override
    public String toString(){
        return getName() + "\n\t" + getAddress() + "\n\tsalary " + salary + " euros/month";
    }
}
