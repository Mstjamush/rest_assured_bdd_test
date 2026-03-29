package leave.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties props = new Properties();

    static {
        try (InputStream is = Config.class.getClassLoader().getResourceAsStream("testrail.properties")) {
            props.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load testrail.properties", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}