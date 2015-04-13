import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileUtils {

    private FileUtils(){} // hmmm
    
    public static String readFrom(File file) {
        String result = "";
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            int current;
            while ((current = br.read()) != -1) {
                result += (char) current;
            }
        } catch(IOException e) {}
        return result;
    }
    
    public static void main(String[] args){
        Path filePath = Paths.get("potato.txt");
        
        System.out.println(FileUtils.readFrom(filePath.toFile()));
    }
}
