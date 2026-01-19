package kbm.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop;

	public Properties initProperties() {

		FileInputStream fis = null;
		prop = new Properties();

		try {
			fis = new FileInputStream("./src/test/resource/config/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return prop;
	}
}
