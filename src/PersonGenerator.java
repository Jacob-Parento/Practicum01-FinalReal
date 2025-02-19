import java.util.Scanner;

public class PersonGenerator {
    private int idNum;
    private String firstName;
    private String lastName;
    private String title;
    private int YoB;

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYoB() {
        return YoB;
    }

    public void setYoB(int yoB) {
        YoB = yoB;
    }

    public PersonGenerator(int idNum, String firstName, String lastName, String title, int yoB)
    {
        this.idNum = idNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        YoB = yoB;
    }

    public static PersonGenerator createPersonFromInput()
    {
        Scanner in = new Scanner(System.in);

        int idNum = SafeInput.getInt(in, "Enter ID number");
        String firstName = SafeInput.getNonZeroLenString(in, "Enter first name");
        String lastName = SafeInput.getNonZeroLenString(in, "Enter last name");
        String title = SafeInput.getNonZeroLenString(in, "Enter title");
        int YoB = SafeInput.getInt(in, "Enter year of birth");

        return new PersonGenerator(idNum, firstName, lastName, title, YoB);
    }

    @Override
    public String toString() {
        return "PersonGenerator{" +
                "idNum='" + idNum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", YoB=" + YoB +
                '}';
    }
}
