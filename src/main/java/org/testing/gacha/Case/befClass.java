package org.testing.gacha.Case;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testing.gacha.Utils.Utils;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.function.Function;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class befClass {

    public static AppiumDriver driver;


        //读取配置文件中的信息
        public String MyCookiesForGet(String key){
           ResourceBundle resourceBundle;//定义一个ResourceBundle类的对象，用来从env.properties文件中获取配置信息
           String vau;//定义一个String属性，用来存储获取的value值
            //调用getBundle方法，告诉resourceBundle从哪个配置文件中获取配置信息，定义Locale.CHINA是中文信息
            resourceBundle = ResourceBundle.getBundle("env", Locale.CHINA);
            //获取配置信息并赋值给vau
            vau = resourceBundle.getString(key);
            return vau;
        }

        @BeforeTest
        public static void setup () throws Exception {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(CapabilityType.BROWSER_NAME, "");
            cap.setCapability("platformName", "Android"); //指定测试平台
            cap.setCapability("deviceName", "emulator-5554\tdevice"); //指定测试机的ID,通过adb命令`adb devices`获取
            cap.setCapability("platformVersion", "6.0.1");

            //将上面获取到的包名和Activity名设置为值
            cap.setCapability("appPackage", "cc.topop.gacha");
            cap.setCapability("appActivity", ".ui.splash.view.AdverActivity");

//        //A new session could not be created的解决方法
//        cap.setCapability("appWaitActivity", "com.meizu.flyme.calculator.Calculator");
//        //每次启动时覆盖session，否则第二次后运行会报错不能新建session
//        cap.setCapability("sessionOverride", true);

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            System.out.print("*****已经启动蛋趣*****");
            Thread.sleep(3000);
        }


        /*关闭driver*/
        @AfterTest
        public void tearDown () {
            driver.quit();
            System.out.println("*****关闭driver*****");
        }


    //封装显式等待方法
    public AndroidElement waitforelement(By locaor, int timeout,String msg) {
        AndroidElement element =null;
        try {
            //System.out.println("最长等待"+timeout+"秒");
            //设置显示等待
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            element =(AndroidElement)wait.until(ExpectedConditions.visibilityOfElementLocated(locaor));

        } catch (Exception e) {
            System.out.println(msg+"元素没有在页面出现");
        }

        return element;

    }
    //封装断言方法
    public void eleEquText(By by,String expected,String massage){
        try {

                Assert.assertEquals(driver.findElement(by).getText(),expected,massage);
                System.out.println(massage+"存在");
                //Assert.assertEquals(driver.findElement(By.id(by)).getText(),expected,massage);
        }catch (Exception e){
            System.out.println(massage+"不存在");

        }

    }
    //上滑
    public void SwipeUp() {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        Duration duration=Duration.ofMillis(100);
        new TouchAction(driver)
                .press(PointOption.point(width/2, 1145))
                .moveTo(PointOption.point(width / 2, 218)).waitAction(WaitOptions.waitOptions(duration))
                .moveTo(PointOption.point(width/2,-300)).release()
                .perform();

    }

    // 下滑
    public void SwipeDown() {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver)
                .longPress(PointOption.point(width / 2, height - 500))
                .moveTo(PointOption.point(width / 2, 500)).release().perform();
    }

    // 左滑
    public void SwipeLeft() {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver)
                .longPress(PointOption.point(width - 100, height / 2))
                .moveTo(PointOption.point(150, height / 2)).release().perform();
    }

    // 右滑
    public void SwipeRight() {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver).longPress(PointOption.point(150, height / 2))
                .moveTo(PointOption.point(width - 100, height / 2)).release()
                .perform();
    }
    //截图功能
    public void snapshot(String filename)
    {
        // this method will take screen shot ,require two parameters ,one is driver name, another is file name
        String currentPath =MyCookiesForGet("login1.local");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screenFile=new File(currentPath);//可删除
        // Now you can do whatever you need to do with it, for example copy somewhere
        try {
            System.out.println("save snapshot path is:"+currentPath+"/"+filename);
            FileUtils.copyFile(scrFile, new File(currentPath+"/"+filename+".png"));
            Utils.copyFile(scrFile,screenFile);//可删除
            Reporter.log("<a href=\"" + currentPath + "\" target=_blank>点击查看截图</a><p/>", true);//可删除
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Can't save screenshot");
            e.printStackTrace();
        }
        finally
        {

            System.out.println("screen shot finished");
        }
    }
    //截图，暂时无效，未使用
    public void screenshots(AndroidDriver driver) {
        File file = driver.getScreenshotAs(OutputType.FILE);
        File screenFile=new File("F:\\screenFile.png");
        Utils.copyFile(file, screenFile);
        String s = "F:\\\\screenFile.png";
        Reporter.log("<a href=\"" + s + "\" target=_blank>点击查看截图</a><p/>", true);
    }

}
