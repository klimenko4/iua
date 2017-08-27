package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPopupPage extends BasePage {

    @FindBy(css = "#FloatLogin [name = 'login']")
    private WebElement loginInput;

    @FindBy(css = "#FloatLogin [name = 'pass']")
    private WebElement passwordInput;

    @FindBy(css = "[name = 'lFloat'] fieldset + input")
    private WebElement submitButton;


    LoginPopupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public MailPage login(String login, String password){
        this.loginInput.sendKeys(login);
        this.passwordInput.sendKeys(password);
        this.submitButton.click();
        return new MailPage(driver, wait);
    }
}
