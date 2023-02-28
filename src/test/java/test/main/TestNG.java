package test.main;

import MBS.MBS_base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.zeromq.ZMQ.sleep;

public class TestNG {
    WebDriver driver;
    @Test
    public  void login_test(){
        System.out.println("测试项：MBS登录");
        MBS_base.Login_MOS(driver);
    }
    @Test(dependsOnMethods = {"login_test"},enabled = true)
    public  void add_MBS_user()  {
        System.out.println("测试项：添加MBS用户");
        MBS_base.Create_User(this.driver, 1);
    }
    @Test(dependsOnMethods = {"add_MBS_user"},enabled = true)
    void del_MBS_user(){
        System.out.println("测试项：删除MBS用户");
        MBS_base.Delete_user(driver);
    }
    @BeforeSuite
    public void beforeSuiteTest(){
        System.out.println("测试注解.beforeSuiteTest套件，仅一次");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options.addArguments("--ignore-certificate-errors"));

        System.out.println("当前执行的服务器：69");
        driver.get("https://172.16.30.69:9074/zzydemo#/login");
    }
    @AfterSuite
    public void afterSuiteTest(){
        System.out.println("测试注解：afterSuiteTest 测试结束");
        sleep(1);
        System.out.println("selenium quit now");
        driver.quit();


    }
}
