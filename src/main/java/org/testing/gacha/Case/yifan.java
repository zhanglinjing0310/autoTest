package org.testing.gacha.Case;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class yifan extends befClass {

    @Test(priority = 8)
    public void ouQi(){
        System.out.println("*****进入欧气赏*****");
        //点击进入欧气赏
        waitforelement(By.id("cc.topop.gacha:id/fl_egg"),60,"欧气赏").click();
        //滚动条播报，刷新按钮，蛋蛋喵推荐是否存在
        waitforelement(By.id("cc.topop.gacha:id/recycleview"),60,"滚动条");
        waitforelement(By.id("cc.topop.gacha:id/iv_refresh"),60,"刷新");
        waitforelement(By.id("cc.topop.gacha:id/tv_title"),60,"蛋蛋喵推荐");
        //上划屏幕

    }
    @Test(priority = 9)
    public void all(){
        System.out.println("*****买一次欧气赏*****");
        //点击进入全部页面
        /*List<WebElement> lis=driver.findElementsByClassName("android.widget.FrameLayout");
        WebElement XiO=lis.get(2);
        XiO.click();*/

        //点击进入欧气赏详情
        waitforelement(By.className("android.widget.ImageView"),60,"欧气赏列表").click();
        //点击新手引导
        waitforelement(By.id("cc.topop.gacha:id/iv_guide_content"),60,"新手引导").click();
        waitforelement(By.id("cc.topop.gacha:id/iv_guide_content"),60,"新手引导").click();
        waitforelement(By.id("cc.topop.gacha:id/iv_guide_content"),60,"新手引导").click();
        waitforelement(By.id("cc.topop.gacha:id/iv_guide_content"),60,"新手引导").click();
        //获取价格
        String prace=driver.findElement(By.id("cc.topop.gacha:id/tv_price_once")).getText();
        //点击买一次
        waitforelement(By.id("cc.topop.gacha:id/iv_buy_one"),60,"买一次").click();
        //断言购买文本是否是1次，预计消费金额是否正确
        eleEquText(By.id("cc.topop.gacha:id/tv_play_count"),"1次","购买1次弹窗");
        eleEquText(By.id("cc.topop.gacha:id/tv_play_money"),prace,"预计消费金额");
        //点击确定按钮进行购买
        waitforelement(By.id("cc.topop.gacha:id/tv_confirm_txt"),60,"购买一次").click();


    }


}
