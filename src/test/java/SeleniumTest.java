import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    WebDriver driver;

    @Before
    public void setup()
    {
        String browser =System.getProperty("browser");
        if (browser ==null)
        {
            driver = new ChromeDriver();
        }
        if (browser.equals("chrome"))
        {
          driver = new ChromeDriver();
        }
        else if (browser.equals("firefox"))
        {
          driver = new FirefoxDriver();
         }
        else
        {
           driver = new ChromeDriver();
        }
        //*/
        // driver = new FirefoxDriver();
        // driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get ("https://www.google.com");
    }

    @After
    public void quitBrowser()
    {
        driver.quit();
    }

    @Test
    public void testEnter() throws InterruptedException {
        String expected = "French language - Wikipedia";

        WebElement barreRecherche = driver.findElement(By.id("lst-ib"));
        //WebElement barreRecherche = driver.findElement(By.cssSelector(".rc > .r > a"));
        barreRecherche.sendKeys("french");
        barreRecherche.sendKeys(Keys.ENTER);
        WebElement premierResultat = driver.findElement(By.cssSelector(".rc > .r > a"));
        //WebElement premierResultat = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div/div/h3/a "));
        Assert.assertEquals(expected,premierResultat.getText());

        Thread.sleep(1000);

        //*[@id="rso"]/div[2]/div/div/div/div/h3/a
        // Explication "Xpath" précédent: A partir de la racine trouver l'id "rso"

        // République française - France — Wikipédia

        // driver.close(); fermer juste une fenetre/onglet
    }

    @Test
    public void testClick() throws InterruptedException {

        WebElement barreRecherche = driver.findElement(By.id("lst-ib"));
        //WebElement barreRecherche = driver.findElement(By.cssSelector(".rc > .r > a"));
        barreRecherche.sendKeys("french");

        WebElement buttonRecherche = driver.findElement(By.className("lsb"));
        //WebElement buttonRecherche = driver.findElement(By.cssSelector(".rc > .r > a"));
        buttonRecherche.click();


        Thread.sleep(1000);
    }
/*    @Test
   public void testEnter2() throws InterruptedException {

        WebElement barreRecherche = driver.findElement(By.id("lst-ib"));
        barreRecherche.sendKeys("canele");
        barreRecherche.sendKeys(Keys.ENTER);

        //Thread.sleep(1000);

        // driver.close(); fermer juste une fenetre/onglet
    }*/
}

