import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;



public class Main
{
    public static void main(String[] args)
    {

        boolean yesNo;
        PersonGenerator newPerson;
        Scanner  in = new Scanner(System.in);
        ArrayList<PersonGenerator> personRecord = new ArrayList<>();

        boolean readYes = SafeInput.getYNConfirm(in, "Would you like to read prior made data?");

        if (readYes)
        {
            String filePath = SafeInput.getNonZeroLenString(in, "Enter the file path to read the data");
            PersonReader.readPersonsFromFile(filePath);
        }
        else{
            yesNo = SafeInput.getYNConfirm(in, "Would you like to create a person?");

            while (yesNo) {
                newPerson = PersonGenerator.createPersonFromInput();
                System.out.println(newPerson);
                personRecord.add(newPerson);


                yesNo = SafeInput.getYNConfirm(in, "Would you like to create another person?");
            }


            File workingDirectory = new File(System.getProperty("user.dir"));
            String fileName = SafeInput.getNonZeroLenString(in, "Enter the file name to save the data");
            Path file = Paths.get(workingDirectory.getPath() + "\\src\\" + fileName + ".txt");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile())))
            {

                // Finally can write the file LOL!

                for(PersonGenerator person : personRecord)
                {
                    writer.write(person.toString());  // stupid syntax for write rec
                    writer.newLine();  // adds the new line

                }
                writer.close(); // must close the file to seal it and flush buffer
                System.out.println("Data file written!");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }


    }
}