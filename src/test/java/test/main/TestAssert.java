package test.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestAssert {
    public static boolean judge_MBS_add_user(WebDriver driver){
        WebDriverWait waitforwho =new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            String txt2=waitforwho.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/aui-message-group/aui-message/div/span"))).getText();
            System.out.println("[业务反馈]："+txt2);
            if(txt2.equals("成功添加用户")) return true;
            else
            { return false;}
        }
        catch (Exception e){
           System.out.println("异常："+e);
           isScreenShot.getScreenshot(driver,"添加用戶");
            return false;
        }


    }
}
