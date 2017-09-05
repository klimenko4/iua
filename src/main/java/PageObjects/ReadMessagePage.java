package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadMessagePage extends LoggedUserHeaderPage{

    @FindBy(css = ".message_body")
    WebElement messageText;

    @FindBy(css = ".sn_menu li:nth-child(2) a")
    WebElement messagesLink;


    public ReadMessagePage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public String getMessageText() {
        return messageText.getText();
    }


    public MailPage openMailPage() {
        messagesLink.click();
        return new MailPage(driver, wait);
    }
}
