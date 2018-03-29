package Framework;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;

public class appiumServer {
	
	@BeforeSuite
	public void startAppiumServer() throws InterruptedException, IOException {
		Runtime.getRuntime().exec("cmd /c start C:\\Users\\vince\\appiumstart.bat");
		Thread.sleep(7000L);
	}
	

}
