package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;

public class MyInfoPage extends BaseTest {

	@Test(priority = 1, groups = "OPAA-TC-242")
	public void openMyInfoPage() {

		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a")).click();
	}

}
