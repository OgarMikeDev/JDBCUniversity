import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private int id;
    private String name;
    private double salary;
    private int age;
    private static List<Teacher> listAllTeachers = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void addTeacher(Teacher teacher) {
        listAllTeachers.add(teacher);
    }

    public static void getListAllTeachers() {
        for (Teacher currentTeacher : listAllTeachers) {
            System.out.println("\"" + currentTeacher + "\"");
        }
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
