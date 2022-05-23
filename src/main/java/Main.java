import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Course course = session.get(Course.class, 1);
        List<Student> studentsList = course.getStudents();
        for (Student student:
             studentsList) {
            System.out.println(student.getName());
        }
//        System.out.println(course.getStudents().size());
//        System.out.println(course.getTeacher().getName());


//        Course course1 = new Course();
//        course.setName("Nenoviy kurs");
//        course.setType(CourseType.BUSINESS);
//        course.setTeacherId(2);


        session.save(course);

        transaction.commit();
//        Course course = session.get(Course.class, 1);
//        System.out.println(course.getName());

        sessionFactory.close();
    }
}

//==================================================
//============= 1st Lesson =========================
//==================================================
//    String url = "jdbc:mysql://localhost:3306/skillbox";
//    String user = "root";
//    String pass = "NStalker3013@";
//
//        try{
//                Connection connection = DriverManager.getConnection(url, user, pass);
//
//                Statement statement = connection.createStatement();
//
////            statement.execute("UPDATE Courses SET name='Веб-разработчик с нуля до PRO' WHERE id = 1");
//
//                ResultSet resultSet = statement.executeQuery("SELECT * FROM Courses");
//                while(resultSet.next())
//                {
//                Course course = new Course();
//                course.setId(resultSet.getInt("id"));
//                course.setName(resultSet.getString("name"));
//
//
//                String courseName = resultSet.getString("name");
//                System.out.println(courseName);
//                }
//                resultSet.close();
//                statement.close();
//                connection.close();
//
//                } catch (Exception ex) {
//                ex.printStackTrace();
//                }