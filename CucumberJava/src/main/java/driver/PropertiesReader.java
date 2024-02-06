package driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    public static Properties ReadProperties(){
        Properties properties=new Properties();
        FileInputStream fileInputStream;
        try {
            fileInputStream=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/properties/config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
