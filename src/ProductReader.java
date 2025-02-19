import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProductReader {
    public static void readProducts(String fileName)
    {
        String rec = "";
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\" + fileName + ".txt");


        try (InputStream in = new BufferedInputStream(Files.newInputStream(file));
             BufferedReader reader = new BufferedReader(new InputStreamReader(in)))
        {
            // Finally we can read the file LOL!
            int line = 0;
            while (reader.ready()) {
                rec = reader.readLine();
                line++;
                // echo to screen
                System.out.printf("\nLine %4d %-60s ", line, rec);
            }
            System.out.println("\n\nData file read!");

        }catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
