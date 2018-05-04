import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dbdatadriven {

	WebDriver driver = null;

	@Test(dataProvider = "getData")
	public void doLogin(String scenario, String username, String password) {

		if (scenario.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\vince\\Downloads\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		if (scenario.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\vince\\Downloads\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		} else if (scenario.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\vince\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		Actions actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/AccountChooser?service=mail&continue=https://mail.google.com/mail/");
		actions.moveToElement(driver.findElement(By.xpath("//*[@id='identifierId']"))).click().sendKeys(username)
				.build().perform();
		driver.findElement(By.id("identifierNext")).click();
		actions.moveToElement(driver.findElement(By.name("password"))).click().sendKeys(password).build().perform();
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		driver.quit();

	}

	@DataProvider
	public Object[][] getData() throws SQLException {

		String host = "localhost";
		String port = "3306";
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://" + host + ":" + port + "/qadbdemo2" + "?useSSL=false", "root", "CalvinSusie098");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from credentials;");
		int colCount = rs.getMetaData().getColumnCount();
		rs.last();
		int rowCount = rs.getRow();
		rs.beforeFirst();
		
        Object[][] data = new Object[rowCount][colCount];
        int row = 0;
        while (rs.next()) {
            for (int i = 0; i < colCount; i++) {
                data[row][i] = rs.getObject(i+1);
            }
            row++;
        }
		return data;

	}

}
