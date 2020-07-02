package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties proprty = new Properties();

    static {
        String path = "configuration.properties";

        try {
            FileInputStream file = new FileInputStream(path);
            proprty.load(file);
            file.close();
        } catch (IOException e) {
            System.out.println("Properties file not found !!");
        }
    }

    public static String getProprty(String keyWord){
        return proprty.getProperty(keyWord);
    }

}
