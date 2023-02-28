package MBS;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.text.DecimalFormat;

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
        sleep(1);
        DecimalFormat usernum = new DecimalFormat("000000");

        for ( int i=0;i<usrnumbs;i++) {
            System.out.println("当前格式：" + usernum.format(i+1));
            sleep(1);

            driver.findElement(By.tagName("aui-button")).click();
            driver.findElement(By.xpath("//aui-form[@id=\'userBasic\']/form/aui-form-item[2]/div/div/aui-input/div/div[2]/input")).sendKeys("BAS2Tusers"+usernum.format(i+1));
            driver.findElement(By.xpath("//aui-form[@id=\'userBasic\']/form/aui-form-item[3]/div/div/aui-input/div/div[2]/input")).sendKeys("自动化用户");
            driver.findElement(By.cssSelector(".suffix > .aui-input")).click();
            driver.findElement(By.cssSelector(".tree-node-label")).click();
            // 密码
            driver.findElement(By.xpath("//aui-form[@id=\'userBasic\']/form/aui-form-item[5]/div/div/aui-input/div/div[2]/input")).sendKeys("12345678");
            // 密码确认
            driver.findElement(By.xpath("//aui-form[@id=\'userBasic\']/form/aui-form-item[6]/div/div/aui-input/div/div[2]/input")).sendKeys("12345678");
            driver.findElement(By.cssSelector("aui-button:nth-child(2)")).click();
        }


    }
    public static void Delete_user(WebDriver driver){
        // Test name: 123
        // Step # | name | target | value | comment
        // 1 | open | /zzydemo |  |
        // 2 | setWindowSize | 1388x910 |  |
        driver.manage().window().setSize(new Dimension(1388, 910));
        driver.findElement(By.cssSelector("ul:nth-child(2) > .first-title")).click();
        // 3 | click | xpath=//td/aui-checkbox/label/span |  |
        driver.findElement(By.xpath("//td/aui-checkbox/label/span")).click();
        // 4 | click | xpath=//aui-dropdown/div/span |  |
        driver.findElement(By.xpath("//aui-dropdown/div/span")).click();
        // 5 | click | css=aui-dropdown-item:nth-child(7) > .item |  |
        driver.findElement(By.cssSelector("aui-dropdown-item:nth-child(7) > .item")).click();
        // 6 | click | css=.aui-message-box__btns > aui-button:nth-child(2) |  |
        driver.findElement(By.cssSelector(".aui-message-box__btns > aui-button:nth-child(2)")).click();
    }
}
