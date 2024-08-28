import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestStudentRepository {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(StudentRepository.class.getName());
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        logger.addHandler(handler);
        logger.setLevel(Level.ALL);

        StudentRepository repository = new StudentRepository();

        try {
            repository.addStudent(new Student("Ionut", "Popescu", "1988-01-01", "Male", "1234568970"));
            repository.addStudent(new Student("Daria", "Ionescu", "2006-05-15", "Female", "289765323"));

            System.out.println("List by Last Name:");
            for (Student s : repository.listStudents("lastName")) {
                System.out.println(s.getLastName() + " " + s.getFirstName());
            }


            System.out.println("List by Birth Date:");
            for (Student s : repository.listStudents("birthDate")) {
                System.out.println(s.getDateOfBirth() + ": " + s.getFirstName() + " " + s.getLastName());
            }


            System.out.println("Students with age 18:");
            for (Student s : repository.getStudentsByAge(18)) {
                System.out.println(s.getFirstName() + " " + s.getLastName());
            }

            repository.deleteStudent("1");
            System.out.println("Deleted student with ID 1.");

        } catch (InvalidStudentDataException | StudentNotFoundException e) {
            logger.severe(e.getMessage());
        }
    }
}

