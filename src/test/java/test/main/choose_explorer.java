package test.main;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class choose_explorer {
    static void explorer_choice(WebDriver driver,String webserver_ip){

       // chrome_explorer(driver,webserver_ip);
        firefox_explorer(driver,webserver_ip);
    }
    private static void chrome_explorer(WebDriver driver, String webserver_ip)
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options.addArguments("--ignore-certificate-errors"));
        driver.get("https://"+webserver_ip+":9074/zzydemo#/login");
    }
    private static void firefox_explorer(WebDriver driver, String webserver_ip)
    {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options =new FirefoxOptions();
        driver = new FirefoxDriver(options.addArguments("--ignore-certificate-errors"));
        driver.get("https://"+webserver_ip+":9074/zzydemo#/login");
    }
    private static void internet_explorer(WebDriver driver, String webserver_ip)
    {

    }
}
