package giocavi.ocp.file;

import java.io.*;
import java.util.Properties;

/**
 * Created by Giovanni on 21/10/2016.
 */
public class PropertiesExample {
    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.setProperty("peso", "64");
        prop.setProperty("age", "29");
        try(BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("classpath:myfile.properties")))
        {
          prop.store(output, null);
        } catch(IOException e) {}

    }
}
