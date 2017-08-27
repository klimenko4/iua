package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

    public static final String homePageUrl = "http://i.ua/";


    @FindBy (css = ".user_menu .first")
    private WebElement loginButton;

    @FindBy (css = ".site_sections li:nth-child(1) a")
    private WebElement mailBoxButton;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
        PageFactory.initElements(driver, this);
    }


    public MainPage open() {
        driver.get(homePageUrl);
        return this;
    }
    public LoginPopupPage openLoginPopup() {
        this.loginButton.click();
        return new LoginPopupPage(driver, wait);
    }

    public MailPage openMailPage() {
        this.mailBoxButton.click();
        return new MailPage(driver,wait);
    }
}
