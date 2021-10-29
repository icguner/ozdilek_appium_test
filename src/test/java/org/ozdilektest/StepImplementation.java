package org.ozdilektest;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class StepImplementation extends BaseTest {
    private static Logger logger = (Logger) LogManager.getLogger(StepImplementation.class);
    WebDriverWait wait = new WebDriverWait(appiumDriver, 5);

    public boolean isElementExistByXpath(String Selector){
        try{
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(Selector)));
            return true;
        }
        catch(TimeoutException ex){
            return false;
        }
    }

    public boolean isElementExistByID(String Selector){
        try{
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(Selector)));
            return true;
        }
        catch(TimeoutException ex){
            return false;
        }
    }

    @Step("<time> saniye bekle")
    public void waitSecond(int time) throws  InterruptedException {
        Thread.sleep(1000* time);
        logger.warn(time + " Saniye bekleniyor.");
    }

    @Step("<Selector> xPath'li elemente <Text> değerini yaz.")
    public void SendTextByXpath(String Selector, String Text){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(Selector)));
        appiumDriver.findElement(By.xpath(Selector)).sendKeys(Text);
        logger.warn(Selector + " Elementine " + Text + " Değeri yazılıyor");
    }

    @Step("<Selector> ID'li elemente <Text> değerini yaz.")
    public void SendTextByID(String Selector, String Text){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(Selector)));
        appiumDriver.findElement(By.id(Selector)).sendKeys(Text);
        logger.warn(Selector + " Elementine " + Text + " Değeri yazılıyor");
    }

    @Step("<Selector> xPath'li elemente tıkla")
    public void ClickByXpath(String Selector){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(Selector)));
        appiumDriver.findElement(By.xpath(Selector)).click();
        logger.warn(Selector + " Elementine tıklanıyor.");
    }

    @Step("<Selector> ID'li elemente tıkla")
    public void ClickByID(String Selector){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(Selector)));
        appiumDriver.findElement(By.id(Selector)).click();
        logger.warn(Selector + " Elementine tıklanıyor.");
    }

    @Step("<Count> kere sayfayı aşağı kayır.")
    public void ScroolPageDown(int Count){
        int heightOfScreen = appiumDriver.manage().window().getSize().getHeight();
        int widthOfScreen = appiumDriver.manage().window().getSize().getWidth();
        int x = (int) (widthOfScreen * 0.5);
        int y = (int) (heightOfScreen * 0.5);

        TouchAction action = new TouchAction(appiumDriver);
        for (int i=0; i< Count; i++) {
            action.longPress(PointOption.point(x,y+270)).moveTo(PointOption.point(x,y-270)).release().perform();
        }
        logger.warn("Sayfa aşağı kaydırıldı.");
    }

    @Step("Uygulamanın açıldığını kontrol et.")
    public void isAppOpened() {
        final String appActionbarLocation = "com.ozdilek.ozdilekteyim:id/container";
        Assert.assertTrue("Uygulama acilamadi.",isElementExistByID(appActionbarLocation));
    }

    @Step("Alışveriş sayfasının açıldığını kontrol et.")
    public void isShoppingPageOpened() {
        final String appSearchBarLocation = "com.ozdilek.ozdilekteyim:id/edtSearch";
        Assert.assertTrue("Alışveriş sayfası açılamadı.",isElementExistByID(appSearchBarLocation));
    }

    @Step("Kategori sayfasının açıldığını kontrol et.")
    public void isCategoryPageOpened() {
        final String appSearchBarLocation = "//android.widget.LinearLayout[@content-desc=\"Kategoriler\"]";
        Assert.assertTrue("Kategori sayfası açılamadı.",isElementExistByXpath(appSearchBarLocation));
    }

    @Step("Ürün detay sayfasının açıldığını kontrol et.")
    public void isProductDetailPageOpened() {
        final String productPageLocation = "com.ozdilek.ozdilekteyim:id/tvItemDescription";
        Assert.assertTrue("Ürün detay sayfası açılamadı.",isElementExistByID(productPageLocation));
    }

    @Step("Giriş sayfasının açıldığını kontrol et.")
    public void isLoginPageOpened() {
        final String loginPageLocation = "com.ozdilek.ozdilekteyim:id/btnLogin";
        Assert.assertTrue("Giriş sayfası açılamadı.",isElementExistByID(loginPageLocation));
    }

    @Step("Uygulamada <Count> kez geri butonuna bas.")
    public void clickBackButton(int Count) throws InterruptedException {
        final String backButtonLocation = "com.ozdilek.ozdilekteyim:id/ivBack";
        for (int i=0; i< Count; i++) {
            WebElement el = appiumDriver.findElement(By.id(backButtonLocation));
            el.click();
            logger.warn("Geri butonuna basıldı.");
            Thread.sleep(1000);
        }
    }

    @Step("Ürün listesinden rastgele bir ürün seç.")
    public void selectRandomProduct() {
        Random rand = new Random();
        String productXpath = "//androidx.recyclerview.widget.RecyclerView [@resource-id=\"com.ozdilek.ozdilekteyim:id/recyclerView\"]/android.widget.FrameLayout";
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(productXpath)));
        List<MobileElement> productList = appiumDriver.findElements(By.xpath(productXpath));
        WebElement randomElement = productList.get(rand.nextInt(productList.size()));
        randomElement.click();
        logger.warn("Ürün listesinden rastgele bir ürün seçildi.");
    }

    @Step("Beden listesinden rastgele bir beden seç.")
    public void selectRandomSize() {
        Random rand = new Random();
        String sizeXpath = "//android.widget.RelativeLayout [@resource-id='com.ozdilek.ozdilekteyim:id/relLaySizeIn']";
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(sizeXpath)));
        List<MobileElement> sizeList = appiumDriver.findElements(By.xpath(sizeXpath));
        WebElement randomElement = sizeList.get(rand.nextInt(sizeList.size()));
        randomElement.click();
        logger.warn("Beden listesinden rastgele bir ürün seçildi.");
    }

}
