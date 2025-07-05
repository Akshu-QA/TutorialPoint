package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CompleteTest {

	WebDriver driver;

	public void implicitWaitMethod(int timeValue) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeValue));
	}

	@Test(priority = 1)
	public void TextBox() {
		implicitWaitMethod(10);
		driver.findElement(By.xpath("//*[@class='accordion-item'][1]")).click();

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"navMenus\"]/li[1]"))))
				.click();

		driver.findElement(By.xpath("//input[@id='fullname']")).sendKeys("johan");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("jon@gmail.com");
		driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("current address is input here ");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("jon@1234");
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
	}

	@Test(priority = 2)
	public void checkBox() {
		implicitWaitMethod(5);

		WebElement checkBoxDisp = driver.findElement(By.xpath("//a[@href='check-box.php']"));

		if (checkBoxDisp.isDisplayed()) {
			checkBoxDisp.click();
			System.out.println("checkbox module is display");
		} else {
			System.out.println("not displyed");
		}

		boolean checkBoxMainLevel1Disp = driver.findElement(By.xpath("//span[text()='Main Level 1 ']")).isDisplayed();
		System.out.println("Main level is displayed" + checkBoxMainLevel1Disp);

		boolean checkBoxMainLevel2Disp = driver.findElement(By.xpath("//span[text()='Main Level 2 ']")).isDisplayed();
		System.out.println("Main level is displayed" + checkBoxMainLevel2Disp);

		driver.findElement(By.xpath("//input[@id='c_bs_1']")).click();
		driver.findElement(By.xpath("//input[@id='c_bs_2']")).click();
		driver.findElement(By.xpath("//li[@id='bs_1']/span[@class='plus']")).click();

		WebElement subLevel1 = driver.findElement(By.xpath("//span[text()='Sub Level 1 ']"));
		subLevel1.isDisplayed();

		WebElement subLevel1Disp = driver.findElement(By.xpath("//li[@id='bf_1']//span[@class='plus']"));
		subLevel1Disp.isDisplayed();

		driver.findElement(By.xpath("//li[@id='bs_2']/span[@class='plus']")).click();
	}

	@Test(priority = 3)
	public void radioBtn() {
		implicitWaitMethod(7);

	}

	@Test(priority = 4)
	public void webTable() {
		implicitWaitMethod(7);
// ankit will do
	}

	@Test(priority = 5)
	public void buttonClick() {
		implicitWaitMethod(7);

	}

	@Test(priority = 6)
	public void links() {
		implicitWaitMethod(7);

	}

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/selenium/practice/dynamic-prop.php");
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		// driver.quit();
	}

}
