package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SuccessSendingMailPage extends LoggedUserHeaderPage {

     @FindBy(css = ".block_confirmation .content.clear")
     WebElement confirmBlock;


    public SuccessSendingMailPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public String getConfirmationText(){
        return confirmBlock.getText();
    }

}
