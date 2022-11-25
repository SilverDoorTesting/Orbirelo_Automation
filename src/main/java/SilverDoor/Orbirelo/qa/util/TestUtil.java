package SilverDoor.Orbirelo.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import SilverDoor.Orbirelo.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static String takeSnapShot(String testMethodName) {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		String destinationPath = currentDir + "\\screenshots\\" + testMethodName+ ".png";
		File destFile = new File(destinationPath);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e){
			e.printStackTrace();
		}
		return destinationPath;
	}
}
