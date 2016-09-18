package World;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(
				"./src/World/Configs.properties");
		props.load(file);
		return props;
	}

        public static String ReadConfigFile(String param) throws IOException {

		Properties prop = getProp();
		return prop.getProperty(param);
        }
}
