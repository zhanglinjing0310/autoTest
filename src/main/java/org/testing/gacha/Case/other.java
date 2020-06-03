package org.testing.gacha.Case;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class other extends befClass{

    @Test(priority = 3)
    public void yiJianFaQuan() throws IOException, InterruptedException {
        //【一键发圈】扭蛋机扭蛋，并一键发圈内含隐藏款和稀有款

        //进入扭蛋页面
        waitforelement(By.id("cc.topop.gacha:id/bg_view_recommend"),60,"进入首页").click();
        waitforelement(By.id("cc.topop.gacha:id/tv_search_key"),60,"搜索输入框").click();
        waitforelement(By.id("cc.topop.gacha:id/et_search"),60,"搜索页面的搜索输入框").click();
        waitforelement(By.id("cc.topop.gacha:id/et_search"),60,"搜索页面的搜索输入框").sendKeys("一键发圈");

        //回车
    /*    String cmdstr="adb shell input keyevent 66";
        Runtime.getRuntime().exec(cmdstr).waitFor();*/

        Thread.sleep(3000);
        //点击一键发圈测试扭蛋机
        waitforelement(By.id("cc.topop.gacha:id/tv_title"),60,"一键发圈扭蛋机").click();
        //点击立即扭蛋
        waitforelement(By.id("cc.topop.gacha:id/twist_egg_start_play"),60,"立即扭蛋").click();
        //扭一次，账户余额付款
        waitforelement(By.id("cc.topop.gacha:id/tv_buy_one"),60,"扭一次").click();
        waitforelement(By.id("cc.topop.gacha:id/cl_balance"),60,"账户余额").click();
        //点击确定按钮
        waitforelement(By.id("cc.topop.gacha:id/iv_bg_content"),60,"确定").click();
        //进入结果页面，点击一键发送的按钮
        waitforelement(By.id("cc.topop.gacha:id/iv_send"),70,"发送").click();
        Thread.sleep(3000);
        //点击继续扭蛋按钮
        waitforelement(By.id("cc.topop.gacha:id/iv_bg_content"),60,"继续扭蛋").click();
        Thread.sleep(2000);
        //点击返回首页按钮
        waitforelement(By.id("cc.topop.gacha:id/iv_back"),60,"返回首页").click();
        //点击取消按钮
        waitforelement(By.id("cc.topop.gacha:id/tv_cancel"),60,"取消").click();
        //点击取消按钮
        waitforelement(By.id("cc.topop.gacha:id/tv_cancel"),60,"取消").click();


    }



}
