package flash.lyfngo.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop;
	private static final String CONFIG_PATH = 
	        "C:\\Users\\vikra\\eclipse-workspace\\LYFnGO\\src\\main\\resources\\config.properties";
	public static Properties initProperties() {
		 prop=new Properties();
		 try {
			FileInputStream file=new FileInputStream(CONFIG_PATH);
			prop.load(file);
		} catch (IOException e) {
			// TODO: handle exception
	e.printStackTrace();
		}
		return prop;
	}
	public static String propertyvalue(String key) {
		return prop.getProperty(key);
	}
	public static void setProperty(String key, String value) {
        if (prop == null) {
            initProperties();
        }
        prop.setProperty(key, value);
        try (FileOutputStream fos = new FileOutputStream(CONFIG_PATH)) {
            prop.store(fos, "Updated by ConfigReader");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
