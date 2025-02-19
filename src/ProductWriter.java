import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


public class ProductWriter {

    public static void main(String[] args)
    {
        ArrayList<String> productRecord = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        boolean done = false;
        boolean yesNo;
        int idNum = 0;
        String prodName = "";
        String prodDesc = "";
        double prodCost = 0.0;

        done = SafeInput.getYNConfirm(in, "Are you entering products?" );
        if (done)
        {
            do {

                idNum = SafeInput.getInt(in, "Enter ID number");
                prodName = SafeInput.getNonZeroLenString(in, "Enter product name");
                prodDesc = SafeInput.getNonZeroLenString(in, "Enter product description");
                prodCost = SafeInput.getDouble(in, "Enter price of product");

                productRecord.add(idNum + "," + prodName + "," + prodDesc + "," + prodCost);

                done = SafeInput.getYNConfirm(in, "Are you done entering products?" );
            }while(!done);

            for (String product : productRecord)
            {
                System.out.println(product);
            }

            File workingDirectory = new File(System.getProperty("user.dir"));
            String fileName = SafeInput.getNonZeroLenString(in, "Enter the file name to save the data");
            Path file = Paths.get(workingDirectory.getPath() + "\\src\\" + fileName + ".txt");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile())))
            {
                for(String product : productRecord)
                {
                    writer.write(product);
                    writer.newLine();
                }
                writer.close();
                System.out.println("Data file written!");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
        else{
            done = SafeInput.getYNConfirm(in, "Would you like to read the data?");
            if (done)
            {
                String filePath = SafeInput.getNonZeroLenString(in, "Enter the file to read");
                ProductReader.readProducts(filePath);
            }
        }
        System.out.println("Job Done!");
    }
}
