import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String user = "root";
        String url = "jdbc:mysql://localhost:3306/university";
        String password = "Misha06122000)))";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            //Изменение названия курса с индексом 3
            statement.execute(
                    "UPDATE Courses SET name='Java-разработчик с 0 до PRO(Professional)' " +
                    "WHERE id=3");
            //Создание записи для учителя с индексом 51
            statement.execute(
                    "INSERT INTO Teachers (id, name, salary, age) " +
                            "VALUES (51, 'Кунжут', 10000, 101)");
            //Создание записи для курса с индексом 47
            statement.execute(
                    "INSERT INTO Courses " +
                            "(id, name, duration, " +
                            "type, description, teacher_id, " +
                            "students_count, price, price_per_hour) " +
                            "VALUES " +
                            "(47, 'Продажа курсов по Java', 20, " +
                            "'MARKETING', 'Курс, кот-й научит Вас продавать курсы по Java', 1," +
                            "100, 100000, 10000)");
            //Удаление учителя с индексом 51
            statement.execute(
                    "DELETE FROM Teachers WHERE id=51");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM courses");
            while (resultSet.next()) {
                Course currentCourse = new Course();
                currentCourse.setId(resultSet.getInt("id"));
                currentCourse.setName(resultSet.getString("name"));
                currentCourse.setDuration(resultSet.getInt("duration"));
                currentCourse.setType(CourseType.valueOf(resultSet.getString("type")));
                currentCourse.setDescription(resultSet.getString("description"));
                currentCourse.setTeacherId(resultSet.getInt("teacher_id"));
                currentCourse.setStudentsCount(resultSet.getInt("students_count"));
                currentCourse.setPrice(resultSet.getDouble("price"));
                currentCourse.setPricePerHour(resultSet.getDouble("price_per_hour"));
                Course.addCourse(currentCourse);
            }

            resultSet = statement.executeQuery("SELECT * FROM teachers");
            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(resultSet.getInt("id"));
                teacher.setName(resultSet.getString("name"));
                teacher.setSalary(resultSet.getDouble("salary"));
                teacher.setAge(resultSet.getInt("age"));
                Teacher.addTeacher(teacher);
            }

            resultSet = statement.executeQuery("SELECT * FROM students");
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setRegistrationDate(resultSet.getDate("registration_date"));
                Student.addStudent(student);
            }

            System.out.println("Все курсы:");
            Course.getListAllCourses();
            System.out.println("Все учителя:");
            Teacher.getListAllTeachers();
            System.out.println("Все студенты:");
            Student.getListAllStudents();

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.getMessage();
        }

    }
}
