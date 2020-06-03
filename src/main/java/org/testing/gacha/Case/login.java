package org.testing.gacha.Case;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class login extends befClass{

    /*蛋趣权限允许等*/
    @Test(priority = 1)
    public void plus() throws Exception {
        /*进入蛋趣首页*/
        System.out.println("*****进入蛋趣准备工作*****");
        Thread.sleep(4000);
        /*电话、位置等权限允许、选择不更新，*/
        try {
            waitforelement(By.id("cc.topop.gacha:id/tv_confirm_txt"),60,"yun");

            driver.findElementById("cc.topop.gacha:id/tv_confirm_txt").click();
            Thread.sleep(3000);
            driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
            Thread.sleep(3000);
            driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
            Thread.sleep(5000);
            driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
            waitforelement(By.id("cc.topop.gacha:id/tv_cancel_txt"),20,"暂不更新").click();

            //Thread.sleep(8000);
            /*调用封装好的显示等待方法，查找立即更新按钮
            waitforelement(By.id("cc.topop.gacha:id/tv_confirm_txt"),10).click();
*/
            /*点击暂不更新，如没有则点击立即更新*/
            /*WebElement isUpdate = driver.findElementById("cc.topop.gacha:id/tv_cancel_txt");
            WebElement isUpdate1 = driver.findElementById("cc.topop.gacha:id/tv_confirm_txt");
            if(isUpdate.isDisplayed() && isUpdate1.isDisplayed()) {
                isUpdate.click();
            }else{
                //driver.findElementById("cc.topop.gacha:id/tv_confirm_txt").click();
                System.out.print("不更新");
            }
*/

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("*****蛋趣准备工作完成*****");
    }
    @Test(priority = 2)
    public void login() throws Exception {
        System.out.println("*****进入密码登录*****");
        /*密码登录蛋趣*/
        waitforelement(By.id("cc.topop.gacha:id/fl_mine"),60,"我的按钮").click();
        //driver.findElementById("cc.topop.gacha:id/fl_mine").click();
        Thread.sleep(3000);
        /*点击手机号登录*/
        driver.findElementById("cc.topop.gacha:id/tv_other_login").click();
        Thread.sleep(2000);
        /*点击密码登录*/
        driver.findElementById("cc.topop.gacha:id/tv_right").click();
        Thread.sleep(2000);
        /*输入账号密码*/
        driver.findElementById("cc.topop.gacha:id/et_input_phone_number").sendKeys(MyCookiesForGet("login1.account"));
        driver.findElementById("cc.topop.gacha:id/et_input_password").sendKeys(MyCookiesForGet("login1.password"));
        Thread.sleep(2000);
        /*断言登录按钮是否存在，点击登录按钮*/
        eleEquText(By.id("cc.topop.gacha:id/tv_login"),"登录","登录按钮");
        //eleEquText("cc.topop.gacha:id/tv_login","登录","登录按钮");
        //Assert.assertEquals(driver.findElement(By.id("cc.topop.gacha:id/tv_login")).getText(),"登录","登录按钮");
        driver.findElementById("cc.topop.gacha:id/tv_login").click();
        Thread.sleep(4000);

        /*取消绑定微信*/
        waitforelement(By.id("cc.topop.gacha:id/tv_confirm_txt"),10,"取消绑定按钮");
        //driver.findElementById("cc.topop.gacha:id/tv_confirm_txt").click();
        /*输出登录成功*/
        System.out.println("*****蛋趣登录成功*****");
        Thread.sleep(3000);
    }


}
