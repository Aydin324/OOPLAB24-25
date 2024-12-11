package week11.student;

public class Student {
    private int ID;
    private String name;
    private double GPA;
    private String university, department;

    public Student(int ID, String name, String university, String department, double GPA) {
        this.ID = ID;
        this.name = name;
        this.GPA = GPA;
        this.university = university;
        this.department = department;
    }

    //getters
    public int getID() {return ID;}
    public String getName() {return name;}
    public double getGPA() {return GPA;}
    public String getUniversity() {return university;}
    public String getDepartment() {return department;}

    @Override
    public String toString(){
        return name;
    }
}
