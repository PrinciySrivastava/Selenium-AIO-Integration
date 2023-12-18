package testcase;


import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;

public class AdminPage extends BaseTest {

	@Test(priority = 1, groups = "OPAA-TC-240")
	public void openAdminPage() {

		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(60));
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")).click();

	}

	@Test(priority = 2, groups = "OPAA-TC-241")
	public void searchSystemUsers() {

		String expectedText = "System Users";
		SoftAssert softAssert = new SoftAssert();
		driver.findElement(By.xpath("//div[@class='oxd-form-row']//div[1]//div[1]//div[1]//div[2]//input"))
				.sendKeys("Garry.White");
		driver.findElement(By.xpath(
				"/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"))
				.click();
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-pencil-fill']")).click();
		driver.findElement(
				By.xpath("//button[@type='button' and @class='oxd-button oxd-button--medium oxd-button--ghost']"))
				.click();
		String actualText = driver.findElement(By.xpath("oxd-text oxd-text--h5 oxd-table-filter-title")).getText();
		softAssert.assertEquals(actualText, expectedText);
		softAssert.assertAll();

	}

}
