package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {


    @FindBy(name = "login")
    private WebElement loginInput;

    @FindBy(name = "pass")
    private WebElement passwordInput;

    @FindBy(css = "fieldset + input")
    private WebElement submitButton;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public LoginPage open() {
        driver.get("https://passport.i.ua/login/");
        return this;
    }

    public MainPage login(String login, String password) {
        this.loginInput.sendKeys(login);
        this.passwordInput.sendKeys(password);
        this.submitButton.click();
        return new MainPage(driver, wait);
    }

}
