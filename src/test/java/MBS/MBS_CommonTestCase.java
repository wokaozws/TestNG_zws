package MBS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class MBS_CommonTestCase {
    public static void MENU_click(WebDriver driver){
        //隐式等待 秒加载整个界面
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.findElement(By.xpath("//*[@id=\"app\"]/aui-app/aui-page/aui-console/div[1]/a/img")).click();

    }
}
