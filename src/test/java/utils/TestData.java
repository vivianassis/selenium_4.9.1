package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestData {
    private static final Properties testData;

    static {
        testData = new Properties();
        try {
            String filePath = "src/test/resources/data.properties";
            testData.load(new FileInputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getData(String key) {
        return testData.getProperty(key);
    }
}

