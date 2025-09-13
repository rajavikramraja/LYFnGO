package flash.lyfngo.test;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import flash.lyfngo.base.BaseTest;
import flash.lyfngo.pom.ForgotPasswordPage;
import flash.lyfngo.utils.ConfigReader;
import flash.lyfngo.utils.generateNewPassword;

public class ForgotPasswordTest extends BaseTest {
@Test
public void ForgotPasswordValidate() throws InterruptedException {
	
	ForgotPasswordPage fpt=new ForgotPasswordPage (driver);
	fpt.ClickForgotPasswordBtn();
	fpt.EnterEmail("consult@putsbox.com");
	 String parentWindow = driver.getWindowHandle();
	 System.out.println(parentWindow);
	fpt.ClickSendMeBtn();
	String urlMail = prop.getProperty("urlMail");
	driver.switchTo().newWindow(WindowType.TAB).get(urlMail);
	fpt.ClickHtml();
	String otp = fpt.getOtpText();
	fpt.switchBackToInbox(parentWindow);
	fpt.InputOtp(otp);
	fpt.clickVerifyBtn();
	String oldPassword = ConfigReader.propertyvalue("oldPassword");
	 String newPassword = generateNewPassword.generateRandomPassword(oldPassword);
	
	fpt.enterNewPass(newPassword);
	fpt.enterConPass(newPassword);
	fpt.ClickSubmit();
	ConfigReader.setProperty("oldPassword", newPassword);
	fpt.EnterSignEmail("consult@putsbox.com");
	fpt.EnterSignPass(newPassword);
	fpt.ClickSignBtn();
	fpt.ValidateLogin();
	
}
}
