package testcase;

import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;

public class LoginPage extends BaseTest {
	@Test(priority = 1, groups = "OPAA-TC-224")
	public void loginWithoutCredentials() {
		String expectedText = "Required";
		SoftAssert softAssert = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.findElement(
				By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"))
				.click();
		String actualTextUsernameField = driver
				.findElement(By.xpath("//div[@class='orangehrm-login-form']//form/div[1]/div[1]//span")).getText();
		softAssert.assertEquals(actualTextUsernameField, expectedText);
		String actualTextPasswordField = driver
				.findElement(By.xpath("//div[@class='orangehrm-login-form']//form/div[2]/div[1]//span")).getText();
		softAssert.assertEquals(actualTextPasswordField, expectedText);
	}
	
	@Test(priority = 2, groups = "OPAA-TC-225")
	public void loginWithoutPassword() {
		driver.navigate().refresh();
		String expectedText = "Required";
		SoftAssert softAssert = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("Admin");
		driver.findElement(
				By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"))
				.click();
		String actualTextPasswordField = driver
				.findElement(By.xpath("//div[@class='orangehrm-login-form']//form/div[2]/div[1]//span")).getText();
		softAssert.assertEquals(actualTextPasswordField, expectedText);
	}
	
	@Test(priority = 3, groups = "OPAA-TC-226")
	public void loginWithoutUsername() throws InterruptedException {
		driver.navigate().refresh();
		String expectedText = "Required";
		SoftAssert softAssert = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active' and @type='password']"))
				.sendKeys("admin123");
		driver.findElement(
				By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"))
				.click();
		Thread.sleep(6000);
		String actualTextUsernameField = driver
				.findElement(By.xpath("//div[@class='orangehrm-login-form']//form/div[1]/div[1]//span")).getText();
		softAssert.assertEquals(actualTextUsernameField, expectedText);
	}
	
	@Test(priority = 4, groups = "OPAA-TC-228")

	public void forgotPasswordLink() throws Exception {

		String expectedText1 = "Reset Password";
		String expectedText2 = "Required";
		String expectedText3 = "Login";
		String expectedText4 = "Reset Password link sent successfully";
		String expectedText5 = "A reset password link has been sent to you via email.";
		String expectedText6 = "You can follow that link and select a new password.";
		String expectedText7 = "Note:";
		String expectedText8 = "If the email does not arrive, please contact your OrangeHRM Administrator.";
		SoftAssert softAssert = new SoftAssert();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")).click();
		Thread.sleep(6000);
		String actualText1 = driver
				.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']"))
				.getText();
		Thread.sleep(6000);
		softAssert.assertEquals(actualText1, expectedText1);
		Thread.sleep(6000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(6000);
		String actualText2 = driver.findElement(By.xpath("//div[@class='oxd-form-row']//div[1]//span")).getText();
		Thread.sleep(6000);
		softAssert.assertEquals(actualText2, expectedText2);
		Thread.sleep(6000);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(6000);
		String actualText3 = driver.findElement(By.xpath("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']"))
				.getText();
		Thread.sleep(6000);
		softAssert.assertEquals(actualText3, expectedText3);
		Thread.sleep(6000);
		driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active']")).sendKeys("Admin");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(6000);
		String actualText4 = driver
				.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']"))
				.getText();
		Thread.sleep(6000);
		softAssert.assertEquals(actualText4, expectedText4);
		Thread.sleep(6000);
		String actualText5 = driver.findElement(By.xpath("//div[@class='orangehrm-card-container']//p[1]//p"))
				.getText();
		Thread.sleep(6000);
		softAssert.assertEquals(actualText5, expectedText5);
		Thread.sleep(6000);
		String actualText6 = driver.findElement(By.xpath("//div[@class='orangehrm-card-container']//p[2]//p"))
				.getText();
		Thread.sleep(6000);
		softAssert.assertEquals(actualText6, expectedText6);
		Thread.sleep(6000);
		String actualText7 = driver.findElement(By.xpath("//div[@class='orangehrm-card-container']//p[3]/p[1]"))
				.getText();
		Thread.sleep(6000);
		softAssert.assertEquals(actualText7, expectedText7);
		Thread.sleep(6000);
		String actualText8 = driver.findElement(By.xpath("//div[@class='orangehrm-card-container']//p[3]/p[2]"))
				.getText();
		Thread.sleep(6000);
		softAssert.assertEquals(actualText8, expectedText8);
		Thread.sleep(6000);
		driver.navigate().back();
		driver.navigate().back();
	}

	@Test(priority = 5, groups = "OPAA-TC-227")
	public void login() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(600));
		// Thread.sleep(9000);
		driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active' and @name='username']"))
				.sendKeys("Admin");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active' and @name='password']"))
				.sendKeys("admin123");
		Thread.sleep(6000);
		driver.findElement(
				By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"))
				.click();
		Thread.sleep(3000);
	}
}