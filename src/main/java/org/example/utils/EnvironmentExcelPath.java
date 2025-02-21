package org.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentExcelPath {
    public static String getEnvironment() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        return properties.getProperty("environment"); // e.g., "dev", "qa", "prod"
    }

    public static String getExcelFilePath() throws IOException {
        String env = getEnvironment();
        return System.getProperty("user.dir") + "/src/test/resources/TestData_" + env + ".xlsx";
    }
}
