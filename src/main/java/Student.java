import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {
    private int id;
    private String name;
    private int age;
    private Date registrationDate;
    private static List<Student> listAllStudents = new ArrayList<>();

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public static void addStudent(Student student) {
        listAllStudents.add(student);
    }

    public static void getListAllStudents() {
        for (Student currentStudent : listAllStudents) {
            System.out.println("\"" + currentStudent + "\"");
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
