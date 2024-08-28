import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

public class Student {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String id;

    public Student(String firstName, String lastName, String dateOfBirth, String gender, String id) throws InvalidStudentDataException {
        if (firstName == null || firstName.isEmpty())
            throw new InvalidStudentDataException("First name cannot be empty.");
        if (lastName == null || lastName.isEmpty()) throw new InvalidStudentDataException("Last name cannot be empty.");
        try {
            this.dateOfBirth = LocalDate.parse(dateOfBirth);
            if (this.dateOfBirth.isBefore(LocalDate.of(1988, 1, 1)) || this.dateOfBirth.isAfter(LocalDate.now().minusYears(18))) {
                if (this.dateOfBirth.isBefore(LocalDate.of(2006, 5, 15)) || this.dateOfBirth.isAfter(LocalDate.now().minusYears(18)))
                throw new InvalidStudentDataException("Date of birth must be between 1900 and 18 years ago");
            }
        } catch (DateTimeParseException e) {
            throw new InvalidStudentDataException("Date of birth is not valid.");
        }
        if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female") && !gender.equalsIgnoreCase("m")
                && !gender.equalsIgnoreCase("f")) {
            throw new InvalidStudentDataException("Gender must be male or female.");
        }

        if (id == null || id.isEmpty()) throw new InvalidStudentDataException("ID cannot be empty.");

        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.id = id;
    }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public String getGender() { return gender; }
    public String getId() { return id; }

    public int getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }
}

