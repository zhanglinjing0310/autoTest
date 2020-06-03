package org.testing.gacha.Case;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;


public class eggRing extends befClass {

    @Test(priority = 4)
    public void handle() throws InterruptedException {
        /*进入蛋圈-种草，断言吸欧、交易*/
        Thread.sleep(2000);
        //点击蛋圈
        waitforelement(By.id("cc.topop.gacha:id/fl_egg_ring"),60,"蛋圈").click();

        //断言吸欧、交易title
        eleEquText(By.xpath("//android.widget.TextView[@text='吸欧']"),"吸欧","吸欧");
        eleEquText(By.xpath("//android.widget.TextView[@text='交易']"),"交易","交易");
        Thread.sleep(1000);


        System.out.print("上滑完成");
        Thread.sleep(2000);
        SwipeUp();
        System.out.print("滑动完成");

/*        //点赞
        waitforelement(By.id("cc.topop.gacha:id/iv_like"),60).click();
        //点击评论
        waitforelement(By.id("cc.topop.gacha:id/iv_comment"),60).click();*/

    }
    @Test(priority = 5)
    public  void like() throws InterruptedException, IOException {
        System.out.println("*****进入吸欧，点赞*****");
        /*进入蛋圈-吸欧，进行点赞操作，并断言【欧气认证】标签*/
        List<WebElement>lis=driver.findElementsByClassName("android.widget.TextView");
        WebElement XiO=lis.get(2);
        XiO.click();
        //点赞
        waitforelement(By.id("cc.topop.gacha:id/iv_like"),60,"点赞").click();
      /*  File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  // 调用截图方法
        FileUtils.copyFile(src, new File("/Users/itszb/Desktop/testpic/screen.png"));*/
        System.out.println("查看图片欧气认证标志，是否赞变红");
        snapshot("likes");
        Thread.sleep(2000);
    }
    @Test(priority =6)
    public void comment() throws InterruptedException {
        System.out.println("*****评论蛋圈*****");
        //点击评论按钮，进入蛋圈详情页
        waitforelement(By.id("cc.topop.gacha:id/iv_comment"),60,"评论按钮").click();
        //在蛋圈详情页点击评论按钮，弹出输入法
        waitforelement(By.id("cc.topop.gacha:id/fl_comment"),60,"详情页评论按钮").click();
        //点击输入框，输入"好可爱"
        waitforelement(By.id("cc.topop.gacha:id/et_comment"),60,"输入框").click();
        waitforelement(By.id("cc.topop.gacha:id/et_comment"),60,"输入框").sendKeys("好欧啊");
        //点击发送按钮
        waitforelement(By.id("cc.topop.gacha:id/tv_send"),60,"发送按钮").click();
        Thread.sleep(2000);

    }
    @Test(priority = 7)
    public void editEgg() throws InterruptedException {
        System.out.println("*****发表种草蛋圈*****");
        waitforelement(By.id("cc.topop.gacha:id/iv_left"),60,"返回蛋圈按钮").click();
        waitforelement(By.id("cc.topop.gacha:id/iv_right"),60,"编辑蛋圈按钮").click();
        //点击评价输入框
        waitforelement(By.id("cc.topop.gacha:id/et_evaluate"),60,"蛋圈评价输入框").sendKeys("这个真好看");
        //点击上传图片按钮
        waitforelement(By.id("cc.topop.gacha:id/iv_add_photo"),60,"上传图片按钮").click();
        //点击选择图片
        waitforelement(By.id("cc.topop.gacha:id/v_selected"),60,"图片").click();

        boolean T=driver.findElementById("cc.topop.gacha:id/v_selected").isSelected();
        Assert.assertEquals(T,true,"选择图片");

        //点击完成按钮
        waitforelement(By.id("cc.topop.gacha:id/tv_right"),60,"完成按钮").click();
        //点击发布按钮
        waitforelement(By.id("cc.topop.gacha:id/btn_commit_send"),60,"发布按钮").click();
        Thread.sleep(3000);

    }
}
