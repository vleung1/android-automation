package testngFiles;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
	@BeforeTest
	public void RunsOnceBeforeTests() {
		System.out.println("This runs once before all tests");
	}
	
	@AfterTest
	public void RunsOnceAfterTests() {
		System.out.println("This runs once after all tests");
	}
	
	@BeforeMethod
	public void RunsOnceBeforeEachTest() {
		System.out.println("This runs once before each test");
	}
	
	@AfterMethod
	public void RunsOnceAfterEachTest() {
		System.out.println("This runs once after each test");
	}
	
	@Test
	public void TestCase1() {
		System.out.println("Test case #1");
	}
	
	@Test
	public void TestCase2() {
		System.out.println("Test case #2");
	}
	
	
}
