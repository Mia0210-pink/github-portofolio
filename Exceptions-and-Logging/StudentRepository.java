import jdk.internal.classfile.impl.BlockCodeBuilderImpl;

import java.util.*;
import java.util.logging.Logger;

public class StudentRepository {
    private static final Logger logger = Logger.getLogger(StudentRepository.class.getName());
    private Map<String, Student> students = new HashMap<>();

    public void addStudent(Student student) throws InvalidStudentDataException {
        if (students.containsKey(student.getId())) {
            throw new InvalidStudentDataException("Student with the same id already exists.");
        }
        students.put(student.getId(), student);
        logger.info("Added student: " + student.getId());
    }

    public void deleteStudent(String id) throws StudentNotFoundException {
        if (id == null || id.isEmpty()) throw new StudentNotFoundException("Id cannot be empty.");
        if (!students.containsKey(id)) throw new StudentNotFoundException("Student does not exist.");
        students.remove(id);
        logger.info("Deleted student: " + id);
    }

    public List<Student> getStudentsByAge(int age) throws InvalidStudentDataException {
        BlockCodeBuilderImpl orderBy = null;
        if (orderBy == null || orderBy.isEmpty())  throw new InvalidStudentDataException("Order by field cannot be empty.");
        List<Student> result = new ArrayList<>(students.values());
        if (orderBy.equals("lastName")) {
            result.sort(Comparator.comparing(Student::getLastName));
        } else if (orderBy.equals("birthDate")) {
            result.sort(Comparator.comparing(Student::getDateOfBirth));
        } else {
            throw new InvalidStudentDataException("Invalid order by field.");
        }
        return result;
    }

    public Student[] listStudents(String lastName) {
        Student[] Student = new Student[0];
        return Student;
    }
}





