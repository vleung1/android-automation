package testngFiles2;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Annotations2 {
	
	@BeforeSuite
	public void RunsOnceBeforeEverything() {
		System.out.println("This runs before everything");
	}
	
	@AfterSuite
	public void RunsOnceAfterEverything() {
		System.out.println("This runs after everything");
	}

}
