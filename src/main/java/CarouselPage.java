import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarouselPage extends Comandos{

    public CarouselPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    List<String> textCarouselExpected = Arrays.asList("1", "2", "3");

    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup//android.widget.TextView")
    public WebElement caroselValue;

    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup")
    public RemoteWebElement scroll;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Back\"]")
    public WebElement backButton;

    public List<String> getCarouselValues(){
        String by = "//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup//android.widget.TextView";
        List<String> elementsFound = new ArrayList<>();
        fluentWait(caroselValue);

        for (int i = 0; i<3; i ++){
            WebElement element = driver.findElement(By.xpath(by));
            elementsFound.add(element.getText());
            System.out.println(element.getText());
            swipeLeft(scroll);
        }
        return elementsFound;
    }
}
