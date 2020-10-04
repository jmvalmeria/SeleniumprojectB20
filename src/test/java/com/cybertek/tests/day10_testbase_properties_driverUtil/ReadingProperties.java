package com.cybertek.tests.day10_testbase_properties_driverUtil;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

    @Test
    public void reading_from_properties_file() throws IOException {

        //Properties: User Properties class object
        //We created properties object to be able to read configuration.properties file
        Properties properties = new Properties();

        //FileInputStream: opens the file
        String path = "configuration.properties";

        //We need to pass the path () to open in the JVM
        FileInputStream file = new FileInputStream(path);

        //We will load the file
        properties.load(file);

        //We read from the file
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));

        //Close the file
        file.close();
    }

    public void using_properties_utility_method(){
        //This will read the given "Key's value and return it as String
        ConfigurationReader.getProperty("browser");
    }

}
