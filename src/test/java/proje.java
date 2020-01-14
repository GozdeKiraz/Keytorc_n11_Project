import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;
public class proje {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        setUp();

        driver.navigate().to("https://www.n11.com/");

        clickElement(By.className("btnSignIn"));
        sendKeys (By.id("email"),"gzdkiraz@gmail.com");
        sendKeys (By.id("password"),"Hm5.g35918");
        clickElement(By.id("loginButton"));
        sendKeys (By.id("searchData"),"samsung");
        clickElement(By.className("searchBtn"));
        clickElement(By.xpath("//*[@id=\"contentListing\"]/div/div/div[2]/div[3]/a[2]"));
        clickElement(By.xpath("//*[@id=\"p-398121848\"]/div[1]/span"));
        clickElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/div[2]/div[1]/a[2]"));
        //clickElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/div[2]/div[2]/div/a[2]"));
        clickElement(By.xpath("//*[@id=\"myAccount\"]/div[3]/ul/li[1]/div/a"));
        clickElement(By.className("deleteProFromFavorites"));
        clickElement(By.className("closeBtn"));

        driver.quit();

    }
    public static WebElement findElement(By by){
        return  driver.findElement(by);
    }
    public static void clickElement(By by){
        findElement(by).click();
    }
    public static void sendKeys(By by,String text){
        findElement(by).sendKeys(text);

    }
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver","properties/driver/chromedriver.exe");
        driver =new ChromeDriver();
    }
}
