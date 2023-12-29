import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class AppiumSetup extends Comandos{

    HomePage homePage;
    SampleListPage sampleListPage;
    NativeViewPage nativeViewPage;
    SliderPage sliderPage;
    VerticalSwipingPage verticalSwipingPage;
    DragAndDropPage dragAndDropPage;
    DoubleTapPage doubleTapPage;
    LonPressPage lonPressPage;
    WebViewPage webViewPage;
    CarouselPage carouselPage;
    WheelPickerPage wheelPickerPage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("platformVersion","13");
        caps.setCapability("deviceName","192.168.1.66:5555");
        caps.setCapability("autoGrantPermissions", "true");
        caps.setCapability("app",System.getProperty("user.dir")+"\\src\\main\\resources\\appiumChallenge.apk");
        driver = new AndroidDriver(new URL(" http://127.0.0.1:4723/"),caps);

        while (driver.findElements(AppiumBy.xpath("//*[@class='android.widget.Button'][2]")).size()>0)
        {
            driver.findElement(AppiumBy.xpath("//*[@class='android.widget.Button'][2]")).click();
        }

        homePage = new HomePage(driver);
        sampleListPage = new SampleListPage(driver);
        nativeViewPage = new NativeViewPage(driver);
        sliderPage = new SliderPage(driver);
        verticalSwipingPage = new VerticalSwipingPage(driver);
        dragAndDropPage = new DragAndDropPage(driver);
        doubleTapPage = new DoubleTapPage(driver);
        lonPressPage = new LonPressPage(driver);
        webViewPage = new WebViewPage(driver);
        carouselPage = new CarouselPage(driver);
        wheelPickerPage = new WheelPickerPage(driver);

    }
    @Test(priority = 1)
    public void login() {
        fluentWait(homePage.logoImage);
        Assert.assertEquals(homePage.logoImage.getAttribute("className"),"android.widget.ImageView");
    }

    @Test(priority = 2)
    public void goToSampleList(){
        clickElem(homePage.loginButton);
        Assert.assertEquals(sampleListPage.pageTitle.getText(),"Samples List");
    }

    @Test(priority = 3)
    public void goToNativeView(){
        clickElem(sampleListPage.nativeView);
        Assert.assertEquals(nativeViewPage.pageTitle.getText(), "Native View Demo");
        Assert.assertEquals(nativeViewPage.viewOne.getText(),"Hello World, I'm View one ");
        Assert.assertEquals(nativeViewPage.viewTwo.getText(), "Hello World, I'm View two ");
        Assert.assertEquals(nativeViewPage.viewThree.getText(),"Hello World, I'm View three ");
        clickElem(nativeViewPage.backButton);
        Assert.assertEquals(sampleListPage.pageTitle.getText(),"Samples List");
    }

    @Test(priority = 4)
    public void goToSlider(){
        clickElem(sampleListPage.slider);
        sliderPage.moveSlider();
        Assert.assertEquals(sliderPage.slider.getText(),"128.0");
        clickElem(sliderPage.backButton);
    }

    @Test(priority = 5)
    public void goToDragDrop(){
        clickElem(sampleListPage.dragAndDrop);
        dragAndDropPage.dragGesture();
        Assert.assertEquals(dragAndDropPage.successMessage.getText(),"Circle dropped");
        clickElem(dragAndDropPage.backButton);

    }

    @Test(priority = 6)
    public void goToDoubleTap(){
        clickElem(sampleListPage.doubleTap);
        doubleTapPage.doubleTapGesture();
        fluentWait(doubleTapPage.message);
        Assert.assertEquals(doubleTapPage.message.getText(),"Double tap successful!");
        clickElem(doubleTapPage.okButton);
        clickElem(doubleTapPage.backButton);
    }

    @Test(priority = 7)
    public void goToLongPressPage(){
        clickElem(sampleListPage.longPress);
        lonPressPage.longPressGesture();
        Assert.assertEquals(lonPressPage.message.getText(),"you pressed me hard :P");
        clickElem(lonPressPage.okButton);
        clickElem(lonPressPage.backButton);
    }

    @Test(priority = 8)
    public void goToWebView(){
        clickElem(sampleListPage.webView);
        fluentWait(webViewPage.webTitle);
        Assert.assertEquals(webViewPage.webTitle.getText(),"Hacker News");
        clickElem(webViewPage.webLoginButton);
        clickElem(webViewPage.backButton);
    }

    @Test(priority = 9)
    public void goToCarosel() {
        swipeUp(sampleListPage.scroll);
        clickElem(sampleListPage.carousel);
        Assert.assertEquals(carouselPage.getCarouselValues(), carouselPage.textCarouselExpected);
        clickElem(carouselPage.backButton);
    }
    @Test(priority = 10)
    public void goToWheelPage() throws InterruptedException {
        clickElem(sampleListPage.wheelPicker);
        for(int i = 0; i<wheelPickerPage.textColorExpected.size(); i++){
            clickElem(wheelPickerPage.picker);
            Thread.sleep(5000);
            clickElem(wheelPickerPage.insertListIndex(wheelPickerPage.textColorExpected.get(i)));
            Assert.assertEquals(wheelPickerPage.upCurrentColor.getText().substring(16).trim(),wheelPickerPage.textColorExpected);
        }
    }

}
