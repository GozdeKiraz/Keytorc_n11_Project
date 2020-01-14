import okhttp3.internal.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Thread.sleep;
public class proje {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        setUp();
        //site giriş
        driver.navigate().to("https://www.n11.com/");

        //Sayfa içerisinde aşağı kaydırma
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 250);");

        //kullanıcı girişi
        clickElement(By.className("btnSignIn"));
        sendKeys (By.id("email"),"gzdkiraz@gmail.com");
        sendKeys (By.id("password"),"Hm5.g35918");
        clickElement(By.id("loginButton"));

        //ürün arama
        sendKeys (By.id("searchData"),"samsung");
        clickElement(By.className("searchBtn"));

        //Sayfa değiştirme
        clickElement(By.cssSelector("#contentListing > div > div > div.productArea > div.pagination > a:nth-child(2)"));
        //Favorilere ekleme
        clickElement(By.xpath("//*[@id=\"p-398121848\"]/div[1]/span"));

        //Hesabım üzerine fare imlecini kaydırma ve favori sayfasına gitme
        Actions action = new Actions(driver);
        WebElement mainMenu = findElement(By.className("myAccount"));
        action.moveToElement(mainMenu).moveToElement(driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/div[2]/div[2]/div/a[2]"))).click().build().perform();


        //Favorilerim sayfası
        clickElement(By.xpath("//*[@id=\"myAccount\"]/div[3]/ul/li[1]/div/a"));

        //Favorilerden silme ve çıkan mesajı kapatma
        clickElement(By.className("deleteProFromFavorites"));
        clickElement(By.className("closeBtn"));

        driver.quit();

    }

    //Eleman bulma
    public static WebElement findElement(By by){
        return  driver.findElement(by);
    }

    //Tıklama işlemi
    public static void clickElement(By by){
        findElement(by).click();
    }
    //Text yazdırma
    public static void sendKeys(By by,String text){
        findElement(by).sendKeys(text);

    }
    //Chrome tarayıcısını tanıtma
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver","properties/driver/chromedriver.exe");
        driver =new ChromeDriver();
    }
}
