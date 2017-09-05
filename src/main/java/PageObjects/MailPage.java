package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage extends LoggedUserHeaderPage {


    @FindBy(css = ".make_message a")
    private WebElement sendMessageButton;

    @FindBy(css = "form .row span.sbj")
    private WebElement latestMessageSubj;

    @FindBy(css = "form .row .attr input")
    private WebElement latestMessageCheckBox;

    @FindBy(css = ".button.l_r.del")
    private WebElement deleteSelectedMessagesButton;


    MailPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public String getLastMessageSubject() {

        return this.latestMessageSubj.getText();
    }

    public ReadMessagePage clickOnLastMessageSubject() {
        this.latestMessageSubj.click();
        return new ReadMessagePage(driver, wait);
    }

    public SendMessagePage sendMessage() {
        this.sendMessageButton.click();
        return new SendMessagePage(driver, wait);
    }

    public MailPage checkLastMessageCheckbox() {
        latestMessageCheckBox.click();
        return new MailPage(driver, wait);
    }

    public MailPage deleteSelectedMessages() {
        deleteSelectedMessagesButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return new MailPage(driver, wait);
    }
}
