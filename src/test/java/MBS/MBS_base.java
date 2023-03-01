package MBS;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import static zmq.ZMQ.sleep;

public class MBS_base {
    public static void Login_MOS(WebDriver driver)
    {
        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/aui-form-item[2]/div/div/aui-input/div/div[2]/input")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/aui-form-item[3]/div/div/aui-input/div/div[2]/input")).sendKeys("admin.111");
        driver.findElement(By.tagName("aui-button")).click();
    }


    public static void Create_User(WebDriver driver, int usrnumbs) {
        driver.manage().window().setSize(new Dimension(1388, 910));
        driver.findElement(By.cssSelector("ul:nth-child(2) > .first-title")).click();
        //隐式等待2秒加载整个界面
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        DecimalFormat usernum = new DecimalFormat("000000");

            driver.findElement(By.tagName("aui-button")).click();
            driver.findElement(By.xpath("//aui-form[@id=\'userBasic\']/form/aui-form-item[2]/div/div/aui-input/div/div[2]/input")).sendKeys("BAS2Tusers"+usernum.format(usrnumbs));
            driver.findElement(By.xpath("//aui-form[@id=\'userBasic\']/form/aui-form-item[3]/div/div/aui-input/div/div[2]/input")).sendKeys("自动化用户");
            driver.findElement(By.cssSelector(".suffix > .aui-input")).click();
            driver.findElement(By.cssSelector(".tree-node-label")).click();
            // 密码
            driver.findElement(By.xpath("//aui-form[@id=\'userBasic\']/form/aui-form-item[5]/div/div/aui-input/div/div[2]/input")).sendKeys("12345678");
            // 密码确认
            driver.findElement(By.xpath("//aui-form[@id=\'userBasic\']/form/aui-form-item[6]/div/div/aui-input/div/div[2]/input")).sendKeys("12345678");
            driver.findElement(By.cssSelector("aui-button:nth-child(2)")).click();



    }
    public static void Delete_user(WebDriver driver){

       // driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1920, 910));
        //sleep(2);
        System.out.println("功能:用户中心点击");
        driver.findElement(By.cssSelector("ul:nth-child(2) > .first-title")).click();
        //sleep(1);
        System.out.println("功能：用户复选框点击");
        driver.findElement(By.cssSelector("tr:nth-child(2) .checkbox__inner")).click();
        //sleep(1);
        System.out.println("功能：下拉框点击");
        driver.findElement(By.cssSelector(".dropdown-icon")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        System.out.println("功能：下拉框删除点击");
        driver.findElement(By.className("item")).click();
        //sleep(1);
        System.out.println("功能：确认");
        driver.findElement(By.cssSelector(".aui-message-box__btns > aui-button:nth-child(2)")).click();
    }
}
