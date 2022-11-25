package SilverDoor.Orbirelo.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import SilverDoor.Orbirelo.qa.base.TestBase;
import SilverDoor.Orbirelo.qa.pageobjects.DashboardPage;
import SilverDoor.Orbirelo.qa.pageobjects.LoginPage;
import SilverDoor.Orbirelo.qa.pageobjects.ReservationsPage;
import SilverDoor.Orbirelo.qa.util.ListenerTest;

@Listeners(ListenerTest.class)
public class RebookApartmentPageTest extends TestBase{

	public LoginPage loginPage;
	public DashboardPage dashboardPage;
	public ReservationsPage reservationsPage;

	public RebookApartmentPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
	}

	@Test
	public void f() {
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
