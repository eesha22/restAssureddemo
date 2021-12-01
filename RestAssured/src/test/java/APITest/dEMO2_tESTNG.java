package APITest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dEMO2_tESTNG {
	
	@BeforeClass
	public void BC()
	{
		System.out.println("Something BC2");
	}
	@BeforeMethod
	public void BM()
	{
		System.out.println("Something BM2");
	}
	@Test
	public void Texst2()
	{
		System.out.println("Something test2");
	}
	@AfterTest
	public void AT()
	{
		System.out.println("Something AT2");
	}
	@AfterSuite
	public void AS()
	{
		System.out.println("Something AS2");
	}

}
