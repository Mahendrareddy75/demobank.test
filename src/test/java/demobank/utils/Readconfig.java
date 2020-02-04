package demobank.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	Properties prop;
	public Readconfig() {
		File src=new File("./configuration\\config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			 prop=new Properties();
			prop.load(fis);
		
		}catch(Exception e) {
			System.out.println("Exception is"+ e.getMessage());
			
		}
	}
	public String getAppurl() {
		String url=prop.getProperty("baseurl");
		return url;
	}
	public String getusername() {
	String username=prop.getProperty("username");
	return username;
}
	public String getpassword() {
    String password=prop.getProperty("password");
    return password;
}
	public String getchromepath() {
String chromepath=prop.getProperty("chromepath");
return chromepath;
}
	public String getfirefoxpath() {
String firefoxpath=prop.getProperty("firefoxpath");
return firefoxpath;
}


}
