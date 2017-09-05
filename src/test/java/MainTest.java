import PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MainTest extends BaseTest {


    public static final String login1 = "logintest1@i.ua";
    public static final String login2 = "logintest2@i.ua";
    public static final String pass1 = "123456A";
    public static final String pass2 = "123456A";
    public static final String messageSubject = Integer.toString((int) (Math.random() * 1000 * 1000));
    public static final String messageText = Integer.toString((int) (Math.random() * 1000 * 1000));


    @Test(dataProvider = "getRegisteredUsersData", dataProviderClass = IUADataProvider.RegisteredUsersDataProvider.class)
    public void userLoginFromPopup(String login, String password) {
        MainPage mainPage = new MainPage(driver, wait);
        mainPage.open().openLoginPopup().login(login, password);
    }

    @Test(dataProvider = "getRegisteredUsersData", dataProviderClass = IUADataProvider.RegisteredUsersDataProvider.class)
    public void userLoginFromLoginPage(String login, String password) {
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.open().login(login, password).openMailPage();
    }

    @Test
    public void sendMessageBetweenUsersWithDelete() {
        MainPage mainPage = new MainPage(driver, wait);
        SuccessSendingMailPage successSendingMailPage = new SuccessSendingMailPage(driver, wait);
        ReadMessagePage readMessagePage = new ReadMessagePage(driver, wait);

        MailPage mailPage = mainPage.open()
                .openLoginPopup()
                .login(login1, pass1)
                .openMailPage();
        String confirmText = mailPage.sendMessage().sendMail(login2, messageSubject, messageText).getConfirmationText();
        String expectedConfirmationText = "Письмо успешно отправлено адресатам";
        Assert.assertEquals(confirmText, expectedConfirmationText);

        mailPage = successSendingMailPage.logout()
                .openLoginPopup()
                .login(login2, pass2)
                .openMailPage();
        String actualMessageSubject = mailPage.getLastMessageSubject();
        Assert.assertEquals(actualMessageSubject, messageSubject);

        String actualMessageText = mailPage.clickOnLastMessageSubject().getMessageText();
        Assert.assertTrue(actualMessageText.contains(messageText));
        mailPage = readMessagePage.openMailPage();

        actualMessageSubject = mailPage.checkLastMessageCheckbox().deleteSelectedMessages().getLastMessageSubject();
        Assert.assertNotEquals(actualMessageSubject, messageSubject);

    }
}