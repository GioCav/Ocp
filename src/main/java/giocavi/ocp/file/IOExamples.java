package giocavi.ocp.file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Created by Giovanni on 21/10/2016.
 */
public class IOExamples {
    public static void main(String[] args) {

        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\text.txt"))){
            reader.read();
            if (reader.markSupported()) {
                reader.mark(10);
                reader.readLine();
                reader.reset();
            }
        } catch(IOException e) {
            e.printStackTrace();
        };
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\text.txt"))){
            writer.write('c');
            writer.write("ciao");
            writer.write(new char[] {10,2});
        } catch(IOException e) {
            e.printStackTrace();
        };
        //Stream
        try(InputStream istream = new BufferedInputStream(new FileInputStream("C:\\text.txt"))){
           char firstchar = (char) istream.read();
        } catch(IOException e) {
            e.printStackTrace();
        };
        try(OutputStream ostream = new BufferedOutputStream(new FileOutputStream("C:\\text.txt"))){
            // ostream.write("ciao"); //NO string input!
        } catch(IOException e) {
            e.printStackTrace();
        };
        try {
            InputStream s = Files.newInputStream(Paths.get("ciao"));
            BufferedReader g = Files.newBufferedReader(Paths.get("ciao"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path p = Paths.get("giovanni.txt");
    }
}
