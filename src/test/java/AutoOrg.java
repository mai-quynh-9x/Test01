import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;
public class AutoOrg {

    public static void main(String[] args) throws InterruptedException {


        //Khởi tạo browser với Chrome
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Mở trang Id.luklak.live
        driver.get("https://id.luklak.live/signin");
        //Click textbox tài khoản
        driver.findElement(By.id("basic_email")).sendKeys("qtestx@mailinator.com");
        //Click textbox mật khẩu
        driver.findElement(By.id("basic_password")).click();
        driver.findElement(By.id("basic_password")).sendKeys("11111111");
        //Click button Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //driver.findElement(By.className("button-submit-custom")).click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-form-item-explain-error']")));




        // Find the button
        WebElement button = driver.findElement(By.xpath("//div[@class='ant-form-item-explain-error']"));

        // Get the text of the button
        String buttonText = button.getText();
        System.out.println(buttonText);

        // Assert that the button text is as expected
        Assert.assertEquals(buttonText, "Đăng nhập không thành công");

        //Click vào button Chuyển tổ chức, chọn tổ chức
        driver.findElement(By.className("btnHeaderRight")).click();


        // Get the list of elements
        List<WebElement> plants = driver.findElements(By.xpath("//div[@class='ant-popover popover-list-org ant-popover-placement-bottom ']//li"));

        // Create a new Random object
        Random random = new Random();
        System.out.println(plants.size()); // print size of organization list
        // Generate a random index between 0 and the size of the list (exclusive)
        int randomIndex = random.nextInt(plants.size()); //print the index of the random organization

        System.out.println(randomIndex);

        // Get the element at the random index
        WebElement randomPlant = plants.get(randomIndex);
        Thread.sleep(3000);
        // Click on the random element
        randomPlant.click();

        
        //Chưa chạy đc
        //driver.findElement(By.cssSelector("ul.ant-list-items li:nth-of-type(2)")).click();
        //lấy thẻ con "li" có số thứ tự là 2
        //Click icon X để đóng modal Tính năng mới
        driver.findElement(By.xpath("//div[@class='styles_close-icon__whZDn']")).click();
        Thread.sleep(3000);
        //Click vào button Quick Action
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quick-actions")));
        driver.findElement(By.id("quick-actions")).click();
        //Click chọn tạo mục
        driver.findElement(By.xpath("//*[contains(text(),'[N]')]")).click();
        //driver.findElement(By.xpath("//*[contains(text(),'[N]'),'Tạo mục']")).click();
        Thread.sleep(5000);
        //Tạo mục
        //Tiêu đề
        driver.findElement(By.xpath("//textarea[@class='luklak-input luklak-input-outlined styles_title-issue-input__Spso8']")).sendKeys("Tiêu đề mục");
        //Mảng việc
        driver.findElement(By.xpath("//div[@class='styles_info__TOXCz']")).click();
        driver.findElement(By.xpath("//div[@class='luklak-dynamically-css1']//span[2]")).click();
        //Loại mục
 
        //Mô tả
        driver.findElement(By.xpath("//div[@class='styles_contentEditableRoot__IBCsL contentEditableRoot']")).click();
        driver.findElement(By.xpath("//div[@class='styles_contentEditableRoot__IBCsL contentEditableRoot']")).sendKeys("Mô tả mục");
        //Click button Tạo và mở
        driver.findElement(By.xpath("//*[contains(text(),'Tạo và mở')]")).click();
    }
}


