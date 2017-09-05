package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedUserHeaderPage extends BasePage {

    @FindBy(css = ".ho_menu-account li:nth-child(3) span")
    WebElement settingsButton;

    @FindBy(css = "#accountSettingsPopup > ul > li:nth-child(7) > a")
    WebElement logoutButton;


    LoggedUserHeaderPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public MainPage logout() {
        settingsButton.click();
        WebElement element = wait.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();
        return new MainPage(driver, wait);
    }
}
