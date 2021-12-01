package APITest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo_TestNG {
	//before running any class/test if you want to run we can use before suit
	@BeforeSuite
	public void BS()
	{
		System.out.println("This is going to execute before any test");
	}
	
	@BeforeTest
	public void BT()
	{
		System.out.println("This will run after test suite");
	}
	@BeforeClass
	public void BC()
	{
		System.out.println("sOMETHING BcLASS");
	}
	@BeforeMethod
	public void BM()
	{
		System.out.println("sOMTHING BM");
	}
	@Test
	public void Texst()
	{
		System.out.println("Something test");
		Assert.assertEquals("Eesha","Eesha");
	}
	@AfterClass
	public void AC()
	{
		System.out.println("Something AC");
	}
	@AfterMethod
	public void AM()
	{
		System.out.println("Something AM");
	}
	@AfterTest
	public void AT()
	{
		System.out.println("somethin AT");
	}
	
	@AfterSuite
	public void AS()
	{
		System.out.println("something AS");
	}
}
