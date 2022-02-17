package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalValuesDrive {
	Properties prop;

	public GlobalValuesDrive() {
	}

	public Boolean Initialize() throws IOException {
		Boolean status = false;
		FileInputStream fis = new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\HealthMagus\\data.propeties");
		if (fis != null) {
			prop = new Properties();
			prop.load(fis);
			status = true;
		}
		return status;
	}

	public String getQaUrl() {
		return prop.getProperty("qaurl");
	}

	public String getDevUrl() {
		return prop.getProperty("devurl");
	}

	public String getEnvironment() {
		return prop.getProperty("environment");
	}
	
	public String getTitle() {
		return prop.getProperty("title");
	}
	public String getBrowser() {
		return prop.getProperty("browser");
	}

}
