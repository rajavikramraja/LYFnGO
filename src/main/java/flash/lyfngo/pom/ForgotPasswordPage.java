package flash.lyfngo.pom;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage {
	WebDriver driver;
	 WebDriverWait wait;
	public ForgotPasswordPage(WebDriver driver) {
		
		this.driver=driver;
		this.wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);                                                                                                                                                                                                                                                                                                                                                         
			// TODO Auto-generated constructor stub
		}
	@FindBy(xpath = "//p[normalize-space()='Forgot password?']")
	WebElement forgotPasswordBtn;
	@FindBy(xpath = "//input[@name='email']")
	WebElement emailInput;
	@FindBy(xpath = "//button[normalize-space()='Send me instructions']")
	WebElement sendMeBtn;
	@FindBy(xpath = "//tbody/tr[1]")
	WebElement latestRow;
	@FindBy(xpath = "//tbody/tr[1]//a[contains(@href,'.html')]")
	WebElement htmlLink;
	@FindBy(xpath = "//p[@id='otpnumber']")
	WebElement otpElement;
	@FindBy(xpath = "//input[@type='tel' and @maxlength='1']")
	List<WebElement> otpInputs;
	@FindBy(xpath = "//button[normalize-space()='Verify']")
	WebElement verifyButton;
	@FindBy(xpath = "//input[@name='New Password*']")
	WebElement newPassEle;
	@FindBy(xpath = "//input[@name='Confirm Password*']")
	WebElement conPassEle;
	@FindBy(xpath = "//button[@value='legacy']")
	WebElement SubmitEle;
	@FindBy(xpath = "//input[@name='email']")
	WebElement SignEmailEle;
	@FindBy(xpath = "//input[@name='password']")
	WebElement SignPassEle;
	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement SignVerify;
	@FindBy(xpath = "//img[@alt='Hello, User']")
	WebElement LoginVerify;
	public void ClickForgotPasswordBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordBtn));
		forgotPasswordBtn.click();
	}
	public void EnterEmail(String email) {
		wait.until(ExpectedConditions.visibilityOf(emailInput));
		emailInput.sendKeys(email);	
	}
	public void ClickSendMeBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(sendMeBtn));
		sendMeBtn.click();
		
	}
	public void ClickHtml() throws InterruptedException {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOf(latestRow));
		Thread.sleep(3000);
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOf(latestRow));
		String dateText = latestRow.getText();
	    System.out.println("Latest mail date: " + dateText);
		String otpPage = htmlLink.getAttribute("href");
		
		driver.switchTo().newWindow(WindowType.TAB).get(otpPage);
	/**	String parentWindow = driver.getWindowHandle();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(parentWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
		**/
		
	}
	public String getOtpText() {
		WebElement otpvalue = wait.until(ExpectedConditions.visibilityOf(otpElement));
		String otpNumber = otpvalue.getText();
		System.out.println(otpNumber);
	return otpNumber;	
	}
	 public void switchBackToInbox(String parentWindow) {
	        driver.switchTo().window(parentWindow);
	    }
	
	public void InputOtp(String otp) {
	
	wait.until(ExpectedConditions.visibilityOfAllElements(otpInputs));
	for (int i = 0; i < otp.length(); i++) {
	    otpInputs.get(i).sendKeys(String.valueOf(otp.charAt(i)));
	}
	}
	public void clickVerifyBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(verifyButton));
		verifyButton.click();
	}
	public void enterNewPass(String newpass) {
		wait.until(ExpectedConditions.visibilityOf(newPassEle));
		newPassEle.sendKeys(newpass);
	}
	public void enterConPass(String Conpass) {
		conPassEle.sendKeys(Conpass);
	}
	public void ClickSubmit() {
		wait.until(ExpectedConditions.elementToBeClickable(SubmitEle));
		SubmitEle.click();
	}
	public void EnterSignEmail(String Email) {
		wait.until(ExpectedConditions.visibilityOf(SignEmailEle));
		SignEmailEle.clear();
		SignEmailEle.sendKeys(Email);
	}
	public void EnterSignPass(String Pass) {
		wait.until(ExpectedConditions.visibilityOf(SignPassEle));
		SignPassEle.sendKeys(Pass);
	}
	public void ClickSignBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(SignVerify));
		SignVerify.click();
	}
	public void ValidateLogin() {
		wait.until(ExpectedConditions.visibilityOf(LoginVerify));
		if (LoginVerify.isDisplayed()) {
	        System.out.println("Login successful — User profile image is visible.");
	    } else {
	        throw new AssertionError("Login failed! User profile image not visible.");
	    }
	}
}
