package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage extends BasePage {


    @FindBy (css = ".make_message a")
    WebElement sendMessageButton;

    MailPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public SendMessagePage sendMessage() {
        this.sendMessageButton.click();
        return new SendMessagePage(driver, wait);
    }

}
