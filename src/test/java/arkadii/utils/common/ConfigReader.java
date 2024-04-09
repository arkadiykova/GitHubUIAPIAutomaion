package arkadii.utils.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try{
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
        }catch (IOException e){
            System.err.println("File is not found in configuration file");
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyword){return properties.getProperty(keyword);}


}
