package SpeechToText.SpeechRecognition;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpeechToText {

	static WebDriver driver;

	public static void login() throws InterruptedException, IOException {

		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		Map<String, Object> profile = new HashMap<String, Object>();
		Map<String, Object> contentSettings = new HashMap<String, Object>();

		// SET CHROME OPTIONS
		// 0 - Default, 1 - Allow, 2 - Block
		// contentSettings.put("geolocation", 1);
		contentSettings.put("Microphone", 1);
		profile.put("managed_default_content_settings", contentSettings);
		prefs.put("profile", profile);

//		Map<String, Object> chromePrefs = new HashMap<String, Object>();
//		chromePrefs.put("microphone", 1);

		options.setExperimentalOption("prefs", prefs);

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(ChromeOptions.CAPABILITY, options);

		driver = new ChromeDriver();

		driver.get("https://phone.firertc.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("aidanearl03@gmail.com");

		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("pacoman1");

		driver.findElement(By.xpath("//input[@name='commit']")).click();

		driver.findElement(By.xpath("//a[@class='btn btn-default btn-lg']")).click();

		driver.findElement(By.xpath("//input[@class='dialer-input form-control dropdown-toggle']"))
				.sendKeys("18007827282");
		driver.findElement(
				By.xpath("//div[@class='action-bar buttons btn-group btn-group-justified']//div[1]//button[1]"))
				.click();
		driver.findElement(By.xpath("//button[@class='btn btn-dialer']")).click();

		Thread.sleep(70000);
		driver.findElement(By.xpath("//dl[@id='button_1']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//dl[@id='button_1']")).click();

		Thread.sleep(9000);
		String number = "6124926571477609#";

		for (int i = 0; i < number.length(); i++) {

			Thread.sleep(200);

			driver.findElement(By.xpath("//dl[@id='button_" + number.charAt(i) + "']")).click();

		}

		Thread.sleep(6000);

		String otp = RunPython.GetOTP();

		System.out.println(otp);

		for (int i = 0; i < number.length(); i++) {

			Thread.sleep(200);

			driver.findElement(By.xpath("//dl[@id='button_" + number.charAt(i) + "']")).click();

		}
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		SpeechToText.login();
	}

}
