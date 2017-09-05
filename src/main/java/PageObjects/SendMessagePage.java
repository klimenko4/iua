package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendMessagePage extends BasePage {


    @FindBy(id = "to")
    private WebElement toUserInput;

    @FindBy(name = "subject")
    private WebElement subjectInput;

    @FindBy(id = "text")
    private WebElement textInput;

    @FindBy(name = "send")
    private WebElement sendButton;


    SendMessagePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }


    public SuccessSendingMailPage sendMail(String userMail, String subject, String text) {
        toUserInput.sendKeys(userMail);
        subjectInput.sendKeys(subject);
        textInput.sendKeys(text);
        sendButton.click();
        return new SuccessSendingMailPage(driver, wait);
    }
    public SuccessSendingMailPage sendMail(String userMail) {
       return sendMail(userMail,"SubjectText", "Body of message");
    }

}


