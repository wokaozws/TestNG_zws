package test.main;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class isScreenShot {

    //重载--带方法名的截图
    public static void getScreenshot(WebDriver driver,String TestCase_name) {
        // 截图主体功能
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // 拼接路径和图片名称
        String xpath = "./Screenshots/error/" +TestCase_name+ "_" + getCurrentTime() + ".png";
        File screenFile = new File(xpath);
        try {
            FileUtils.copyFile(screen,screenFile);
            System.out.print(" 截图保存路径 "+xpath);
        } catch (Exception e) {
            System.out.print(" 截图保存失败 "+xpath);
            e.printStackTrace();
        }
    }
    //重载--一种简单的截图
    public static void getScreenshot(WebDriver driver) {
        // 截图主体功能
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // 拼接路径和图片名称
        String xpath = "./Screenshots/error/" + "_" + getCurrentTime() + ".png";
        File screenFile = new File(xpath);
        try {
            FileUtils.copyFile(screen,screenFile);
            System.out.print(" 截图保存路径 "+xpath);
        } catch (Exception e) {
            System.out.print(" 截图保存失败 "+xpath);
            e.printStackTrace();
        }
    }
    private static String getCurrentTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        return sdf.format(date);
    }
}
