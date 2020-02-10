import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GeneratePages {


    public static void generatePages() throws FileNotFoundException {
        for(final File fileEntry : new File("./src/main/java/").listFiles()) {
            Scanner file = new Scanner(fileEntry.getAbsoluteFile());
            while (file.hasNext()) {
                System.out.println(file.nextLine());
            }
        }

    }

}
