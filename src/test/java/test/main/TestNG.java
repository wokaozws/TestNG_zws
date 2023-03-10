package test.main;

import MBS.MBS_CommonTestCase;
import MBS.MBS_base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;


import static test.main.TestAssert.judge_MBS_add_user;
import static test.main.choose_explorer.*;

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
        MBS_base.Create_User(this.driver, 2);
        Assert.assertTrue(judge_MBS_add_user(driver),"断言！");
    }
    @Test(dependsOnMethods = {"add_MBS_user"},enabled = true)
    void del_MBS_user(){
        System.out.println("测试项：删除MBS用户");
        MBS_base.Delete_user(driver);
    }
    @AfterMethod
    void afterTestCase(){
        System.out.println("---[用例后静止,返回标题]---");
        MBS_CommonTestCase.MENU_click(driver);
    }
    @BeforeSuite
    public void beforeSuiteTest(){
        System.out.println("测试环境准备...");
        String webserver_ip="172.16.30.69";
        System.out.println("当前执行的服务器："+webserver_ip);
        choose_explorer.explorer_choice(driver,webserver_ip);

    }
    @AfterSuite
    public void afterSuiteTest(){
        System.out.println("〓〓〓【测试结束】〓〓〓");
        System.out.println("selenium 退出");
        driver.quit();
    }
}
