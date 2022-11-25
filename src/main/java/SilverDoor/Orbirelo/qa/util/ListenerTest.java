package SilverDoor.Orbirelo.qa.util;

import org.testng.ITestListener;
import org.testng.ITestResult;

import SilverDoor.Orbirelo.qa.base.TestBase;

public class ListenerTest extends TestBase implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			TestUtil.takeSnapShot(result.getMethod().getMethodName());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}